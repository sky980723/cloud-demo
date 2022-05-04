package com.atguigu.springcloud.service;

import com.alibaba.druid.sql.visitor.ExportParameterizedOutputVisitor;
import com.mysql.jdbc.TimeUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

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
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "线程池" + Thread.currentThread().getName() + "paymentinfo_timout,id:" + id;
	}

	public String paymentInfo_TimeoutHandler(Integer id) {

		return "paymentInfo_TimeoutHandler," + id + "超时了";
	}
}
