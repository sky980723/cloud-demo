package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author sky
 * @date 2022-04-06 22:07
 */
@Service
public class PaymentService {

	/**
	 * 正常访问
	 *
	 * @param id
	 * @return
	 */
	public String paymentInfo_OK(Integer id) {

		return "线程池" + Thread.currentThread().getName() + "paymentinfo_ok,id:" + id;
	}

	@HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")})
	public String paymentInfo_Timeout(Integer id) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "线程池" + Thread.currentThread().getName() + "paymentinfo_timout,id:" + id;
	}

	public String paymentInfo_TimeoutHandler(Integer id) {

		return "paymentInfo_TimeoutHandler," + id + "超时了";
	}

	//=====服务熔断
	@HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸
	})
	public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
		if (id < 0) {
			throw new RuntimeException("******id 不能负数");
		}
		String serialNumber = IdUtil.simpleUUID();

		return Thread.currentThread().getName() + "\t" + "调用成功，流水号: " + serialNumber;
	}

	public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
		return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " + id;
	}
}
