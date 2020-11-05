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

package com.github.huifer.fast.view.zookeeper.servlet.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.huifer.fast.view.common.servlet.SupportServlet;
import com.github.huifer.fast.view.common.utils.HttpServletUtils;
import com.github.huifer.fast.view.zookeeper.core.api.ZookeeperNodeOperation;
import com.github.huifer.fast.view.zookeeper.core.impl.ZookeeperNodeOperationImpl;
import com.github.huifer.fast.view.zookeeper.core.model.ZkNodeInfo;
import com.github.huifer.fast.view.zookeeper.core.utils.FastZookeeperDataStore;
import org.apache.zookeeper.CreateMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 * @author huifer
 */
public class ZookeeperNodeServiceImpl extends SupportServlet implements ZookeeperNodeService {

	private static final Logger log = LoggerFactory.getLogger(ZookeeperNodeServiceImpl.class);

	ZookeeperNodeOperation nodeOperation = new ZookeeperNodeOperationImpl();

	@Override
	public void handler(String path, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if (path.startsWith("/node/addNode")) {
			String postBody = HttpServletUtils.getPostBody(req);
			Map map = getGson().fromJson(postBody, Map.class);
			String paramPath = (String) map.get("path");
			String paramData = (String) map.get("data");
			String paramModel = (String) map.get("model");
			CreateMode createMode = CreateMode.valueOf(paramModel);
			boolean b = nodeOperation.addNode(FastZookeeperDataStore.getCuratorFramework(), paramPath, paramData, createMode);
			writeOk(b, resp);
		}
		else if (path.startsWith("/node/getNode")) {
			String postBody = HttpServletUtils.getPostBody(req);
			Map map = getGson().fromJson(postBody, Map.class);
			String paramPath = (String) map.get("path");
			ZkNodeInfo nodeInfo = nodeOperation.getNodeInfo(FastZookeeperDataStore.getCuratorFramework(), paramPath);

			writeOk(nodeInfo, resp);

		}
		else if (path.startsWith("/node/children")) {
			String postBody = HttpServletUtils.getPostBody(req);
			Map map = getGson().fromJson(postBody, Map.class);
			String paramPath = (String) map.get("path");
			List<String> child = null;
			try {
				child = nodeOperation.getChild(FastZookeeperDataStore.getCuratorFramework(), paramPath);
				writeOk(child, resp);
			}
			catch (Exception e) {
				log.error("获取子节点失败.", e);
				writeError(e.getMessage(), resp);
			}
		}
		else if (path.startsWith("/node/remove")) {
			String postBody = HttpServletUtils.getPostBody(req);
			Map map = getGson().fromJson(postBody, Map.class);
			String paramPath = (String) map.get("path");
			try {
				boolean b = nodeOperation.removeNode(FastZookeeperDataStore.getCuratorFramework(), paramPath);
				writeOk(b, resp);
			}
			catch (Exception e) {
				log.error("删除节点失败.", e);
				writeError(e.getMessage(), resp);
			}

		}
		else if (path.startsWith("/node/update")) {
			String postBody = HttpServletUtils.getPostBody(req);
			Map map = getGson().fromJson(postBody, Map.class);
			String paramPath = (String) map.get("path");
			String paramData = (String) map.get("data");
			boolean b = nodeOperation.updateNode(FastZookeeperDataStore.getCuratorFramework(), paramPath, paramData);
			writeOk(b, resp);

		}
	}
}
