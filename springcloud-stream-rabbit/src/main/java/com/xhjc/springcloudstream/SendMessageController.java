package com.xhjc.springcloudstream;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@EnableBinding(Source.class)
public class SendMessageController {

	@Autowired
	private Source source;

	/**
	 * http://localhost:8080/send?message=123
	 * @param message
	 * @return
	 */
	@GetMapping("/send")
	public Object send(String message) {
//		MessageBuilder<String> messageBuilder = MessageBuilder.withPayload(message);
		MessageBuilder<String> messageBuilder = MessageBuilder.withPayload(message).setHeader("routingkey","info");
		source.output().send(messageBuilder.build());
		return "message sended : "+message;
	}

	/**
	 * http://localhost:8080/sendBatch
	 * @return
	 */
	@GetMapping("/sendBatch")
	public Object sendbatch() {
		for(int i = 0 ; i < 10 ; i ++) {
			MessageBuilder<String> messageBuilder = MessageBuilder.withPayload("这是第"+i+"条消息");
			source.output().send(messageBuilder.build());
		}
		return "message batch sended";
	}
}
