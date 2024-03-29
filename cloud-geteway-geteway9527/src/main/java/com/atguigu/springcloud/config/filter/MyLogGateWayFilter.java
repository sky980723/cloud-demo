package com.atguigu.springcloud.config.filter;

import io.netty.util.internal.StringUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ChannelSendOperator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author sky
 * GateWay过滤器
 * @date 2022-08-14 22:34
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		//
		log.info("*************** come in my LogGateway filter" + new Date());
		//获取参数中的uname
		String uname = exchange.getRequest().getQueryParams().getFirst("uname");
		if (StringUtils.isEmpty(uname)) {
			log.info("uname未获取到");
			//这里是赋值一个 406的状态值
			exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
			//不通过的写法 结束请求 向前端返回
			return exchange.getResponse().setComplete();
		}
		//通过的写法 放行
		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {
		//优先级  数字越小代表优先级越高
		return 0;
	}
}
