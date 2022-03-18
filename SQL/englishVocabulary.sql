use master

create database engvocabulary
use engvocabulary
create table word
(
	idword int identity(1,1) not null,
	en varchar(20),
	vn nvarchar(25),
	idtopic int
)

create table topic
(
	idtopic int not null,
	topicname nvarchar(25)
)


create table person
(
	idperson int not null,
	uusername varchar(30),
	upassword varchar(30),
	uname nvarchar(30),
	ugender nvarchar(3),
	uaddress nvarchar(30),
	utelephone varchar(10),
	uemail varchar(30)
)

create table personword
(
	idperson int not null,
	idword int not null
)

alter table word add constraint pk_word
primary key (idword)

alter table topic add constraint pk_topic
primary key (idtopic)

alter table person add constraint pk_person
primary key (idperson)

alter table personword add constraint pk_personword
primary key (idperson, idword)

alter table word add constraint fk_word_topic
foreign key (idtopic) references topic(idtopic)

alter table personword add constraint fk_personword_word
foreign key (idword) references word(idword)

alter table personword add constraint fk_personword_topic
foreign key (idperson) references person(idperson)


insert into topic
values
(1,'Travelling'),
(2,'Technology'),
(3,'Family'),
(4,'House'),
(5,'Animal')

insert into word
values
('transport', N'phương tiện', 1),
('suitcase', N'chiếc vali', 1),
('passport', N'hộ chiếu', 1),
('train station', N'Ga tàu', 1),
('airport', N'Sân bay',1),
('ticket office', N'Nơi bán vé', 1),
('information desk', N'Quầy hướng dẫn',1),
('delayed', N'trì hoãn',1),
('flight attendant', N'Tiếp viên hàng không',1),
('passenger', N'hành khách', 1),
('pilot', N'Phi công', 1),
('inbound travel', N'du lịch trong nước', 1),
('backpacking', N'Du lịch bụi, phượt', 1),
('ecotourism', N'Du lịch sinh thái',1),
('outbound travel', N'Du lịch nước ngoài',1),
('leisure travel', N'Du lịch nghỉ dưỡng', 1),
('travel agency', N'Đại lý du lịch',1),
('go sightseeing', N'ngắm cảnh', 1),
('souvenirs', N'quà lưu niệm', 1),
('tour guide', N'hướng dẫn viên du lịch',1),
('alphanumeric data', N'dữ liệu chữ số', 2),
('analysis', N'phân tích', 2),
('broad classification', N'phân loại tổng quát',2),
('cluster controller', N'bộ điều khiển trùm', 2),
('configuration', N'cấu hình',2),
('intranet', N'mạng nội bộ', 2),
('graphics', N'đồ họa', 2),
('multi-user', N'đa người dùng', 2),
('operation', N'thao tác', 2),
('operating system', N'hệ điều hành', 2),
('packet', N'gói dữ liệu', 2),
('protocol', N'giao thức', 2),
('source code', N'mã nguồn',2),
('circuit', N'mạch', 2),
('terminal', N'máy trạm', 2),
('hardware', N'phần cứng',2),
('software', N'phần mềm',2),
('disk', N'đĩa', 2),
('microprocessor', N'bộ vi xử lý', 2),
('memory', N'bộ nhớ', 2),
('grandparents ', N'Ông bà', 3),
('grandfather', N'Ông nội', 3),
('grandmother', N'bà nội',3),
('aunt', N'Cô/ dì', 3),
('uncle', N'Cậu/ chú', 3),
('cousin', N'Anh chị em họ',3),
('parents ', N'Ba mẹ',3),
('stepparent', N'Cha mẹ kế',3),
('sibling', N'Anh chị em ruột',3),
('spouse', N'Vợ chồng', 3),
('stepfather ', N'Cha dượng', 3),
('stepmother ', N'Mẹ kế', 3),
('grandchildren', N'Các cháu (của ông bà)', 3),
('nuclear family ', N' Gia đình hạt nhân', 3),
('extended family', N'Đại gia đình', 3),
('single parent ', N'mẹ đơn thân', 3),
('close-knit family', N'gia đình êm ấm ', 3),
('dysfunctional family', N'gia đình không êm ấm',3),
('broken home', N'gia đình tan vỡ', 3),
('distant relative', N'họ hàng xa ', 3),
('divorce ', N'li dị', 3),
('apartment', N'căn hộ',4),
('terraced house', N'một nhà trong một dãy',4),
('cottage', N'nhà ở vùng nông thôn',4),
('bungalow ', N'nhà gỗ một tầng',4),
('bedsit', N'căn hộ khép kín',4),
('villa', N' biệt thự',4),
('bedroom', N'phòng ngủ',4),
('living room', N' phòng khách',4),
('bathroom', N'phòng tắm',4),
('hall', N'phong lớn/ đại sảnh',4),
('shed ', N'nhà kho',4),
('loft', N'tầng lửng/ gác xép',4),
('aAttic ', N'phòng gác mái',4),
('cellar', N'hầm chứa/ kho chứa',4),
('basement', N'tầng hầm để ở',4),
('porch', N'cổng vòm, mái vòm',4),
('balcony', N'ban công',4),
('dining table', N'bàn ăn',4),
('carpet', N'thảm',4),
('bookshelf', N'giá sách, kệ sách',4),
('chick', N'Con gà con', 5),
('turkey ', N'Gà Tây', 5),
('camel', N'Con lạc đà', 5),
('bull', N' Con bò đực', 5),
('cow', N'Con bò cái', 5),
('calf', N'Con bê', 5),
('piglet', N'Lợn con', 5),
('dove', N'Bồ câu',5),
('squirrel', N'Con sóc',5),
('porcupine', N'Con nhím', 5),
('hippopotamus', N'Con hà mã',5),
('raccoon', N'Con gấu mèo', 5),
('giraffe', N'Con hươu cao cổ',5),
('rhinoceros', N'Con tê giác', 5),
('jaguar', N'Con báo đốm', 5),
('donkey', N'Con lừa', 5),
('zebra', N'Con ngựa vằn', 5),
('hedgehog', N'Con nhím', 5),
('alligator', N'Con cá sấu', 5),
('mink', N'Con chồn', 5),
('chipmunk', N'Sóc chuột', 5)


select idword, en, vn, word.idtopic from word
inner join topic on word.idtopic = topic.idtopic
where topicname = 'Travelling'

Select topicname from topic