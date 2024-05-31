package com.onlinebookstore.bookstore.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.onlinebookstore.bookstore.model.Book;
import com.onlinebookstore.bookstore.repository.BookRepository;
import com.onlinebookstore.bookstore.request.CreateBookRequest;

@Service
public class BookServiceImpl implements BookService {

	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}
	
	private BookRepository bookRepository;


	@Override
	public Book createBook(CreateBookRequest req) {
		
		Book book = new Book();
		
		book.setGenre(req.getGenre());
		book.setAuthor(req.getAuthor());
		book.setAvailable(req.isAvailable());
		book.setDescription(req.getDescription());
		book.setImages(req.getImages());
		book.setDateAdded(new Date());
		book.setPrice(req.getPrice());
		book.setTitle(req.getTitle());
		book.setQuantityInStock(req.getQuantityInStock());
		
		return bookRepository.save(book);
	}

	@Override
	public void deleteBook(Long bookId) throws Exception {
//		Book book = findBookById(bookId);

	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> searchBook(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findBookById(Long bookId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book updateAvailabilityStatus(Long bookId) throws Exception {
		
		return null;
	}

}
