package com.quguai.dao;

import com.quguai.bean.Article;
import com.quguai.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.Repository;

public interface BookDao extends ElasticsearchRepository<Book, Integer> {
    Book findBookByAuthorLike(String author);
}
