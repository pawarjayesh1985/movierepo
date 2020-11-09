package ksubaka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by jpawar on 11/8/2020.
 */
@SpringBootApplication
@EnableFeignClients
@EnableAutoConfiguration(exclude = {
        TransactionAutoConfiguration.class,
        SpringDataWebAutoConfiguration.class
})
@ComponentScan(basePackages = {"ksubaka"})
public class KsukabaStarter {
    public static void main(String[] args) {
        SpringApplication.run(KsukabaStarter.class, args);
    }
}
