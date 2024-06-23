package net.serviceconsumerfeign.controller;

import net.serviceconsumerfeign.Response;
import net.serviceconsumerfeign.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final HelloService helloService;

    public HelloController (HelloService helloService){
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public Response<String> hello(){
        return helloService.hello();
    }
}
