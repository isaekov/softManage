package ru.hwru.softmanage;

import org.springframework.boot.SpringApplication;

public class TestSoftManageApplication {

    public static void main(String[] args) {
        SpringApplication.from(SoftManageApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
