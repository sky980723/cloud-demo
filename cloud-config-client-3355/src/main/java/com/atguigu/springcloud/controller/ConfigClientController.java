package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sky
 * @date 2022-08-23 23:17
 */
@RestController
@RefreshScope
public class ConfigClientController {

	@Value("${config.info}")
	private String configInfo;

	@GetMapping("/configInfo")
	public String getConfigInfo() {

		return configInfo;
	}
}
