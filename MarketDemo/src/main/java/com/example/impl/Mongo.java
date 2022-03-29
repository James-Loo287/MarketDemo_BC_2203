package com.example.impl;

import com.example.Fruit;

import java.math.BigDecimal;

/**
 * @Description：芒果
 * @Author：James Loo
 * @Date：2022/3/27 22:15
 */
public class Mongo implements Fruit {
    private BigDecimal price; // 单价
    private BigDecimal quantity; // 购买数量

    public Mongo(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    /**
     * 计算购买芒果的金额
     * @return 金额
     */
    @Override
    public BigDecimal getAmount() {
        BigDecimal amount;
        amount = price.multiply(quantity);
        System.out.println("购买芒果需要：" + amount + "元");
        return amount;
    }
}
