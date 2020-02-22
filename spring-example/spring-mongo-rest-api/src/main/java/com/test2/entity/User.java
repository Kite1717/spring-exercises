package com.test2.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

//entity package da
// mongoDB yani ilişkisel veri  tabanları içersinde
// bir collection(table) a denk gelecek yani tablonun içersindeki
// verinin modelini tutacak classımızdır


//bu tag ise bu classın bir collection olcağını belirtir
@Document
public class User {

    //basic features
    //bu Collection için id budur
    @Id
    private  String id;
    private String name;
    private String lastName;

    //special features
    // eye color , skils , age etc..
    private HashMap specialFeatures;


    //ulaşılabilir olması için getter setter olmalıdır

    //region getterSetter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public HashMap getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(HashMap specialFeatures) {
        this.specialFeatures = specialFeatures;
    }
    //endregion
}
