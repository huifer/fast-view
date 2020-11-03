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

package com.github.huifer.fast.view.zookeeper.core.utils;

import java.util.List;

import com.github.huifer.fast.view.common.model.IpPort;
import org.apache.curator.framework.CuratorFramework;

import org.springframework.cloud.zookeeper.ZookeeperProperties;

/**
 *
 * 数据仓库
 * @author huifer
 */
public class FastZookeeperDataStore {
	/**
	 * zookeeper operation object
	 */
	public static CuratorFramework curatorFramework;

	public static ZookeeperProperties zookeeperProperties;


	public static List<IpPort> ipPorts;

	private FastZookeeperDataStore() {
		throw new IllegalStateException("Utility class");
	}

	public static List<IpPort> getIpPorts() {
		return ipPorts;
	}

	public static void setIpPorts(List<IpPort> ipPorts) {
		FastZookeeperDataStore.ipPorts = ipPorts;
	}

	public static ZookeeperProperties getZookeeperProperties() {
		return zookeeperProperties;
	}

	public static void setZookeeperProperties(ZookeeperProperties zookeeperProperties) {
		FastZookeeperDataStore.zookeeperProperties = zookeeperProperties;
	}

	public static CuratorFramework getCuratorFramework() {
		return curatorFramework;
	}

	public static void setCuratorFramework(CuratorFramework curatorFramework) {
		FastZookeeperDataStore.curatorFramework = curatorFramework;
	}
}
