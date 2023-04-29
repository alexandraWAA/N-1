package com.example.n1.repository;

import com.example.n1.model.Post;
import com.example.n1.projection.PostProjection;
import com.example.n1.projection.UsersProjection;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = "SELECT userId, userName, COUNT(DISTINCT p.id) AS allPosts, " +
            "COUNT(DISTINCT c2.id) AS allComments, " +
            " (SELECT p2.id FROM post AS p2 WHERE p2.user_id = table1.userId " +
            "ORDER BY (SELECT COUNT(*) FROM comment WHERE post_id = p2.id) " +
            "DESC, p2.id DESC LIMIT 1) AS lastPostId FROM (SELECT u.id AS userId, u.userName AS username, " +
            "COUNT(table2.id) AS countCommentsOnPost FROM comment AS table2 " +
            "JOIN users AS u ON table2.user_id=u.id GROUP BY u.id, u.userName " +
            " ORDER BY countCommentsOnPost DESC) AS table1 " +
            "JOIN post AS p ON table1.userId = p.user_id LEFT JOIN comment AS c2 ON table1.userId = c2.user_id " +
            "GROUP BY userId, userName LIMIT 10", nativeQuery = true)
    List<UsersProjection> findTopTenUsers(@Param("postId") Long postId);

//    @EntityGraph(attributePaths = {"comments", "user"})
    List<Post> findAllBy();

    List<PostProjection> findProjBy(PageRequest pageRequest);
}
