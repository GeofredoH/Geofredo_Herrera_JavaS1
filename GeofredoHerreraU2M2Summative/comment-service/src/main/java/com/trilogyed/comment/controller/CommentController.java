package com.trilogyed.comment.controller;

import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.exception.NotFoundException;
import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentDao commentDao;

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComment(@Valid @RequestBody Comment comment) {
        comment = commentDao.createComment(comment);

        if (comment == null) {
            throw new NotFoundException(
                    "Unable to return comment recently created."
            );
        }
        return comment;

    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Comment findComment(@PathVariable("id") int id) {
        Comment comment = commentDao.getComment(id);

        if (comment == null) {
            throw new NotFoundException(
                    "No commment found for id " + id
            );
        }
        return comment;
    }

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> findAllComments() {
        List<Comment> comments = commentDao.getAllComments();

        if (comments.isEmpty()) {
            throw new NotFoundException("No comments found at this time.");
        }
        return comments;
    }

    @RequestMapping(value = "/comments/postid/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> findCommentsByPostId(@PathVariable("id") int id) {
        List<Comment> comments = commentDao.getCommentsByPostId(id);

        if (comments.isEmpty()) {
            throw new NotFoundException("No comments found for post id " + id);
        }
        return comments;
    }

    @RequestMapping(value = ("/comment/{id}"), method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateComment(@Valid @RequestBody Comment comment, @PathVariable("id") int id) {
        if (comment.getCommentId() != id) {
            throw new NotFoundException(
                    "Id in endpoint must match comment id"
            );
        }
        commentDao.updateComment(comment, id);
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable("id") int id) {
        commentDao.deleteComment(id);
    }

}
