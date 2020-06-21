INSERT INTO `goods`(`goods_id`, `shop_id`, `order_id`, `goods_price`, `goods_name`, `goods_remaning`, `goods_dsp`, `goods_tag`) VALUES (1, NULL, NULL, 100, 'iPadPro 2019', 100, '它如同一片充满魔力的玻璃。\r\n它快到让很多笔记本电脑都眼红。\r\n它的 Pro 级摄像头打通了真实和虚拟的交界。\r\n它能让你用手、用笔、用键盘，还有触控板来互动。\r\n它，就是新款 iPad Pro。', '3C');
INSERT INTO `goods`(`goods_id`, `shop_id`, `order_id`, `goods_price`, `goods_name`, `goods_remaning`, `goods_dsp`, `goods_tag`) VALUES (2, NULL, NULL, 200, ' iPhone 11', 30, '全新双摄系统取景范围更大，可将你的所见所爱尽收画面之中。iPhone 迄今最快的芯片和从早用到晚的电池续航，让你能做的事更多，却无需频频充电。而有了 iPhone 最高的视频画质，你所记录的那些美好时分，也会更加鲜活。', '3C');
INSERT INTO `goods`(`goods_id`, `shop_id`, `order_id`, `goods_price`, `goods_name`, `goods_remaning`, `goods_dsp`, `goods_tag`) VALUES (3, NULL, NULL, 200, ' iPadPro 2020', 1, ' iPadPro 2020的描述', '3C');
INSERT INTO `goods`(`goods_id`, `shop_id`, `order_id`, `goods_price`, `goods_name`, `goods_remaning`, `goods_dsp`, `goods_tag`) VALUES (4, NULL, NULL, 80, '男士T恤A', 0, '男士T恤A的描述', 'male；男装');
INSERT INTO `goods`(`goods_id`, `shop_id`, `order_id`, `goods_price`, `goods_name`, `goods_remaning`, `goods_dsp`, `goods_tag`) VALUES (5, NULL, NULL, 70, '男士T恤B', 0, '男士T恤B的描述', 'male');
INSERT INTO `goods`(`goods_id`, `shop_id`, `order_id`, `goods_price`, `goods_name`, `goods_remaning`, `goods_dsp`, `goods_tag`) VALUES (6, NULL, NULL, 69, '男士T恤C', 0, '男士T恤C的描述', 'male');
INSERT INTO `goods`(`goods_id`, `shop_id`, `order_id`, `goods_price`, `goods_name`, `goods_remaning`, `goods_dsp`, `goods_tag`) VALUES (7, NULL, NULL, 88, '连衣裙A', 0, '连衣裙A的描述', NULL);
INSERT INTO `goods`(`goods_id`, `shop_id`, `order_id`, `goods_price`, `goods_name`, `goods_remaning`, `goods_dsp`, `goods_tag`) VALUES (8, NULL, NULL, 98, '连衣裙B', 0, '连衣裙B的描述', NULL);
INSERT INTO `goods`(`goods_id`, `shop_id`, `order_id`, `goods_price`, `goods_name`, `goods_remaning`, `goods_dsp`, `goods_tag`) VALUES (9, NULL, NULL, 77, '女裤子', 0, '女裤子的描述', NULL);
INSERT INTO `address`(`address_id`, `user_id`, `address`) VALUES (1, 1, '????');
INSERT INTO `address`(`address_id`, `user_id`, `address`) VALUES (2, 1, '????');

INSERT INTO `order_request`(`order_id`, `user_id`, `buyer_id`, `seller_id`, `goods_name`, `goods_quantity`, `goods_price`) VALUES (1, 1, 1, 2, '????', 1, 56);
INSERT INTO `shipping_state`(`id`, `order_id`, `date`, `loc`, `other_info`) VALUES (1, 1, '2020-06-15 00:00:00', '??', '???');
INSERT INTO `shopping_cart`(`id`, `user_id`, `goods_id`, `goods_name`, `goods_quantity`, `goods_price`) VALUES (51, 1, 2, 'iPhone 11', 1, 200);
INSERT INTO `shopping_cart`(`id`, `user_id`, `goods_id`, `goods_name`, `goods_quantity`, `goods_price`) VALUES (52, 1, 3, 'iPadPro 2020', 1, 200);
INSERT INTO `user_finance`(`finance_id`, `user_id`, `balance`) VALUES (1, 1, 250);
INSERT INTO `user_finance`(`finance_id`, `user_id`, `balance`) VALUES (2, 2, 10300);
INSERT INTO `user_info`(`user_id`, `message_id`, `sign_up_id`, `login_id`, `finance_id`, `use_level_id`, `shop_id`, `user_admin`, `user_name`, `user_password`, `usersex`, `user_birthdate`, `user_phonenumber`, `user_img`, `user_introduction`, `user_tag`) VALUES (1, NULL, NULL, NULL, 1, 1, NULL, 'admin', '????', 'admin', 1, '2019-08-07', '12345678901', NULL, '????', 0);
INSERT INTO `user_info`(`user_id`, `message_id`, `sign_up_id`, `login_id`, `finance_id`, `use_level_id`, `shop_id`, `user_admin`, `user_name`, `user_password`, `usersex`, `user_birthdate`, `user_phonenumber`, `user_img`, `user_introduction`, `user_tag`) VALUES (2, NULL, NULL, NULL, 2, 2, NULL, 'root', '????', 'root', 1, '2019-08-07', '12345678901', NULL, '????', 1);
INSERT INTO `user_level`(`level_id`, `user_id`, `level`, `points`) VALUES (1, 1, 3, 250);
INSERT INTO `user_level`(`level_id`, `user_id`, `level`, `points`) VALUES (2, 2, 3, 200);
