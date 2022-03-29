package com.example;

import com.example.impl.Apple;
import com.example.impl.Mongo;
import com.example.impl.Strawberry;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Description：计算顾客购买商品的总价
 * @Author：James Loo
 * @Date：2022/3/27 23:30
 */
public class Shopping {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BigDecimal appleAmount = new BigDecimal("0");
        BigDecimal strawberryAmount = new BigDecimal("0");
        BigDecimal mongoAmount = new BigDecimal("0");
        BigDecimal amount;
        String endDateTime = "2022-03-27 08:25:12"; // 促销活动截止日期

        //顾客购买苹果
        Salesman salesman = new Salesman(FruitFactory.getApple()); // 使用构造函数默认顾客选择购买苹果
        System.out.println("请输入购买苹果的数量（单位：斤）：");
        appleAmount = salesman.getAmount(sc);

        //顾客购买草莓
        Strawberry strawberry = (Strawberry)FruitFactory.getStrawberry();
        strawberry.setEndDateTime(endDateTime);
        salesman.setFruit(strawberry); // 使用set方法切换到购买草莓
        System.out.println("请输入购买草莓的数量（单位：斤）：");
        strawberryAmount = salesman.getAmount(sc);

        //顾客购买芒果
        salesman.setFruit(FruitFactory.getMongo()); // 使用set方法切换到购买草莓
        System.out.println("请输入购买芒果的数量（单位：斤）：");
        mongoAmount = salesman.getAmount(sc);

        // 计算总价
        salesman.getTotalAmount(appleAmount, strawberryAmount, mongoAmount, endDateTime);
    }

}
