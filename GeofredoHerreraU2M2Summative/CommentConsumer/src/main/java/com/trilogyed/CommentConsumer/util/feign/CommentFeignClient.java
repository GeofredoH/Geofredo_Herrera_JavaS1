package com.trilogyed.CommentConsumer.util.feign;

import com.trilogyed.CommentConsumer.message.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
//import java.util.List;

@FeignClient(name = "comment-service")
public interface CommentFeignClient {

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComment(@Valid @RequestBody Comment comment);

}
