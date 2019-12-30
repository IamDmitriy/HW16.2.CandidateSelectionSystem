package com.company;

public class Candidate {
    private String name; //уникальное значение
    private String sex;
    private int age;
    private Integer relevance; //где 0 — низкое значение соответствия, а 5 — очень высокое значение соответствия
    private Integer rating; //0-5, где 0 — низкое значение оценки, а 5 — очень высокое значение оценки

    public Candidate(String name, String sex, int age, Integer relevance, Integer rating) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.relevance = relevance;
        this.rating = rating;
    }

    @Override
    public String toString() {
        String tableFormat = "%-10s%-10s%-10s";
        return String.format(tableFormat, name, relevance, rating);
    }
}
