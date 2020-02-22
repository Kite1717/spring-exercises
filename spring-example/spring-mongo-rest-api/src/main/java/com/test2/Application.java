package com.test2;

import com.test2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//spring boot projesi olduğunu gösterir
@SpringBootApplication

//bu projede mongoDB kullanılıyor
//mongoDB repository lerini devreye almamız içindir
@EnableMongoRepositories
public class Application {

    //Post işi kayıt etmek için bir örneği şimdilik burada
    // yapıyoruz daha sonra web sayfasından alacağız

    //buraya inject ettik userRepository @Autowired bu tag ile
    @Autowired
    UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        //app i ayağa kaldırdıktan sonra
    }
}
