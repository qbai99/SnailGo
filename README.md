# 步骤
1. 导入此项目。选中pom 文件就好
2. 建立MySQL数据库,版本尽量不要超过5.X。否则需要修改数据库驱动包的版本以及数据库连接信息等


# 标题命名规则
# 主版本号.子版本号.阶段版本号.日期版本号_希腊字母版本号
●主版本号(1):当功能模块有较大的变动，比如增加多个模块或者整体架构发生变化。此版本号由项目决定是否修改。

●子版本号(1):当功能有一定的增加或变化,比如增加了对权限控制、增加自定义视图等功能。此版本号由项目决定是否修改。

●阶段版本号(1): -般是Bug修复或是一些小的变动， 要经常发布修订版，时间间隔不限，修复一个严重的bug即可发布一个修订版。此版本号由项目经理决定是否修改。

●日期版本号(051021):用于记录修改项目的当前日期， 每天对项目的修改都需要更改日期版本号。此版本号由开发人员决定是否修改。

●希腊字母版本号(beta):此版本号用于标注当前版本的软件处于哪个开发阶段，当软件进入到另一个阶段时需要修改此版本号。此版本号由项目决定是否修改。


# 更新信息
# ver 1.0.0.200612_beta
1. 修改了数据库创建的问题
2. 导入login界面
# 更新信息
# ver 1.0.1.200612_beta
1.增加了访问卖家页面/联系卖家接口
# 更新信息
# ver 1.0.2.200612_beta
1.  将个人信息管理模块的前端界面整合，并与商品界面的前端界面连接
# 更新信息
# ver 1.0.1.200613_beta
1.增加了支付界面-pay.html
2.增加了static/img的内容
3.增加了PayController
4.增加登录界面
# ver 1.0.2.200614_beta
1.添加了查询个人信息的controller
2.页面打开个人中心可以显示个人信息
3.增加注册界面
# ver 1.0.2.200615_beta
1.完成了修改密码接口
2.将数据库表中的所有主码设置为自增
3.登陆界面与注册界面的数据库连接
# ver 1.0.3.200615_beta
1.完成了收货地址的查看和添加
2.完成了余额的查看以及充值
3.修改了些许页面的跳转问题
4.完成了系统管理员推送消息以及其他客户端接收消息
# ver 1.0.4.200615_beta
1.完善了个人信息的修改操作
2.修改了数据库的部分内容
3.修改了部分mapper.xml的内容
4.修改了部分实体类的内容


# 使用说明
+ "http://localhost:端口号/ws"  系统管理员消息推送，主页能显示消息
+ "http://localhost:端口号/loginPage"  登录界面
+ "http://localhost:端口号/signUpPage"     注册界面