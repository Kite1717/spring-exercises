package com.test1.t1helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//bu classın web api olabilmesi için eklenir
@RestController
//hangi adreste yayınlansın diyebileceğimiz için bunu verdik
@RequestMapping("/message")
public class HelloApi {

    //message adresine bir get isteği olarak map edielim
    // oraya gidince açılması için

    //yukarıdaki "/message" adrese GET yani
    // açmaya çalıştığımız da aşağıdaki method çalışsın demek
    // oluyor
    // ve bu içerik döndürülüyor
    @GetMapping
    public  String  hello()
    {
       return "Hello!!";

    }


}
