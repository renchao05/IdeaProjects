package com.chaoRen.state;

/**
 * 此接口定义各个状态的统一操作接口
 */
public interface LogisticsState {
    void doAction(JdLogistics context);
}
