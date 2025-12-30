package com.telusko.SpringJDBCDemo;

import com.telusko.SpringJDBCDemo.model.Alien;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcDemoApplication.class, args);

        Alien alien1 = context.getBean(Alien.class);
        alien1.setName("Alien1");
        alien1.setId(111);
        alien1.setTech("Alien2");

        AlienRepo repo = context.getBean(AlienRepo.class);
        repo.save(alien1);
        System.out.println(repo.findAll());
	}

}
