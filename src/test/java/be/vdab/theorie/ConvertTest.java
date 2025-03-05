package be.vdab.theorie;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
public class ConvertTest {
    @Test
    void eenInchs2Komma54Centimeters() {
        assertThat(new Convert().inchesNaarCentimeters((BigDecimal.ONE))).isEqualByComparingTo("2.54");
    }
    @Test
    void tweehonderdInchesIs508Centimeters() {
        assertThat(new Convert().inchesNaarCentimeters(BigDecimal.valueOf(200))).isEqualByComparingTo("508");
    }
}
