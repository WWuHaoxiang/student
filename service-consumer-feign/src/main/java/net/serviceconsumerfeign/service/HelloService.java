package net.serviceconsumerfeign.service;

import net.serviceconsumerfeign.Response;
import net.serviceconsumerfeign.clients.HelloClient;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    private final HelloClient helloClient;

    public HelloService(HelloClient helloClient){
        this.helloClient = helloClient;
    }

    public Response<String> hello(){
        return helloClient.hello();
    }
}
