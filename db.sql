/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/6/10 18:53:15                           */
/*==============================================================*/

drop database if exists eshop;


create database eshop;
use eshop;

drop table if exists address;

drop table if exists browsing_records;

drop table if exists chat_record;

drop table if exists good_imgs;

drop table if exists good_infos;

drop table if exists good_norms;

drop table if exists good_tags;

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
/* Table: good_imgs                                             */
/*==============================================================*/
create table good_imgs
(
   id                   bigint not null auto_increment,
   goods_id             bigint,
   imgs                 longtext,
   primary key (id)
);

/*==============================================================*/
/* Table: good_infos                                            */
/*==============================================================*/
create table good_infos
(
   id                   bigint not null auto_increment,
   goods_id             bigint,
   infos                text,
   primary key (id)
);

/*==============================================================*/
/* Table: good_norms                                            */
/*==============================================================*/
create table good_norms
(
   id                   bigint not null auto_increment,
   goods_id             bigint,
   norms                varchar(255),
   primary key (id)
);

/*==============================================================*/
/* Table: good_tags                                             */
/*==============================================================*/
create table good_tags
(
   id                   bigint not null auto_increment,
   goods_id             bigint,
   tags                 varchar(255),
   primary key (id)
);

/*==============================================================*/
/* Table: goods                                                 */
/*==============================================================*/
create table goods
(
   goods_id             bigint not null auto_increment,
   shop_id              bigint,
   order_id             bigint,
   cart_id              int,
   goods_price          double,
   goods_name           varchar(255),
   goods_remaning       int default 0,
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
   buyer_id             bigint,
   seller_id            bigint,
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
   shop_boss            varchar(255),
   shop_goods           text,
   primary key (shop_id)
);

/*==============================================================*/
/* Table: shopping_cart                                         */
/*==============================================================*/
create table shopping_cart
(
   id                   int not null auto_increment,
   user_id              bigint,
   goods_id             int,
   goods_name           varchar(255),
   goods_remaining      int,
   goods_quantity       int,
   goods_price          double not null,
   primary key (id)
);

/*==============================================================*/
/* Table: sign_up                                               */
/*==============================================================*/
create table sign_up
(
   sign_up_id           bigint not null auto_increment,
   user_id              bigint,
   username             char(7),
   password             varchar(15),
   identity             bool,
   email_address        longtext,
   sex                  bool,
   address              varchar(255),
   primary key (sign_up_id)
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
   cart_id              int,
   user_admin           varchar(255),
   user_name            varchar(7) not null,
   user_password        varchar(15) not null,
   usersex              int,
   user_birthdate       date,
   user_phonenumber     char(11),
   user_img             varchar(255),
   user_introductoin    text,
   user_tag             bool,
   level_id             bigint,
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

alter table address add constraint FK_Relationship_4 foreign key (user_id)
      references user_info (user_id) on delete restrict on update restrict;

alter table browsing_records add constraint FK_Relationship_10 foreign key (user_id)
      references user_info (user_id) on delete restrict on update restrict;

alter table good_imgs add constraint FK_Relationship_26 foreign key (goods_id)
      references goods (goods_id) on delete restrict on update restrict;

alter table good_infos add constraint FK_Relationship_25 foreign key (goods_id)
      references goods (goods_id) on delete restrict on update restrict;

alter table good_norms add constraint FK_Relationship_23 foreign key (goods_id)
      references goods (goods_id) on delete restrict on update restrict;

alter table good_tags add constraint FK_Relationship_24 foreign key (goods_id)
      references goods (goods_id) on delete restrict on update restrict;

alter table goods add constraint FK_Relationship_19 foreign key (shop_id)
      references shop (shop_id) on delete restrict on update restrict;

alter table goods add constraint FK_Relationship_20 foreign key (order_id)
      references order_request (order_id) on delete restrict on update restrict;

alter table goods add constraint FK_Relationship_9 foreign key (cart_id)
      references shopping_cart (cart_id) on delete restrict on update restrict;

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

alter table shopping_cart add constraint FK_Relationship_28 foreign key (goods_id)
    references good_infos (goods_id) on delete restrict on update restrict;

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

alter table user_info add constraint FK_Relationship_7 foreign key (cart_id)
      references shopping_cart (cart_id) on delete restrict on update restrict;

alter table user_level add constraint FK_Relationship_6 foreign key (user_id)
      references user_info (user_id) on delete restrict on update restrict;

