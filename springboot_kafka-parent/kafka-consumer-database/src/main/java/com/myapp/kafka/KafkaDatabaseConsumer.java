package com.myapp.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.myapp.entity.WikimediaData;
import com.myapp.repository.WikimediaDataRepository;

@Service
public class KafkaDatabaseConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

	private WikimediaDataRepository dataRepository;

	public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository) {
		super();
		this.dataRepository = dataRepository;
	}

	@KafkaListener(topics = "ms-topic", groupId = "myGroup")
	public void consume(String eventMessage) {
		LOGGER.info(String.format("Event message received -> %s", eventMessage));
		
		WikimediaData wikimediaData=new WikimediaData();
		wikimediaData.setWikiEventData(eventMessage);
		
		dataRepository.save(wikimediaData);
	}

}
