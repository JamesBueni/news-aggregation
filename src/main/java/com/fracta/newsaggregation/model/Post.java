package com.fracta.newsaggregation.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Post name is required.")
	private String name;
	@Nullable
	private String url;
	@Nullable
	@Lob
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "authorId", referencedColumnName = "id")
	private User author;
	private Integer voteCount;
	private Instant creationDate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "communityId", referencedColumnName = "id")
	private Community community;
	
}
