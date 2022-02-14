package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.IPaymentService;
import com.atguigu.springcloud.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sun.util.resources.cldr.rwk.CalendarData_rwk_TZ;

import javax.annotation.Resource;
import java.awt.geom.RectangularShape;

/**
 * @author Sky
 */
@RestController
@Slf4j
public class PaymentController {

	@Resource
	private IPaymentService paymentService;

	@PostMapping(value = "/payment/create")
	public CommonResult create(@RequestBody Payment payment) {

		int result = paymentService.create(payment);

		log.info("插入结果" + result);

		if (result > 0) {
			return new CommonResult(200, "插入数据库成功", result);
		} else {
			return new CommonResult(444, "插入数据库失败", null);
		}
	}

	@GetMapping(value = "/payment/get/{id}")
	public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
		Payment payment = paymentService.getPaymentById(id);

		if (payment != null) {
			return new CommonResult(200, "查询成功,serverPort:  ", payment);
		} else {
			return new CommonResult(444, "没有对应记录,查询ID: " + id, null);
		}
	}
}
