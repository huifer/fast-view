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

package com.github.huifer.view.common.handler;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.huifer.view.common.DataStore;
import com.github.huifer.view.common.model.ResultVo;
import com.github.huifer.view.common.utils.HttpServletUtils;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.huifer.view.common.servlet.ResourceServlet.SESSION_USER_KEY;

/**
 *
 * 登录的url处理
 *
 * @author huifer
 */
public class LoginService implements HandlerUrlService {
	private static final Logger log = LoggerFactory.getLogger(LoginService.class);

	Gson gson = new Gson();

	@Override
	public void handler(String url, HttpServletRequest req, HttpServletResponse resp) {

		if (log.isDebugEnabled()) {
			log.debug("handler login url ,url = {}", url);
		}
		try {
			String postBody = HttpServletUtils.getPostBody(req);
			if (log.isDebugEnabled()) {
				log.debug("请求参数 = {}", postBody);
			}

			Map<String, String> map = gson.fromJson(postBody, Map.class);
			String username = map.get("username");
			String password = map.get("password");


			if (username.equals(DataStore.getUsername()) && password.equals(DataStore.getPassword())) {
				req.getSession().setAttribute(SESSION_USER_KEY, username);
				HttpServletUtils.write(resp, new ResultVo("success", true, 200));
			}
			else {
				HttpServletUtils.write(resp, new ResultVo("fail", false, 400));
			}

		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
