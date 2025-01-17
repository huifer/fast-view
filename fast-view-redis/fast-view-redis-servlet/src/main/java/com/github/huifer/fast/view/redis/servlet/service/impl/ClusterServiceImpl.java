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

package com.github.huifer.fast.view.redis.servlet.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.huifer.fast.view.common.utils.HttpServletUtils;
import com.github.huifer.fast.view.redis.core.api.IRedisClusterOperation;
import com.github.huifer.fast.view.redis.core.impl.IRedisClusterOperationImpl;
import com.github.huifer.fast.view.redis.core.model.cluster.ClusterListInfo;
import com.github.huifer.fast.view.redis.core.model.vo.ResultVO;
import com.github.huifer.fast.view.redis.servlet.service.ClusterService;
import com.google.gson.Gson;

/**
 *
 *
 * @author huifer
 */
public class ClusterServiceImpl implements ClusterService {
	Gson gson = new Gson();

	IRedisClusterOperation redisClusterOperation = new IRedisClusterOperationImpl();

	@Override
	public void handler(String path, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if (path.startsWith("/cluster/infos")) {
			List<ClusterListInfo> clusterListInfos = redisClusterOperation.clusterInfos();
			ResultVO ok = new ResultVO("ok", clusterListInfos, 200);
			resp.setContentType("application/json; charset=UTF-8");
			resp.getWriter().write(gson.toJson(ok));
		}
		else if (path.startsWith("/cluster/cmd")) {
			String postBody = HttpServletUtils.getPostBody(req);
			Map<String, String> map = gson.fromJson(postBody, Map.class);
			String nodeId = map.get("nodeId");
			String cmd = map.get("cmd");

			Properties info = this.redisClusterOperation.info(nodeId, cmd);
			Map<String, String> res = new HashMap<>();

			info.forEach((k, v) -> {
				res.put(k.toString(), gson.toJson(v));
			});
			ResultVO ok = new ResultVO("ok", res, 200);
			resp.setContentType("application/json; charset=UTF-8");
			resp.getWriter().write(gson.toJson(ok));
		}
	}
}
