package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {
    private static final double BASE_COST = 2;

    public StandardParcel(String description, double weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public double baseCost() {
        return BASE_COST;
    }

    @Override
    public String toString() {
        return "Стандарная " + description +
                ", вес: " + weight +
                ", адрес доставки: " + deliveryAddress + '\'' +
                ", дата отправления: " + sendDay;
    }
}
