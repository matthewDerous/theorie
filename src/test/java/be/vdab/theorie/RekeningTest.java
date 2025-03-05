package be.vdab.theorie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

class RekeningTest {
    private Rekening rekening;
    private static final BigDecimal TWEE = BigDecimal.valueOf(2);
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

    @Test
    void hetGestortBedragMagNietNulZijn() {
        assertThatIllegalArgumentException().isThrownBy(() -> rekening.stort(BigDecimal.ZERO));
    }
    @Test
    void hetGestortBedragMagNietNegatiefZijn() {
        assertThatIllegalArgumentException().isThrownBy(() -> rekening.stort(BigDecimal.valueOf(-1)));
    }

    @Test
    void stortMetNullKanNiet() {
        assertThatNullPointerException().isThrownBy(() -> rekening.stort(null));
    }

    @Test void eenNieuweRekeningHeeftGeenStortingen() {
        assertThat(rekening.getStortingen()).isEmpty();
    }

    @Test void nadatJe10€StortIsErEenStortingVan10€() {
        rekening.stort(BigDecimal.TEN);
        assertThat(rekening.getStortingen()).containsOnly(BigDecimal.TEN);
    }
    @Test void nadatJe10€En1€StortZijnDeStortingen10€En1€() {
        rekening.stort(BigDecimal.TEN);
        rekening.stort(BigDecimal.ONE);
        assertThat(rekening.getStortingen()).containsExactly(BigDecimal.TEN, BigDecimal.ONE);
    }
    @Test @DisplayName("nadat je 10€ en 1€ en 2€ stort zijn de stortingen gesorteerd 1,2 en 10€")
    void nadatJe10€En1€En2€StortZijnDeStortingenGesorteerd1€En2€En10€() {

        rekening.stort(BigDecimal.TEN);
        rekening.stort(BigDecimal.ONE);
        rekening.stort(TWEE);
        assertThat(rekening.getStortingenGesorteerd()).isSorted().containsExactly(BigDecimal.ONE, TWEE, BigDecimal.TEN);
    }

}