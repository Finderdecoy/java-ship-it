package ru.yandex.practicum.delivery;
public class PerishableParcel extends Parcel { //скоропортящаяся
    private int timeToLive;
    private double overPrice = 1;

    public boolean isExpired(int currentDay) {
        if (sendDay + timeToLive >= currentDay) {
            return false;
        }
        return true;
    }

    public PerishableParcel(String description, double weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    double baseCost() {
        return BASE_COST + overPrice;
    }

    @Override
    public String toString() {
        return "Скоропортящаяся " + description +
                ", вес: " + weight +
                ", адрес доставки: " + deliveryAddress + '\'' +
                ", дата отправления: " + sendDay + ", срок годности: " + timeToLive;
    }
}
