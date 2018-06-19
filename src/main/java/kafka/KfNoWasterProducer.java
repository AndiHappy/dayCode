package kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KfNoWasterProducer {

	private final static Logger log = LoggerFactory.getLogger(KfProducer.class);

	private static class InstanceHolder {
		private static final KfNoWasterProducer instance = new KfNoWasterProducer();
	}

	public static KfNoWasterProducer getInstance() {
		return InstanceHolder.instance;
	}
	
	private static KafkaProducer<String,Object> producer = null;

	
	static {  //public KfProducer() {
		Properties props = new Properties();
		
		props.put("zk.connect", "127.0.0.1:2181");
		props.put("producer.type", "async");
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092,127.0.0.1:9093,127.0.0.1:9094");
		props.put(ProducerConfig.CLIENT_ID_CONFIG, "DemoProducer");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

//		使用KafkaProducer.send(record, callback)
//		如果仅仅是要消息无丢失，使用带callback的send方法；如果还要保证无乱序问题，那么发送失败时一定要在callback逻辑中立即关闭producer：close(0) 
//		unclean.leader.election.enable=false
//		replication.factor = 3 
//		min.insync.replicas = 2
//		replication.factor > min.insync.replicas
//		enable.auto.commit=false
		
		
		props.put(ProducerConfig.ACKS_CONFIG, "all");
		props.put(ProducerConfig.RETRIES_CONFIG, Integer.MAX_VALUE);
		props.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION,"1");
		producer = new KafkaProducer<String,Object> (props);
		log.info("init kafka producer!");
	}

	/**
	 * 单线程存储：不指定partitionKey
	 *
	 * @param message
	 * @param topic
	 */
	public void sendMessage(String topic, Object message) {
		sendMessage(topic, null, message);
	}

	/**
	 * 多线程存储：分partition保存。特殊业务需要按本partition内保证消息的有序性
	 * 
	 * @param topic
	 * @param partitionKey
	 * @param message
	 */
	public void sendMessage(String topic, String partitionKey, Object message) {
		try {
			ProducerRecord<String, Object> data = new ProducerRecord<String, Object>(topic, partitionKey, message);
			Callback callback = new Callback() {
				@Override
				public void onCompletion(RecordMetadata metadata, Exception exception) {
					if(exception != null){
						System.out.println("");
					}
				}
			};
			producer.send(data, callback );
		} catch (Throwable e) {
			log.error("sendMessage " + message + "  topic = " + topic, e);
		}
	}

	
	public static void main(String[] args) throws InterruptedException {
		while (true) {
			for (int i = 1; i <= 10; i++) {
				KfProducer.getInstance().sendMessage(KfConstant.topic, i + "",  "kafka prducer  = " + i);
				Thread.sleep(1000);
			}	
		}
		
	}

}