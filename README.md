## thinker-base
###基础信息（用户管理、组织管理、权限管理）

###项目结构 
>* com.github.slowrookie							项目启动入口
>* com.github.slowrookie.cfg    					基本的配置信息
>* com.github.slowrookie.exception 					统一异常捕获抛出处理（方便调用者知道错误的具体信息）
>* com.github.slowrookie.interceptor				AOP
>* com.github.slowrookie.persistence 				持久化抽象类父类
>* com.github.slowrookie.persistence.entity			所有系统中的持久化对象
>* com.github.slowrookie.persistence.entity.query 	持久化对象的查询对象
>* com.github.slowrookie.repository 				持久化接口类
>* com.github.slowrookie.service 					服务类接口
>* com.github.slowrookie.service.impl				服务类实现类
>* com.github.slowrookie.web						Controller管理

###注释规范
>*	所有注释均需要言简意赅。
>*	每个类都需要有个说明其作用的注释，位于class 上方。
>*	Controll和Servcie接口中需要明确写明方法的注释，实现类中方法钱不必写注释，所有的实现方法必须都来自于接口定义。
>*	对于代码块内的注释，不要写在每一行的后面，应写在对应行的上方。

###编码规范
>*	命名需要充分体现其功能，超过30个字符才考虑简写。
>*	不要使用代码格式化快捷键(eclpse: Ctrl+Shift+F),一行代码长度达到编辑窗口的60% ~ 70%手动换行
>*	所有类名和属性字段都遵循骆驼命名法，不要出现下划线之类的特殊字符
>*	类名和方法名应该充分体现功能，要有主次之分和联系。（例如：User里的 唯一主键，应该就是Id不应该是UserId，数据库名称规范也如此）

###主要结构图
 
