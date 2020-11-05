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

package com.github.huifer.fast.view.zookeeper.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.huifer.fast.view.common.servlet.ResourceServlet;
import com.github.huifer.fast.view.zookeeper.servlet.service.ZookeeperInfoService;
import com.github.huifer.fast.view.zookeeper.servlet.service.ZookeeperInfoServiceImpl;
import com.github.huifer.fast.view.zookeeper.servlet.service.ZookeeperNodeService;
import com.github.huifer.fast.view.zookeeper.servlet.service.ZookeeperNodeServiceImpl;

/**
 *
 *
 * @author huifer
 */
public class FastZookeeperServlet extends ResourceServlet {
	ZookeeperInfoService zookeeperInfoService = new ZookeeperInfoServiceImpl();

	ZookeeperNodeService zkNodeService = new ZookeeperNodeServiceImpl();

	public FastZookeeperServlet(String resourcePath) {
		super("support/zk");
	}

	@Override
	protected void handlerOtherUri(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String contextPath = req.getContextPath();
		String servletPath = req.getServletPath();
		String requestURI = req.getRequestURI();

		resp.setCharacterEncoding("utf-8");

		if (contextPath == null) {
			contextPath = "";
		}

		String uri = contextPath + servletPath;
		String path = requestURI.substring(contextPath.length() + servletPath.length());
		if (path.startsWith("/info")) {
			zookeeperInfoService.handler(path, req, resp);
		}
		if (path.startsWith("/node")) {
			zkNodeService.handler(path, req, resp);
		}
	}
}
