package ru.mycompany.phrase.domain.constant;

public class RegExp {

    public final static String nickname = "^[a-zA-Z0-9а-яА-Я. _-]{4,15}$";
    public final static String password = "^[a-zA-Z0-9а-яА-Я.,:; _?!+=/'\\\\\"*(){}\\[\\]\\-]{8,100}$";
    public final static String phrase = "^[a-zA-Z0-9а-яА-Я.,:; _?!+=/'\\\\\"*(){}\\[\\]\\-]{1,140}$";
    public final static String tag = "^[a-zA-Z0-9а-яА-Я.,:; _?!+=/'\\\"*(){}\\[\\]\\-]{3,25}$";
}
