package com.javaBrains.javaBrains;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.javaBrains.javaBrains.repository.UserRepository")
@SpringBootApplication
public class JavaBrainsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaBrainsApplication.class, args);
	}


}
