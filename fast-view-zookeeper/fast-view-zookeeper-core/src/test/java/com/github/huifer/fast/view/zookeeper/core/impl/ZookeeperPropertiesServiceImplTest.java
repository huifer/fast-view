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

import java.io.IOException;
import java.util.Map;

import com.github.huifer.fast.view.zookeeper.core.api.ZookeeperPropertiesService;
import com.github.huifer.fast.view.zookeeper.core.model.ZookeeperState;
import org.apache.zookeeper.common.X509Exception;
import org.junit.Test;

/**
 *
 *
 * @author huifer
 */
public class ZookeeperPropertiesServiceImplTest {
	ZookeeperPropertiesService zke = new ZookeeperPropertiesServiceImpl();

	@org.junit.Test
	public void ipPort() {
	}

	@Test
	public void fourCmd() throws IOException, X509Exception.SSLContextException {
		String  dt =  zke.sendFourCmd("localhost", 2181, "mntr");
		System.out.println(dt);
	}

	@org.junit.Test
	public void srvr() throws Exception {
		ZookeeperState srvr = zke.srvr("127.0.0.1", 2181);
		System.out.println();
	}

	@org.junit.Test
	public void mntr() {
	}

	@org.junit.Test
	public void conf() throws Exception {
		Map<String, String> localhost = zke.conf("localhost", 2181);
		System.out.println();
	}

	@org.junit.Test
	public void envi() {

	}
}