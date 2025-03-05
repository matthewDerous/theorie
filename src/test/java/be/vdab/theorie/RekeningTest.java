package be.vdab.theorie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RekeningTest {
    private Rekening rekening;
    @BeforeEach
    void beforeEach() {
        rekening = new Rekening();
    }
    @Test
    void hetSaldoVanEenNieuweREkeningIs0Euro() {
        assertThat(rekening.getSaldo()).isZero();
    }

    @Test
    void nadatJe10EuroStrortIsSaldo10() {
        rekening.stort(BigDecimal.TEN);
        assertThat(rekening.getSaldo()).isEqualByComparingTo("10");
    }

    @Test
    void nadatJe10EuroStrortEn1EuroIsSaldo11() {
        rekening.stort(BigDecimal.TEN);
        rekening.stort(BigDecimal.ONE);
        assertThat(rekening.getSaldo()).isEqualByComparingTo("11");
    }

}