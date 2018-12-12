package com.example.ElasticSearch.demoElasticSearch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.ElasticSearch.demoElasticSearch.exceptions.BookNotFoundException;
import com.example.ElasticSearch.demoElasticSearch.model.Book;
import com.example.ElasticSearch.demoElasticSearch.repository.BookRepository;

	@Service
	public class BookServiceImpl implements BookService {

	    private BookRepository bookRepository;

		@Autowired
	    public void setBookRepository(BookRepository bookRepository) {
	        this.bookRepository = bookRepository;
	    }

		
	    public Book save(Book book) {
	        return bookRepository.save(book);
	    }

	    public void delete(Book book) {
	        bookRepository.delete(book);
	    }


	    public Iterable<Book> findAll() {
	        return bookRepository.findAll();
	    }

	    public Page<Book> findByAuthor(String author, PageRequest pageRequest) {
	        return bookRepository.findByAuthor(author, pageRequest);
	    }

	    public List<Book> findByTitle(String title) {
	        return bookRepository.findByTitle(title);
	    }

		public Book findOne(String id) {
			Optional<Book> book=bookRepository.findById(id);
			if (! book.isPresent()) {
				throw new BookNotFoundException("id-" + id);
			}
			return book.get();
		}

}
