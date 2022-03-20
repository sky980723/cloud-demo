package com.atguigu.springcloud.lb;


import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author Sky
 */
public interface LoadBalancer {

	ServiceInstance INSTANCE(List<ServiceInstance> serviceInstances);


}
