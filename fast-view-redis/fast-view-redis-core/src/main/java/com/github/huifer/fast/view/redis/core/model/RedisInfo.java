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

package com.github.huifer.fast.view.redis.core.model;

import java.util.List;

import com.github.huifer.fast.view.redis.core.model.info.RedisCliInfoClients;
import com.github.huifer.fast.view.redis.core.model.info.RedisCliInfoCluster;
import com.github.huifer.fast.view.redis.core.model.info.RedisCliInfoCpu;
import com.github.huifer.fast.view.redis.core.model.info.RedisCliInfoKeyspace;
import com.github.huifer.fast.view.redis.core.model.info.RedisCliInfoMemory;
import com.github.huifer.fast.view.redis.core.model.info.RedisCliInfoPersistence;
import com.github.huifer.fast.view.redis.core.model.info.RedisCliInfoReplication;
import com.github.huifer.fast.view.redis.core.model.info.RedisCliInfoServer;
import com.github.huifer.fast.view.redis.core.model.info.RedisCliInfoStats;


public class RedisInfo {

	private RedisCliInfoClients clients;

	private RedisCliInfoCluster cluster;

	private RedisCliInfoCpu cpu;

	private List<RedisCliInfoKeyspace> keyspace;

	private RedisCliInfoMemory memory;

	private RedisCliInfoPersistence persistence;

	private RedisCliInfoReplication replication;

	private RedisCliInfoServer server;

	private RedisCliInfoStats stats;

	public List<RedisCliInfoKeyspace> getKeyspace() {
		return keyspace;
	}

	public void setKeyspace(List<RedisCliInfoKeyspace> keyspace) {
		this.keyspace = keyspace;
	}

	public RedisCliInfoClients getClients() {
		return clients;
	}

	public void setClients(RedisCliInfoClients clients) {
		this.clients = clients;
	}

	public RedisCliInfoCluster getCluster() {
		return cluster;
	}

	public void setCluster(RedisCliInfoCluster cluster) {
		this.cluster = cluster;
	}

	public RedisCliInfoCpu getCpu() {
		return cpu;
	}

	public void setCpu(RedisCliInfoCpu cpu) {
		this.cpu = cpu;
	}

	public RedisCliInfoMemory getMemory() {
		return memory;
	}

	public void setMemory(RedisCliInfoMemory memory) {
		this.memory = memory;
	}

	public RedisCliInfoPersistence getPersistence() {
		return persistence;
	}

	public void setPersistence(RedisCliInfoPersistence persistence) {
		this.persistence = persistence;
	}

	public RedisCliInfoReplication getReplication() {
		return replication;
	}

	public void setReplication(RedisCliInfoReplication replication) {
		this.replication = replication;
	}

	public RedisCliInfoServer getServer() {
		return server;
	}

	public void setServer(RedisCliInfoServer server) {
		this.server = server;
	}

	public RedisCliInfoStats getStats() {
		return stats;
	}

	public void setStats(RedisCliInfoStats stats) {
		this.stats = stats;
	}
}
