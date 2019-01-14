package kafka;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;



public class KfConsume {
	
	
	public static void main(String[] args) throws UnsupportedEncodingException{
		commonConsumerStart();
	}

	
	private static void commonConsumerStart() throws UnsupportedEncodingException {
		
		Map<String, Object> props = new HashMap<String, Object>();
	    props.put("bootstrap.servers", "XXX:9092");
	    props.put("group.id", "test1234");
	    props.put("zookeeper.connect", "XXXX:2181/kafka");
	    props.put("partition.assignment.strategy", "range");
	    props.put("key.deserializer", StringDeserializer.class.getName());
	    props.put("value.deserializer",StringDeserializer.class.getName());
	    props.put("session.timeout.ms", 10000);
	    props.put("enable.auto.commit", true);
	    props.put("auto.commit.interval.ms", 10000);
      
        props.put("zookeeper.session.timeout.ms", "6000");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "smallest");
        props.put("client.id", "test5");
     
		@SuppressWarnings("resource")
		KafkaConsumer<String, Object> consumer = new KafkaConsumer<String, Object>(props);
		consumer.subscribe("rongyunasync");
		 while (true) {
		        Map<String, ConsumerRecords<String, Object>> records = consumer.poll(100);
		        if(records != null){
		        	int count = records.size();
			        if(count > 0){
			        	 System.out.println("record size: "+ records.size());
			        	 for (Entry<String, ConsumerRecords<String, Object>> recordMetadata : records.entrySet()) {
			        		  List<ConsumerRecord<String, Object>> recordsPerTopic = recordMetadata.getValue().records();
			        		  for(int i = 0;i < recordsPerTopic.size();i++) {
			   	               ConsumerRecord<String, Object> record = recordsPerTopic.get(i);
			   	               try {
			   	            	System.out.println(URLDecoder.decode((String) record.key(),"UTF-8"));
			   	            	 System.out.println(URLDecoder.decode((String) record.value(),"UTF-8"));
			   	               } catch (Exception e) {
			   	               	e.printStackTrace();
			   	               }               
			   	          }
						}
			        }
		        }
		        
		    }
		
	}
	
	
    
    
   
//	 while (true) {
//	        ConsumerRecords<String, Object> records = consumer.poll(100);
//	        int count = records.count();
//	        if(count > 0){
//	        	 System.out.println("record size: "+ records.count());
//			        for (ConsumerRecord<String, Object> record : records){
//			            System.out.println(URLDecoder.decode((String) record.value(),"UTF-8"));
//			        }
//	        }
//	    }
    
	/**
	 * 只消费最新的msg
	 */
//	private static void commonConsumer() {
//		Properties props = new Properties();
//	    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//	    props.put(ConsumerConfig.GROUP_ID_CONFIG, "test");
//	    props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
//	    props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
////	    props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
//	    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//	    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
//
////	    @SuppressWarnings("resource")
////		KafkaConsumer<String, Object> consumer = new KafkaConsumer<String, Object>(props);
////	    consumer.subscribe(Arrays.asList(KfConstant.topic));
////	    while (true) {
////	        ConsumerRecords<String, Object> records = consumer.poll(100);
////	        for (ConsumerRecord<String, Object> record : records)
////	            System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
////	    }
////	    consumer.close();
//	}
	


}
