package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Repository
public class CommentDaoJdbcTemplateImpl implements CommentDao {

    private String INSERT_COMMENT =
            "insert into comment (post_id, create_date, commenter_name, comment)" +
                    " values(?,?,?,?)";
    private String SELECT_COMMENT_BY_ID =
            "select * from comment where comment_id = ?";
    private String SELECT_ALL_COMMENTS =
            "select * from comment";
    private String SELECT_COMMENTS_BY_POST_ID =
            "select * from comment where post_id = ? ";
    private String UPDATE_COMMENTS =
            "update comment set post_id = ?, create_date = ?, commenter_name = ?, comment = ? where comment_id = ?";
    private String DELETE_COMMENT =
            "delete from comment where comment_id = ?";

    JdbcTemplate jdbcTemplate;

    @Autowired
    public CommentDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Comment createComment(Comment comment) {
        jdbcTemplate.update(
                INSERT_COMMENT,
                comment.getPostId(),
                comment.getCreateDate(),
                comment.getCommenterName(),
                comment.getComment()
        );

        int id =
                jdbcTemplate.queryForObject(
                        "select last_insert_id()",
                        Integer.class
                );

        comment.setCommentId(id);


        return comment;
    }

    @Override
    public Comment getComment(int id) {

        try {
            return jdbcTemplate.queryForObject(
                    SELECT_COMMENT_BY_ID,
                    this::mapRowToComment,
                    id
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    @Override
    public List<Comment> getAllComments() {
        try {
            return jdbcTemplate.query(
                    SELECT_ALL_COMMENTS,
                    this::mapRowToComment
            );
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public List<Comment> getCommentsByPostId(int id) {
        try {
            return jdbcTemplate.query(
                    SELECT_COMMENTS_BY_POST_ID,
                    this::mapRowToComment,
                    id
            );
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public void updateComment(Comment comment, int id) {
        jdbcTemplate.update(UPDATE_COMMENTS,
                comment.getPostId(),
                comment.getCreateDate(),
                comment.getCommenterName(),
                comment.getComment(),
                id
        );
    }

    @Override
    public void deleteComment(int id) {
        jdbcTemplate.update(DELETE_COMMENT, id);
    }

    private Comment mapRowToComment(ResultSet rs, int rowNumber) throws SQLException {

        Comment comment = new Comment();
        comment.setCommentId(rs.getInt("comment_id"));
        comment.setPostId(rs.getInt("post_id"));
        comment.setCreateDate(rs.getDate("create_date").toLocalDate());
        comment.setCommenterName(rs.getString("commenter_name"));
        comment.setComment(rs.getString("comment"));

        return comment;
    }


}
