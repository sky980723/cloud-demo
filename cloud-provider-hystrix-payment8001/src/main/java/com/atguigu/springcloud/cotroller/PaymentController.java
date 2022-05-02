package com.atguigu.springcloud.cotroller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sky
 * @date 2022-04-06 22:11
 */
@RestController
@Slf4j
public class PaymentController {


	@Resource
	private PaymentService paymentService;

	@GetMapping("/payment/hystrix/ok/{id}")
	public String PaymentInfo_ok(@PathVariable("id") Integer id) {
		String result = paymentService.paymentInfo_OK(id);
		log.info(result);

		return result;
	}

	@GetMapping("/payment/hystrix/timeout/{id}")
	public String PaymentInfo_timeout(@PathVariable("id") Integer id) {
		String result = paymentService.paymentInfo_Timeout(id);
		log.info(result);

		return result;
	}
}
