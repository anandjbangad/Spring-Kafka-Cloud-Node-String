package com.codenotfound.kafka.nodeMakeResponse;

import com.codenotfound.kafka.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendResponseForReceivedRequest {

  private static final Logger LOGGER = LoggerFactory.getLogger(SendResponseForReceivedRequest.class);

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  public void send(Response response) {
    String query_to_request;
    query_to_request = response.getSendingTo() + "#" + response.getResult() + "#" + response.getProcessedBy();
    kafkaTemplate.send(response.getSendingTo(), query_to_request);
    LOGGER.info("sending response ", query_to_request);
  }

  public void sendTopicQuery(String topic, String query){
    kafkaTemplate.send(topic,query);
  }
}
