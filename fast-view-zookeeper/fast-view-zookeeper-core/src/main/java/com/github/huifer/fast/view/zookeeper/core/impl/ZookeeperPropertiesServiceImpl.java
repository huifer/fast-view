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
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.github.huifer.fast.view.common.model.IpPort;
import com.github.huifer.fast.view.zookeeper.core.api.ZookeeperPropertiesService;
import com.github.huifer.fast.view.zookeeper.core.model.ZookeeperState;
import com.github.huifer.fast.view.zookeeper.core.utils.ZookeeperPropertiesUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.client.FourLetterWordMain;
import org.apache.zookeeper.common.X509Exception;

import org.springframework.cloud.zookeeper.ZookeeperProperties;

/**
 * zookeeper properties operation
 *
 * @author huifer
 */
public class ZookeeperPropertiesServiceImpl implements ZookeeperPropertiesService {
	@Override
	public List<IpPort> ipPort(ZookeeperProperties zookeeperProperties) {
		return ZookeeperPropertiesUtils.getIpPorts(zookeeperProperties);
	}

	@Override
	public ZookeeperState srvr(String host, int port) throws Exception {
		String stateText = FourLetterWordMain.send4LetterWord(host, port, "srvr");
		int minLatency = -1;
		BigDecimal avgLatency = new BigDecimal("-1");

		int maxLatency = -1;
		long received = -1;
		long sent = -1;
		int outStanding = -1;
		long zxid = -1;
		String mode = "";

		int nodeCount = -1;
		Srvr srvr =
				new Srvr(
						stateText,
						minLatency,
						avgLatency,
						maxLatency,
						received,
						sent,
						outStanding,
						zxid,
						mode,
						nodeCount)
						.invoke();
		minLatency = srvr.getMinLatency();
		avgLatency = srvr.getAvgLatency();
		maxLatency = srvr.getMaxLatency();
		received = srvr.getReceived();
		sent = srvr.getSent();
		outStanding = srvr.getOutStanding();
		zxid = srvr.getZxid();
		mode = srvr.getMode();
		nodeCount = srvr.getNodeCount();

		int totalWatches = totalWatches(host, port);

//		int clientNumber = clientNumber(host, port);

		ZookeeperState zookeeperState = new ZookeeperState();
		zookeeperState.setMinLatency(minLatency);
		zookeeperState.setAvgLatency(avgLatency);
		zookeeperState.setMaxLatency(maxLatency);
		zookeeperState.setReceived(received);
		zookeeperState.setSent(sent);
		zookeeperState.setOutStanding(outStanding);
		zookeeperState.setZxid(zxid);
		zookeeperState.setMode(mode);
		zookeeperState.setNodeCount(nodeCount);
		zookeeperState.setTotalWatches(totalWatches);
//		zookeeperState.setClientNumber(clientNumber);

		return zookeeperState;
	}

	private int clientNumber(String host, int port)
			throws IOException, X509Exception.SSLContextException {
		int clientNumber = -1;
		String consText = FourLetterWordMain.send4LetterWord(host, port, "cons");

		if (!StringUtils.isEmpty(consText)) {
			Scanner scanner = createScanner(consText);
			if (StringUtils.isEmpty(consText)) {
				clientNumber = 0;
			}
			while (scanner.hasNextLine()) {
				++clientNumber;
			}
			scanner.close();
		}
		return clientNumber;
	}

	private Scanner createScanner(String line) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(line);
			return scanner;
		}
		catch (Exception e) {
			throw e;
		}
	}


	private int totalWatches(String host, int port)
			throws IOException, X509Exception.SSLContextException {
		int totalWatches = -1;
		String wchsText = FourLetterWordMain.send4LetterWord(host, port, "wchs");
		if (!StringUtils.isEmpty(wchsText)) {
			Scanner scanner = createScanner(wchsText);
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				if (line.startsWith("Total watches:")) {
					totalWatches = Integer.parseInt(split(line));
				}
			}
			scanner.close();
		}
		return totalWatches;
	}

	private String split(String line) {
		return line.substring(line.indexOf(":") + 1).replaceAll(" ", "").trim();
	}

	@Override
	public Map<String, String> mntr(String host, int port) throws Exception {
		String mntr = FourLetterWordMain.send4LetterWord(host, port, "mntr");
		Scanner scanner = new Scanner(mntr);
		Map<String, String> map = new HashMap<>();

		while (scanner.hasNext()) {
			String line = scanner.nextLine();

			String[] split = line.split("\t");
			if (split.length == 2) {
				map.put(split[0], split[1]);
			}
		}
		return map;
	}

	@Override
	public Map<String, String> stat(String host, int port) throws Exception {
		String mntr = FourLetterWordMain.send4LetterWord(host, port, "stat");
		Scanner scanner = new Scanner(mntr);
		Map<String, String> map = new HashMap<>();

		while (scanner.hasNext()) {
			String line = scanner.nextLine();

			String[] split = line.split("\t");
			String s = split[0];
			String[] st2 = s.split(":");
			if (st2.length == 2) {
				map.put(st2[0], st2[1]);
			}
		}
		return map;
	}


	@Override
	public Map<String, String> conf(String host, int port) throws Exception {
		String conf = FourLetterWordMain.send4LetterWord(host, port, "conf");
		Scanner scanner = new Scanner(conf);
		Map<String, String> map = new HashMap<>();

		while (scanner.hasNext()) {
			String line = scanner.nextLine();

			String[] split = line.split("=");
			if (split.length == 2) {
				map.put(split[0], split[1]);
			}
		}
		return map;
	}

	@Override
	public String sendFourCmd(String host, int port, String cmd) throws IOException, X509Exception.SSLContextException {
		return FourLetterWordMain.send4LetterWord(host, port, cmd);
	}

	@Override
	public Map<String, String> envi(String host, int port) throws Exception {
		String envi = FourLetterWordMain.send4LetterWord(host, port, "envi");
		Scanner scanner = new Scanner(envi);
		Map<String, String> map = new HashMap<>();

		while (scanner.hasNext()) {
			String line = scanner.nextLine();

			String[] split = line.split("=");
			if (split.length == 2) {
				map.put(split[0], split[1]);
			}
		}
		return map;
	}


	private class Srvr {
		private final String stateText;

		private int minLatency;

		private BigDecimal avgLatency;

		private int maxLatency;

		private long received;

		private long sent;

		private int outStanding;

		private long zxid;

		private String mode;

		private int nodeCount;

		public Srvr(
				String stateText,
				int minLatency,
				BigDecimal avgLatency,
				int maxLatency,
				long received,
				long sent,
				int outStanding,
				long zxid,
				String mode,
				int nodeCount) {
			this.stateText = stateText;
			this.minLatency = minLatency;
			this.avgLatency = avgLatency;
			this.maxLatency = maxLatency;
			this.received = received;
			this.sent = sent;
			this.outStanding = outStanding;
			this.zxid = zxid;
			this.mode = mode;
			this.nodeCount = nodeCount;
		}

		public int getMinLatency() {
			return minLatency;
		}

		public BigDecimal getAvgLatency() {
			return avgLatency;
		}

		public int getMaxLatency() {
			return maxLatency;
		}

		public long getReceived() {
			return received;
		}

		public long getSent() {
			return sent;
		}

		public int getOutStanding() {
			return outStanding;
		}

		public long getZxid() {
			return zxid;
		}

		public String getMode() {
			return mode;
		}

		public int getNodeCount() {
			return nodeCount;
		}

		/**
		 * 计算 srvr 信息
		 *
		 * @return srvr 结果
		 */
		public Srvr invoke() {
			if (!StringUtils.isEmpty(stateText)) {
				Scanner scanner = createScanner(stateText);
				while (scanner.hasNext()) {
					String line = scanner.nextLine();

					if (line.startsWith("Latency min/avg/max:")) {
						String[] latencys = split(line).split("/");
						minLatency = Integer.parseInt(latencys[0]);
						avgLatency = new BigDecimal(latencys[1]);
						maxLatency = Integer.parseInt(latencys[2]);
					}
					else if (line.startsWith("Received:")) {
						received = Long.parseLong(split(line));
					}
					else if (line.startsWith("Sent:")) {
						sent = Long.parseLong(split(line));
					}
					else if (line.startsWith("Outstanding:")) {
						outStanding = Integer.parseInt(split(line));
					}
					else if (line.startsWith("Zxid:")) {
						zxid = Long.parseLong(split(line).substring(2), 16);
					}
					else if (line.startsWith("Mode:")) {
						mode = split(line);
					}
					else if (line.startsWith("Node count:")) {
						nodeCount = Integer.parseInt(split(line));
					}
				}
				scanner.close();
			}
			return this;
		}
	}
}
