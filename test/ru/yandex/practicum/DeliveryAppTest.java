package ru.yandex.practicum.delivery;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryAppTest {
    private static StandardParcel standardParcel;
    private static FragileParcel fragileParcel;
    private static PerishableParcel perishableParcel;
    private static ParcelBox<StandardParcel> standartBox;

    @BeforeAll
    static void beforeAll() {
        standardParcel = new StandardParcel("Посылка1", 20, "Адрес1", 1);
        fragileParcel = new FragileParcel("Посылка2", 20, "Адрес3", 3);
        perishableParcel = new PerishableParcel("Посылка3", 20, "Адрес5", 5, 2);
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
    public void shouldReturnFalseWhenParcelIsExpired() {
        assertFalse(perishableParcel.isExpired(7));
    }

    @Test
    public void shouldReturnTrueWhenParcelIsNOTExpired() {
        assertTrue(perishableParcel.isExpired(8));
    }

    @Test
    public void shouldBeNullIfBoxWeightMoreExpected() {
        standartBox = new ParcelBox<>(19);
        standartBox.addParcel(standardParcel);
        assertNull(standartBox.getParcel());
    }

    @Test
    public void shouldBeNotNullIfBoxWeightMoreExpected() {
        standartBox = new ParcelBox<>(20);
        standartBox.addParcel(standardParcel);
        assertEquals(standardParcel,standartBox.getParcel());
    }


}
