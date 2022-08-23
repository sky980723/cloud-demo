package com.atguigu.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.sendgrid.SendGridAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import javax.swing.text.AbstractDocument;
import java.util.Arrays;
import java.util.List;
import java.util.SimpleTimeZone;

/**
 * @author Sky
 */
@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class EurekaMain7001 {

	public static void main(String[] args) {
		SpringApplication.run(EurekaMain7001.class, args);
	}
}
