package com.codenotfound.kafka.Receiver;

import java.util.concurrent.CountDownLatch;

import com.codenotfound.kafka.Base64.Java8Base64Image;
import com.codenotfound.kafka.model.Request;
import com.codenotfound.kafka.model.Response;
import com.codenotfound.kafka.CloudNode.ProcessRequest;
import com.codenotfound.kafka.nodeMakeResponse.SendResponseForReceivedRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import static com.codenotfound.kafka.Base64.Java8Base64Image.decoder;

public class ReceiveRequestReceiveResponse {

  private static final Logger LOGGER = LoggerFactory.getLogger(ReceiveRequestReceiveResponse.class);

  private CountDownLatch latch = new CountDownLatch(1);

  public CountDownLatch getLatch() {
    return latch;
  }

  public static int counter =0;

  public static long timerStart =System.currentTimeMillis();
  public static long totalTime =0;

  @Autowired
  SendResponseForReceivedRequest sendResponseForReceivedRequest;

  private static final String VOICE_NAME_KEVIN = "kevin16";

  @KafkaListener(topics = "cloudNodeReq")
  public void receive(String query) {
  //  DisplayRequest display = new DisplayRequest();
  //  display.createWindow(query);
    System.out.println(query);
    String payload[] = query.split("#");
    Request request = new Request();
    ProcessRequest processRequest = new ProcessRequest();
    Response response = new Response();
    if(payload.length == 5){
      request.setrequestSentTo(payload[0]);
      request.setRequestSentBy(payload[1]);
      request.setRequestValue(payload[2]);
      request.setResponseGivenBackTo(payload[3]);
      request.setRequestNumber(payload[4]);
    }
    response =  processRequest.requestProcess(request);
 //   TextToSpeechConvertor textToSpeechConvertor = new TextToSpeechConvertor();
 //   textToSpeechConvertor.speak(request.getRequestValue());

    //latch.countDown();
    sendResponseForReceivedRequest.send(response);

  }

      @KafkaListener(topics = "cloudNodeResp")
    public void response(String response){
    //    System.out.println(response);
        counter = counter + 1;
        String responsePayload[];
        responsePayload = response.split("#");
    //    DisplayResponse displayResponse = new DisplayResponse();
    //    displayResponse.createWindow("Response Received from " +responsePayload[2] +" for RequestNumber { " + responsePayload[3] + " }" + " and response is = " + responsePayload[1] );
      //  Java8Base64Image java8Base64Image = new Java8Base64Image();
    //    decoder(responsePayload[1], "C:\\Users\\Anand J Bangad\\Documents\\DecodedImage\\" + Integer.toString(counter) + ".jpg");
        LOGGER.info("Response Received from = '{}' for RequestNumber '{}' and response is = '{}'",responsePayload[2],responsePayload[3],responsePayload[1]);
  //      TextToSpeechConvertor textToSpeechConvertor = new TextToSpeechConvertor();
  //
        if (counter > 1200){
          totalTime = System.currentTimeMillis() - timerStart;
          System.out.println(totalTime);

        }

        //      textToSpeechConvertor.speak(responsePayload[1]);
    }

}
