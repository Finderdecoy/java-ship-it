package ru.yandex.practicum.delivery;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatedCostTest {
    private static StandardParcel standardParcel;
    private static FragileParcel fragileParcel;
    private static PerishableParcel perishableParcel;
    private static StandardParcel parcel0Kg;
    @BeforeAll
    static void beforeAll() {
        standardParcel = new StandardParcel("Посылка1", 20, "Адрес1", 1);
        fragileParcel = new FragileParcel("Посылка2", 20, "Адрес3", 3);
        perishableParcel = new PerishableParcel("Посылка3", 20, "Адрес5", 5, 2);
        parcel0Kg = new StandardParcel("Посылка4", 0, "Адрес1", 1);
    }

    @Test
    public void shouldBe40DeliveryCostForStandartParcelWhenWeigh20Kg() {
        assertEquals(40, standardParcel.calculateDeliveryCost(), 0);
    }

    @Test
    public void shouldBe80DeliveryCostForFragileParcelWhenWeigh20Kg() {
        assertEquals(80, fragileParcel.calculateDeliveryCost(), 0);
    }

    @Test
    public void shouldBe60DeliveryCostForPerishableParcelWhenWeigh20Kg() {
        assertEquals(60, perishableParcel.calculateDeliveryCost(), 0);
    }

    @Test
    public void shouldBe0DeliveryCostForPerishableParcelWhenWeigh0Kg() {
        assertEquals(0, parcel0Kg.calculateDeliveryCost(), 0);
    }

}
