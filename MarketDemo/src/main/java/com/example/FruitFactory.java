package com.example;

import com.example.impl.Apple;
import com.example.impl.Mongo;
import com.example.impl.Strawberry;

import java.math.BigDecimal;

/**
 * @Description：水果工厂
 * @Author：James Loo
 * @Date：2022/3/27 22:30
 */
public class FruitFactory {
    private FruitFactory() {}

    public static Fruit getApple() {
        return new Apple(new BigDecimal("8.00"));
    }

    public static Fruit getStrawberry() {
        return new Strawberry(new BigDecimal("13.00"));
    }

    public static Fruit getMongo() {
        return new Mongo(new BigDecimal("20.00"));
    }
}
