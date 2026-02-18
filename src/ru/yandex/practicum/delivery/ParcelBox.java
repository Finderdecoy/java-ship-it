package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    ArrayList<T> parcelBox = new ArrayList<>();
    private double weightBox = 0;
    private double maxWeight;

    public ParcelBox(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addParcel(T parcel) {
        if (weightBox + parcel.weight <= maxWeight) {
            weightBox += parcel.weight;
            parcelBox.add(parcel);
        } else {
            System.out.println("Коробка переполнена , посылка :\n" + "<<" + parcel + ">>" + "\n не была упакована в коробку");
        }
    }

    public ArrayList<T> getParcel() {
        return parcelBox;
    }

}
