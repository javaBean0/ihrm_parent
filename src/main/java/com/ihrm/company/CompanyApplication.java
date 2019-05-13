package com.ihrm.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * author:bigStone
 * Date:2019/5/13
 **/

//配置springBoot的包扫描
@SpringBootApplication(scanBasePackages = "com.ihrm.company")
//配置jpa注解的扫描
@EntityScan(value = "com.ihrm.domain.company")
public class CompanyApplication {

    //配置启动方法
    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class, args);
    }

}
