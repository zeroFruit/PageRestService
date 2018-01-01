insert into user(id, display_name, last_updated_date, created_date)
	values(10001, 'user1', sysdate(), sysdate());
insert into user(id, display_name, last_updated_date, created_date)
	values(10002, 'user2', sysdate(), sysdate());
insert into user(id, display_name, last_updated_date, created_date)
	values(10003, 'user3', sysdate(), sysdate());
insert into user(id, display_name, last_updated_date, created_date)
	values(10004, 'user4', sysdate(), sysdate());
insert into user(id, display_name, last_updated_date, created_date)
	values(10005, 'user5', sysdate(), sysdate());

insert into title_tag(id, title)
	values(50001, 'Wonder');
insert into title_tag(id, title)
	values(50002, 'Obama : An Intimate Portrait');
insert into title_tag(id, title)
	values(50003, 'Auggie & Me');
insert into title_tag(id, title)
	values(50004, 'Harry Potter and the Prisoner of azkaban');
	
insert into author_tag(id, author)
	values(60001, 'R. J. Palacio');
insert into author_tag(id, author)
	values(60002, 'Pete Souza');
insert into author_tag(id, author)
	values(60003, 'J. K. Rowling');

insert into author_tag_title_tag(author_tag_id, title_tag_id)
	values(60001, 50001);
insert into author_tag_title_tag(author_tag_id, title_tag_id)
	values(60001, 50003);
insert into author_tag_title_tag(author_tag_id, title_tag_id)
	values(60002, 50002);
insert into author_tag_title_tag(author_tag_id, title_tag_id)
	values(60003, 50004);
	
insert into title_tag_author_tag(title_tag_id, author_tag_id)
	values(50001, 60001);
insert into title_tag_author_tag(title_tag_id, author_tag_id)
	values(50003, 60001);
insert into title_tag_author_tag(title_tag_id, author_tag_id)
	values(50002, 60002);
insert into title_tag_author_tag(title_tag_id, author_tag_id)
	values(50004, 60003);
	
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(20001,
	'https://cdn.pixabay.com/photo/2017/10/24/23/45/girl-2886598_150.jpg',
	'content1',
	sysdate(), sysdate(), 10001, 50001, 60001);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(20002,
	'https://cdn.pixabay.com/photo/2017/10/25/09/12/background-2887350_150.jpg',
	'content2',
	sysdate(), sysdate(), 10001, 50002, 60002);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(20003,
	'https://cdn.pixabay.com/photo/2017/10/25/01/21/fire-2886715_150.jpg',
	'content3',
	sysdate(), sysdate(), 10001, 50001, 60001);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(20004,
	'https://cdn.pixabay.com/photo/2017/10/25/00/13/girl-2886637_150.jpg',
	'content4',
	sysdate(), sysdate(), 10002, 50001, 60001);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(20005,
	'https://cdn.pixabay.com/photo/2017/10/25/00/01/santa-claus-2886624_150.jpg',
	'content5',
	sysdate(), sysdate(), 10002, 50003, 60001);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(20006,
	'https://cdn.pixabay.com/photo/2017/10/24/22/02/pumpkin-soup-2886322_150.jpg',
	'content6',
	sysdate(), sysdate(), 10003, 50004, 60003);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(20007,
	'https://cdn.pixabay.com/photo/2017/10/25/09/13/bridge-2887353_150.jpg',
	'content7',
	sysdate(), sysdate(), 10003, 50001, 60001);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(20008,
	'https://cdn.pixabay.com/photo/2017/10/22/14/53/ballerina-2878011_150.jpg',
	'content8',
	sysdate(), sysdate(), 10003, 50002, 60002);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(20009,
	'https://cdn.pixabay.com/photo/2017/10/24/10/58/halloween-2884162_150.png',
	'content9',
	sysdate(), sysdate(), 10003, 50001, 60001);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(20010,
	'https://cdn.pixabay.com/photo/2017/10/25/16/54/african-lion-2888519_150.jpg',
	'content10',
	sysdate(), sysdate(), 10004, 50001, 60001);
	
insert into bookmark(id, user_id)
	values(30001, 10001);
insert into bookmark(id, user_id)
	values(30002, 10002);
insert into bookmark(id, user_id)
	values(30003, 10003);
insert into bookmark(id, user_id)
	values(30004, 10004);
insert into bookmark(id, user_id)
	values(30005, 10005);

insert into bookmark_book(bookmark_id, book_id)
	values(30001, 20001);
insert into bookmark_book(bookmark_id, book_id)
	values(30001, 20002);
insert into bookmark_book(bookmark_id, book_id)
	values(30001, 20004);
	
insert into collection(id, label, user_id)
	values(40001, 'collection-1', 10001);
insert into collection(id, label, user_id)
	values(40002, 'collection-2', 10002);

	
insert into collection_book(collection_id, book_id)
	values(40001, 20001);
insert into collection_book(collection_id, book_id)
	values(40001, 20002);
insert into collection_book(collection_id, book_id)
	values(40002, 20008);
insert into collection_book(collection_id, book_id)
	values(40002, 20009);