/*
 *
 * Copyright 2020 HuiFer All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.github.huifer.fast.view.common.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.github.huifer.fast.view.common.handler.HandlerUrlService;
import com.github.huifer.fast.view.common.handler.LoginService;
import com.github.huifer.fast.view.common.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.util.StringUtils;

import static com.github.huifer.fast.view.common.Const.DEFAULT_PASSWORD;
import static com.github.huifer.fast.view.common.Const.DEFAULT_USERNAME;
import static com.github.huifer.fast.view.common.Const.PARAM_NAME_PASSWORD;
import static com.github.huifer.fast.view.common.Const.PARAM_NAME_USERNAME;

/**
 *
 *
 * @author huifer
 */
public class ResourceServlet extends HttpServlet {
	public static final String SESSION_USER_KEY = "hf-view-user";

	private static final Logger log = LoggerFactory.getLogger(ResourceServlet.class);

	protected final String resourcePath;

	HandlerUrlService loginHandler = new LoginService();


	private String username;

	private String password;

	public ResourceServlet(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	@Override
	public void init() throws ServletException {
		initAuth();
	}

	private void initAuth() {
		String username = getInitParameter(PARAM_NAME_USERNAME);
		if (StringUtils.isEmpty(username)) {
			this.username = DEFAULT_USERNAME;
		}
		else {
			this.username = username;
		}

		String password = getInitParameter(PARAM_NAME_PASSWORD);

		if (StringUtils.isEmpty(password)) {
			this.password = DEFAULT_PASSWORD;
		}
		else {
			this.password = password;
		}

	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		String requestURI = request.getRequestURI();

		log.debug("contextPath = [{}] , servletPath = [{}] , requestURI = [{}]", contextPath, servletPath, requestURI);

		response.setCharacterEncoding("utf-8");

		if (contextPath == null) {
			contextPath = "";
		}
		String uri = contextPath + servletPath;
		String path = requestURI.substring(contextPath.length() + servletPath.length());

		log.debug("path = [{}] ", path);
		if ("/loginBtn".equals(path)) {
			loginHandler.handler(uri, request, response);
			return;
		}

		if (
				!ContainsUser(request)//
						&& !("/login.html".equals(path) //
						|| path.startsWith("/css")//
						|| path.startsWith("/js") //
						|| path.startsWith("/img"))) {
			if (contextPath.equals("") || contextPath.equals("/")) {
				response.sendRedirect("/login.html");
			}
			else {
				if ("".equals(path)) {
					response.sendRedirect("/login.html");
				}
				else {
					response.sendRedirect("login.html");
				}
			}
			return;
		}

		if ("login.html".equals(path)) {
			response.sendRedirect(contextPath + "/" + servletPath + "/login.html");
			return;
		}


		if (ContainsUser(request)) {
			handlerOtherUri(request, response);
		}
		if (
				path.endsWith("html") ||
						path.endsWith("css") ||
						path.endsWith("js")
		) {

			returnResourceFile(path, uri, response);
		}
	}

	/**
	 * 其他url处理
	 */
	protected void handlerOtherUri(HttpServletRequest request, HttpServletResponse response) throws IOException {

	}


	/**
	 * 判断是否存在用户
	 */
	public boolean ContainsUser(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return session != null && session.getAttribute(SESSION_USER_KEY) != null;
	}


	private String getFilePath(String fileName) {
		return resourcePath + fileName;
	}

	private void returnResourceFile(String fileName, String uri, HttpServletResponse response)
			throws
			IOException {

		String filePath = getFilePath(fileName);

		if (filePath.endsWith(".html")) {
			response.setContentType("text/html; charset=utf-8");
		}
		if (fileName.endsWith(".jpg")) {
			byte[] bytes = FileUtils.readByteArrayFromResource(filePath);
			if (bytes != null) {
				response.getOutputStream().write(bytes);
			}

			return;
		}

		String text = FileUtils.readFromResource(filePath);
		if (text == null) {
			response.sendRedirect(uri + "/index.html");
			return;
		}
		if (fileName.endsWith(".css")) {
			response.setContentType("text/css;charset=utf-8");
		}
		else if (fileName.endsWith(".js")) {
			response.setContentType("text/javascript;charset=utf-8");
		}
		response.getWriter().write(text);
	}

}
