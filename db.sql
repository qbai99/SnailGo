/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/6/10 18:53:15                           */
/*==============================================================*/

drop database if exists eshop;
CREATE DATABASE `eshop` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use eshop;

drop table if exists address;

drop table if exists browsing_records;

drop table if exists chat_record;

drop table if exists goods;

drop table if exists login;

drop table if exists message_record;

drop table if exists order_request;

drop table if exists send_receive;

drop table if exists shipping_state;

drop table if exists shop;

drop table if exists shopping_cart;

drop table if exists sign_up;

drop table if exists user_finance;

drop table if exists user_info;

drop table if exists user_level;

DROP TABLE IF EXISTS `comment`;

/*==============================================================*/
/* Table: address                                               */
/*==============================================================*/
create table address
(
   address_id           bigint not null auto_increment,
   user_id              bigint,
   address              varchar(255),
   primary key (address_id)
);

/*==============================================================*/
/* Table: browsing_records                                      */
/*==============================================================*/
create table browsing_records
(
   records_id           bigint not null auto_increment,
   user_id              bigint,
   records              varchar(255),
   primary key (records_id)
);

/*==============================================================*/
/* Table: chat_record                                           */
/*==============================================================*/
create table chat_record
(
   chatroom_id          int not null auto_increment,
   logid                int,
   sender_id            int,
   receiver_id          int,
   send_time            varchar(200),
   send_content         varchar(200),
   primary key (chatroom_id)
);


/*==============================================================*/
/* Table: goods                                                 */
/*==============================================================*/
create table goods
(
   goods_id             bigint not null auto_increment,
   shop_id              bigint,
   order_id             bigint,
   goods_price          double,
   goods_name           varchar(255),
   goods_remaning       int default 0,
   goods_dsp           varchar(255),
   goods_tag             varchar(255),
   primary key (goods_id)
);

/*==============================================================*/
/* Table: login                                                 */
/*==============================================================*/
CREATE TABLE login
(
   login_id             INT NOT NULL auto_increment,
   user_id              BIGINT,
   user_admin             VARCHAR(255),
   user_password             VARCHAR(15),
   PRIMARY KEY (login_id)
);


/*==============================================================*/
/* Table: message_record                                        */
/*==============================================================*/
create table message_record
(
   message_id           int not null auto_increment,
   title                varchar(255) not null,
   content              text,
   mail_timing          datetime not null,
   send_date            datetime not null,
   primary key (message_id)
);

/*==============================================================*/
/* Table: "order"                                               */
/*==============================================================*/
create table order_request
(
   order_id             bigint not null auto_increment,
   user_id              bigint,
   goods_id             bigint,
   buyer_id             bigint,
   seller_id            bigint,
   address_id           bigint,
   goods_name           varchar(255),
   goods_quantity       bigint,
   goods_price          double,
   primary key (order_id)
);

/*==============================================================*/
/* Table: send_receive                                          */
/*==============================================================*/
create table send_receive
(
   user_id              bigint not null auto_increment,
   chatroom_id          int not null,
   primary key (user_id, chatroom_id)
);

/*==============================================================*/
/* Table: shipping_state                                        */
/*==============================================================*/
create table shipping_state
(
   id                   bigint not null auto_increment,
   order_id             bigint,
   date                 datetime,
   loc                  varchar(255),
   other_info           longtext,
   primary key (id)
);

/*==============================================================*/
/* Table: shop                                                  */
/*==============================================================*/
create table shop
(
   shop_id              bigint not null auto_increment,
   user_id              bigint,
   shop_name            varchar(255),
   shop_main_bussiness  varchar(255),
   shop_star            double,
   shop_dsp             varchar(255),
   shop_loc             varchar(255),
   primary key (shop_id)
);

/*==============================================================*/
/* Table: shopping_cart                                         */
/*==============================================================*/
create table shopping_cart
(
   id                   int not null auto_increment,
   user_id              bigint,
   goods_id             bigint,
   goods_name           varchar(255),
   goods_quantity       int,
   goods_price          double not null,
   primary key (id)
);

/*==============================================================*/
/* Table: sign_up                                               */
/*==============================================================*/
create table sign_up
(
sign_up_id           BIGINT NOT NULL AUTO_INCREMENT,
   user_id              BIGINT,
   user_name             VARCHAR(15),
   user_password             VARCHAR(15),
   identity             BOOL,
   email_address        VARCHAR(255),
   PRIMARY KEY (sign_up_id)
);

/*==============================================================*/
/* Table: user_finance                                          */
/*==============================================================*/
create table user_finance
(
   finance_id           bigint not null auto_increment,
   user_id              bigint,
   balance              double,
   primary key (finance_id)
);

/*==============================================================*/
/* Table: user_info                                             */
/*==============================================================*/
create table user_info
(
   user_id              bigint not null auto_increment,
   message_id           int,
   sign_up_id           bigint,
   login_id             int,
   finance_id           bigint,
   use_level_id         bigint,
   shop_id              bigint,
   user_admin           varchar(255),
   user_name            varchar(7) not null,
   user_password        varchar(15) not null,
   usersex              int,
   user_birthdate       char(255),
   user_phonenumber     char(11),
   user_img             longblob,
   user_introduction    text,
   user_tag             bool,
   primary key (user_id)
);

/*==============================================================*/
/* Table: user_level                                            */
/*==============================================================*/
create table user_level
(
   level_id             bigint not null auto_increment,
   user_id              bigint,
   level                int,
   points               int,
   primary key (level_id)
);

DROP TABLE IF EXISTS comment;
CREATE TABLE comment  (
                            comment_id int(11) NOT NULL,
                            goods_id bigint(20) NULL DEFAULT NULL,
                            user_id int(11) NULL DEFAULT NULL,
                            com varchar(255),
                            PRIMARY KEY (comment_id) USING BTREE,
                            INDEX fk_comment_1(goods_id) USING BTREE,
                            CONSTRAINT fk_comment_1 FOREIGN KEY (goods_id) REFERENCES goods (goods_id) ON DELETE RESTRICT ON UPDATE RESTRICT
);

DROP TABLE IF EXISTS goods_img;
CREATE TABLE goods_img (
  img_id bigint not null auto_increment,
  goods_id              bigint,
  goods_img             longblob,
  primary key (img_id)
);

alter table goods_img add constraint FK_Relationship_101 foreign key (goods_id)
references goods (goods_id) on delete restrict on update restrict;

alter table address add constraint FK_Relationship_4 foreign key (user_id)
      references user_info (user_id) on delete restrict on update restrict;

alter table browsing_records add constraint FK_Relationship_10 foreign key (user_id)
      references user_info (user_id) on delete restrict on update restrict;


alter table goods add constraint FK_Relationship_19 foreign key (shop_id)
      references shop (shop_id) on delete restrict on update restrict;

alter table goods add constraint FK_Relationship_20 foreign key (order_id)
      references order_request (order_id) on delete restrict on update restrict;

alter table login add constraint FK_Relationship_14 foreign key (user_id)
      references user_info (user_id) on delete restrict on update restrict;

alter table order_request add constraint FK_Relationship_1 foreign key (user_id)
      references user_info (user_id) on delete restrict on update restrict;

alter table send_receive add constraint FK_Relationship_17 foreign key (user_id)
      references user_info (user_id) on delete restrict on update restrict;

alter table send_receive add constraint FK_Relationship_18 foreign key (chatroom_id)
      references chat_record (chatroom_id) on delete restrict on update restrict;

alter table shipping_state add constraint FK_Relationship_27 foreign key (order_id)
      references order_request (order_id) on delete restrict on update restrict;

alter table shop add constraint FK_Relationship_2 foreign key (user_id)
      references user_info (user_id) on delete restrict on update restrict;


alter table shopping_cart add constraint FK_Relationship_8 foreign key (user_id)
      references user_info (user_id) on delete restrict on update restrict;

alter table sign_up add constraint FK_Relationship_16 foreign key (user_id)
      references user_info (user_id) on delete restrict on update restrict;

alter table user_finance add constraint FK_Relationship_12 foreign key (user_id)
      references user_info (user_id) on delete restrict on update restrict;

alter table user_info add constraint FK_Relationship_11 foreign key (finance_id)
      references user_finance (finance_id) on delete restrict on update restrict;

alter table user_info add constraint FK_Relationship_13 foreign key (login_id)
      references login (login_id) on delete restrict on update restrict;

alter table user_info add constraint FK_Relationship_15 foreign key (sign_up_id)
      references sign_up (sign_up_id) on delete restrict on update restrict;

alter table user_info add constraint FK_Relationship_21 foreign key (message_id)
      references message_record (message_id) on delete restrict on update restrict;

alter table user_info add constraint FK_Relationship_3 foreign key (shop_id)
      references shop (shop_id) on delete restrict on update restrict;

alter table user_info add constraint FK_Relationship_5 foreign key (use_level_id)
      references user_level (level_id) on delete restrict on update restrict;

alter table user_level add constraint FK_Relationship_6 foreign key (user_id)
      references user_info (user_id) on delete restrict on update restrict;

alter table order_request add constraint FK_Relationship_100 foreign key (goods_id)
references goods (goods_id) on delete restrict on update restrict;

alter table order_request add constraint FK_Relationship_102 foreign key (address_id)
references address (address_id) on delete restrict on update restrict;