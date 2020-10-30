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

package com.github.huifer.view.common.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.github.huifer.view.common.handler.HandlerUrlService;
import com.github.huifer.view.common.handler.LoginService;
import com.github.huifer.view.common.utils.FileUtils;

import org.springframework.util.StringUtils;

import static com.github.huifer.view.common.Const.DEFAULT_PASSWORD;
import static com.github.huifer.view.common.Const.DEFAULT_USERNAME;
import static com.github.huifer.view.common.Const.PARAM_NAME_PASSWORD;
import static com.github.huifer.view.common.Const.PARAM_NAME_USERNAME;

/**
 *
 *
 * @author huifer
 */
public class ResourceServlet extends HttpServlet {
	public static final String SESSION_USER_KEY = "hf-view-user";

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

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String contextPath = req.getContextPath();
		String servletPath = req.getServletPath();
		String requestURI = req.getRequestURI();
		resp.setCharacterEncoding("utf-8");

		if (contextPath == null) { // root context
			contextPath = "";
		}
		String uri = contextPath + servletPath;
		String path = requestURI.substring(contextPath.length() + servletPath.length());


		if (path.equals("/login")) {
			req.getSession().setAttribute(SESSION_USER_KEY, "1");
			loginHandler.handler(path, req, resp);
			return;
		}

		if (path.equals("")) {
			returnResourceFile("login.html", null, resp);
			return;
		}

		if (!ContainsUser(req)) {

			returnResourceFile("login.html", null, resp);
			return;
		}


		if (path.equals("/a")) {
			resp.getWriter().write("aa");
			return;
		}
		returnResourceFile(path, uri, resp);

	}

	public boolean ContainsUser(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return session != null && session.getAttribute(SESSION_USER_KEY) != null;
	}


	protected String getFilePath(String fileName) {
		return resourcePath + fileName;
	}

	protected void returnResourceFile(String fileName, String uri, HttpServletResponse response)
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
