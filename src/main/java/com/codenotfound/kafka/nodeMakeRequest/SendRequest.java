package com.codenotfound.kafka.nodeMakeRequest;

import com.codenotfound.kafka.model.Request;
import com.codenotfound.kafka.model.Response;
import com.codenotfound.kafka.nodeMakeResponse.SendResponseForReceivedRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class SendRequest {
    private static final Logger LOGGER = LoggerFactory.getLogger(SendResponseForReceivedRequest.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate1;

    public void send(Request request) {
        String requestPayload;
        requestPayload = request.getrequestSentTo()+"#"+request.getRequestSentBy()+"#"+request.getRequestValue()+"#"+request.getResponseGivenBackTo()+"#"+request.getRequestNumber();
        LOGGER.info("Sending Request '{}', Request Number is '{}'",requestPayload,request.getRequestNumber());
        kafkaTemplate1.send(request.getrequestSentTo(), requestPayload);

    }

}
