package net.serviceconsumerfeign.clients;

import net.serviceconsumerfeign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("service-provider3")
public interface HiClient {
    @GetMapping("/hi")
    Response<String> hi();

}
