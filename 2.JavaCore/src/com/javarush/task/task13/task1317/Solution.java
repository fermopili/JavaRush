package com.javarush.task.task13.task1317;

/* 
Погода
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Today(WeatherType.CLOUDY));
        System.out.println(new Today(WeatherType.FOGGY));
        System.out.println(new Today(WeatherType.FROZEN));
    }

    static class Today implements  Weather{
        private String type;

        Today(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return String.format("%s for today", this.getWeatherType());
        }

        public    String   getWeatherType(){return this.type;}
    }
}
