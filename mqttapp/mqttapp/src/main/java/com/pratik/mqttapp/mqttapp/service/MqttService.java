package com.pratik.mqttapp.mqttapp.service;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;

@Service
public class MqttService {

    private final MqttClient mqttClient;

    public MqttService(MqttClient mqttClient) {
        this.mqttClient = mqttClient;
    }

    public void publish(String topic, String message) throws Exception {
        MqttMessage mqttMessage = new MqttMessage(message.getBytes());
        mqttMessage.setQos(1); // QoS level
        mqttClient.publish(topic, mqttMessage);
    }

    public void subscribe(String topic) throws Exception {
        mqttClient.subscribe(topic, (t, msg) -> {
            String receivedMessage = new String(msg.getPayload());
            System.out.println("Received message: " + receivedMessage);
        });
    }
}

