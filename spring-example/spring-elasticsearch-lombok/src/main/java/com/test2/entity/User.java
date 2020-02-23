package com.test2.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

//bunun bir saklanabilir bir dökümantasyon class ı olduğunu söylüyoruz
@Document(indexName = "users",type = "user")

//!!!!<<<----------Lombok kullanmak için PLugin yüklenmelidir ----->>!!!!
//Lombok kullanarak classın üstüne yazdığımızda
// @Getter classın içinde tüm field lar için getter oluştur
//@Setter classın içinde tüm field lar için setter oluştur
//Lombok kodu refactoring  yapıp okunabilir hale getiriyor
@Getter
@Setter

//hiç parametre vermeden constructor yaratılmasını istersek eklenir
@NoArgsConstructor

//tüm field lar ile constructor yaratılmasını istiyorsak
@AllArgsConstructor
/**
* ToString methodu yaratılır
* @ToString(exclude = "name")
* equals ve hashcode methodları için
* @EqualsAndHashCode
*/
public class User {
    @Id
    private String id;
    // !!! @Getter buraya eklersek altında bulunan sadece name için
    // getter oluşturur !!!

    //field lar için ön açıklama nasıl store edileceğini söylüyoruz
    @Field(name = "first", type = FieldType.Text)
    private String first;
    @Field(name = "last", type = FieldType.Text)
    private  String last;
    @Field(name = "address", type = FieldType.Text)
    private String address;
    @Field(name = "birth_day", type = FieldType.Date)
    private Date birthDay;
}
