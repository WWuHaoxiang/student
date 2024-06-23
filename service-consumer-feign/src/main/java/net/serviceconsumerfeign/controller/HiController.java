package net.serviceconsumerfeign.controller;

import net.serviceconsumerfeign.Response;
import net.serviceconsumerfeign.service.HiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    private final HiService hiService;

    public HiController (HiService hiService){
        this.hiService = hiService;
    }

    @GetMapping("/hi")
    public Response<String> hi(){
        return hiService.hi();
    }
}
