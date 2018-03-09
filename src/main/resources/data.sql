insert into user(id, display_name, email, pw, profile, last_updated_date, created_date)
	values(10001, 'user1', 'a@gmail.com', '$2a$12$DeHdHJWEiMhYCK1N99BFzuagfW2Enfa/kQiXKztQrFc61zNFdjoQe', 'profile1', sysdate(), sysdate());
insert into user(id, display_name, email, pw, profile, last_updated_date, created_date)
	values(10002, 'user2', 'b@gmail.com', '2', 'profile2', sysdate(), sysdate());
insert into user(id, display_name, email, pw, profile, last_updated_date, created_date)
	values(10003, 'user3', 'c@gmail.com', '3', 'profile3', sysdate(), sysdate());
insert into user(id, display_name, email, pw, profile, last_updated_date, created_date)
	values(10004, 'user4', 'd@gmail.com', '4', 'profile4', sysdate(), sysdate());
insert into user(id, display_name, email, pw, profile, last_updated_date, created_date)
	values(10005, 'user5', 'e@gmail.com', '5', 'profile5', sysdate(), sysdate());

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
	values(20004,
	'https://dummyimage.com/1:1x360',
	'패, 별이 이름자를 한 있습니다. 비둘기, 별 그리고 당신은 하나에 차 하나 까닭입니다. 딴은 지나고 둘 쉬이 아침이 한 위에 어머님, 이름을 있습니다. 않은 어머니, 무덤 하늘에는 거외다. 별 어머님, 이름자를 이름을 이름과, 헤는 별이 헤일 언덕 거외다. 패, 별들을 계집애들의 피어나듯이 슬퍼하는 어머니, 애기 듯합니다. 둘 이 벌써 밤이 계집애들의 가을로 불러 별 봅니다. 벌써 내 속의 내일 봅니다. 남은 못 멀리 불러 새겨지는 이름자를 아무 써 그러나 봅니다. 멀리 못 언덕 경, 것은 위에도 이름과, 봅니다.',
	sysdate(), sysdate(), 10002, 50001, 60001);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(20005,
	'https://dummyimage.com/1:1x360',
	'무덤 아스라히 벌레는 위에 이름자 나의 멀리 많은 별이 까닭입니다. 멀리 자랑처럼 슬퍼하는 내 봅니다. 노루, 소녀들의 이런 계집애들의 별 걱정도 까닭입니다. 위에도 헤는 하나에 까닭입니다. 자랑처럼 이 잔디가 추억과 거외다. 멀리 파란 쉬이 계절이 하나에 못 멀듯이, 덮어 까닭입니다. 아름다운 이네들은 계절이 한 아스라히 많은 버리었습니다. 가을로 가슴속에 말 까닭입니다. 내 헤일 계집애들의 별 북간도에 거외다.',
	sysdate(), sysdate(), 10002, 50003, 60001);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(20006,
	'https://dummyimage.com/1:1x360',
	'언덕 가슴속에 사람들의 나는 별에도 버리었습니다. 오는 사람들의 별에도 자랑처럼 너무나 소녀들의 가을 봄이 겨울이 있습니다. 추억과 멀듯이, 오는 나는 패, 별 토끼, 까닭입니다. 많은 덮어 이 별 별 강아지, 내 언덕 있습니다. 오면 릴케 마리아 나의 토끼, 라이너 된 하나에 봅니다. 너무나 오면 패, 있습니다. 위에 노새, 이름과, 밤을 슬퍼하는 계십니다. 내 아스라히 다 별에도 버리었습니다. 하늘에는 사랑과 내린 까닭입니다. 흙으로 풀이 헤는 이름을 내일 그리고 가을 다 버리었습니다.',
	sysdate(), sysdate(), 10003, 50004, 60003);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(20007,
	'https://dummyimage.com/1:1x360',
	'따뜻한 구하기 그러므로 같은 이성은 같이, 않는 능히 주며, 이것이다. 스며들어 있는 역사를 구하지 이것이다. 낙원을 생의 얼마나 황금시대다. 트고, 뼈 창공에 인간은 동력은 그들에게 이성은 눈이 그리하였는가? 가치를 영락과 열매를 위하여 얼마나 앞이 보내는 있다. 능히 있는 웅대한 지혜는 돋고, 이상을 것이다. 뼈 꽃 그들의 운다. 낙원을 천자만홍이 이상의 새 유소년에게서 실현에 것이다. 역사를 같이, 오직 이성은 따뜻한 그리하였는가? 찾아다녀도, 찬미를 새 바이며, 크고 위하여 붙잡아 때까지 말이다.',
	sysdate(), sysdate(), 10003, 50001, 60001);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(20008,
	'https://dummyimage.com/1:1x360',
	'뜨고, 얼음이 피에 인간의 아니한 이 있는가? 이것은 할지라도 같으며, 하였으며, 청춘의 따뜻한 청춘을 두기 청춘의 보라. 우리 않는 모래뿐일 청춘 광야에서 있음으로써 인도하겠다는 이것이다. 것이다.보라, 간에 청춘의 봄바람이다. 착목한는 이상이 사라지지 피부가 청춘의 약동하다. 꽃 쓸쓸한 가진 열락의 있으며, 청춘이 이것이다. 산야에 거친 인생을 그들의 소담스러운 청춘을 것이다. 능히 있을 그들에게 되는 풍부하게 힘차게 발휘하기 그들의 있다. 그림자는 심장은 때에, 보는 불어 튼튼하며, 이것은 있는가?',
	sysdate(), sysdate(), 10003, 50002, 60002);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(20009,
	'https://dummyimage.com/1:1x360',
	'보내는 전인 싶이 별과 수 너의 찬미를 사막이다. 청춘의 피가 있는 거친 생생하며, 끝에 것이다. 그들의 곳으로 관현악이며, 온갖 열락의 오직 칼이다. 목숨을 과실이 기관과 붙잡아 우리의 우리 못할 가치를 속잎나고, 봄바람이다. 가치를 소담스러운 오아이스도 천자만홍이 굳세게 같으며, 있는가? 있음으로써 별과 이 사막이다. 사는가 꽃이 그와 이상의 일월과 가는 귀는 것이다. 것이 노년에게서 그러므로 그들은 그들의 어디 피어나는 아름답고 공자는 힘있다. 주며, 보내는 할지라도 길을 피어나는 끓는다. 그들에게 노년에게서 사랑의 품었기 봄바람을 아니다. 가치를 충분히 더운지라 쓸쓸하랴?',
	sysdate(), sysdate(), 10003, 50001, 60001);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(20001,
	'https://dummyimage.com/1:1x360',
	'피에 우리는 구하지 아니다. 새가 눈이 하는 위하여 없는 웅대한 보라. 청춘의 방지하는 붙잡아 모래뿐일 있는 속에 천자만홍이 웅대한 인류의 봄바람이다. 보이는 살았으며, 열락의 인생에 가장 풍부하게 부패뿐이다. 가진 동력은 천지는 불러 긴지라 청춘 있는가? 석가는 피에 생명을 우리의 위하여서. 쓸쓸한 이 끝에 봄바람이다. 불어 끝에 평화스러운 물방아 설산에서 기관과 교향악이다. 같이 보는 용감하고 싶이 심장은 우리 황금시대의 충분히 봄바람이다. 시들어 얼음이 그들의 있는 행복스럽고 것이다.보라, 곳으로 것이다.',
	sysdate(), sysdate(), 10001, 50001, 60001);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
  values(20002,
  'https://dummyimage.com/1:1x360',
  '따뜻한 넣는 든 인생을 투명하되 불어 있는가? 얼마나 천지는 청춘에서만 미묘한 끓는다. 인간은 두기 청춘을 희망의 어디 피가 구하지 기관과 사막이다. 하였으며, 황금시대의 그와 밥을 아름다우냐? 같은 생생하며, 거친 것이다. 꽃이 찬미를 날카로우나 길지 할지라도 얼음과 약동하다. 힘차게 얼음이 우리는 청춘의 없으면, 이상 그것을 것이다. 없으면, 튼튼하며, 아니더면, 것이다. 얼마나 청춘 많이 못하다 위하여서, 그들의 착목한는 피부가 피는 운다. 모래뿐일 위하여 되려니와, 보내는 대중을 봄바람이다.',
  sysdate(), sysdate(), 10001, 50002, 60002);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
	values(20003,
	'https://dummyimage.com/1:1x360',
	'시들어 것이 무엇을 튼튼하며, 밥을 같으며, 이는 갑 얼음과 그리하였는가? 두기 꾸며 어디 이성은 끝까지 인생의 것이다. 풍부하게 그들은 지혜는 미인을 것이다. 불어 우리 피가 피부가 광야에서 약동하다. 청춘은 행복스럽고 있는 그와 우리 사랑의 얼마나 속에서 것이다. 대중을 투명하되 못할 피고 사라지지 있는 맺어, 끓는다. 싹이 가지에 역사를 노래하며 사막이다. 속에 때에, 피는 생생하며, 작고 착목한는 위하여서, 많이 듣는다. 이상이 얼음이 더운지라 가지에 피가 것이다.',
	sysdate(), sysdate(), 10001, 50001, 60001);
insert into book(id, img_src, content, last_updated_date, created_date, user_id, title_tag_id, author_tag_id)
values(20010,
			 'https://dummyimage.com/1:1x360',
			 '희망의 무엇을 그들을 이상의 수 소금이라 청춘의 있다. 내는 피고, 가장 붙잡아 품고 설산에서 끓는 사라지지 이것이다. 가슴에 행복스럽고 구할 속에 하여도 있으며, 용감하고 새 칼이다. 있음으로써 피는 사랑의 밝은 같이 것은 수 약동하다. 가지에 같은 두손을 못할 영락과 무엇을 것은 청춘 아름다우냐? 대한 따뜻한 사는가 위하여 가치를 무엇을 평화스러운 가는 봄바람이다. 같지 긴지라 능히 살았으며, 할지라도 그림자는 같으며, 말이다. 유소년에게서 따뜻한 가슴이 인생을 뿐이다. 어디 군영과 얼마나 천하를 동력은 그와 것이다.',
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
	values(30002, 20001);
insert into bookmark_book(bookmark_id, book_id)
	values(30003, 20001);
insert into bookmark_book(bookmark_id, book_id)
	values(30001, 20002);
insert into bookmark_book(bookmark_id, book_id)
	values(30002, 20002);
insert into bookmark_book(bookmark_id, book_id)
	values(30001, 20004);
