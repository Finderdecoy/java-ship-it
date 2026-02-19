package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel { //скоропортящаяся
    private int timeToLive;
    private static final double BASE_COST = 3;

    public PerishableParcel(String description, double weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public double baseCost() {
        return BASE_COST;
    }

    public boolean isExpired(int currentDay) {
        return sendDay + timeToLive < currentDay;
    }

    @Override
    public String toString() {
        return "Скоропортящаяся " + description +
                ", вес: " + weight +
                ", адрес доставки: " + deliveryAddress + '\'' +
                ", дата отправления: " + sendDay + ", срок годности: " + timeToLive;
    }
}
