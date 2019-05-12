package com.example.stadium;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class Sports extends DataSupport {

    private int id;
    private  String sports_name;
    private int sports_num;
    private int sports_price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return sports_name;
    }

    public void setName(String name) {
        this.sports_name = name;
    }

    public int getNum() {
        return sports_num;
    }

    public void setNum(int num) {
        this.sports_num = num;
    }

    public int getPrice() {
        return sports_price;
    }

    public void setPrice(int price) {
        this.sports_price = price;
    }

}
