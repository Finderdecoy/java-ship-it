package ru.yandex.practicum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandardParcel;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParcelBoxTest {
    private StandardParcel parcel1;
    private StandardParcel parcel2;
    private StandardParcel parcel3;
    private ParcelBox<StandardParcel> standartBox;
    private ArrayList<StandardParcel> testParcel;

    @BeforeEach
    public void beforeEach() {
        parcel1 = new StandardParcel("Посылка1", 20, "Адрес1", 1);
        parcel2 = new StandardParcel("Посылка2", 19, "Адрес1", 1);
        parcel3 = new StandardParcel("Посылка3", 21, "Адрес1", 1);
        standartBox = new ParcelBox<>(20);
        testParcel = new ArrayList<>();
    }

    @Test
    public void shouldReturnEmptyList() {
        standartBox.addParcel(parcel3);
        assertEquals(testParcel,standartBox.getParcel());
    }

    @Test
    public void shouldReturnListWithParcel1() {
        standartBox.addParcel(parcel1);
        testParcel.add(parcel1);
        assertEquals(testParcel, standartBox.getParcel());
    }

    @Test
    public void shouldReturnListWithParcel2(){
        standartBox.addParcel(parcel2);
        testParcel.add(parcel2);
        assertEquals(testParcel, standartBox.getParcel());
    }

}
