package com.yimoom.pplay.common.util;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;


import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class RequestUtils {


	private static final Logger logger = LoggerFactory.getLogger(RequestUtils.class);


	/**
	 * 生成请求ID
	 * 
	 *  @return
	 */
	public static String generateRequestId() {
		return Long.toString(new Date().getTime());
	}


	/**
	 * 获取请求参数.如果请求参数为空时，返回一个默认值.
	 * 
	 * @param request
	 * @param name 参数名
	 * @param defaultValue 默认值
	 * @return
	 */
	public static String getRequestParam(HttpServletRequest request, String name, String defaultValue) {
		String value = request.getParameter(name);
		return value != null ? value : defaultValue;
	}


	/**
	 * 获取请求参数.如果请求参数为空时，返回一个默认值.
	 * 
	 * @param request
	 * @param name 参数名
	 * @param defaultValue 默认值
	 * @return
	 */
	public static int getRequestParam(HttpServletRequest request, String name, int defaultValue) {
		String value = request.getParameter(name);
		return StringUtils.isNotBlank(value) ? Integer.valueOf(value) : defaultValue;
	}


	/**
	 * 获取请求头列表
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> resolveHeaders(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		for (Enumeration<String> headerNames = request.getHeaderNames(); headerNames.hasMoreElements();) {
			String headerName = headerNames.nextElement();
			result.put(headerName, request.getHeader(headerName));
		}
		return result;
	}


	/**
	 * 获取请求参数列表
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> resolveParams(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		for (Enumeration<String> paramNames = request.getParameterNames(); paramNames.hasMoreElements();) {
			String paramName = paramNames.nextElement();
			result.put(paramName, request.getParameter(paramName));
		}
		return result;
	}


	/**
	 * 获取请求体
	 * 
	 * @param request
	 * @return
	 */
	public static String resolveBody(HttpServletRequest request) {
		String result;
		try {
			result = IOUtils.toString(request.getInputStream());
		} catch (IOException e) {
			logger.error("failure to resolve body", e);
			result = "[failure to resolve body]";
		}
		return result;
	}


	/**
	 * 获取绝对路径,以"/"开头.
	 * 
	 * @param request
	 * @param path 相对路径
	 * @return
	 */ 
	public static String getFullPath(HttpServletRequest request, String path) {


		String tmp = StringUtils.defaultIfBlank(path, "");


		if (StringUtils.startsWithAny(tmp.toLowerCase(), "http", "https")) {
			return path;
		}


		if (!StringUtils.startsWith(path, "/")) {
			path = "/" + path;
		}


		return request.getContextPath()+ request.getServletPath() + path;
	}


	/**
	 * 获取完整的URL.
	 * 
	 * @param request
	 * @param path 相对URL
	 * @return
	 */
	public static String getFullUrl(HttpServletRequest request, String path) {
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + getFullPath(request, path);
	}


	/**
	 * 格式化URL
	 * 
	 * @param url
	 * @return
	 */
	public static String normalizeUrl(String url) {
		return url.replaceAll("/{2,}", "/");
	}


	/**
	 * 获取客户端的请求IP.
	 * 
	 * @param request
	 * @return
	 */
	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (null == ip) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}


}
