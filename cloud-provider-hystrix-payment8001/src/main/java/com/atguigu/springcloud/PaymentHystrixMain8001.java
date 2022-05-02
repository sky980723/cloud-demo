package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author sky
 * @date 2022-04-06 22:05
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentHystrixMain8001 {
	public static void main(String[] args) {

		SpringApplication.run(PaymentHystrixMain8001.class, args);
	}
}
