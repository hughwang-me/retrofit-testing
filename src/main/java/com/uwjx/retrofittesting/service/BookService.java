package com.uwjx.retrofittesting.service;

import com.uwjx.retrofittesting.model.Book;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface BookService {

    @GET("book/list")
    Call<List<Book>> listRepos();

    @GET("book/getById/{id}")
    Call<Book> getByBookId(@Path("id") Integer id);
}
