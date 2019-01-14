package kafka;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.common.serialization.StringDeserializer;

public class ConsumerTest {



    ConsumerConnector consumerConnector;

    public ConsumerTest() {

        Properties props = new Properties();
//	    props.put("zookeeper.connect", "10.66.108.70:2181,10.66.108.165:2181,10.66.106.224:2181,10.66.106.250:2181,10.66.104.6:2181");
//        props.put("group.id", "test");
//        props.put("zookeeper.session.timeout.ms", "40000");
//        props.put("zookeeper.sync.time.ms", "20000");
//        props.put("auto.commit.interval.ms", "100000");
        
        props.put("bootstrap.servers", ":9092");
	    props.put("group.id", "test123");
	    props.put("zookeeper.connect", ":2181/kafka");

	    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	    props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
//	    props.put("session.timeout.ms", 10000);
	    props.put("enable.auto.commit", true);
	    props.put("auto.commit.interval.ms", 10000);
      
        props.put("zookeeper.session.timeout.ms", "6000");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "largest");
        props.put("client.id", "test"+Math.random());

        ConsumerConfig consumerConfig = new ConsumerConfig(props);
        consumerConnector =  Consumer.createJavaConsumerConnector(consumerConfig);
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put("rongyunasync", new Integer(1));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumerConnector.createMessageStreams(topicCountMap);
        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get("rongyunasync");
        for (KafkaStream<byte[], byte[]> stream : streams) {
            StreamConsumer streamConsumer = new StreamConsumer(stream);
            new Thread(streamConsumer).start();
        }
    }




    class StreamConsumer implements Runnable {

        private KafkaStream stream;

        public StreamConsumer(KafkaStream stream) {
            this.stream = stream;
        }

        public void run() {
            ConsumerIterator<byte[], byte[]> it = this.stream.iterator();
            while (it.hasNext()) {
                System.out.println("Consumed message: " +  new String(it.next().message()));
            }
        }
    }



    public static void main(String[] args) {
        new ConsumerTest();
    }


}