package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sky
 */
@Service
public class PaymentServiceImplService implements IPaymentService {

	@Autowired
	private PaymentDao paymentDao;

	@Override
	public int create(Payment payment) {

		return paymentDao.create(payment);
	}

	@Override
	public Payment getPaymentById(Long id) {

		return paymentDao.getPaymentById(id);
	}
}
