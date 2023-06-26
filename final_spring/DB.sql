-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ssafit
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ssafit
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ssafit`;
CREATE SCHEMA IF NOT EXISTS `ssafit` DEFAULT CHARACTER SET utf8 ;
USE `ssafit`;

-- -----------------------------------------------------
-- Table `ssafit`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`user` (
  `user_seq` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(20) NOT NULL,
  `user_pwd` VARCHAR(20) NOT NULL,
  `user_name` VARCHAR(10) NOT NULL,
  `user_nickname` VARCHAR(20) NOT NULL,
  `user_email` VARCHAR(20) NOT NULL,
  `user_point` INT NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_seq`),
  UNIQUE INDEX `user_seq_UNIQUE` (`user_seq` ASC) VISIBLE,
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE,
  UNIQUE INDEX `user_nickname_UNIQUE` (`user_nickname` ASC) VISIBLE)
ENGINE = InnoDB;


INSERT INTO `ssafit`.`user` (user_id, user_pwd, user_name, user_nickname, user_email, user_point)
VALUES
('ssafy0', '0000', '이승엽', '관리자', 'ssafy0@ssafy.com', 1000),
('ssafy1', '0001', '김경보', '람쥐썬더', 'ssafy1@ssafy.com', 900),
('ssafy2', '0002', '김솔은', '솔의눈', 'ssafy2@ssafy.com', 800),
('ssafy3', '0003', '김희경', '스마일감자', 'ssafy3@ssafy.com', 700),
('ssafy4', '0004', '대박균', '세균맨', 'ssafy4@ssafy.com', 400),
('ssafy5', '0005', '문웅홍', '곰돌이푸', 'ssafy5@ssafy.com',0),
('ssafy6', '0006', '신수택', '국세청', 'ssafy6@ssafy.com',0),
('ssafy7', '0007', '정희태', '김태희', 'ssafy7@ssafy.com',0),
('ssafy8', '0008', '찰리박', '칠리소스', 'ssafy8@ssafy.com',1200),
('ssafy9', '0009', '지존민우', '지.존', 'ssafy9@ssafy.com',1500),
('ssafy10', '0010', '독고혜민', '외로운주먹', 'ssafy10@ssafy.com',200),
('ssafy11', '0011', '독고혜자', '의로운주먹', 'ssafy11@ssafy.com', 300),
('ssafy12', '0012', '박민종', '언더아머단속반', 'ssafy12@ssafy.com', 0),
('ssafy13', '0013', '김수현', '외계인', 'ssafy13@ssafy.com', 500),
('ssafy14', '0014', '선우경희', '어머니', 'ssafy14@ssafy.com', 400),
('ssafy15', '0015', '김혁종', '학종이', 'ssafy15@ssafy.com',0),
('ssafy16', '0016', '이희주', '준식이', 'ssafy16@ssafy.com',0),
('ssafy17', '0017', '나유지', '유당불내증', 'ssafy17@ssafy.com',0),
('ssafy18', '0018', '제갈종혁', '맛있는겨울배', 'ssafy18@ssafy.com',3000),
('ssafy19', '0019', '오윤영', '피자나라치킨공주', 'ssafy19@ssafy.com',1900),
('ssafy20', '0020', '홍사박', '코천딩채', 'ssafy20@ssafy.com',2000);

SELECT * FROM ssafit.user;

-- -----------------------------------------------------
-- Table `ssafit`.`tef`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`tef` (
  `tef_id` INT NOT NULL AUTO_INCREMENT,
  `tef_img` TEXT NULL DEFAULT NULL,
  `tef_title` VARCHAR(20) NOT NULL,
  `tef_content` TEXT NOT NULL,
  `tef_writer` VARCHAR(10) NOT NULL,
  `tef_created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tef_updated_at` TIMESTAMP NULL DEFAULT NULL,
  `tef_like` INT NOT NULL DEFAULT '0',
  PRIMARY KEY (`tef_id`),
  UNIQUE INDEX `TEF_id_UNIQUE` (`tef_id` ASC) VISIBLE,
  INDEX `fk_TEF_user1_idx` (`tef_writer` ASC) VISIBLE,
  CONSTRAINT `fk_TEF_user1`
    FOREIGN KEY (`tef_writer`)
    REFERENCES `ssafit`.`user` (`user_nickname`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


INSERT INTO `ssafit`.`tef` (tef_img, tef_title, tef_content, tef_writer, tef_like)
VALUES
('https://firebasestorage.googleapis.com/v0/b/ssafit-95520.appspot.com/o/images%2F%EC%98%A4%EC%9A%B4%EC%99%842(%EB%8B%AC%EB%A6%AC%EA%B8%B0).jpg?alt=media&token=a7a49624-2451-455f-90b6-29a0e38159a6','인증합니다!', '오늘 8km 달리기 했어요.', '스마일감자', 8),
('https://firebasestorage.googleapis.com/v0/b/ssafit-95520.appspot.com/o/images%2F%EC%98%A4%EC%9A%B4%EC%99%841(%EB%8B%AC%EB%A6%AC%EA%B8%B0).png?alt=media&token=f60a4d8e-56cb-449d-aa07-02ec670ca595', '인증해요.', '5km 달리기 인증합니다.', '곰돌이푸', 15),
('https://firebasestorage.googleapis.com/v0/b/ssafit-95520.appspot.com/o/images%2F%EC%98%A4%EC%9A%B4%EC%99%84(%EC%9E%90%EC%A0%84%EA%B1%B0%20%EC%9D%B8%EC%A6%9D).jpg?alt=media&token=0704f77f-f27d-4088-9c55-32a3cf426740', '오늘도 안전 라이딩~', '자전거 10km 라이딩 했어요.', '국세청', 10),
('https://firebasestorage.googleapis.com/v0/b/ssafit-95520.appspot.com/o/images%2F%EC%98%A4%EC%9A%B4%EC%99%84(%ED%95%84%EB%9D%BC%ED%85%8C%EC%8A%A4).jpg?alt=media&token=5756d31b-60d3-42b7-ad03-53e75c28db85','탄탄한 몸매 관리를 위해 오늘도...', '필라테스도 벌써 한달이네요! 몸매가 점점 탄탄해지는거 같아요!!', '김태희', 50),
('https://firebasestorage.googleapis.com/v0/b/ssafit-95520.appspot.com/o/images%2F%EC%98%A4%EC%9A%B4%EC%99%84(%EA%B9%80%EC%A2%85%EA%B5%AD).jpg?alt=media&token=ec14ffca-7f48-46b4-b844-7128555273c8','매콤하게 운동해봤습니다.', '다음주는,  1RM. 도전해보겠습니다.', '칠리소스', 90),
('https://firebasestorage.googleapis.com/v0/b/ssafit-95520.appspot.com/o/images%2F%EC%98%A4%EC%9A%B4%EC%99%84(%EB%B0%B0%EB%A8%B9%EC%96%B4%EB%B0%B0).jpg?alt=media&token=2ff799f0-c346-4d66-84c3-19b10aabc01c','뭐 드시냐고 세 번째 물어봅니다.', '배(복근) 먹어 배!', '맛있는겨울배', 120),
('https://firebasestorage.googleapis.com/v0/b/ssafit-95520.appspot.com/o/images%2F%EC%98%A4%EC%9A%B4%EC%99%84(%EC%9A%B4%EB%8F%99%EC%A2%80%ED%95%98%EB%8D%94%EB%86%88).png?alt=media&token=3ee7b64a-f744-4a17-b58d-c480e08988a5','운동 좀 하더 놈', '자~! 오늘은 헬스를! 해보았어요~', '맛있는겨울배', 50),
('https://firebasestorage.googleapis.com/v0/b/ssafit-95520.appspot.com/o/images%2F%EC%98%A4%EC%9A%B4%EC%99%843(%ED%99%8D%EC%84%9D%EC%B2%9C).png?alt=media&token=b4808516-f9b4-45a1-8c0c-d4e0bbb0eed6','1RM 인증합니다!', '오늘은 550 입니다~ 개인 최고 기록 경신이네요!', '언더아머단속반', 60),
('https://firebasestorage.googleapis.com/v0/b/ssafit-95520.appspot.com/o/images%2F%EC%98%A4%EC%9A%B4%EC%99%844(%ED%99%8D%EC%84%9D%EC%B2%9C).png?alt=media&token=ae8c9b98-d45c-4550-82cd-6175de2d1803','1RM 인증할게요.', '오늘은 490이네요...', '언더아머단속반', 40),
('https://firebasestorage.googleapis.com/v0/b/ssafit-95520.appspot.com/o/images%2F%EC%98%A4%EC%9A%B4%EC%99%84(%EB%A7%88%EB%8F%99%EC%84%9D).jpg?alt=media&token=47846c06-11fa-4847-a972-ba630ac4c8d2','오늘은 정말 힘드네요 ㅠㅠ', '그래도 화이팅 해봤어요!', '지.존', 100),
('https://firebasestorage.googleapis.com/v0/b/ssafit-95520.appspot.com/o/images%2F%EC%98%A4%EC%9A%B4%EC%99%84(%EC%A0%95%EA%B6%8C%EC%A7%80%EB%A5%B4%EA%B8%B0).jpg?alt=media&token=e7b29faa-8d90-4593-9e01-6dbd42e1de4e','정권 지르기 1000번 실시했습니다.', '다음은 발차기 1000번!', '외로운주먹', 80);

 SELECT * FROM ssafit.tef;
-- -----------------------------------------------------
-- Table `mydb`.`tefLike`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`tefLike` (
  `tef_like_id` INT NOT NULL AUTO_INCREMENT,
  `tef_board_id` INT NOT NULL,
  `user_nickname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`tef_like_id`),
  INDEX `fk_tefLike_tef_idx` (`tef_board_id` ASC) VISIBLE,
  INDEX `fk_tefLike_user1_idx` (`user_nickname` ASC) VISIBLE,
  UNIQUE INDEX `tef_like_id_UNIQUE` (`tef_like_id` ASC) VISIBLE,
  CONSTRAINT `fk_tefLike_tef`
    FOREIGN KEY (`tef_board_id`)
    REFERENCES `ssafit`.`tef` (`tef_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_tefLike_user1`
    FOREIGN KEY (`user_nickname`)
    REFERENCES `ssafit`.`user` (`user_nickname`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

select * from tefLike;
-- -----------------------------------------------------
-- Table `ssafit`.`free`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`free` (
  `free_id` INT NOT NULL AUTO_INCREMENT,
  `free_title` VARCHAR(20) NOT NULL,
  `free_content` TEXT NOT NULL,
  `free_writer` VARCHAR(10) NOT NULL,
  `free_created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `free_updated_at` TIMESTAMP NULL DEFAULT NULL,
  `free_like` INT NOT NULL DEFAULT '0',
  PRIMARY KEY (`free_id`),
  UNIQUE INDEX `free_id_UNIQUE` (`free_id` ASC) VISIBLE,
  INDEX `fk_free_user1_idx` (`free_writer` ASC) VISIBLE,
  CONSTRAINT `fk_free_user1`
    FOREIGN KEY (`free_writer`)
    REFERENCES `ssafit`.`user` (`user_nickname`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

INSERT INTO `ssafit`.`free` (free_title, free_content, free_writer, free_like)
VALUES
('고민이 있습니다.', '람쥐썬더', '람쥐썬더', 10),
('가장 좋아하는 음료?', '회원님들은 가장 좋아하는 음료가 뭔가요? 저는 솔의 눈 입니다.', '솔의눈', 7),
('단기간 내에 근성장 이루는 법', '운동 초보분들 단기간 내에 근성장 이루는 꿀팁 몇가지 알려드리겠습니다.', '스마일감자', 1),
('한잔해', '두잔해, 세잔해~', '세균맨', 3),
('인증해요.', '5km 달리기 인증합니다.', '곰돌이푸', 4),
('자전거 관심 있으신 분들', '이번에 엄복동2 나온다고 하네요. 제가 제일 좋아하는 영화에요! 기대가 됩니다~ ㅎㅎ', '국세청', 0),
('예쁜 꽃 보고 가세요~', '벚꽃 시즌이네요~ 꽃이 너무 예쁘게 만개했어요~', '김태희', 12),
('10년전 오늘', '아리조나에서 찍었던 사진입니다.', '칠리소스', 3),
('농구 좋아하세요?', '더 퍼스트 슬램덩크 정말 재밌네요... 다음에 더빙판으로 한 번 더 보겠습니다!', '지.존', 5),
('도장깨기3', '오늘은 서울 용산에 위치한 킥복싱 도장 간판을 가져왔습니다.', '외로운주먹', 4),
('정말 심각한 고민이 있습니다.', '람쥐썬더', '람쥐썬더', 33),
('프로틴 추천해주세요!', '이제 막 운동 시작한 헬린이인데, 프로틴 좀 추천 부탁드려요!', '의로운주먹', 11),
('닭가슴살 추천 부탁드려요.', '닭가슴살은 역시~', '칠리소스', 0),
('뛸 때 신발 뭐 신으세요?', '저는 A6 신습니다~', '지.존', 2),
('자~ 지금부터 단속 들어갑니다.', '500 찍었구요, 이제부터 단속 시작하겠읍니다.^^*', '언더아머단속반', 3),
('도장깨기2', '오늘은 일산에 위치한 유도 도장 간판을 가져왔습니다.', '외로운주먹', 4),
('오늘 밤 친선경기 있어요!', '대한민국~~~', '지.존', 3),
('한일전 하네요!', '치킨 집 미어터지겠네요...', '세균맨', 6),
('죄송합니다', '안죄송해!', '맛있는겨울배', 17),
('도장깨기1', '오늘은 부산에 위치한 권투 도장 간판을 가져왔습니다.', '외로운주먹', 4);
 SELECT * FROM ssafit.free; 
-- -----------------------------------------------------
-- Table `mydb`.`freeLike`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`freeLike` (
  `free_like_id` INT NOT NULL AUTO_INCREMENT,
  `free_board_id` INT NOT NULL,
  `user_nickname` VARCHAR(45) NOT NULL,
  INDEX `fk_freeLike_free1_idx` (`free_board_id` ASC) VISIBLE,
  INDEX `fk_freeLike_user1_idx` (`user_nickname` ASC) VISIBLE,
  PRIMARY KEY (`free_like_id`),
  UNIQUE INDEX `free_like_id_UNIQUE` (`free_like_id` ASC) VISIBLE,
  CONSTRAINT `fk_freeLike_free1`
    FOREIGN KEY (`free_board_id`)
    REFERENCES `ssafit`.`free` (`free_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_freeLike_user1`
    FOREIGN KEY (`user_nickname`)
    REFERENCES `ssafit`.`user` (`user_nickname`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SELECT * FROM `freeLike`;

-- -----------------------------------------------------
-- Table `ssafit`.`event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`event` (
  `event_id` INT NOT NULL AUTO_INCREMENT,
  `event_title` VARCHAR(45) NOT NULL,
  `event_content` TEXT NOT NULL,
  `event_writer` VARCHAR(10) NOT NULL,
  `event_created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `event_updated_at` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`event_id`),
  UNIQUE INDEX `question_id_UNIQUE` (`event_id` ASC) VISIBLE,
  INDEX `fk_question_user1_idx` (`event_writer` ASC) VISIBLE,
  CONSTRAINT `fk_event_user1`
    FOREIGN KEY (`event_writer`)
    REFERENCES `ssafit`.`user` (`user_nickname`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


INSERT INTO `ssafit`.`event` (event_title, event_content, event_writer)
VALUES
('작심삼일 이벤트', '1월 1일부터 1월 2일, 3일까지 헬스장에서 운동한 사진을 인증해주세요! 푸짐한 상품이 기다립니다!!', '관리자'),
('돌아온 오.운.완 이벤트3 시작합니다', '운동 후 사진을 찍어 인증해주세요!', '관리자'),
('돌아온 오.운.완 이벤트2 시작합니다', '운동 후 사진을 찍어 인증해주세요!', '관리자'),
('돌아온 오.운.완 이벤트 시작합니다.', '운동 후 사진을 찍어 인증해주세요!', '관리자'),
('춘계 달리기', '춘계 달리기 이벤트를 시작합니다. 인증샷을 올려주세요~', '관리자'),
('봄봄봄봄봄이왔어요~~~', '벚꽃 사진을 찍어 인증해주세요~!', '관리자'),
('오.운.완 이벤트3 시작합니다.', '운동 후 사진을 찍어 인증해주세요!', '관리자'),
('오.운.완 이벤트2 시작합니다.', '운동 후 사진을 찍어 인증해주세요!', '관리자'),
('슬램덩크 상영 기념 이벤트!', '슬램덩크 영화를 보고 인증해주세요~!', '관리자'),
('오.운.완 이벤트 시작합니다.', '운동 후 사진을 찍어 인증해주세요!', '관리자'),
('솔로들의 크리스마스 이벤트!', '12월 24일, 25일에 운동한 사진을 올려 인증해주세요! 푸짐한 상품이 준비되어있습니다.', '관리자'),
('추석 운동 이벤트', '추석에 운동 후 사진을 찍어 인증해주세요!', '관리자'),
('송편 이벤트!', '운동만 하시진 않을거죠?! 송편을 빚고, 인증해주세요~!', '관리자'),
('월드컵 이벤트2', '16강 진출을 기념해 16강전 경기 결과를 예측해주세요!', '관리자'),
('월드컵 이벤트!', '월드컵이 돌아왔습니다~ 예선전의 경기 결과를 예측해주세요!!', '관리자'),
('여름 이벤트', '비키니 입을 준비 하셔야죠? 현재 체중과 목표 체중을 세우고, 목표 달성을 인증해주세요~~~', '관리자'),
('돌아온 한일전 경기 결과 예측 이벤트!', '오랜만에 돌아온 한일전! 점수 예측 고우고우~~~', '관리자'),
('닭가슴살 구매 인증 이벤트', '웹 사이트 제휴사인 R사의 닭가슴살을 구매하고 인증하신 분들께, 할인권을 제공해드립니다!', '관리자'),
('3대 몇? 이벤트', '개인의 1RM을 인증해주세요! 최고기록을 인증하신분께 언더아머 운동복을 선물해드립니다~!', '관리자'),
('한일전 경기 결과 예측 이벤트.', '한일전 점수를 예측해주세요!', '관리자');


 SELECT * FROM ssafit.event;
-- -----------------------------------------------------
-- Table `ssafit`.`freecomment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`freecomment` (
  `comment_id` INT NOT NULL AUTO_INCREMENT,
  `free_id` INT NOT NULL,
  `free_comment_writer` VARCHAR(10) NOT NULL,
  `comment_content` TEXT NOT NULL,
  `comment_created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `comment_updated_at` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  UNIQUE INDEX `free_comment_id_UNIQUE` (`comment_id` ASC) VISIBLE,
  INDEX `fk_freeComment_free1_idx` (`free_id` ASC) VISIBLE,
  INDEX `fk_freeComment_user1_idx` (`free_comment_writer` ASC) VISIBLE,
  CONSTRAINT `fk_freeComment_free1`
    FOREIGN KEY (`free_id`)
    REFERENCES `ssafit`.`free` (`free_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_freeComment_user1`
    FOREIGN KEY (`free_comment_writer`)
    REFERENCES `ssafit`.`user` (`user_nickname`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


INSERT INTO `ssafit`.`freeComment` (free_id, free_comment_writer, comment_content)
VALUES
(1, '지.존', '정말 엄청난 고민이네요.'),
(1, '국세청', '원만한 해결하시길...'),
(2, '지.존', '저는 마운틴 듀 좋아해요.'),
(2, '외로운주먹', '저는 피, 땀, 눈물을 좋아합니다.'),
(6, '지.존', '으...'),
(6, '외로운주먹', '...'),
(7, '솔의눈', '와 사진에서 향기가 나는거 같아요! 킁킁!!'),
(7, '외로운주먹', '나비처럼 날아서 벌처럼 쏘고 싶네요.'),
(9, '세균맨', '저도 어제 봤어요. 띵작 인정합니다.'),
(10, '지.존', '좀 치시네요?'),
(1, '맛있는겨울배', '얘! 이런거 읽을 시간이 없단다.'),
(1, '맛있는겨울배', '주겨벌랑!'),
(11, '맛있는겨울배', '그래, 정말 심각한 고민이네?'),
(11, '맛있는겨울배', '꼭, 감전되어서 병원신세지렴!'),
(13, '맛있는겨울배', '광고검지검지!'),
(15, '의로운주먹', '결국 해내셨군요! 축하드립니다.'),
(15, '외로운주먹', '저는 패션근육은 취급 안합니다.'),
(15, '맛있는겨울배', '얘! 어디서 좀 놀았니?'),
(19, '람쥐썬더', '???'),
(19, '지.존', '논란이 있을 수 있겠네요.');

SELECT * FROM ssafit.freeComment;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
