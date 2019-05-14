package com.ihrm.company;

import com.ihrm.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

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

    //初始化IdWorker
    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }


}
