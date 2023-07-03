package com.proxy.weather;


import java.util.Random;

public class WeatherForecast implements Forecast {

    private String weatherData;

    public WeatherForecast() throws InterruptedException {
        refreshData();
    }

    public String getWeather() {
        return weatherData;
    }

    public void refreshData() throws InterruptedException {
        Thread.sleep(5000);
        Random random = new Random();
        int randomNumber = random.nextInt(3);

        switch (randomNumber) {
            case 0:
                weatherData = "Sunny";
                break;
            case 1:
                weatherData = "Cloudy";
                break;
            case 2:
                weatherData = "Rainy";
                break;
        }
    }
}
