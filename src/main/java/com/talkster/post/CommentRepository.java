package com.talkster.post;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long>{

    List<Comment> getCommentsByPost(Post post);

}
