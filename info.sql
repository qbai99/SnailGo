use eshop;
INSERT INTO user_info
(user_id, user_admin, user_name, user_password, usersex, user_birthdate, user_phonenumber,user_introduction,user_tag)
VALUES (1,"admin","测试买家","admin",1,"2019-8-7","12345678901","我太难了",false);

INSERT INTO user_info
(user_id, user_admin, user_name, user_password, usersex, user_birthdate, user_phonenumber,user_introduction,user_tag)
VALUES (2,"root","测试卖家","root",1,"2019-8-7","12345678901","我太难了",true);

INSERT INTO user_level
(level_id,user_id,level,points)
VALUES(1,1,3,250);

INSERT INTO user_level
    (level_id,user_id,level,points)
VALUES(2,2,3,200);

INSERT INTO user_finance
(finance_id,user_id,balance)
VALUES(1,1,250);

INSERT INTO user_finance
    (finance_id,user_id,balance)
VALUES(2,2,10300);

INSERT INTO address (address_id,user_id,address) VALUES(1,1,"四川大学");
INSERT INTO address (address_id,user_id,address) VALUES(2,1,"清华大学");

INSERT INTO order_request (order_id,user_id,buyer_id,seller_id,goods_name,goods_quantity,goods_price)
VALUE (1,1,1,2,"机器学习",1,56);

INSERT INTO shipping_state (id,order_id,date,loc,other_info)
VALUE (1,1,"2020-6-15","广东","配送中");

UPDATE user_info SET use_level_id = 1,finance_id = 1 WHERE user_id = 1;
UPDATE user_info SET use_level_id = 2,finance_id = 2 WHERE user_id = 2;