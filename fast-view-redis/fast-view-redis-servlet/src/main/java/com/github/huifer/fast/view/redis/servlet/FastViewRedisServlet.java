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

package com.github.huifer.fast.view.redis.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.huifer.fast.view.common.servlet.ResourceServlet;
import com.github.huifer.fast.view.redis.servlet.service.ClusterService;
import com.github.huifer.fast.view.redis.servlet.service.HandlerRedisService;
import com.github.huifer.fast.view.redis.servlet.service.HashKeyService;
import com.github.huifer.fast.view.redis.servlet.service.KeySearchService;
import com.github.huifer.fast.view.redis.servlet.service.ListKeyService;
import com.github.huifer.fast.view.redis.servlet.service.RedisConnectionService;
import com.github.huifer.fast.view.redis.servlet.service.SetKeyService;
import com.github.huifer.fast.view.redis.servlet.service.StringKeyService;
import com.github.huifer.fast.view.redis.servlet.service.ZSetKeyService;
import com.github.huifer.fast.view.redis.servlet.service.impl.ClusterServiceImpl;
import com.github.huifer.fast.view.redis.servlet.service.impl.HandlerRedisServiceImpl;
import com.github.huifer.fast.view.redis.servlet.service.impl.HashKeyServiceImpl;
import com.github.huifer.fast.view.redis.servlet.service.impl.KeySearchServiceImpl;
import com.github.huifer.fast.view.redis.servlet.service.impl.ListKeyServiceImpl;
import com.github.huifer.fast.view.redis.servlet.service.impl.RedisConnectionServiceImpl;
import com.github.huifer.fast.view.redis.servlet.service.impl.SetKeyServiceImpl;
import com.github.huifer.fast.view.redis.servlet.service.impl.StringKeyServiceImpl;
import com.github.huifer.fast.view.redis.servlet.service.impl.ZSetKeyServiceImpl;

/**
 *
 *
 * @author huifer
 */
public class FastViewRedisServlet extends ResourceServlet {
	HandlerRedisService handlerRedisService = new HandlerRedisServiceImpl();

	KeySearchService keySearchService = new KeySearchServiceImpl();

	StringKeyService stringKeyService = new StringKeyServiceImpl();

	HashKeyService hashKeyService = new HashKeyServiceImpl();

	ZSetKeyService zSetKeyService = new ZSetKeyServiceImpl();

	ListKeyService listKeyService = new ListKeyServiceImpl();

	SetKeyService setKeyService = new SetKeyServiceImpl();

	ClusterService clusterService = new ClusterServiceImpl();

	RedisConnectionService redisConnectionService = new RedisConnectionServiceImpl();

	public FastViewRedisServlet(String resourcePath) {
		super("support/redis");
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
		if (path.startsWith("/service")) {
			this.handlerRedisService.handler(path, req, resp);
			return;
		}
		if (path.startsWith("/key")) {
			this.keySearchService.handler(path, req, resp);
			return;
		}
		if (path.startsWith("/string")) {
			this.stringKeyService.handler(path, req, resp);
			return;
		}
		if (path.startsWith("/hash")) {

			this.hashKeyService.handler(path, req, resp);
			return;
		}
		if (path.startsWith("/zset")) {

			this.zSetKeyService.handler(path, req, resp);
			return;
		}
		if (path.startsWith("/list")) {

			this.listKeyService.handler(path, req, resp);
			return;
		}
		if (path.startsWith("/set")) {
			this.setKeyService.handler(path, req, resp);
			return;
		}
		if (path.startsWith("/cluster")) {
			clusterService.handler(path, req, resp);
			return;
		}
		if (path.startsWith("/cm")) {
			redisConnectionService.handler(path, req, resp);
			return;
		}
		return;
	}
}
