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

package com.github.huifer.fast.view.redis.servlet.bean;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;

import com.github.huifer.fast.view.common.Const;
import com.github.huifer.fast.view.common.DataStore;
import com.github.huifer.fast.view.common.conf.HfViewConfig;
import com.github.huifer.fast.view.common.factory.HfViewAutoConfigure;
import com.github.huifer.fast.view.redis.servlet.FastViewRedisServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author huifer
 */
@Component
@ComponentScan("com.github.huifer.view.redis.*")
@Import(HfViewAutoConfigure.class)
public class RedisServletBeans {
	private static final Logger log = LoggerFactory.getLogger(RedisServletBeans.class);

	@Autowired private ApplicationContext context;

	@Bean
	public ServletRegistrationBean commonServlet() {
		if (log.isDebugEnabled()) {
			log.debug("开始初始化 redis servlet");
		}
		ServletRegistrationBean<Servlet> servletServletRegistrationBean = new ServletRegistrationBean<>();
		servletServletRegistrationBean.setServlet(new FastViewRedisServlet("/support/redis"));
		Map<String, String> initParams = new HashMap<>(10);
		HfViewConfig bean = context.getBean(HfViewConfig.class);


		if (bean != null && !bean.equals(new HfViewConfig())) {

			initParams.put(Const.PARAM_NAME_USERNAME, bean.getLogin());
			initParams.put(Const.PARAM_NAME_PASSWORD, bean.getPassword());
			DataStore.setPassword(bean.getPassword());
			DataStore.setUsername(bean.getLogin());
		}
		servletServletRegistrationBean.setInitParameters(initParams);
		servletServletRegistrationBean.addUrlMappings("/redis/*");
		if (log.isDebugEnabled()) {
			log.debug("开始初始化 redis servlet 完成.");
		}
		return servletServletRegistrationBean;
	}

}
