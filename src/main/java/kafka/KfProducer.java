package kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





public class KfProducer {

	private final static Logger log = LoggerFactory.getLogger(KfProducer.class);

	private static class InstanceHolder {
		private static final KfProducer instance = new KfProducer();
	}

	public static KfProducer getInstance() {
		return InstanceHolder.instance;
	}
	
	private static KafkaProducer<String,Object> producer = null;

	static {  //public KfProducer() {
		Properties props = new Properties();
		props.put("zk.connect", "127.0.0.1:2181");
		props.put("producer.type", "async");
		props.put("bootstrap.servers", "127.0.0.1:9092,127.0.0.1:9093,127.0.0.1:9094");
		props.put("client.id", "DemoProducer");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
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
					System.out.println("发送完成！");
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