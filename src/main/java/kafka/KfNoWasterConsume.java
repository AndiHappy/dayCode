package kafka;

import java.util.Arrays;
import java.util.Properties;
import java.util.UUID;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;



public class KfNoWasterConsume {
	
	
	public static void main(String[] args){
		
		commonConsumer();
		
		commonConsumerStart();
	}

	
	private static void commonConsumerStart() {
		
		Properties props = new Properties();
	    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	    props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
	    props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
	    props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
	    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
	    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
	    
	    //从头开始消费
	    props.put(ConsumerConfig.GROUP_ID_CONFIG, "test"+UUID.randomUUID().toString());
	    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

	    @SuppressWarnings("resource")
		KafkaConsumer<String, Object> consumer = new KafkaConsumer<String, Object>(props);
	    consumer.subscribe(Arrays.asList(KfConstant.topic));
		 while (true) {
		        ConsumerRecords<String, Object> records = consumer.poll(100);
		        int count = records.count();
		        if(count > 0){
		        	 System.out.println("record size: "+ records.count());
				        for (ConsumerRecord<String, Object> record : records){
				            System.out.printf("offset = %d, key = %s, value = %s \n", record.offset(), record.key(), record.value());
				        }
		        }
		    }
		
	}

	/**
	 * 只消费最新的msg
	 */
	private static void commonConsumer() {
		Properties props = new Properties();
	    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	    props.put(ConsumerConfig.GROUP_ID_CONFIG, "test");
	    props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
	    props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
	    props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
	    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
	    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());

	    @SuppressWarnings("resource")
		KafkaConsumer<String, Object> consumer = new KafkaConsumer<String, Object>(props);
	    consumer.subscribe(Arrays.asList(KfConstant.topic));
	    while (true) {
	        ConsumerRecords<String, Object> records = consumer.poll(100);
	        for (ConsumerRecord<String, Object> record : records)
	            System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
	    }
//	    consumer.close();
	}
	


}
