package com.fracta.newsaggregation.model;

public enum VoteType {
	UPVOTE(1), DOWNVOTE(-1);
	
	private Integer direction;
	
	VoteType(int direction) {
		this.direction = direction;
	}
	
	public Integer getDirection() {
		return direction;
	}
}