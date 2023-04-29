package com.renchao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLog {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(TestLog.class);
        logger.info("hello world!");
    }
}
