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

package com.github.huifer.view.common.factory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;

import com.github.huifer.view.common.conf.HfViewConfig;
import com.github.huifer.view.common.servlet.ResourceServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static com.github.huifer.view.common.Const.PARAM_NAME_PASSWORD;
import static com.github.huifer.view.common.Const.PARAM_NAME_USERNAME;


/**
 *
 *
 * @author huifer
 */
@Configuration
@ComponentScan("com.github.huifer.view.*")
@EnableConfigurationProperties(HfViewConfig.class)
public class HfViewAutoConfigure {
	private static final Logger log = LoggerFactory.getLogger(HfViewAutoConfigure.class);

	@Autowired
	private ApplicationContext context;

	@Bean
	public ServletRegistrationBean commonServlet() {
		if (log.isDebugEnabled()) {
			log.debug("开始初始化common servlet");
		}
		ServletRegistrationBean<Servlet> servletServletRegistrationBean = new ServletRegistrationBean<>();
		servletServletRegistrationBean.setServlet(new ResourceServlet("/support/"));
		Map<String, String> initParams = new HashMap<>(10);
		HfViewConfig bean = context.getBean(HfViewConfig.class);


		if (bean != null && !bean.equals(new HfViewConfig())) {

			initParams.put(PARAM_NAME_USERNAME, bean.getLogin());
			initParams.put(PARAM_NAME_PASSWORD, bean.getPassword());

		}
		servletServletRegistrationBean.setInitParameters(initParams);
//		servletServletRegistrationBean.setUrlMappings(Collections.singleton("/common/*"));
		servletServletRegistrationBean.addUrlMappings(new String[]{"/common/*"});
		if (log.isDebugEnabled()) {
			log.debug("开始初始化common servlet 完成.");
		}
		return servletServletRegistrationBean;
	}
}
