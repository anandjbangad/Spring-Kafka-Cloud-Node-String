package com.codenotfound.kafka;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.test.context.junit4.SpringRunner;
import com.codenotfound.kafka.nodeReceiveRequest.ReceiveRequest;
import com.codenotfound.kafka.nodeMakeResponse.SendResponseForReceivedRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringKafkaApplicationTest {

  protected final static String HELLOWORLD_TOPIC = "cloudNodeReq";

  @Autowired
  private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

  @Autowired
  private ReceiveRequest receiver;

  @Autowired
  private SendResponseForReceivedRequest sendResponseForReceivedRequest;

//  @Autowired
//  private com.codenotfound.kafka.nodeMakeResponse.Test test;
  @ClassRule
  public static KafkaEmbedded kafkaEmbedded = new KafkaEmbedded(1, true, HELLOWORLD_TOPIC);

  @Before
  public void runBeforeTestMethod() throws Exception {
    // wait until all the partitions are assigned
    for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry
        .getListenerContainers()) {
      ContainerTestUtils.waitForAssignment(messageListenerContainer,
          kafkaEmbedded.getPartitionsPerTopic());
    }
  }

  @Test
  public void testReceive() throws Exception {
    //com.codenotfound.kafka.model.Request request = new com.codenotfound.kafka.model.Request("","","",)
    //sender.send(HELLOWORLD_TOPIC, "Hello Spring Kafka!");
    String query = "cloudNodeReq#DeviceNode#HelloFromDeviceNode#test2";
    //sendResponseForReceivedRequest.sendTopicQuery("cloudNodeReq",query);
   // test.send(query);
//    receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
//    assertThat(receiver.getLatch().getCount()).isEqualTo(0);
  }
}
