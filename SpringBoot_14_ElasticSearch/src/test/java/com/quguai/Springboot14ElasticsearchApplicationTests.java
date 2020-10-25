package com.quguai;

import com.quguai.bean.Article;
import com.quguai.bean.Book;
import com.quguai.dao.BookDao;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.io.IOException;

@SpringBootTest
class Springboot14ElasticsearchApplicationTests {

	@Autowired
	RestClient restClient;

	@Autowired
	BookDao bookDao;

	@Autowired
	ElasticsearchRestTemplate restTemplate;

	@Test
	void add() throws IOException {
		Article article = new Article(1, "李扬", "钢铁", "hello");
		Request request = new Request("POST", "/megacorp/article/1");
		request.addParameter("pretty", "true");
		JSONObject jsonObject = new JSONObject(article);

		System.out.println(jsonObject.toString());
		request.setEntity(new NStringEntity(jsonObject.toString()));
		Response response = restClient.performRequest(request);
		String s = EntityUtils.toString(response.getEntity());
		System.out.println(s);
	}

	@Test
	void getById() throws IOException {
		Article article = new Article(1, "李扬", "钢铁", "hello");
		Request request = new Request("GET", "/megacorp/article/1");
		request.addParameter("pretty", "true");
		Response response = restClient.performRequest(request);
		String s = EntityUtils.toString(response.getEntity());
		System.out.println(s);
	}

	@Test
	void updateById() throws IOException {
		Article article = new Article(1, "李1扬", "钢铁", "hello");
		Request request = new Request("GET", "/megacorp/article/1");
		request.addParameter("pretty", "true");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("doc", new JSONObject(article));
		request.setEntity(new NStringEntity(jsonObject.toString()));

		Response response = restClient.performRequest(request);
		String s = EntityUtils.toString(response.getEntity());
		System.out.println(s);
	}

	@Test
	public void saveBook(){
		bookDao.save(new Book(1, "ll", "s", "d"));
	}
	@Test
	public void likeBook(){
		Book l = bookDao.findBookByAuthorLike("l");
		System.out.println(l);
	}
}
