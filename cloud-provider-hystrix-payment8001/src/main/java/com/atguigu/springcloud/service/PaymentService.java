package com.atguigu.springcloud.service;

import com.mysql.jdbc.TimeUtil;
import org.springframework.stereotype.Service;

/**
 * @author sky
 * @date 2022-04-06 22:07
 */
@Service
public class PaymentService {

	/**
	 * 正常访问
	 * @param id
	 * @return
	 */
	public String paymentInfo_OK(Integer id) {

		return "线程池" + Thread.currentThread().getName() + "paymentinfo_ok,id:" + id;
	}

	public String paymentInfo_Timeout(Integer id) {
		try {
			Thread.sleep(3000);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {

		}
		return "线程池" + Thread.currentThread().getName() + "paymentinfo_timout,id:" + id;
	}
}
