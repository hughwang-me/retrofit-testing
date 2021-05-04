package com.uwjx.retrofittesting.service;

import com.alibaba.fastjson.JSON;
import com.uwjx.retrofittesting.model.Book;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

@Slf4j
public class TestService {

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:19800/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BookService service = retrofit.create(BookService.class);



        try {
//            Call<List<Book>> repos = service.listRepos();
//            Response<List<Book>> response = repos.execute();
//            for (Book book : response.body()) {
//                log.warn("结果:{}" , JSON.toJSONString(book));
//            }

            Call<Book> bookCall = service.getByBookId(1);
            Response<Book> response = bookCall.execute();
            log.warn("结果：{}" , response.body());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
