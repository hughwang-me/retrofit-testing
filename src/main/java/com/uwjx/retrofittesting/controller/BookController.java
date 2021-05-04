package com.uwjx.retrofittesting.controller;

import com.rx.commons.model.ResultModel;
import com.uwjx.retrofittesting.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "book")
public class BookController {

    @GetMapping
    public ResultModel books(){
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Book book = new Book();
            book.setId((long)i);
            book.setName("书名称:" + i);
            book.setAuthor("作者:"+i);
            book.setPrice((double)i);
            books.add(book);
        }
        return ResultModel.success(books);
    }

}
