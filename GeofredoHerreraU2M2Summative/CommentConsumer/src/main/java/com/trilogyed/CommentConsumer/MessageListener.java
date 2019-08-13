package com.trilogyed.CommentConsumer;

import com.trilogyed.CommentConsumer.message.Comment;
import com.trilogyed.CommentConsumer.util.feign.CommentFeignClient;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @Autowired
    CommentFeignClient commentFeignClient;

    @RabbitListener(queues = CommentConsumerQueueApplication.QUEUE_NAME)
    public void receiveMessage(Comment msg) {

        System.out.println("Message received and processing.");

        Comment comment = commentFeignClient.createComment(msg);

        System.out.println(msg.toString() + " message sent.");
    }
}
