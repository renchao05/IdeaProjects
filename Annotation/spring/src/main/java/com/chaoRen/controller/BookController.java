package com.chaoRen.controller;

import com.chaoRen.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;

}
