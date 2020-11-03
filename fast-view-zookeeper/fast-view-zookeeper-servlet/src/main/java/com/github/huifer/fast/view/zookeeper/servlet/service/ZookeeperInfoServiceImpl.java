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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.huifer.fast.view.common.model.IpPort;
import com.github.huifer.fast.view.common.model.ResultVo;
import com.github.huifer.fast.view.common.utils.HttpServletUtils;
import com.github.huifer.fast.view.zookeeper.core.api.ZookeeperPropertiesService;
import com.github.huifer.fast.view.zookeeper.core.impl.ZookeeperPropertiesServiceImpl;
import com.github.huifer.fast.view.zookeeper.core.model.ZkInfo;
import com.github.huifer.fast.view.zookeeper.core.model.ZookeeperState;
import com.github.huifer.fast.view.zookeeper.core.utils.FastZookeeperDataStore;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 * @author huifer
 */
public class ZookeeperInfoServiceImpl implements ZookeeperInfoService {
	private static final Logger log = LoggerFactory.getLogger(ZookeeperInfoServiceImpl.class);

	Gson gson = new Gson();

	ZookeeperPropertiesService zookeeperPropertiesService = new ZookeeperPropertiesServiceImpl();

	@Override
	public void handler(String path, HttpServletRequest req, HttpServletResponse resp) throws IOException {


		// zookeeper 节点列表
		if (path.startsWith("/info/list")) {
			infoList(resp);
		}
		else if (path.startsWith("/info/four/cmd")) {

			sendFourCmd(req, resp);
		}

		else if (path.startsWith("/info/four/srvr")) {
			srvr(req, resp);
		}
		else if (path.startsWith("/info/four/mntr")) {
			mntr(req, resp);
		}
		else if (path.startsWith("/info/four/conf")) {
			conf(req, resp);
		}
		else if (path.startsWith("/info/four/envi")) {
			envi(req, resp);
		}

	}

	private void infoList(HttpServletResponse resp) throws IOException {
		List<IpPort> ipPorts = zookeeperPropertiesService.ipPort(FastZookeeperDataStore.getZookeeperProperties());

		List<ZkInfo> zkInfos = new ArrayList<>(ipPorts.size());
		for (IpPort ipPort : ipPorts) {
			try {
				Map<String, String> stat = zookeeperPropertiesService.stat(ipPort.getIp(), ipPort.getPort());
				String mode = stat.get("Mode");
				zkInfos.add(new ZkInfo(ipPort.getIp(), String.valueOf(ipPort.getPort()), mode));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		ResultVo ok = new ResultVo("ok", zkInfos, 200);
		resp.getWriter().write(gson.toJson(ok));
		return;
	}

	private void envi(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String postBody = HttpServletUtils.getPostBody(req);
		Map<String, String> map = gson.fromJson(postBody, Map.class);
		String ip = map.get("ip");
		String port = map.get("port");
		try {
			Map<String, String> envi = zookeeperPropertiesService.envi(ip, Integer.parseInt(port));
			ResultVo ok = new ResultVo("ok", envi, 200);
			resp.getWriter().write(gson.toJson(ok));
		}
		catch (Exception e) {
			log.error("四字命令 envi 执行失败.", e);

		}
	}

	private void conf(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String postBody = HttpServletUtils.getPostBody(req);
		Map<String, String> map = gson.fromJson(postBody, Map.class);
		String ip = map.get("ip");
		String port = map.get("port");
		try {
			Map<String, String> conf = zookeeperPropertiesService.conf(ip, Integer.parseInt(port));
			ResultVo ok = new ResultVo("ok", conf, 200);
			resp.getWriter().write(gson.toJson(ok));
		}
		catch (Exception e) {
			log.error("四字命令 conf 执行失败.", e);

		}
	}

	private void mntr(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String postBody = HttpServletUtils.getPostBody(req);
		Map<String, String> map = gson.fromJson(postBody, Map.class);
		String ip = map.get("ip");
		String port = map.get("port");
		try {
			Map<String, String> mntr = zookeeperPropertiesService.mntr(ip, Integer.parseInt(port));
			ResultVo ok = new ResultVo("ok", mntr, 200);
			resp.getWriter().write(gson.toJson(ok));
		}
		catch (Exception e) {
			log.error("四字命令 mntr 执行失败.", e);

		}
	}

	private void srvr(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String postBody = HttpServletUtils.getPostBody(req);
		Map<String, String> map = gson.fromJson(postBody, Map.class);
		String ip = map.get("ip");
		String port = map.get("port");
		try {
			ZookeeperState srvr = zookeeperPropertiesService.srvr(ip, Integer.parseInt(port));
			ResultVo ok = new ResultVo("ok", srvr, 200);
			resp.getWriter().write(gson.toJson(ok));
		}
		catch (Exception e) {
			log.error("四字命令 srvr 执行失败.", e);
		}
	}

	/**
	 * 发送四字命令
	 */
	private void sendFourCmd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String postBody = HttpServletUtils.getPostBody(req);
		Map<String, String> map = gson.fromJson(postBody, Map.class);
		String ip = map.get("ip");
		String port = map.get("port");
		String cmd = map.get("cmd");
		try {

			String cmdReturn = zookeeperPropertiesService.sendFourCmd(ip, Integer.parseInt(port), cmd);
			ResultVo ok = new ResultVo("ok", cmdReturn, 200);
			resp.getWriter().write(gson.toJson(ok));
			return;
		}
		catch (Exception e) {
			log.error("zookeeper 四字命令发送失败 ", e);
		}
	}
}
