package com.sofka.utils;

public enum Resources {
    BASE_URL("https://api.openweathermap.org/data/2.5/"),
    TOKEN("0f1433d636f7febe1666913d0a55991d"),
    ATTRIBUTE_WEATHER("weather"),
    ATTRIBUTE_NAME("name"),
    GET_CLIMA_CIUDAD("weather?q=%s&appid=%s");

    private final String value;

    Resources(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}


