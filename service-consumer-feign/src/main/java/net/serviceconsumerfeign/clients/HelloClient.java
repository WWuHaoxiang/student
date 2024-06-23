package net.serviceconsumerfeign.clients;

import net.serviceconsumerfeign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("service-provider2")
public interface HelloClient {
    @GetMapping("/hello")
    Response<String> hello();
}
