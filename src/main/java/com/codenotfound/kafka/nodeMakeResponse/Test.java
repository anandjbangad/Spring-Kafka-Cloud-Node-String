package com.codenotfound.kafka.nodeMakeResponse;

import com.codenotfound.kafka.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class Test{
    private static final Logger LOGGER = LoggerFactory.getLogger(SendResponseForReceivedRequest.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate1;

    public void send(String query) {
    //    String query_to_request;
    //    query_to_request = response.getSendingTo() + "#" + response.getResult() + "#" + response.getProcessedBy();
        kafkaTemplate1.send("cloudNodeReq",query);
        LOGGER.info("sending request ", query);
    }
}