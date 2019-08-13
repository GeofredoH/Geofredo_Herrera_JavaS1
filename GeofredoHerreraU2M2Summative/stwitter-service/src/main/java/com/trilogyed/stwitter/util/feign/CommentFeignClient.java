package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.dto.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "comment-service")
public interface CommentFeignClient {
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Comment findComment(@PathVariable("id") int id);

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> findAllComments();

    @RequestMapping(value = "/comments/postid/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> findCommentsByPostId(@PathVariable("id") int id);

    @RequestMapping(value = ("/comment/{id}"), method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateComment(@Valid @RequestBody Comment comment, @PathVariable("id") int id);

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable("id") int id);

}
