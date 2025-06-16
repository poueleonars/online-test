package cn.kmbeast;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * 项目启动类
 */
@MapperScan("cn.kmbeast.mapper")
@SpringBootApplication
@CrossOrigin("*")
public class OnlineTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnlineTestApplication.class, args);
    }
}
