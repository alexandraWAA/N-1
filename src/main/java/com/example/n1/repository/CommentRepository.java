package com.example.n1.repository;

import com.example.n1.model.Comment;
import com.example.n1.projection.CommentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "SELECT c.id, c.body, c.post_id AS postId FROM comment AS c WHERE c.post_id IN (?1) ", nativeQuery = true)
    List<CommentProjection> findByPostIdIn(List<Long> postIds);
}
