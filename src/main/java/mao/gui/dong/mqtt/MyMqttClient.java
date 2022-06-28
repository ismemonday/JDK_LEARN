package mao.gui.dong.mqtt;

import com.hivemq.client.mqtt.MqttClient;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt3.Mqtt3AsyncClient;

import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/3/28 下午5:58
 */
public class MyMqttClient {
    public static void main(String[] args) {
        Mqtt3AsyncClient client = MqttClient.builder()
                .useMqttVersion3()
                .identifier(UUID.randomUUID().toString())
                .serverHost("192.168.102.167")
                .serverPort(1883)
                .buildAsync();

        client.connect().whenComplete((mqtt3ConnAck, throwable) -> {
            if(throwable!=null){
                throwable.fillInStackTrace();
            }else {
                //开始发布或者注册
                //开100个线程来干
                for (int i = 0; i < 100; i++) {
                    new Thread(()->{
                        while (true){
                            try {
                                Thread.sleep(200);
                                pubList(client);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
            }
        });
    }

    private static void pubList(Mqtt3AsyncClient client){
        String msg = "hello my first mqtt";
        ByteBuffer myPayload = ByteBuffer.wrap(msg.getBytes());
        client.publishWith()
                .topic("my/topic")
                .payload(myPayload)
                .qos(MqttQos.EXACTLY_ONCE)
                .send()
                .whenComplete((mqtt3Publish, throwable) -> {
                    if (throwable != null) {
                        // Handle failure to publish
                        System.out.println("发布失败");
                    } else {
                        // Handle successful publish, e.g. logging or incrementing a metric
                        System.out.println("发布成功");
                    }
                });
    }
}


class ClientReceive{
    public static void main(String[] args) {
        Mqtt3AsyncClient client = MqttClient.builder()
                .useMqttVersion3()
                .identifier(UUID.randomUUID().toString())
                .serverHost("192.168.102.167")
                .serverPort(1883)
                .buildAsync();

        client.connect().whenComplete((mqtt3ConnAck, throwable) -> {
            if(throwable!=null){
                throwable.fillInStackTrace();
            }else {
                //开始发布或者注册
                subscribe(client);
            }
        });
    }

    private static void subscribe(Mqtt3AsyncClient client){
        client.subscribeWith().
                topicFilter("my/topic").
                callback((publish)->{
                    System.out.println("client1收到mq消息为:"+new String(publish.getPayloadAsBytes()));
                }).send().whenComplete((mqtt3SubAck, throwable) -> {
            if (throwable != null) {
                // Handle failure to subscribe
                System.out.println("Handle failure to subscribe");
            } else {
                // Handle successful subscription, e.g. logging or incrementing a metric
                System.out.println("Handle successful subscription");
            }
        });
    }
}