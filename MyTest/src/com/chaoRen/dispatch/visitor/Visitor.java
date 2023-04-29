package com.chaoRen.dispatch.visitor;

/**
 * 访问者接口，具体如何访问，由其实现类定义
 */
public interface Visitor {
    void visit(Picture picture);
    void visit(Gif gif);
    void visit(Video video);
}
