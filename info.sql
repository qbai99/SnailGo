INSERT INTO user_info
(user_id, user_admin, user_name, user_password, usersex, user_birthdate, user_phonenumber,user_introduction,user_tag)
VALUES (1,"admin","123","admin",1,"2019-8-7","12345678901","我太难了",false);

INSERT INTO user_level
(level_id,user_id,level,points)
VALUES(1,1,3,250);

INSERT INTO user_finance
(finance_id,user_id,balance)
VALUES(1,1,250);

INSERT INTO address (address_id,user_id,address) VALUES(1,1,"四川大学");
INSERT INTO address (address_id,user_id,address) VALUES(2,1,"清华大学");

UPDATE user_info SET use_level_id = 1,finance_id = 1 WHERE user_id = 1