package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sky
 * @date 2022-08-13 17:31
 */
@Configuration
public class GateWayConfig {

	@Bean
	public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
		RouteLocatorBuilder.Builder routers = routeLocatorBuilder.routes();

		//代码方式实现网关路由
		routers.route("path_route_atguigu", r -> r.path("/guonei").uri("http://news.baidu.com/")).build();

		return routers.build();
	}
}
