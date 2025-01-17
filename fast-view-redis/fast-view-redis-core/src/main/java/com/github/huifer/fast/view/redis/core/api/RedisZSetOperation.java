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

package com.github.huifer.fast.view.redis.core.api;

import java.util.Set;

import com.github.huifer.fast.view.redis.core.model.RedisConnectionConfig;


/**
 *  redis 的 zset 数据类型操作
 * @author huifer
 * */
public interface RedisZSetOperation extends IRedisOperationLabel {

	/**
	 * zset 添加数据
	 *
	 * @param config redis 连接配置
	 * @param k 键
	 * @param score 分数
	 * @param member 值
	 */
	void add(RedisConnectionConfig config, String k, double score, String member);

	/**
	 * 删除一个元素
	 *
	 * @param config redis 连接配置
	 * @param key 键
	 * @param member 值
	 */
	void del(RedisConnectionConfig config, String key, String member);

	/**
	 * 获取zset
	 *
	 * @param config redis 连接配置
	 * @param key 键
	 * @return 数据
	 */
	Set get(RedisConnectionConfig config, String key);

	/**
	 * 更新一个元素
	 *	覆盖memer的score值
	 * @param config redis 连接配置
	 * @param k 键
	 * @param score 分数
	 * @param member 值
	 */
	void update(RedisConnectionConfig config, String k, double score, String member);

	/**
	 * zset 的元素数量
	 * @param config redis 连接配置
	 * @param k 键
	 * @return zset 的元素数量
	 */
	Long size(RedisConnectionConfig config, String k);

	/**
	 * 获取 zset 的值
	 * @param config redis 连接配置
	 * @param k 键
	 * @param start 开始索引
	 * @param end 结束索引
	 * @return zset 的值
	 */
	Set get(RedisConnectionConfig config, String k, long start, long end);

	/**
	 * 修改 member
	 * @param config redis 连接配置
	 * @param k 键
	 * @param oldMember 历史 member 值
	 * @param newMember 新 member 值
	 * @param score 分数
	 */
	void removeOldSaveNew(RedisConnectionConfig config, String k, String oldMember, String newMember, double score);
}
