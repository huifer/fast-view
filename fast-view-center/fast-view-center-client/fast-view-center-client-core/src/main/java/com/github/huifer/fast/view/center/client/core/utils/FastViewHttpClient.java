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

package com.github.huifer.fast.view.center.client.core.utils;

import java.util.List;
import java.util.Map;

import com.github.huifer.fast.view.center.common.model.RestResult;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;


/**
 * http client 
 *
 * @author huifer
 */
public class FastViewHttpClient {
	public static final String POST_METHOD = "POST";

	public static final String GET_METHOD = "GET";

	private static final int TIME_OUT_MILLIS = 10000;

	private static final int CON_TIME_OUT_MILLIS = 5000;

	public static RestResult<String> httpGet(String url, List<String> headers, Map<String, String> paramValues) {
		return request(url, headers, paramValues, "", CON_TIME_OUT_MILLIS, TIME_OUT_MILLIS, "UTF-8",
				GET_METHOD);
	}

	public static RestResult<String> request(String url, List<String> headers, Map<String, String> paramValues,
			String body, int connectTimeout, int readTimeout, String encoding, String method) {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		if (method.equals(GET_METHOD)) {

		}
		else if (method.equals(POST_METHOD)) {
			HttpPost httpPost = new HttpPost(url);
			Gson gson = new Gson();
			String jsonString = gson.toJson(paramValues);
			StringEntity entity = new StringEntity(jsonString, "UTF-8");

			// post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
			httpPost.setEntity(entity);

			httpPost.setHeader("Content-Type", "application/json;charset=utf8");
			CloseableHttpResponse response = null;
			try {

				// 由客户端执行(发送)Post请求
				response = httpClient.execute(httpPost);
				// 从响应模型中获取响应实体
				HttpEntity responseEntity = response.getEntity();

				System.out.println("响应状态为:" + response.getStatusLine());
				if (responseEntity != null) {
					String responseD = EntityUtils.toString(responseEntity);
					return gson.fromJson(responseD, RestResult.class);
				}

			}
			catch (Exception e) {
				e.printStackTrace();

			}
		}
		return null;
	}

	public static RestResult<String> httpPost(String url, List<String> headers, Map<String, String> paramValues) {
		return request(url, headers, paramValues, "", CON_TIME_OUT_MILLIS, TIME_OUT_MILLIS, "UTF-8",
				POST_METHOD);
	}

}
