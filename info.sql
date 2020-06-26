use eshop;
INSERT INTO user_info
(user_id, user_admin, user_name, user_password, usersex, user_birthdate, user_phonenumber,user_introduction,user_tag,user_img)
VALUES (1,"admin@163.com","admin","admin",1,"2019-8-7","12345678901","我太难了",false,"123");

INSERT INTO user_info
(user_id, user_admin, user_name, user_password, usersex, user_birthdate, user_phonenumber,user_introduction,user_tag,user_img)
VALUES (2,"root@163.com","root","root",1,"2019-8-7","12345678901","我太难了",true,"123");

INSERT INTO user_info
(user_id, user_admin, user_name, user_password, usersex, user_birthdate, user_phonenumber,user_introduction,user_tag,user_img)
VALUES (3,"8276@qq.com","123","admin",null,null,null,null,false,"123");

INSERT INTO sign_up
    (sign_up_id, user_id,user_name,user_password,identity,email_address)
VALUES (1,1,"admin","admin",1,"admin@163.com");


INSERT INTO sign_up
    (sign_up_id, user_id,user_name,user_password,identity,email_address)
VALUES (2,2,"root","root",1,"root@163.com");

INSERT INTO user_level
(level_id,user_id,level,points)
VALUES(1,1,3,250);

INSERT INTO user_level
    (level_id,user_id,level,points)
VALUES(2,2,3,200);

INSERT INTO user_level
(level_id,user_id,level,points)
VALUES(3,3,1,0);

INSERT INTO user_finance
(finance_id,user_id,balance)
VALUES(1,1,250);

INSERT INTO user_finance
    (finance_id,user_id,balance)
VALUES(2,2,10300);

INSERT INTO user_finance
(finance_id,user_id,balance)
VALUES(3,3,10000);

INSERT INTO address (address_id,user_id,address) VALUES(1,1,"四川省/成都市/双流区川大路/四川大学/13060033269/胡潇");
INSERT INTO address (address_id,user_id,address) VALUES(2,1,"广西壮族自治区/钦州市/永福西大街/永兴市场/13060033269/胡潇");

INSERT INTO order_request (order_id,user_id,goods_id,buyer_id,seller_id,address_id,goods_name,goods_quantity,goods_price)
VALUE (1,1,1,1,2,1,"iPadPro 2019",1,100);

INSERT INTO shipping_state (id,order_id,date,loc,other_info)
VALUE (1,1,"2020-6-15","广东","配送中");

INSERT INTO order_request (order_id,user_id,goods_id,buyer_id,seller_id,address_id,goods_name,goods_quantity,goods_price)
VALUE (2,1,2,1,2,1," iPhone 11",2,200);

INSERT INTO shipping_state (id,order_id,date,loc,other_info)
VALUE (2,2,"2020-6-13","北京","等待出库");

INSERT INTO order_request (order_id,user_id,goods_id,buyer_id,seller_id,address_id,goods_name,goods_quantity,goods_price)
VALUE (3,2,3,2,1,2," iPadPro 2020",1,200);

INSERT INTO shipping_state (id,order_id,date,loc,other_info)
VALUE (3,3,"2020-6-15","广东","配送中");

INSERT INTO order_request (order_id,user_id,goods_id,buyer_id,seller_id,goods_name,goods_quantity,goods_price)
VALUE (4,2,4,2,1,"男士T恤A",2,80);

INSERT INTO shipping_state (id,order_id,date,loc,other_info)
VALUE (4,4,"2020-6-13","北京","等待出库");

INSERT INTO shop
    (shop_id,user_id,shop_name,shop_main_bussiness,shop_star,shop_dsp,shop_loc)
VALUES(1,2,"胡潇的魔法小屋","魔法武器，魔法书，魔药原料，自制魔药等",5,"店铺的商品都经过真人测试，质量绝对有保障","中国昆仑山顶");

INSERT INTO goods
    (goods_id, shop_id, order_id, goods_price, goods_name, goods_remaning, goods_dsp, goods_tag)
VALUES (10, 1, NULL, 98, '神奇动物在哪里', 10, '神奇动物在哪里的描述', 'book/动物学');
INSERT INTO goods
    (goods_id, shop_id, order_id, goods_price, goods_name, goods_remaning, goods_dsp, goods_tag)
VALUES (11, 1, NULL, 77, '魔药学', 20, '魔药学的描述', 'book/植物学');


UPDATE user_info SET use_level_id = 1,finance_id = 1,sign_up_id=1 WHERE user_id = 1;
UPDATE user_info SET use_level_id = 2,finance_id = 2,sign_up_id=2,shop_id=1 WHERE user_id = 2;