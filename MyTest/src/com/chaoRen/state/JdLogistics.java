package com.chaoRen.state;


import java.util.Objects;

/**
 * 此类持有一个LogisticsState 的引用，负责在流程中保持并切换状态
 */
public class JdLogistics {
    private LogisticsState logisticsState;

    public void setLogisticsState(LogisticsState logisticsState) {
        this.logisticsState = logisticsState;
    }

    public LogisticsState getLogisticsState() {
        return logisticsState;
    }

    public void doAction(){
        Objects.requireNonNull(logisticsState);
        logisticsState.doAction(this);
    }
}
