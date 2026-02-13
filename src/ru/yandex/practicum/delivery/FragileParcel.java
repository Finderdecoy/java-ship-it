package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable { //хрупкая
    private double overPrice = 2;

    public FragileParcel(String description, double weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка <<" + this + ">> изменила местоположение на " + newLocation);
    }

    @Override
    double baseCost() {
        return BASE_COST + overPrice;
    }

    @Override
    public <T> void packageItem(T parcel) {
        System.out.println("Посылка " + parcel + " обёрнута в защитную плёнку");

    }

    @Override
    public String toString() {
        return "Хрупкая " + description +
                ", вес: " + weight +
                ", адрес доставки: " + deliveryAddress +
                ", дата отправления: " + sendDay;
    }
}

