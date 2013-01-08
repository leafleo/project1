交换平台SDK主要由交换接口API类库以及配置文件、帮助文档、开发示例等组成，交换平台SDK目录结构如下所示：

1	\conf	配置文件，包括用户凭证和运行配置。用户凭证文件：credentials.properties运行配置文件：dc-client.properties
2	\data	数据目录，临时存储消息和日志。
2.1	\data\msg	消息文件目录
2.1.1	\data\msg\pending	挂起的消息（应发未发）
2.1.2	\data\msg\invalid	非法的消息（永不发送）
2.2	\data\log	交换审计日志目录
2.2.1	\data\log\pending	未同步的交换审计日志
3	\doc	文档目录，包括接入开发实施规范以及API文档。
3.1	\doc\java	Java API文档
3.2	\doc\dotnet	Dotnet API文档
4	\example	示例程序，包括Java和Dotnet版本示例。
4.1	\example\java	Java示例程序
4.2	\example\dotnet	Dotnet示例程序
5	\lib	交换接口API类库，供交换桥接系统调用。
5.1	\lib\java	Java API类库：dc-client.jar
5.2	\lib\dotnet	Dotnet API类库：dc-client.dll

改进如下：
1、增加java版本的程序包
2、增加了即使pending目录的send文件夹不存在，也能正确发送消息
3、解决了多个上一个版本的bug

目前已知问题如下：
1、DatacenterClient的GetAuditLogs方法未实现，将在下次发布中增加。
