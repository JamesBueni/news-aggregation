package com.fracta.newsaggregation.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "communities")
public class Community {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long communityId;
	@NotBlank(message = "Community name is required.")
	private String name;
	@NotBlank(message = "Community description is required.")
	private String description;
	@OneToMany(fetch = FetchType.LAZY)
	private List<Post> posts;
	private Instant creationDate;
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
}
