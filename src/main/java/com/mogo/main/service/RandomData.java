package com.mogo.main.service;

import com.mogo.main.model.Personal;

import java.util.ArrayList;
import java.util.List;

public class RandomData {

    public List<Personal> getRandomData(){

        List<Personal> personalList = new ArrayList<Personal>();
        personalList.add(new Personal("1gg", "abccd", "张三"));
        personalList.add(new Personal("1213", "bcacd", "李四"));
        personalList.add(new Personal("312sfsd1", "abcce", "王二"));
        personalList.add(new Personal("1sada", "edacb", "麻子"));
        personalList.add(new Personal("d121a", "eddcb", "王三"));
        personalList.add(new Personal("a31da", "adacb", "李五"));
        personalList.add(new Personal("1ss21a", "eaacb", "张六"));
        personalList.add(new Personal("1s31da", "edacb", "马云"));
        personalList.add(new Personal("131da", "adacb", "马化腾"));
        personalList.add(new Personal("1s3131da", "edecb", "李彦宏"));
        personalList.add(new Personal("131d31a", "cbeea", "雷军"));
        return personalList;
    }

}
