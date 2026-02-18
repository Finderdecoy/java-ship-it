package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {

    public StandardParcel(String description, double weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
        this.baseCost = 2;
    }

    @Override
    public String toString() {
        return "Стандарная " + description +
                ", вес: " + weight +
                ", адрес доставки: " + deliveryAddress + '\'' +
                ", дата отправления: " + sendDay;
    }
}
