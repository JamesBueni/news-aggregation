package com.fracta.newsaggregation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fracta.newsaggregation.model.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long>{

}
