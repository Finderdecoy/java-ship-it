package ru.yandex.practicum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParcelExpiredTest {
    private static PerishableParcel perishableParcel;

    @BeforeEach
    public void beforeEach() {
        perishableParcel = new PerishableParcel("Посылка3", 20, "Адрес5", 5, 2);
    }

    @Test
    public void shouldReturnFalseWhenParcelIsExpiredIsCurrentDay6() {
        assertFalse(perishableParcel.isExpired(6));
    }

    @Test
    public void shouldReturnFalseWhenParcelIsExpiredIsCurrentDay7() {
        assertFalse(perishableParcel.isExpired(7));
    }

    @Test
    public void shouldReturnTrueWhenParcelIsNOTExpiredIsCurrentDay8() {
        assertTrue(perishableParcel.isExpired(8));
    }

}
