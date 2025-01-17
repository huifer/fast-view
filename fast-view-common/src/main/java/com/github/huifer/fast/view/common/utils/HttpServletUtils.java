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

package com.github.huifer.fast.view.common.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * servlet 工具
 * @author huifer
 */
public class HttpServletUtils {

	private static final Logger log = LoggerFactory.getLogger(HttpServletUtils.class);

	static Gson gson = new Gson();

	public static void write(HttpServletResponse response, Object o) {
		try {
			response.getWriter().write(gson.toJson(o));
		}
		catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("写出返回值时异常. ", e);

			}
		}
	}

	/**
	 * 获取 request 中的body字符串对象
	 * @param request request
	 * @return
	 * @throws IOException
	 */
	public static String getPostBody(HttpServletRequest request) throws IOException {
		byte[] requestBodyToArray = getRequestBodyToArray(request);
		String charEncoding = request.getCharacterEncoding();
		if (charEncoding == null) {
			charEncoding = "UTF-8";
		}
		return new String(requestBodyToArray, charEncoding);

	}

	private static byte[] getRequestBodyToArray(HttpServletRequest request) throws IOException {
		int contentLength = request.getContentLength();
		if (contentLength < 0) {
			return null;
		}
		byte[] buffer = new byte[contentLength];
		for (int i = 0; i < contentLength; ) {

			int readlen = request.getInputStream().read(buffer, i,
					contentLength - i);
			if (readlen == -1) {
				break;
			}
			i += readlen;
		}
		return buffer;
	}

}
