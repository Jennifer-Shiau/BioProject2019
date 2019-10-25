package com.example.jennifershiau.myapplication;

public class Food {
    private int cal;
    private int pre;
    private int other;
    private int nut;
    private String name;
    private int price;
    public Food() {
        pre = 0;
    }
    /*
    public Food(int cal, int nut, String name) {
        this.cal = cal;
        pre = 0;
        other = 0;
        this.nut = nut;
        this.name = name;
    }
    */
    public void setCal(int c) { cal = c;	}
    public void setPre(int p) { pre = p;	}
    public void setOther(int o) { other = o;	}
    public void setNut(int n) { nut = n;	}
    public void setName(String n) { name = n; }
    public void setPrice(int p) { price = p; }
    public int getCal() { return cal; }
    public int getValue() { return (pre + other + nut); }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public void printInfo() {
        System.out.println(name + ", " + cal + ", " + pre + ", " + other + ", " + nut);
    }
}
