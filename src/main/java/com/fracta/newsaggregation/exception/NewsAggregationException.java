package com.fracta.newsaggregation.exception;

public class NewsAggregationException extends RuntimeException {

	public NewsAggregationException(String message) {
		super(message);
	}
	
	public NewsAggregationException(String message, Exception e) {
		super(message, e);
	}
}
