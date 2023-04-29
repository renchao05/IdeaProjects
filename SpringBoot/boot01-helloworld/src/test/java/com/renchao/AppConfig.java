package com.renchao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {
    @Profile("english")
    @Bean
    public English getEnglish() { return new English(); }

    @Profile("chinese")
    @Bean
    public Chinese getChinese() { return new Chinese(); }
}

class Chinese { }

class English { }
