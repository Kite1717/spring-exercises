package com.test2.repository;

import com.test2.entity.User;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//elasticsearch geleneksel olan repository dönüştürdük
// extend ettik yani

//bunu demesekte çalışır bir geleneksel repositroy interface extend ettiğimiz için
@Repository
public interface UserRepository extends ElasticsearchCrudRepository<User,String> {

    //https://www.baeldung.com/spring-data-elasticsearch-tutorial for query example
    //query ile database mize elasticsearch anlayacağı dilde query ürettik
    //buna uygun bir sorgu yaratıp elemanları listelememizi sağlıcaktır
    // buradaki query ile isme yani last param bağlı bir sorgu yarattık
    @Query("{\"bool\": {\"must\": [{\"match\": {\"first\": \"?0\"}}]}}")
    List<User> getByCustomerQuery(String search);

    //spring query mizi oluşturduk o formatta yazdık
    // yada yukarıdaki gibi custom query oluşturabiliriz
    // ad veya  soyad  ile arama yaptırıyoruz
    //http://localhost:8080/user/YILMAZ dersek iki user da geliyor
    // yada http://localhost:8080/user/Y
    List<User> findAllByFirstLikeOrLastLike(String first ,String last);
}
