package com.example.ElasticSearch.demoElasticSearch.exceptions;

public class BookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7936031236813973438L;

	public BookNotFoundException(String exception) {
		super(exception);
	}

}
