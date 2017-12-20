insert into user(id, display_name, last_updated_date, created_date)
	values(1, 'user1', sysdate(), sysdate());
insert into user(id, display_name, last_updated_date, created_date)
	values(2, 'user2', sysdate(), sysdate());
insert into user(id, display_name, last_updated_date, created_date)
	values(3, 'user3', sysdate(), sysdate());
insert into user(id, display_name, last_updated_date, created_date)
	values(4, 'user4', sysdate(), sysdate());
insert into user(id, display_name, last_updated_date, created_date)
	values(5, 'user5', sysdate(), sysdate());

insert into title_tag(id, title)
	values(1, 'title-tag-1');
insert into title_tag(id, title)
	values(2, 'title-tag-2');
insert into title_tag(id, title)
	values(3, 'title-tag-3');
insert into title_tag(id, title)
	values(4, 'title-tag-4');
	
insert into author_tag(id, author)
	values(1, 'author-1');
insert into author_tag(id, author)
	values(2, 'author-2');
insert into author_tag(id, author)
	values(3, 'author-3');
	
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(1,
	'https://cdn.pixabay.com/photo/2017/10/24/23/45/girl-2886598_150.jpg',
	'content1',
	sysdate(), sysdate(), 1, 1, 1);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(2,
	'https://cdn.pixabay.com/photo/2017/10/25/09/12/background-2887350_150.jpg',
	'content2',
	sysdate(), sysdate(), 1, 2, 2);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(3,
	'https://cdn.pixabay.com/photo/2017/10/25/01/21/fire-2886715_150.jpg',
	'content3',
	sysdate(), sysdate(), 1, 1, 1);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(4,
	'https://cdn.pixabay.com/photo/2017/10/25/00/13/girl-2886637_150.jpg',
	'content4',
	sysdate(), sysdate(), 2, 1, 1);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(5,
	'https://cdn.pixabay.com/photo/2017/10/25/00/01/santa-claus-2886624_150.jpg',
	'content5',
	sysdate(), sysdate(), 2, 3, 1);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(6,
	'https://cdn.pixabay.com/photo/2017/10/24/22/02/pumpkin-soup-2886322_150.jpg',
	'content6',
	sysdate(), sysdate(), 3, 4, 3);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(7,
	'https://cdn.pixabay.com/photo/2017/10/25/09/13/bridge-2887353_150.jpg',
	'content7',
	sysdate(), sysdate(), 3, 1, 1);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(8,
	'https://cdn.pixabay.com/photo/2017/10/22/14/53/ballerina-2878011_150.jpg',
	'content8',
	sysdate(), sysdate(), 3, 2, 2);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(9,
	'https://cdn.pixabay.com/photo/2017/10/24/10/58/halloween-2884162_150.png',
	'content9',
	sysdate(), sysdate(), 3, 1, 1);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(10,
	'https://cdn.pixabay.com/photo/2017/10/25/16/54/african-lion-2888519_150.jpg',
	'content10',
	sysdate(), sysdate(), 4, 1, 1);
	
insert into bookmark(id, user_id)
	values(1, 1);
insert into bookmark(id, user_id)
	values(2, 2);
insert into bookmark(id, user_id)
	values(3, 3);
insert into bookmark(id, user_id)
	values(4, 4);
insert into bookmark(id, user_id)
	values(5, 5);

insert into bookmark_book(bookmark_id, book_id)
	values(1, 1);
insert into bookmark_book(bookmark_id, book_id)
	values(1, 2);
	
insert into collection(id, label, user_id)
	values(1, 'collection-1', 1);
insert into collection(id, label, user_id)
	values(2, 'collection-2', 1);
insert into collection(id, label, user_id)
	values(3, 'collection-3', 2);
