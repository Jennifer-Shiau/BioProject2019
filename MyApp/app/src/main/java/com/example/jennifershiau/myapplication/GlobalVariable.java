package com.example.jennifershiau.myapplication;

import android.app.Application;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class GlobalVariable extends Application {
    private int cal;
    private int cal_t;
    private int oth;
    public int gender;
    public int height;
    public int weight;
    public int age;
    public int mode;

    public void setCal(int cal) {
        this.cal = cal;
    }
    public int getCal() {
        return cal;
    }
    public void setCalt(int cal) {
        this.cal_t = cal;
    }
    public int getCalt() {
        return cal_t;
    }

    public void setOth(int oth) {
        this.oth = oth;
    }

    public int getOth() {
        return oth;
    }

    //Food
    public List<Food> foods = new ArrayList<Food>();
    public int[] calList = {50, 30, 50, 50, 30, 80, 90, 50, 60, 80, 130, 80, 150, 210, 310, 180, 220, 140, 180, 40, 130, 100, 130};
    public int[][] othList = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -100, 0, 0, -100, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, -40, -40, -30, 0, 0, 0, -30, -50, 0, -100, -100, 0, -100, 0, 0, 0, 50, 50, 50},
            {0, 0, 0, 0, 0, 0, -60, 0, 0, 0, -60, -100, 0, -100, -100, 0, -100, 0, 0, 0, 50, 50, 50},
            {0, 0, -100, 0, 80, 0, 0, 0, 0, -30, 30, 0, 0, -60, -60, 0, -60, -60, 0, -100, 0, 0, -100}};
    public int[] nutList = {0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 30, 30, 30, 10, 10, 50, 10, 50, 50, 30, 30, 30, 30};
    public String[] nameList = {"高麗菜", "青江菜", "菠菜", "花椰菜", "海帶", "胡蘿蔔", "鹹蛋苦瓜", "茄子", "竹筍",
            "蔥燒豆腐", "番茄炒蛋", "蒸蛋", "豆干炒肉絲", "炸豬排", "香腸", "滷雞腿", "控肉", "蔥爆牛肉",
            "三杯雞", "炒蛤蜊", "秋刀魚", "清蒸雪魚", "吳郭魚"};
    public int[] priceList = {8, 8, 8, 8, 8, 8, 8, 8, 8, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16};

    public int calorie;
    public int price;
    public List<Integer> result = new ArrayList<Integer>();
    public List<Integer> changeResult = new ArrayList<Integer>();
    Switch[] ss = new Switch[23];

    public int[] pre = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public int[] no = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
}