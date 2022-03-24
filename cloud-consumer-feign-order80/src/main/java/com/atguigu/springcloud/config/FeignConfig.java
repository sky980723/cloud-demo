package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sky
 * @date 2022-03-24 22:05
 */
@Configuration
public class FeignConfig {

	@Bean
	Logger.Level feignLoggerLevel() {

		return Logger.Level.FULL;
	}
}
