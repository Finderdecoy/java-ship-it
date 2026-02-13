package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<FragileParcel> fragileParcels = new ArrayList<>();

    public static void main(String[] args) {
        allParcels.add(new StandardParcel("Посылка1", 11, "Адрес1", 1));
        allParcels.add(new StandardParcel("Посылка2", 11, "Адрес2", 2));
        fragileParcels.add(new FragileParcel("Посылка3", 11, "Адрес3", 3));
        fragileParcels.add(new FragileParcel("Посылка4", 11, "Адрес4", 4));
        allParcels.add(new PerishableParcel("Посылка15", 11, "Адрес5", 5, 2));
        allParcels.add(new PerishableParcel("Посылка6", 11, "Адрес6", 6, 4));
        allParcels.add(new StandardParcel("Посылка7", 11, "Адрес7", 7));

        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    packageBox();
                    break;
                case 5:
                    statusDelivery();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 - Упаковать посылки в коробки");
        System.out.println("5 - Статус доставки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Введите тип посылки. 1-Стандарт 2-Хрупкая 3-Скоропортящаяся :");
        int typeParcel = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите описание посылки:");
        String description = scanner.nextLine();
        System.out.println("Введите вес посылки:");
        double weight = Double.parseDouble(scanner.nextLine());
        System.out.println("Введите адрес доставки:");
        String address = scanner.nextLine();
        System.out.println("Введите дату отправления:");
        int sendDay = Integer.parseInt(scanner.nextLine());
        switch (typeParcel) {
            case 1 -> {
                allParcels.add(new StandardParcel(description, weight, address, sendDay));
            }
            case 2 -> {
                fragileParcels.add(new FragileParcel(description, weight, address, sendDay));
            }
            case 3 -> {
                System.out.println("Введите срок годности в днях:");
                int timeToLive = scanner.nextInt();
                allParcels.add(new PerishableParcel(description, weight, address, sendDay, timeToLive));
            }
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem(parcel);
            parcel.deliver(parcel);
        }
        for (FragileParcel fragileParcel : fragileParcels) {
            fragileParcel.packageItem(fragileParcel);
            fragileParcel.deliver(fragileParcel);
        }
    }

    private static void calculateCosts() {
        double sum = 0;
        for (Parcel parcel : allParcels) {
            sum += parcel.calculateDeliveryCost();
        }
        System.out.println("Стоимость всех посылок = " + sum);
    }

    private static void packageBox() {
        System.out.println("Укажите максимальный допустимый вес для коробки:");
        double maxWeight = Double.parseDouble(scanner.nextLine());
        ParcelBox<StandardParcel> standardBox = new ParcelBox<>(maxWeight);
        ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(maxWeight);
        ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(maxWeight);
        for (Parcel parcel : allParcels) {
            if (parcel.getClass().equals(StandardParcel.class)) {
                standardBox.addParcel((StandardParcel) parcel);
            } else if (parcel.getClass().equals(FragileParcel.class)) {
                fragileBox.addParcel((FragileParcel) parcel);
            } else if (parcel.getClass().equals(PerishableParcel.class)) {
                perishableBox.addParcel((PerishableParcel) parcel);
            }
        }
    }

    private static void statusDelivery() {
        for (FragileParcel parcel : fragileParcels) {
            System.out.println("Введите новое местоположение для посылки:<<" + parcel + ">>");
            parcel.reportStatus(scanner.nextLine());
        }

    }
}


