package com.test2.api;

import com.test2.entity.User;
import com.test2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController // controlerımız
@RequestMapping("/user") // map edilecek yerimiz
public class UserApi {

    // kullanıcı repositorymize bağlanması gerektiğini söyleyen etiket
    @Autowired
    private UserRepository userRepository;

    //ilk ekleme işlemi yaptık bi tane
    @PostConstruct
    public  void  init()
    {
        //bir User oluşturduk
        User user = new User();
        user.setName("Mustafa Fırat");
        user.setLastName("YILMAZ");


        // kaydettik mongoDB ye
        userRepository.save(user);
    }
    //a few HTML command
    //Post ----- yeni ir var olmayan veriyi kayıt etmek için
    //Get ----- bir url için eldeki veriyi geri döndürür
    //Put ---- var olan verinin içeriğini güncellemek için

    //bu bir kayıt etme methodudur

    //birden fazla post olsaydı içerisine parametre gerekirdi
    // @PostMapping("url")

    //Post ederken içeriği göndermek için
    //HTML bilindiği üzere ya header yada body içinden veri  gönderilebilir
    //@RequestBody geleceği yeri belirttik
    // daha parametre veya id ile de alınabilir
    @PostMapping
    public ResponseEntity<User> add(@RequestBody User record)
    {
        //save methodu ile ekler
        //ResponseEntity.ok() sağlıklı bir bağlantı olması için ve gelenek olduğu için
       return ResponseEntity.ok(userRepository.save(record));
    }

    //kayıtlı tüm veriyi listeler
    //geti çağırmak için
    //localhost:8080/user
    @GetMapping
    public ResponseEntity<List<User>> listAll()
    {
        return ResponseEntity.ok(userRepository.findAll());
    }

}
