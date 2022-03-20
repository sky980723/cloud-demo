package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sky
 * @date 2022-03-20 17:39
 */
@Component
public class MyLB implements LoadBalancer {

	private AtomicInteger atomicInteger = new AtomicInteger(0);

	public final int getAndIncrement() {
		int current;
		int next;
		do {
			current = this.atomicInteger.get();
			next = current >= 2147483647 ? 0 : current++;
		} while (!this.atomicInteger.compareAndSet(current, next));
		System.out.println("next = " + next);

		return next;
	}

	@Override
	public ServiceInstance INSTANCE(List<ServiceInstance> serviceInstances) {
		int index = getAndIncrement() % serviceInstances.size();

		return serviceInstances.get(index);
	}
}
