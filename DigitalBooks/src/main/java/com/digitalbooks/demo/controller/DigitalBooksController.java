package com.digitalbooks.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.demo.dto.AurthorDto;
import com.digitalbooks.demo.dto.AurthorSignUpDto;
import com.digitalbooks.demo.dto.BookDto;
import com.digitalbooks.demo.dto.ReaderBooks;
import com.digitalbooks.demo.dto.ReaderDto;
import com.digitalbooks.demo.service.serviceImpl.AurthorServiceImpl;
import com.digitalbooks.demo.service.serviceImpl.BookServiceImpl;
import com.digitalbooks.demo.service.serviceImpl.ReaderServiceImpl;

@RestController
public class DigitalBooksController {

	@Autowired
	AurthorServiceImpl AurthorServiceImpl;

	@Autowired
	BookServiceImpl bookServiceImpl;

	@Autowired
	ReaderServiceImpl ReaderServiceImpl;

	@PostMapping(value = "/aurthor/signup")
	public void signUpAurthor(@RequestBody AurthorSignUpDto aurthorSignUpDto) throws Exception {
		AurthorServiceImpl.registerAurthor(aurthorSignUpDto);

	}

	@PostMapping(value = "/aurthor/login")
	public String loginUser(@RequestBody AurthorDto aurthorDto) {
		return AurthorServiceImpl.aurthorLoggedIn(aurthorDto);

	}

	@PostMapping(value = "/aurthor/logout")
	public String logOutUser(@RequestBody AurthorDto aurthorDto) {
		return AurthorServiceImpl.aurthorLoggedOut(aurthorDto);

	}

	@PostMapping(value = "/book")
	public String saveBookDetails(@RequestBody BookDto bookDetails) {

		return bookServiceImpl.saveBookDetails(bookDetails);

	}

	@PatchMapping(value = "/book")
	public String editBookBook(@RequestBody BookDto bookDetails) {
		return bookServiceImpl.updateBook(bookDetails);
	}

	@PostMapping(value = "/digital/books/buy")
	public String buyBook(@RequestBody ReaderDto ReaderDto) {
		return ReaderServiceImpl.BuyBook(ReaderDto);

	}

	@GetMapping(value = "/digital/books/readers/{emailId}/books")
	public ReaderBooks getReaderPurchasedBook(@PathVariable String emailId, @RequestParam int paymentId) {

		return ReaderServiceImpl.getReaderBooks(emailId, paymentId);

	}

	@GetMapping(value = "/digital/books/readers/{emailId}/books/{bookId}")
	public BookDto getReaderBooks(@PathVariable String emailId, @PathVariable int bookId) {

		return ReaderServiceImpl.readBook(emailId, bookId);

	}

	@GetMapping(value = "/digital/books/readers/{emailId}/allBooks")
	public ReaderBooks getReaderPurchasedAllBooks(@PathVariable String emailId) {

		return ReaderServiceImpl.getReaderBooks(emailId);

	}

	@GetMapping(value = "/digital/books/search")
	public BookDto getReaderPurchasedAllBooks(@RequestParam String category, @RequestParam String author,
			@RequestParam String price, @RequestParam String publisher) {

		return bookServiceImpl.searchBooks(category, author, price, publisher);

	}

}
