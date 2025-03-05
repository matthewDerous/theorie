package be.vdab.theorie;
import java.math.BigDecimal;
public class Convert {
    private static final BigDecimal AAnTAL_CENTIMETER_IN_EEN_INCH = BigDecimal.valueOf(2.54);
    BigDecimal inchesNaarCentimeters(BigDecimal inches) {
        return inches.multiply(AAnTAL_CENTIMETER_IN_EEN_INCH);
    }
}
