create TABLE user (
  userid INT NOT NULL PRIMARY KEY,
  name VARCHAR(45),
  sureName VARCHAR(45)
  );

INSERT INTO user (userid, name, sureName) VALUES ('1', 'Евгений', 'Макаренко');
INSERT INTO user (userid, name, sureName) VALUES ('2', 'Ксения', 'Демьянец');
INSERT INTO user (userid, name, sureName) VALUES ('3', 'Артём', 'Нечепаренко');
INSERT INTO user (userid, name, sureName) VALUES ('4', 'Владислав', 'Шешко');
INSERT INTO user (userid, name, sureName) VALUES ('5', 'Анастасия', 'Кравцевич');
INSERT INTO user (userid, name, sureName) VALUES ('6', 'Дмитрий', 'Новиков');
INSERT INTO user (userid, name, sureName) VALUES ('7', 'Александр', 'Емец');
INSERT INTO user (userid, name, sureName) VALUES ('8', 'Михаил', 'Руденок');
INSERT INTO user (userid, name, sureName) VALUES ('9', 'Илья', 'Прямов');
INSERT INTO user (userid, name, sureName) VALUES ('10', 'Расим', 'Агамалыев');

CREATE TABLE account (
  accountid INT NOT NULL PRIMARY KEY,
  account INT,
  userid INT,
  CONSTRAINT userid
    FOREIGN KEY (userid)
    REFERENCES user (userid)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

INSERT INTO account (accountid, account, userid) VALUES ('1', '25000', '10');
INSERT INTO account (accountid, account, userid) VALUES ('2', '79000', '9');
INSERT INTO account (accountid, account, userid) VALUES ('3', '120000', '8');
INSERT INTO account (accountid, account, userid) VALUES ('4', '9000', '7');
INSERT INTO account (accountid, account, userid) VALUES ('5', '3500', '6');
INSERT INTO account (accountid, account, userid) VALUES ('6', '66580', '5');
INSERT INTO account (accountid, account, userid) VALUES ('7', '80000', '4');
INSERT INTO account (accountid, account, userid) VALUES ('8', '500', '3');
INSERT INTO account (accountid, account, userid) VALUES ('9', '73500', '2');
INSERT INTO account (accountid, account, userid) VALUES ('10', '168090', '1');


select * from account
    where accountid = 10;

select * from user
    where userid = 1;

select user.userid, name, sureName, accountid, account from user, account
    where user.userid = account.userid;