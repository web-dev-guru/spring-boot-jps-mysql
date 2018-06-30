package com.cases.mysqls.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestTemplateController {
    @GetMapping(value="/call/{desc}")
    public String callRemote(@PathVariable String desc){
        String url ="http://localhost:8080/find/product/by/"+desc;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response=restTemplate.getForEntity( url, String.class);
        return "ccc"+response.getBody();
    }

    @GetMapping(value="/call/delete/{info}")
    public String callDeleteRemote(){
        String url ="http://localhost:8080/callhandler/delete";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url);
        return "delete";
    }
    @GetMapping(value="/call/exchange/put")
    public String callPutRemote() throws Exception{
        String url ="http://localhost:8080/callhandler/put";
        HttpHeaders headers = new HttpHeaders();//header parameter
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        ObjectMapper mapper =new ObjectMapper();
        Map params= new HashMap();
        params.put("username","rich");
        params.put("password","123456");
        String value = mapper.writeValueAsString(params);
        HttpEntity request = new HttpEntity<>(value,headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response=restTemplate.exchange(url, HttpMethod.PUT,request,String.class);
        return "ccc";
    }

}
