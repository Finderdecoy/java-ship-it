package ru.yandex.practicum.delivery;

public abstract class Parcel {
    protected String description;
    protected double weight;
    protected String deliveryAddress;
    protected int sendDay;
    protected double baseCost;

    public Parcel(String description, double weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public <T> void packageItem(T parcel) {
        System.out.println("Посылка <<" + parcel + ">> упакована");
    }

    public <T> void deliver(T parcel) {
        System.out.println("Доставлена <<" + parcel + ">> по адресу: <<" + deliveryAddress + ">>");
    }

    public double calculateDeliveryCost() {
        return weight * baseCost();
    }

    public double baseCost() {
        return baseCost;
    }

    @Override
    public String toString() {
        return description +
                ", вес: " + weight +
                ", адрес доставки: " + deliveryAddress + '\'' +
                ", дата отправления: " + sendDay;
    }
}
