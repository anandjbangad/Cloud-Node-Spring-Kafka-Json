package com.codenotfound.kafka.nodeMakeResponse;

import com.codenotfound.kafka.producer.Sender;
import com.codenotfound.model.Car;
import com.codenotfound.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class SendResponseForReceivedRequest {

    private static final Logger LOGGER = LoggerFactory.getLogger(com.codenotfound.kafka.producer.Sender.class);

//    @Value("${kafka.topic.json}")
//    private String jsonTopic;

    @Autowired
    private KafkaTemplate<String, Response> kafkaTemplate;

//    public void send(Car car) {
//        LOGGER.info("sending car='{}'", car.toString());
//        kafkaTemplate.send(jsonTopic, car);
//    }
    public void send (Response response){
        LOGGER.info("sending resposne = '{}'", response.toString());
        kafkaTemplate.send(response.sendingTo, response);
    }

}


