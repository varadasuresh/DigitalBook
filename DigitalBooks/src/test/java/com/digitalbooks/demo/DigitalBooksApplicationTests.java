package com.digitalbooks.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.digitalbooks.demo.entity.Aurthor;
import com.digitalbooks.demo.entity.Book;
import com.digitalbooks.demo.repository.AurthorRepository;
import com.digitalbooks.demo.repository.BookRepository;
import com.digitalbooks.demo.service.serviceImpl.AurthorServiceImpl;

@SpringBootTest
class DigitalBooksApplicationTests {
    @Autowired
    AurthorRepository aurthorRepository;
    @Autowired
	BookRepository BookRepository;
    @Test
    void contextLoads() {
    }
    @Test
    public void testauthor() {
        Aurthor author =new Aurthor();
        author.setEmail("xyz");
        aurthorRepository.save(author);
        
    }
public void testbook() {
	Book book = new Book ();
	book.setBookid(123);
	BookRepository.save(book);
}
}

