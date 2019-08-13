package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
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
public class PostDaoJdbcTemplateImpl implements PostDao {
    private String INSERT_POST =
            "insert into post (post_date, poster_name, post)" +
                    "values(?, ?, ?)";
    private String SELECT_POST_BY_ID =
            "select * from post where post_id = ?";
    private String SELECT_ALL_POSTS =
            "select * from post";
    private String SELECT_POSTS_BY_POSTER =
            "select * from post where poster_name = ?";
    private String UPDATE_POST =
            "update post set post_date = ?, poster_name = ?, post = ? where post_id = ?";
    private String DELETE_POST =
            "delete from post where post_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PostDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Post createPost(Post post) {
        jdbcTemplate.update
                (INSERT_POST,
                        post.getPostDate(),
                        post.getPosterName(),
                        post.getPost());

        int id =
                jdbcTemplate.queryForObject
                        ("select last_insert_id()",
                                Integer.class);

        post.setPostId(id);

        return post;
    }

    @Override
    public Post getPost(int id) {
        try {

            return
                    jdbcTemplate.queryForObject(
                            SELECT_POST_BY_ID,
                            this::mapRowToPost
                            , id
                    );

        } catch (EmptyResultDataAccessException e) {

            return null;
        }

    }

    @Override
    public List<Post> getAllPosts() {

        try {
            return
                    jdbcTemplate.query(
                            SELECT_ALL_POSTS,
                            this::mapRowToPost
                    );
        } catch (EmptyResultDataAccessException e) {

            return Collections.emptyList();

        }
    }

    @Override
    public List<Post> getPostsByPoster(String name) {
        try {

            return
                    jdbcTemplate.query(
                            SELECT_POSTS_BY_POSTER,
                            this::mapRowToPost,
                            name
                    );

        } catch (EmptyResultDataAccessException e) {

            return Collections.emptyList();

        }

    }

    @Override
    @Transactional
    public void updatePost(Post post, int id) {

        jdbcTemplate.update(
                UPDATE_POST,
                post.getPostDate(),
                post.getPosterName(),
                post.getPost(),
                id
        );

    }

    @Override
    @Transactional
    public void deletePost(int id) {

        jdbcTemplate.update(
                DELETE_POST,
                id
        );

    }

    private Post mapRowToPost(ResultSet rs, int rowNumber) throws SQLException {

        Post post = new Post();
        post.setPostId(rs.getInt("post_id"));
        post.setPostDate(rs.getDate("post_date").toLocalDate());
        post.setPosterName(rs.getString("poster_name"));
        post.setPost(rs.getString("post"));

        return post;

    }
}
