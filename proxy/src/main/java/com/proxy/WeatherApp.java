package com.proxy;

import com.proxy.weather.Forecast;
import com.proxy.weather.WeatherForecast;
import com.proxy.weather.WeatherProxy;

import java.util.Random;

public class WeatherApp {

    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();

        Forecast weatherForecast = new WeatherProxy();

        for (int n = 0; n < 5; n++) {
            int number = new Random().nextInt(100);
            if (number < 20) {
                weatherForecast.refreshData();
                System.out.println("Weather data refreshed.");
            }
            System.out.println("Current weather: " + weatherForecast.getWeather());
            System.out.println("Execution #" + n + " just finished");
        }

        long end = System.currentTimeMillis();
        System.out.println("The execution took: " + (end - begin) + " [ms]");
    }
}
