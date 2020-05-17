package top.glory.predicate;

//这是一个自定义的路由断言工厂类,要求有两个
//1 名字必须是 配置+RoutePredicateFactory
//2 必须继承AbstractRoutePredicateFactory<配置类>

//predicates:
// - Path=/stock-serv/**
// - Price=100,200 #自定义断言测试，限制价格在100到200之间的才能访问


import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//@Component
public class PriceRoutePredicateFactory extends AbstractRoutePredicateFactory<PriceRoutePredicateFactory.Config> {

    //构造函数
    public PriceRoutePredicateFactory() {
        super(PriceRoutePredicateFactory.Config.class);
    }

    //读取配置文件的中参数值 给他赋值到配置类中的属性上
    public List<String> shortcutFieldOrder() {
        //这个位置的顺序必须跟配置文件中的值的顺序对应
        return Arrays.asList("minPrice", "maxPrice");
    }

    //断言逻辑
    public Predicate<ServerWebExchange> apply(PriceRoutePredicateFactory.Config config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                //1 接收前台传入的Price参数
                String priceStr = serverWebExchange.getRequest().getQueryParams().getFirst("price");
                //2 先判断是否为空
                if (StringUtils.isNotBlank(priceStr)) {
                    int price = Integer.parseInt(priceStr);
                    //3 如果不为空,再进行路由逻辑判断
                    if (price < config.getMaxPrice() && price > config.getMinPrice()) {
                        return true;
                    } else {
                        return false;
                    }
                }
                return false;
            }
        };
    }

    //配置类,用于接收配置文件中的对应参数
    @Data
    @NoArgsConstructor
    public static class Config {
        private int minPrice;//100
        private int maxPrice;//200
    }
}
