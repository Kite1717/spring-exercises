package com.test1.t1helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class T1HelloWorldApplication {

	public static void main(String[] args) {

		//sonucu görmek için tarayıcıda tomcat suncunun bağlı olduğu adres konsolda yazıyor
		//https://localhost:8080
		// mesajı görmek istediğimiz  MAP ettiğimiz kısma gidilmelidir
		//https://localhost:8080/message çıktı gözükür
		SpringApplication.run(T1HelloWorldApplication.class, args);
	}

}
