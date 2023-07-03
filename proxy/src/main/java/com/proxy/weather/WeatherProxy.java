package com.proxy.weather;

public class WeatherProxy implements Forecast {

    private Forecast forecast;

    @Override
    public String getWeather() throws InterruptedException {
        if (forecast == null) {
            forecast = new WeatherForecast();
        }
        return forecast.getWeather();
    }

    @Override
    public void refreshData() throws InterruptedException {
        if (forecast == null) {
            forecast = new WeatherForecast();
        }
        forecast.refreshData();
    }
}