package com.chaoren.admin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@SpringBootTest
class Boot09FeaturesProfileApplicationTests {

    @Test
    void contextLoads() {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("10 * (2 + 1) * 1 + 66"); //96
        int result = (Integer) expression.getValue();
        System.out.println(result);
    }

}
