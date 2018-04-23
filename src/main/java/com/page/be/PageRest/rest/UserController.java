package com.page.be.PageRest.rest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.page.be.PageRest.domain.JwtUser;
import com.page.be.PageRest.domain.bookmark.BookmarkDao;
import com.page.be.PageRest.domain.user.UserDto;
import com.page.be.PageRest.rest.response.BookResponseDto;
import com.page.be.PageRest.security.JwtGenerator;
import com.page.be.PageRest.security.JwtValidator;
import com.page.be.PageRest.security.UserPasswordEncoder;
import com.page.be.PageRest.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.page.be.PageRest.domain.book.Book;
import com.page.be.PageRest.domain.book.BookDao;
import com.page.be.PageRest.domain.bookmark.Bookmark;
import com.page.be.PageRest.domain.collection.Collection;
import com.page.be.PageRest.domain.user.User;
import com.page.be.PageRest.domain.user.UserDao;

@RestController
public class UserController {
	@Autowired
	UserDao userDao;
	@Autowired
	BookDao bookDao;
	@Autowired
	BookmarkDao bmDao;
	@Autowired
	UserPasswordEncoder encoder;
	@Autowired
	JwtGenerator gen;
	@Autowired
	JwtValidator validator;

	@GetMapping("/user/{uid}")
	public User fetchUsers(@PathVariable Long uid) {
		return userDao.findById(uid);
	}

	@GetMapping("/user/{uid}/collections")
	public List<Collection> fetchCollections(@PathVariable Long uid) {
		return userDao.retrieveCollections(uid);
	}

	@GetMapping("/user/{uid}/books")
	public List<BookResponseDto> fetchBooks(@PathVariable Long uid) {
		List<Book> books = userDao.retrieveBooks(uid);
		return setBookmarkCountsToBookResponseDto(books);
	}

	private List<BookResponseDto> setBookmarkCountsToBookResponseDto(List<Book> books) {
		List<BookResponseDto> res = new ArrayList<>();
		for (Book book : books) {
			BigInteger cnt = bmDao.findBookmarkCount(book.getId());
			BookResponseDto resDto = new BookResponseDto(book, cnt);
			res.add(resDto);
		}
		return res;
	}

	@PostMapping("/signup")
	public void signup(@RequestBody UserDto dto) {
		String hashed = encoder.encode(dto.getPw());
		if (userDao.findByEmail(dto.getEmail()) != null) {
			throw new RuntimeException("같은 이메일의 회원이 존재합니다.");
		}
		User user = new User(
				dto.getDisplayName(),
				dto.getEmail(),
				dto.getProfile(),
				hashed);
		userDao.save(user);
		Bookmark bm = new Bookmark(user);
		bmDao.save(bm);
	}

	@PostMapping("/signin")
	public TokenResponseDto signin(@RequestBody UserDto dto) {
		String rawPassword = dto.getPw();
		String email = dto.getEmail();
		try {
			User user = userDao.findByEmail(email);
			System.out.println(user);
			if (encoder.matches(rawPassword, user.getPw())) {
				String accessToken = gen.generateTokenForUser(user);
				return new TokenResponseDto(
						accessToken,
						user.getProfile(),
						user.getEmail(),
						user.getDisplayName(),
						user.getId());
			} else {
				throw new RuntimeException("아이디나 패스워드가 정확하지 않습니다.");
			}
		} catch (Exception e) {
			throw new RuntimeException("아이디나 패스워드가 정확하지 않습니다.");
		}
	}

	@PostMapping("/signin/token")
	public TokenResponseDto signinWithToken(@RequestBody UserDto dto) {
		String accessToken = dto.getAccessToken();
		JwtUser jwtUser = validator.validate(accessToken);
		try {
			User user = userDao.findById(jwtUser.getId());
			return new TokenResponseDto(
					accessToken,
					user.getProfile(),
					user.getEmail(),
					user.getDisplayName(),
					user.getId());
		} catch (Exception e) {
			throw new RuntimeException("아이디나 패스워드가 정확하지 않습니다.");
		}
	}


	@PutMapping("/user/{uid}/bookmark/{bid}")

	public BookResponseDto addBookmark(
			@PathVariable Long uid,
			@PathVariable Long bid) {
		Book book = bookDao.selectById(bid);
		userDao.addBookmark(uid, book);
		return setBookmarkCountToBookResponseDto(book);
	}

	@PutMapping("/user/profile")
	public User editProfile(@RequestBody UserDto dto) {
		return userDao.updateProfile(dto.getId(), dto.getProfile());
	}

	@DeleteMapping("/user/{uid}/bookmark/{bid}")
	public BookResponseDto removeBookmark(
			@PathVariable Long uid,
			@PathVariable Long bid) {
		Book book = bookDao.selectById(bid);
		userDao.removeBookmark(uid, book);
		return setBookmarkCountToBookResponseDto(book);
	}

	private BookResponseDto setBookmarkCountToBookResponseDto(Book book) {
		BigInteger cnt = bmDao.findBookmarkCount(book.getId());
		return new BookResponseDto(book, cnt);
	}
}
