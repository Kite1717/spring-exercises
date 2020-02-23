package com.test2.api;


import com.test2.entity.User;
import com.test2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


//Lombok kullanarak Entity için hangi fieldlar gerekirse
// onun constructor ını eklesin dedik
// bunu yazmasaydık bunu yazmamız gerekirdi
/*
public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
 */
@RequiredArgsConstructor
//bu bir rest controller olduğu için rest api
@RestController
//yayınlması için map gettik /user adresinde yayınlanması için
@RequestMapping("/user")
public class UserController {

    // buna bağlanıp onun üzerinden çalışması için
    private final UserRepository userRepository;

    @GetMapping("/{search}")
    //serach diye bir değer alıyo
    // bunu kullanarak bir çok alanda arama yapacağız
    //bu bir path değişkenidir
    // bu bir get methodudur var olan bir entity çağrımı yapılır
    //aşağıdaki ile yukarıdaki aynı isimde olmalı
    // "/{search}"  ->> @PathVariable String search
    public ResponseEntity<List<User>> getUsers(@PathVariable String search)
    {
        // response doğru bir şekilde bağlandık

        // bir aramaya göre bize bir veya daha fazla kişi gelebilir
      //  List<User> users = userRepository.getByCustomerQuery(search);

        // search parametresini hepsi için yolladık
        List<User> users = userRepository.findAllByFirstLikeOrLastLike(search,search);
        return ResponseEntity.ok(users);
    }

    //init methodunun ilk olarak çalışmasını sağlamak için yaptık
    @PostConstruct
    public void  init()
    {
        List<User> users = new ArrayList<>();
        //yeni bir kullanıcı oluşturduk
        User user = new User();
        user.setFirst("Mustafa Fırat");
        user.setLast("YILMAZ");
        user.setAddress("Address test 1");
        user.setBirthDay(Calendar.getInstance().getTime());
        //elasticsearch kullanırsak id belirtmek zorundayız
        user.setId("U0001");
        users.add(user);


        user = new User();
        user.setFirst("Emre");
        user.setLast("YILMAZ");
        user.setAddress("Address test 2");
        user.setBirthDay(Calendar.getInstance().getTime());
        user.setId("U0002");
        users.add(user);



        //repomuza kaydetmsini söyledik
        userRepository.saveAll(users);

    }

}
