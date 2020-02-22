package com.test2.repository;

//repository package ilgili classlarrın entitysi aracılığı ile
// veri tabanına bağlanıp veri tabanı işlemlerini yapacaktır

import com.test2.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

//interface olarak yazılmalı yoksa spring mongoDB den extend edemeyiz
//ve içeriği manuel doldurmak gerekir

//yani hazır bir repository class yapısını extend ettik
//  MongoRepository<User,String> User collection tipi String unique key(id)

//String olmasının sebebi mongoDB de id lerin default u stringtir
// değiştirilebilir

//@Repository önceden belirtilmesi gerekiyordu
// fakat biz bir interfacemizi Repository interface den extend
// ediyorsak gerek kalmadığını söylüyor
// spring 2.0 dan sonraki sürümlerde
public interface UserRepository extends MongoRepository<User,String> {

}
