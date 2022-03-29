package com.example;

import java.math.BigDecimal;

/**
 * @Description：水果公共接口
 * @Author：James Loo
 * @Date：2022/3/27 22:08
 */
public interface Fruit {
    /**
     * 计算购买某种水果的金额
     * @return 金额
     */
    public BigDecimal getAmount();

    /**
     * 设置购买某种水果的数量
     */
    public void setQuantity(BigDecimal quantity);
}
