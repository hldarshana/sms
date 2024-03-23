package com.example.sms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.example.sms.repository")
@Configuration
public class MongoConfig {
}
