package com.codenotfound.kafka.nodeReceiveRequest;

import CloudNode.ProcessRequest;
import com.codenotfound.kafka.consumer.Receiver;
import com.codenotfound.kafka.nodeMakeResponse.SendResponseForReceivedRequest;
import com.codenotfound.model.Car;
import com.codenotfound.model.Request;
import com.codenotfound.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class ReceiveRequest {

    @Autowired
    private SendResponseForReceivedRequest sendResponseForReceivedRequest;

    private static final Logger LOGGER = LoggerFactory.getLogger(com.codenotfound.kafka.consumer.Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "${kafka.topic.CLOUD_NODE_REQ}")
    public void receive(Request request) {
        LOGGER.info("received ='{}'", request.toString());
        ProcessRequest processRequest = new ProcessRequest();
        Response response = processRequest.requestProcess(request);
        sendResponseForReceivedRequest.send(response);
        latch.countDown();
    }
}


