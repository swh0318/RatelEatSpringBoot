package com.ratel.test.knowledge;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "person")
public class Person {

    private String name;

    private String from;

    private String sex;

    private Integer age;
}
