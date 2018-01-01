package com.codenotfound.kafka.Receiver;

import java.util.concurrent.CountDownLatch;

import com.codenotfound.kafka.model.Request;
import com.codenotfound.kafka.model.Response;
import com.codenotfound.kafka.CloudNode.ProcessRequest;
import com.codenotfound.kafka.nodeMakeResponse.SendResponseForReceivedRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class ReceiveRequestReceiveResponse {

  private static final Logger LOGGER = LoggerFactory.getLogger(ReceiveRequestReceiveResponse.class);

  private CountDownLatch latch = new CountDownLatch(1);

  public CountDownLatch getLatch() {
    return latch;
  }



  @Autowired
  SendResponseForReceivedRequest sendResponseForReceivedRequest;

  private static final String VOICE_NAME_KEVIN = "kevin16";

  @KafkaListener(topics = "cloudNodeReq")
  public void receive(String query) {
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
    TextToSpeechConvertor textToSpeechConvertor = new TextToSpeechConvertor();
    textToSpeechConvertor.speak(request.getRequestValue());

    latch.countDown();
    sendResponseForReceivedRequest.send(response);
  }

      @KafkaListener(topics = "cloudNodeResp")
    public void response(String response){
    //    System.out.println(response);
        String responsePayload[];
        responsePayload = response.split("#");
        LOGGER.info("Response Received from = '{}'  + response is = '{}'",responsePayload[2],responsePayload[1]);
        TextToSpeechConvertor textToSpeechConvertor = new TextToSpeechConvertor();
        textToSpeechConvertor.speak(responsePayload[1]);
    }

}
