package com.example.impl;

import com.example.Fruit;
import com.example.Salesman;

import java.math.BigDecimal;

/**
 * @Description：草莓
 * @Author：James Loo
 * @Date：2022/3/27 22:18
 */
public class Strawberry implements Fruit {
    private BigDecimal price;    // 单价
    private BigDecimal quantity; // 购买数量
    private BigDecimal discount; // 打折折扣
    private String endDateTime; // 促销活动截止日期

    public Strawberry(BigDecimal price) {
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

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }

    /**
     * 计算购买草莓的金额
     * @return 金额
     */
    @Override
    public BigDecimal getAmount() {
        BigDecimal amount;
        // 限时打折，需判断促销活动是否过期
        if (Salesman.isOverdue(endDateTime)) {
            discount = new BigDecimal("1");
            System.out.println("促销活动已结束，草莓已恢复原价");
        } else {
            discount = new BigDecimal("0.8");
            System.out.println("促销活动进行中，草莓限时打 8 折");
        }

        amount = price.multiply(quantity).multiply(discount);
        System.out.println("购买草莓需要：" + amount + "元");
        return amount;
    }
}
