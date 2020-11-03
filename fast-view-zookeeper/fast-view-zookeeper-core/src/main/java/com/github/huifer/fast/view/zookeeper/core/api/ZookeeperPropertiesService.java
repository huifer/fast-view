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

package com.github.huifer.fast.view.zookeeper.core.api;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.github.huifer.fast.view.common.model.IpPort;
import com.github.huifer.fast.view.zookeeper.core.model.ZookeeperState;
import org.apache.zookeeper.common.X509Exception;

import org.springframework.cloud.zookeeper.ZookeeperProperties;

/**
 *
 * zookeeper 属性操作
 * @author huifer
 */
public interface ZookeeperPropertiesService {
	/**
	 * 获取配置中的 zookeeper 节点信息
	 */
	List<IpPort> ipPort(ZookeeperProperties zookeeperProperties);


	/**
	 * zookeeper 四字命令 srvr
	 */
	ZookeeperState srvr(String host, int port) throws Exception;

	Map<String, String> stat(String host, int port) throws Exception;

	/**
	 * zookeeper 四字命令 mntr
	 */
	Map<String, String> mntr(String host, int port) throws Exception;

	/**
	 * zookeeper 四字命令 conf
	 */
	Map<String, String> conf(String host, int port) throws Exception;

	/**
	 * zookeeper 四字命令 envi
	 */
	Map<String, String> envi(String host, int port) throws Exception;

	String sendFourCmd(String host, int port, String cmd) throws IOException, X509Exception.SSLContextException;
}
