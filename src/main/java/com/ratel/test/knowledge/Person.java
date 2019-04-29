package com.ratel.test.knowledge;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Component
@ConfigurationProperties(prefix = "person")
public class Person {

    private String name;

    @Value("${person.from}")
    private String from;

    @Value("${person.sex}")
    private String sex;

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public String getFrom() {
        return from;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
