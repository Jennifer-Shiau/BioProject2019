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
    public int level;

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
    public int[] calList = {110, 110, 130, 110, 130, 130, 110, 130, 150, 200, 180, 140, 310, 360, 310, 450, 370, 350, 300, 180, 260, 160, 220};
    public int[][] othList = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -100, 0, 0, -100, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, -60, -30, 0, 0, 0, -60, -60, 0, -100, -100, 0, -100, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, -30, -100, -100, -30, 0, 0, 0, 0, -30, 0, 0, -30, -60, -30, -60, -60, -60, -60, -100, -30, -100, -100}};
    public int[] nutList = {0, 0, 0, 0, 0, 0, 0, 0, 0, 60, 60, 60, 100, 100, 100, 140, 100, 120, 120, 60, 60, 60, 60};
    public String[] nameList = {"清炒高麗菜", "清炒青江菜", "清炒菠菜", "清炒花椰菜", "薑絲炒海帶結", "紅蘿蔔絲炒蛋", "鹹蛋苦瓜", "魚香茄子", "炒竹筍",
                                "蔥燒豆腐", "番茄炒蛋", "蒸蛋", "豆干炒肉絲", "日式炸豬排", "炒香腸", "滷雞腿", "台式控肉", "蔥爆牛肉", "三杯雞",
                                "鮮炒蛤蜊", "鹽烤秋刀魚", "清蒸雪魚", "煎吳郭魚"};

    public int calorie;
    public List<Integer> result = new ArrayList<Integer>();
    public List<Integer> changeResult = new ArrayList<Integer>();
    Switch[] ss = new Switch[23];

    public int[] pre = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public int[] no = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
}