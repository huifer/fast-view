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

package com.github.huifer.fast.view.center.core.service.impl;

import com.github.huifer.fast.view.center.core.model.ApplicationEntity;
import com.github.huifer.fast.view.center.core.repository.ApplicationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author huifer
 */
@Service
public class ApplicationService {
	@Autowired
	private ApplicationRepository applicationRepository;

	public ApplicationEntity save(ApplicationEntity applicationEntity) {
		return applicationRepository.save(applicationEntity);
	}

	public ApplicationEntity save(String name) {
		ApplicationEntity applicationEntity = queryByName(name);
		if (applicationEntity == null) {

			applicationEntity = new ApplicationEntity();
			applicationEntity.setApplicationName(name);
			return this.save(applicationEntity);
		}
		else
			return applicationEntity;
	}

	public ApplicationEntity queryByName(String name) {
		return applicationRepository.findByName(name);
	}
}
