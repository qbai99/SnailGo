use eshop;
INSERT INTO user_info
(user_id, user_admin, user_name, user_password, usersex, user_birthdate, user_phonenumber,user_introduction,user_tag,user_img)
VALUES (1,"admin@163.com","admin","admin",1,"2019-8-7","12345678901","我太难了",false,"123");

INSERT INTO user_info
(user_id, user_admin, user_name, user_password, usersex, user_birthdate, user_phonenumber,user_introduction,user_tag,user_img)
VALUES (2,"root@163.com","root","root",1,"2019-8-7","12345678901","我太难了",true,"123");

INSERT INTO sign_up
    (sign_up_id, user_id,user_name,user_password,identity,email_address,sex)
VALUES (1,1,"admin","admin",1,"admin@163.com",1);

INSERT INTO sign_up
    (sign_up_id, user_id,user_name,user_password,identity,email_address,sex)
VALUES (2,2,"root","root",1,"root@163.com",1);

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

INSERT INTO order_request (order_id,user_id,buyer_id,seller_id,goods_name,goods_quantity,goods_price)
VALUE (2,1,1,2,"深度学习",2,32.2);

INSERT INTO shipping_state (id,order_id,date,loc,other_info)
VALUE (2,2,"2020-6-13","北京","等待出库");

INSERT INTO order_request (order_id,user_id,buyer_id,seller_id,goods_name,goods_quantity,goods_price)
VALUE (3,2,2,1,"社会心理学",1,56);

INSERT INTO shipping_state (id,order_id,date,loc,other_info)
VALUE (3,3,"2020-6-15","广东","配送中");

INSERT INTO order_request (order_id,user_id,buyer_id,seller_id,goods_name,goods_quantity,goods_price)
VALUE (4,2,2,1,"犯罪心理学",2,32.2);

INSERT INTO shipping_state (id,order_id,date,loc,other_info)
VALUE (4,4,"2020-6-13","北京","等待出库");

UPDATE user_info SET use_level_id = 1,finance_id = 1,sign_up_id=1 WHERE user_id = 1;
UPDATE user_info SET use_level_id = 2,finance_id = 2,sign_up_id=2 WHERE user_id = 2;