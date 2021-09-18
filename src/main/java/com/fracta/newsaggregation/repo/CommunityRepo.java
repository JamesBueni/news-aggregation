package com.fracta.newsaggregation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fracta.newsaggregation.model.Community;

@Repository
public interface CommunityRepo extends JpaRepository<Community, Long> {

}
