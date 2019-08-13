package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentDaoJdbcTemplateImplTest {

    @Autowired
    CommentDao commentDao;

    @Before
    public void setUp() throws Exception {
        List<Comment> comments = commentDao.getAllComments();

        comments.stream()
                .forEach(comment -> commentDao.deleteComment(comment.getCommentId()));
    }

    @Test
    public void createComment() {
        Comment comment = new Comment();
        comment.setPostId(6);
        comment.setCreateDate(LocalDate.now());
        comment.setCommenterName("George Moss");
        comment.setComment("I don't agree with this post.");
        comment = commentDao.createComment(comment);

        Comment comment2 = commentDao.getComment(comment.getCommentId());

        assertEquals(comment, comment2);

        comment2 = commentDao.getComment(7);

        assertNull(comment2);
    }

    @Test
    public void getAllComments() {
        List<Comment> comments = new ArrayList<>();

        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.now());
        comment.setCommenterName("George Moss");
        comment.setComment("I don't like that post.");
        comment = commentDao.createComment(comment);
        comments.add(comment);

        Comment comment2 = new Comment();
        comment2.setPostId(2);
        comment2.setCreateDate(LocalDate.now());
        comment2.setCommenterName("Sam Tom");
        comment2.setComment("This is the best post.");
        comment2 = commentDao.createComment(comment2);
        comments.add(comment2);

        List<Comment> comments2 = commentDao.getAllComments();

        assertEquals(comments, comments2);

        comments2.stream()
                .forEach(comm -> commentDao.deleteComment(comm.getCommentId()));

        comments2 = commentDao.getAllComments();

        assertTrue(comments2.isEmpty());

    }

    @Test
    public void getCommentsByPostId() {
        List<Comment> comments = new ArrayList<>();

        Comment comment = new Comment();
        comment.setPostId(3);
        comment.setCreateDate(LocalDate.now());
        comment.setCommenterName("Steve Nash");
        comment.setComment("This post is very agreeable.");
        comment = commentDao.createComment(comment);
        comments.add(comment);

        Comment comment2 = new Comment();
        comment2.setPostId(3);
        comment2.setCreateDate(LocalDate.now());
        comment2.setCommenterName("Steve Wozniack");
        comment2.setComment("Well said brother.");
        comment2 = commentDao.createComment(comment2);
        comments.add(comment2);

        List<Comment> comments2 = commentDao.getCommentsByPostId(3);

        assertEquals(comments, comments2);

        comments2.stream()
                .forEach(comm -> commentDao.deleteComment(comm.getCommentId()));

        comments2 = commentDao.getCommentsByPostId(3);

        assertTrue(comments2.isEmpty());

    }

    @Test
    public void updateComment() {

        Comment comment = new Comment();
        comment.setCreateDate(LocalDate.now());
        comment.setCommenterName("John Wilkes Booth");
        comment.setComment("Totes Mcgotes on this idea.");
        comment = commentDao.createComment(comment);

        comment.setComment("Actually, we should wait on this one.");

        commentDao.updateComment(comment, comment.getCommentId());

        Comment comment2 = commentDao.getComment(comment.getCommentId());

        assertEquals(comment, comment2);


    }

    @Test
    public void deleteComment() {
        Comment comment = new Comment();
        comment.setPostId(2);
        comment.setCreateDate(LocalDate.now());
        comment.setCommenterName("John Wilkes Booth");
        comment.setComment("Totes Mcgotes on this idea.");
        comment = commentDao.createComment(comment);

        commentDao.deleteComment(2);

        comment = commentDao.getComment(2);

        assertNull(comment);

    }
}