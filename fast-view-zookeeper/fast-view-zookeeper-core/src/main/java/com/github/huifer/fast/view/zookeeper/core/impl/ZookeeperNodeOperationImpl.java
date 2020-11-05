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

package com.github.huifer.fast.view.zookeeper.core.impl;

import java.nio.charset.StandardCharsets;
import java.util.List;

import com.github.huifer.fast.view.zookeeper.core.api.ZookeeperNodeOperation;
import com.github.huifer.fast.view.zookeeper.core.model.ZkNodeInfo;
import com.github.huifer.fast.view.zookeeper.core.model.ZkStat;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * zookeeper node operation
 *
 * @author huifer
 */
public class ZookeeperNodeOperationImpl implements ZookeeperNodeOperation {
	private static final Logger log = LoggerFactory.getLogger(ZookeeperNodeOperationImpl.class);

	@Override
	public boolean addNode(CuratorFramework curatorFramework, String path, String data, CreateMode mode) {
		if (log.isDebugEnabled()) {
			log.debug("addNode, path = {}, data = {}", path, data);
		}
		try {

			if (!exists(curatorFramework, path)) {


				String path1 = curatorFramework.create()
						.withMode(mode)
						.forPath(path, data.getBytes(StandardCharsets.UTF_8));
				return path1.equals(path);
			}
		}
		catch (Exception e) {
			log.error("create zookeeper node error . ", e);
		}
		return false;
	}


	@Override
	public ZkNodeInfo getNodeInfo(CuratorFramework curatorFramework, String path) {
		if (log.isDebugEnabled()) {
			log.debug("nodeInfo, path = {}", path);
		}
		try {

			Stat stat = new Stat();
			byte[] bytes = curatorFramework.getData().forPath(path);
			String dt = new String(bytes, StandardCharsets.UTF_8);

			return new ZkNodeInfo(
					new ZkStat(
							stat.getCzxid(),
							stat.getMzxid(),
							stat.getCtime(),
							stat.getMtime(),
							stat.getVersion(),
							stat.getCversion(),
							stat.getAversion(),
							stat.getEphemeralOwner(),
							stat.getDataLength(),
							stat.getNumChildren(),
							stat.getPzxid()),
					dt,
					nodeType(stat));
		}
		catch (Exception e) {
			log.error("get zookeeper node path data is error.", e);
		}
		return null;
	}

	private String nodeType(Stat stat) {
		return stat.getEphemeralOwner() > 0 ? "临时节点" : "持久化节点";
	}


	@Override
	public List<String> getChild(CuratorFramework curatorFramework, String path) throws Exception {
		return curatorFramework.getChildren().forPath(path);
	}


	private boolean exists(CuratorFramework curatorFramework, String path) {

		try {
			return curatorFramework.checkExists().forPath(path) != null;
		}
		catch (Exception e) {
			log.error("check zookeeper path exists error .", e);
		}
		return false;
	}


	@Override
	public boolean removeNode(CuratorFramework curatorFramework, String path) {
		try {
			curatorFramework.delete().forPath(path);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			log.error("remove zookeeper node error.", e);
		}
		return false;
	}

	@Override
	public boolean updateNode(CuratorFramework curatorFramework, String path, String data) {
		if (exists(curatorFramework, path)) {
			try {
				curatorFramework.setData().forPath(path);
				return true;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
