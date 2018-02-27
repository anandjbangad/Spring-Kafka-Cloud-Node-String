package com.codenotfound.kafka.RequestController;

import com.codenotfound.kafka.Base64.Java8Base64Image;
import com.codenotfound.kafka.model.Request;
import com.codenotfound.kafka.nodeMakeRequest.SendRequest;
import org.apache.kafka.clients.producer.internals.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.concurrent.atomic.AtomicLong;

import static com.codenotfound.kafka.Base64.Java8Base64Image.encoder;

@RestController
public class RequestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final AtomicLong service3Counter = new AtomicLong();

    @Autowired
    SendRequest sendRequest;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "requestQuery", defaultValue = "cloudNodeReq#DeviceNode#HelloFromDeviceNode#deviceNodeResp1") String request) {
//        return new Greeting(counter.incrementAndGet(),
//                String.format(template, name));
        //sendRequest.send( );
        return ("Received Request" + request);
    }

    @RequestMapping("/service2")
    public String service2(@RequestParam(value = "requestQuery", defaultValue = "edgeNodeReq1#CloudNode#HelloFromCloudNode#cloudNodeResp") String requestQuery){
        Request request =new Request();
        String imagePath = "C:\\Users\\Anand J Bangad\\Documents\\Capture.PNG";
        System.out.println("=================Encoder Image to Base 64!=================");
        Java8Base64Image java8Base64Image = new Java8Base64Image();
        String base64ImageString = java8Base64Image.encoder(imagePath);
        String payload[] = requestQuery.split("#");
        if(payload.length ==4) {
            request.setrequestSentTo(payload[0]);
            request.setRequestSentBy(payload[1]);
            request.setRequestValue(payload[2]);
            request.setResponseGivenBackTo(payload[3]);
            request.setRequestNumber(String.valueOf(counter.getAndIncrement()));
        }
        sendRequest.send(request);
        return ("Cloud Node Makes a request to edge node. The request is " + requestQuery);
        //Sending To
        //Sent By
        //Value
        //ResponseToBeGivenTo
    }

    @RequestMapping("/service3")
    public String service3(@RequestParam(value = "requestQuery", defaultValue = "deviceNodeReq1#CloudNode#HelloFromCloudNode#cloudNodeResp") String requestQuery){
        Request request =new Request();
        String payload[] = requestQuery.split("#");
        if(payload.length ==4) {
            request.setrequestSentTo(payload[0]);
            request.setRequestSentBy(payload[1]);
            request.setRequestValue(payload[2]);
            request.setResponseGivenBackTo(payload[3]);
            request.setRequestNumber(String.valueOf(service3Counter.getAndIncrement()));

        }
        sendRequest.send(request);
        return ("Cloud Node Makes a request to device node 1. The request is " + request);
    }
    @RequestMapping("/service4")
    public String service4(@RequestParam(value = "requestQuery", defaultValue = "deviceNodeReq2#CloudNode#HelloFromCloudNode#cloudNodeResp") String requestQuery){
        Request request =new Request();
        String payload[] = requestQuery.split("#");
        String imagePath = "C:\\Users\\Anand J Bangad\\Documents\\Capture.PNG";
        System.out.println("=================Encoder Image to Base 64!=================");
        Java8Base64Image java8Base64Image = new Java8Base64Image();
        String base64ImageString = java8Base64Image.encoder(imagePath);
        if(payload.length ==4) {
            request.setrequestSentTo(payload[0]);
            request.setRequestSentBy(payload[1]);
            request.setRequestValue(base64ImageString);
            request.setResponseGivenBackTo(payload[3]);
            request.setRequestNumber(String.valueOf(service3Counter.getAndIncrement()));

        }
        sendRequest.send(request);
        return ("Cloud Node Makes a request to device node 1. The request is " + request);
    }
}


