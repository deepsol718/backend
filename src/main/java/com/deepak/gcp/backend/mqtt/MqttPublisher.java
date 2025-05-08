package com.deepak.gcp.backend.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;

@Component
public class MqttPublisher {

    private final String brokerUrl = "tcp://broker.hivemq.com:1883";
    private final String clientId = "SpringBootPublisher";
    private final String topic = "orders/print";
    private MqttClient client;

    public MqttPublisher() {
        try {
            client = new MqttClient(brokerUrl, clientId);
            MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);
            client.connect(options);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void publishOrder(String orderJson) {
        try {
            MqttMessage message = new MqttMessage(orderJson.getBytes());
            message.setQos(1);
            client.publish(topic, message);
            System.out.println("Published to topic " + topic + ": " + orderJson);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void sendHi() {
        try {
            MqttMessage message = new MqttMessage("Hi".getBytes());
            message.setQos(1);
            client.publish(topic, message);
            System.out.println("Sent: Hi");
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void sendString(String msg) {
        try {
            MqttMessage message = new MqttMessage(msg.getBytes());
            message.setQos(1);
            client.publish(topic, message);
            System.out.println("Sent: "+msg);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
