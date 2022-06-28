package com.skcc.tes.payment.infrastructure.adapters.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skcc.tes.payment.PaymentApplication;
import com.skcc.tes.payment.domain.ports.spi.PaymentMessagePort;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.util.MimeTypeUtils;

public class AbstractKafkaEventAdapter implements PaymentMessagePort {

    String eventType;
    Long timestamp;

    public AbstractKafkaEventAdapter(){
        this.setEventType(this.getClass().getSimpleName());
        // SimpleDateFormat defaultSimpleDateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
        // this.timestamp = defaultSimpleDateFormat.format(new Date());
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public String toJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;

        try {
            json = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON format exception", e);
        }

        return json;
    }

    @Override
    public void publish(String json){
        if( json != null ){

            /**
             * spring streams 방식
             */
            KafkaProcessor processor = PaymentApplication.getApplicationContext().getBean(KafkaProcessor.class);
            MessageChannel outputChannel = processor.outboundTopic();

            outputChannel.send(MessageBuilder
                    .withPayload(json)
                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                    .build());

        }
    }

    @Override
    public void publish(){
        this.publish(this.toJson());
    }

    @Override
    public void publishAfterCommit(){
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {

            @Override
            public void afterCompletion(int status) {
                AbstractKafkaEventAdapter.this.publish();
            }
        });
    }


    @Override
    public String getEventType() {
        return eventType;
    }

    @Override
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @Override
    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean validate(){
        return getEventType().equals(getClass().getSimpleName());
    }
}