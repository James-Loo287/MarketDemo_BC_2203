package com.example;

import com.example.impl.Apple;
import com.example.impl.Mongo;
import com.example.impl.Strawberry;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @Description：售货员，应用场景类
 * @Author：James Loo
 * @Date：2022/3/27 23:06
 */
public class Salesman {

    private Fruit fruit; // 顾客待计算价钱的水果

    public Salesman(Fruit fruit) {
        super();
        this.fruit = fruit;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    /**
     * 计算顾客购买某种水果的所需金额，其中判断输入购买数量的合法性
     * @param sc 扫描控制台输入对象
     * @return 金额
     */
    public BigDecimal getAmount(Scanner sc) {
        BigDecimal amount;
        boolean isInt = true; // 输入的购买数量是否为整数

        while (true) {
            int choice = 0;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                isInt = false;
                sc.next(); // 清除缓冲区数据，避免进入死循环
            } finally {
                if (choice < 0 || isInt == false) {
                    System.out.println("您的输入有误，请输入大于等于 0 的整数!");
                    isInt = true;
                } else {
                    fruit.setQuantity(BigDecimal.valueOf(choice));
                    amount = fruit.getAmount();
                    break;
                }
            }
        }
        return amount;
    }

    /**
     * 判断促销活动是否已过期
     * @param datetime 促销活动截止日期
     * @return true or false
     */
    public static boolean isOverdue(String datetime) {
        Instant nowTimestamp = Instant.now();  // 获取当前时间戳，统一使用世界标准时间（即0时区时间）进行处理
        LocalDateTime endDateTime = LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); // 促销活动截止时间，为本时区的时间，需要转换
        Instant endTimestamp = endDateTime.toInstant(ZoneOffset.of("+08:00")); // 在把LocalDateTime转换为Instant时，需要明确指定当前这个时间指的是哪个时区的时间
        if (nowTimestamp.compareTo(endTimestamp) > -1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 计算购买商品的总价
     * @param appleAmount 购买苹果的金额
     * @param strawberryAmount 购买草莓的金额
     * @param mongoAmount 购买芒果的金额
     * @param datetime 促销活动截止日期
     * @return 总计金额
     */
    public static BigDecimal getTotalAmount(BigDecimal appleAmount, BigDecimal strawberryAmount, BigDecimal mongoAmount, String datetime) {
        BigDecimal amount = appleAmount.add(strawberryAmount).add(mongoAmount);
        // 限时满减，需判断促销活动是否过期
        if (!Salesman.isOverdue(datetime)) {
            System.out.println("促销活动进行中，购物满 100 可以减 10 块哦！");
            amount = amount.compareTo(new BigDecimal("100")) > -1 ? amount.subtract(new BigDecimal("10")) : amount; // 购物满100减10块
        }
        System.out.println("购买所有商品的总价为：" + amount + "元");
        return amount;
    }

}
