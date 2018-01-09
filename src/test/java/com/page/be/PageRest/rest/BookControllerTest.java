package com.page.be.PageRest.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.page.be.PageRest.PageRestApplication;
import com.page.be.PageRest.domain.book.BookDao;
import com.page.be.PageRest.domain.book.BookDto;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=PageRestApplication.class)
public class BookControllerTest {
	private MockMvc mockMvc;
	@Mock
	@Autowired
	BookDao bookDao;
	@InjectMocks
	@Autowired
	BookController bookController;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders
				.standaloneSetup(bookController)
				.build();
	}
	
	@Test
	@DirtiesContext
	public void post_insert_book_basic() throws Exception {
		BookDto dto = new BookDto();
		dto.setAuthor("New Author");
		dto.setTitle("New Title");
		dto.setContent("New Content");
		dto.setImgSrc("source://example.com");
		dto.setUid(10001L);
		mockMvc.perform(
				post("/book")
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.content(asJsonString(dto))
				)
				.andExpect(status().isOk());
	}
	
	/*
     * converts a Java object into JSON representation
     */
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
