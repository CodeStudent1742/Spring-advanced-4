package com.proxy.weather;

public interface Forecast {
    public String getWeather() throws InterruptedException;
    public void refreshData() throws InterruptedException;
}
