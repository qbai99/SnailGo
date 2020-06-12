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