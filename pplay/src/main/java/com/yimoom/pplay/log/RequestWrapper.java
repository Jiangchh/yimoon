package com.yimoom.pplay.log;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class RequestWrapper extends HttpServletRequestWrapper {
	private  static Logger logger = LoggerFactory.getLogger(RequestWrapper.class);
	private long id;

	private final byte[] body;

	public RequestWrapper(long requestId,HttpServletRequest request) throws IOException {
		super(request);
		body = getBodyString(request).getBytes(Charset.forName("UTF-8"));
		this.id = requestId;
	}
	public RequestWrapper(HttpServletRequest request) throws IOException {
		super(request);
		body = getBodyString(request).getBytes(Charset.forName("UTF-8"));
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public byte[] toByteArray(){
		return body;
	}
	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(getInputStream()));
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {

		//这里从body里面直接读了，没有去读inputStream了，很巧妙的方式
		final ByteArrayInputStream bais = new ByteArrayInputStream(body);

		return new ServletInputStream() {

			@Override
			public int read() throws IOException {
				return bais.read();
			}

			@Override
			public boolean isFinished() {
				return false;
			}

			@Override
			public boolean isReady() {
				return false;
			}

			@Override
			public void setReadListener(ReadListener readListener) {

			}
		};
	}


	public  String getBodyString(ServletRequest request) {
		StringBuilder sb = new StringBuilder();
		InputStream inputStream = null;
		BufferedReader reader = null;
		try {
			inputStream = request.getInputStream();
			reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
			String line = "";
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			logger.warn("处理异常",e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.warn("处理异常",e);
				}
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					logger.warn("处理异常",e);
				}
			}
		}
		return sb.toString();
	}
}
