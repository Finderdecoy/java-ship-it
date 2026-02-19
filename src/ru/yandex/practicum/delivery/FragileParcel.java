package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable { //хрупкая
    private static final double BASE_COST = 4;

    public FragileParcel(String description, double weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public double baseCost() {
        return BASE_COST;
    }

    @Override
    public <T> void packageItem(T parcel) {
        System.out.println("Посылка " + parcel + " обёрнута в защитную плёнку");
        super.packageItem(parcel);
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка <<" + this + ">> изменила местоположение на " + newLocation);
    }

    @Override
    public String toString() {
        return "Хрупкая " + description +
                ", вес: " + weight +
                ", адрес доставки: " + deliveryAddress +
                ", дата отправления: " + sendDay;
    }
}

