package com.codenotfound.kafka.nodeReceiveRequest;

import java.util.concurrent.CountDownLatch;

import com.codenotfound.kafka.model.Request;
import com.codenotfound.kafka.model.Response;
import com.codenotfound.kafka.CloudNode.ProcessRequest;
import com.codenotfound.kafka.nodeMakeResponse.SendResponseForReceivedRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class ReceiveRequest {

  private static final Logger LOGGER = LoggerFactory.getLogger(ReceiveRequest.class);

  private CountDownLatch latch = new CountDownLatch(1);

  public CountDownLatch getLatch() {
    return latch;
  }

  @Autowired
  SendResponseForReceivedRequest sendResponseForReceivedRequest;
  @KafkaListener(topics = "cloudNodeReq")
  public void receive(String query) {
   // LOGGER.info("received payload='{}'", query);
 //   System.out.println("Reached here and end");
    System.out.println(query);
    String payload[] = query.split("#");
    Request request = new Request();
    ProcessRequest processRequest = new ProcessRequest();
    Response response = new Response();
    if(payload.length == 4){
      request.setrequestSentTo(payload[0]);
      request.setRequestSentBy(payload[1]);
      request.setRequestValue(payload[2]);
      request.setResponseGivenBackTo(payload[3]);
    }
    response =  processRequest.requestProcess(request);
    latch.countDown();
    sendResponseForReceivedRequest.send(response);
  }
}
