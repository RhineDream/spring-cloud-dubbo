package top.glory.filters;

//自定义局部过滤器

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

// routes:
//    - id: stock_route
//      uri: lb://service-stock
//      predicates:
//          - Path=/stock-serv/**
//      filters:
//          - Log=true,false  #测试  局部路由过滤器  控制日志是否开启
//@Component
public class LogGatewayFilterFactory
        extends AbstractGatewayFilterFactory<LogGatewayFilterFactory.Config> {

    //构造函数
    public LogGatewayFilterFactory() {
        super(LogGatewayFilterFactory.Config.class);
    }

    //读取配置文件中的参数 赋值到 配置类中
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("testLog", "prodLog");
    }

    //过滤器逻辑
    @Override
    public GatewayFilter apply(LogGatewayFilterFactory.Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                if (config.isTestLog()) {
                    System.out.println("测试环境日志已经开启了！");
                    System.out.println("已记录到测试环境日志中！");
                }
                if (config.isProdLog()) {
                    System.out.println("生成环境日志已经开启了！");
                    System.out.println("已记录到生产环境日志中！");
                }

                return chain.filter(exchange);
            }
        };
    }

    //配置类 接收配置参数
    @Data
    @NoArgsConstructor
    public static class Config {
        private boolean testLog;
        private boolean prodLog;
    }
}