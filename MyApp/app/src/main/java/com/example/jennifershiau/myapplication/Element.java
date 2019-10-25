package com.example.jennifershiau.myapplication;

public class Element implements Comparable<Element> {
    public int index, value;
    public Element(int index, int value){
        this.index = index;
        this.value = value;
    }
    public int compareTo(Element e) {
        return this.value - e.value;
    }
}
