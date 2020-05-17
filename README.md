# spring-cloud-dubbo
对应视频教程:https://edu.51cto.com/course/22492.html

# 微服务介绍

​		微服务采用一组服务的方式来构建一个应用，服务独立部署在不同的进程中，不同服务通过一些轻量级交互机制来通信，例如 RPC、HTTP 等，服务可独立扩展伸缩，每个服务定义了明确的边界，不同的服务甚至可以采用不同的编程语言来实现，由独立的团队来维护。


## 微服务基本概念

### 服务治理

服务治理就是进行服务的自动化管理，其核心是服务的自动注册与发现。
服务注册：服务实例将自身服务信息注册到注册中心。
服务发现：服务实例通过注册中心，获取到注册到其中的服务实例的信息，通过这些信息去请求它们提
供的服务。
服务剔除：服务注册中心将出问题的服务自动剔除到可用列表之外，使其不会被调用到。



### 服务调用

在微服务架构中，通常存在多个服务之间的远程调用的需求。目前主流的远程调用技术有基于
HTTP的RESTful接口以及基于TCP的RPC协议。
REST(Representational State Transfer)
这是一种HTTP调用的格式，更标准，更通用，无论哪种语言都支持http协议
RPC（Remote Promote Call）
一种进程间通信方式。允许像调用本地服务一样调用远程服务。RPC框架的主要目标就是让远程服
务调用更简单、透明。RPC框架负责屏蔽底层的传输方式、序列化方式和通信细节。开发人员在使
用的时候只需要了解谁在什么位置提供了什么样的远程服务接口即可，并不需要关心底层通信细节
和调用过程。



比较项 				RESTful 				RPC
通讯协议 			HTTP 					一般使用TCP
性能 					略低 					 较高
灵活度 				高 						 低
应用 					微服务架构 		 SOA架构

### 服务网关

随着微服务的不断增多，不同的微服务一般会有不同的网络地址，而外部客户端可能需要调用多个
服务的接口才能完成一个业务需求，如果让客户端直接与各个微服务通信可能出现：
客户端需要调用不同的url地址，增加难度
在一定的场景下，存在跨域请求的问题
每个微服务都需要进行单独的身份认证

API网关直面意思是将所有API调用统一接入到API网关层，由网关层统一接入和输出。一个网关的
基本功能有：统一接入、安全防护、协议适配、流量管控、长短链接支持、容错能力。有了网关之后，
各个API服务提供团队可以专注于自己的的业务逻辑处理，而API网关更专注于安全、流量、路由等问
题。



### 服务容错

在微服务当中，一个请求经常会涉及到调用几个服务，如果其中某个服务不可用，没有做服务容错
的话，极有可能会造成一连串的服务不可用，这就是雪崩效应。



### 链路追踪

随着微服务架构的流行，服务按照不同的维度进行拆分，一次请求往往需要涉及到多个服务。互联
网应用构建在不同的软件模块集上，这些软件模块，有可能是由不同的团队开发、可能使用不同的编程
语言来实现、有可能布在了几千台服务器，横跨多个不同的数据中心。因此，就需要对一次请求涉及的
多个服务链路进行日志记录，性能监控即链路追踪





# SpringCloud Alibaba介绍

## 介绍

Spring Cloud Alibaba 致力于提供微服务开发的一站式解决方案。此项目包含开发分布式应用微服
务的必需组件，方便开发者通过 Spring Cloud 编程模型轻松使用这些组件来开发分布式应用服务。
依托 Spring Cloud Alibaba，您只需要添加一些注解和少量配置，就可以将 Spring Cloud 应用接
入阿里微服务解决方案，通过阿里中间件来迅速搭建分布式应用系统。

* 服务限流降级：默认支持 WebServlet、WebFlux， OpenFeign、RestTemplate、Spring Cloud
  Gateway， Zuul， Dubbo 和 RocketMQ 限流降级功能的接入，可以在运行时通过控制台实时修
  改限流降级规则，还支持查看限流降级 Metrics 监控。
* 服务注册与发现：适配 Spring Cloud 服务注册与发现标准，默认集成了 Ribbon 的支持。
  分布式配置管理：支持分布式系统中的外部化配置，配置更改时自动刷新。
* 消息驱动能力：基于 Spring Cloud Stream 为微服务应用构建消息驱动能力。
* 分布式事务：使用 @GlobalTransactional 注解， 高效并且对业务零侵入地解决分布式事务问题。
* 阿里云对象存储：阿里云提供的海量、安全、低成本、高可靠的云存储服务。支持在任何应用、任
  何时间、任何地点存储和访问任意类型的数据。
* 分布式任务调度：提供秒级、精准、高可靠、高可用的定时（基于 Cron 表达式）任务调度服务。
  同时提供分布式的任务执行模型，如网格任务。网格任务支持海量子任务均匀分配到所有
  Worker（schedulerx-client）上执行。
* 阿里云短信服务：覆盖全球的短信服务，友好、高效、智能的互联化通讯能力，帮助企业迅速搭建
  客户触达通道。



## 组件

* Sentinel：把流量作为切入点，从流量控制、熔断降级、系统负载保护等多个维度保护服务的稳
  定性。
* Nacos：一个更易于构建云原生应用的动态服务发现、配置管理和服务管理平台。
* RocketMQ：一款开源的分布式消息系统，基于高可用分布式集群技术，提供低延时的、高可靠
  的消息发布与订阅服务。
* Dubbo：Apache Dubbo™ 是一款高性能 Java RPC 框架。
* Seata：阿里巴巴开源产品，一个易于使用的高性能微服务分布式事务解决方案。
* Alibaba Cloud ACM：一款在分布式架构环境中对应用配置进行集中管理和推送的应用配置中心
  产品。
* Alibaba Cloud OSS: 阿里云对象存储服务（Object Storage Service，简称 OSS），是阿里云提
  供的海量、安全、低成本、高可靠的云存储服务。您可以在任何应用、任何时间、任何地点存储和
  访问任意类型的数据。
* Alibaba Cloud SchedulerX: 阿里中间件团队开发的一款分布式任务调度产品，提供秒级、精
  准、高可靠、高可用的定时（基于 Cron 表达式）任务调度服务。
* Alibaba Cloud SMS: 覆盖全球的短信服务，友好、高效、智能的互联化通讯能力，帮助企业迅速
  搭建客户触达通道。



# 技术选型

* maven：3.3.9

* 数据库：MySQL

* 持久层: SpingData Jpa

* SpringCloud Alibaba 技术栈

  * 注册中心：Nacos

  * 服务注册发现：dubbo

  * 流控 : Sentinel

  * 服务网关 : getway

  * 链路追踪 : Sleuth+zipkin

  * 消息队列 : RocketMQ

  * 分布式事务：Seate
