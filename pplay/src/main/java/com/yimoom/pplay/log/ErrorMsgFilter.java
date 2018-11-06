package com.yimoom.pplay.log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.WriteListener;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.yimoom.pplay.common.util.JsonHelper;
import com.yimoom.pplay.common.util.RequestUtils;

@Component
@Order(1)
@WebFilter(filterName = "errorMsgFilter", urlPatterns = "/*")
public class ErrorMsgFilter implements Filter {
	protected static final Logger logger = LoggerFactory.getLogger(ErrorMsgFilter.class);
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		long startTime = System.currentTimeMillis();
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		RequestWrapper rwapper=new RequestWrapper(request);
		ErrorMsgFilterResponseWrapper wwrapper = new ErrorMsgFilterResponseWrapper(response);

		try {
			filterChain.doFilter(request, response);
		} finally {
			if (logger.isInfoEnabled()) {
				logger.info("这个类是{}",ErrorMsgFilter.class);
				dumpRequest(rwapper);
				logger.info("这里打印的内容是:{}",wwrapper.getResponseData("UTF-8"));
				logger.info("耗时 : " + (System.currentTimeMillis() - startTime));
			}
			rwapper.close();
		}
		
		
	}
	
	public void dumpRequest(HttpServletRequest request) {
		try {
			if (logger.isInfoEnabled()) {
				logger.info("--------------------request dump  begin-------------------------");
				logger.info("request uri: {}", request.getRequestURI());
				logger.info("request type: {}", request.getClass().getName());
				logger.info("request method: {}", request.getMethod());
				logger.info("request characterEncoding: {}", request.getCharacterEncoding());
				dumpRequestHeaders(request);
				dumpSession(request);
				dumpRequestParams(request);
				dumpRequestBody(request);
				logger.info("--------------------request dump  end---------------------------");
			}
		} catch (Throwable e) {
			logger.info("failure to dump request", e);
		}
	}


	private void dumpRequestHeaders(HttpServletRequest request) {
		for (Enumeration<String> headerNames = request.getHeaderNames(); headerNames.hasMoreElements();) {
			String headerName = headerNames.nextElement();
			String value = request.getHeader(headerName);
			logger.info("request header[{}]:{}", headerName, value);
		}
	}


	public void dumpSession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (null != session) {
			for (Enumeration<String> attributeNames = session.getAttributeNames(); attributeNames.hasMoreElements();) {
				String attributeName = attributeNames.nextElement();
				Object value = session.getAttribute(attributeName);
				logger.info("session[{}]:{}", attributeName, JsonHelper.toJSONStringQuietly(value, false));
			}
		}
	}


	private void dumpRequestParams(HttpServletRequest request) {
		for (Enumeration<String> paramNames = request.getParameterNames(); paramNames.hasMoreElements();) {
			String paramName = paramNames.nextElement();
			String[] values = request.getParameterValues(paramName);
			logger.info("request param[{}]:{}", paramName, JsonHelper.toJSONStringQuietly(values, false));
		}
	}


	private void dumpRequestBody(HttpServletRequest request) {
		if (isPayloadInBody(request)) {
			String body = RequestUtils.resolveBody(request);
			logger.info("request body:{}", body);
		} else {
			logger.info("request body:[unsupported payload:[{},{}]]", request.getMethod(), request.getContentType());
		}
	}

	private boolean isPayloadInBody(HttpServletRequest request) {
		String method = request.getMethod();
		if (!("POST".equalsIgnoreCase(method) || "PUT".equalsIgnoreCase(method))) {
			return false;
		}
		String contentType = request.getContentType();

		return StringUtils.containsIgnoreCase(contentType, "application/json")
				|| StringUtils.containsIgnoreCase(contentType, "text/plain")
				|| StringUtils.containsIgnoreCase(contentType, "text/xml")
				|| StringUtils.containsIgnoreCase(contentType, "text/html");
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


}



class ErrorMsgFilterResponseWrapper extends HttpServletResponseWrapper {
	private ByteArrayOutputStream buffer = null;
	private ServletOutputStream out = null;
	private PrintWriter writer = null;

	public ErrorMsgFilterResponseWrapper(HttpServletResponse response) throws IOException{
		super(response);
		buffer = new ByteArrayOutputStream();
		out = new WapperedOutputStream(buffer);
		writer = new PrintWriter(new OutputStreamWriter(buffer, "UTF-8"));
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return out;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		return writer;
	}

	@Override
	public void flushBuffer() throws IOException {
		if (out != null) {
			out.flush();
		}
		if (writer != null) {
			writer.flush();
		}
	}

	@Override
	public void reset() {
		buffer.reset();
	}

	public String getResponseData(String charset) throws IOException {
		flushBuffer();
		byte[] bytes = buffer.toByteArray();
		try {
			return new String(bytes, charset);
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	class WapperedOutputStream extends ServletOutputStream {
		private ByteArrayOutputStream bos = null;
		public WapperedOutputStream(ByteArrayOutputStream stream) throws IOException {
			bos = stream;
		}
		@Override
		public void write(int b) throws IOException {
			bos.write(b);
		}

		@Override
		public boolean isReady() {
			return false;
		}

		@Override
		public void setWriteListener(WriteListener listener) {

		}
	}
}