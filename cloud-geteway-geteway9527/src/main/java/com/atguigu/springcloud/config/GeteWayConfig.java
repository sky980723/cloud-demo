package com.atguigu.springcloud.config;

import javafx.scene.input.TouchEvent;
import org.bouncycastle.jcajce.provider.symmetric.util.PBE;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sky
 * @date 2022-08-13 17:31
 */
@Configuration
public class GeteWayConfig {

	@Bean
	public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
		RouteLocatorBuilder.Builder routers = routeLocatorBuilder.routes();

		routers.route("path_route_atguigu", r -> r.path("/guonei").uri("http://news.baidu.com/")).build();

		return routers.build();
	}
}
