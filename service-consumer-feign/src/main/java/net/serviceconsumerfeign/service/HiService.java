package net.serviceconsumerfeign.service;

import net.serviceconsumerfeign.Response;
import net.serviceconsumerfeign.clients.HiClient;
import org.springframework.stereotype.Service;

@Service
public class HiService {

    private final HiClient hiClient;

    public HiService(HiClient hiClient){
        this.hiClient = hiClient;
    }

    public Response<String> hi(){
        return hiClient.hi();
    }

}
