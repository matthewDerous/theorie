package be.vdab.theorie;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class JaarTest {
    @Test
    void eenJaarDeelbaarDoor400IsEeenSchrikkeljaar() {
        var jaar = new Jaar(2000);
        assertThat(jaar.isSchrikkeljaar()).isTrue();
    }

    @Test
    void eenJaarDeelbaarDoor100IsGeenSchrikkeljaar() {

        assertThat(new Jaar(1900).isSchrikkeljaar()).isFalse();
    }

    @Test
    void eenJaarDeelbaarDoor4IsEeenSchrikkeljaar() {
        assertThat(new Jaar(2012).isSchrikkeljaar()).isTrue();
    }

    @Test
    void eenJaarNietDeelbaarDoor4IsGeenSchrikkeljaar() {

        assertThat(new Jaar(2015).isSchrikkeljaar()).isFalse();
    }

    @Test
    void toStringGeeftHetJaarAlsTekst() {
        assertThat(new Jaar(2015)).hasToString("2015");
    }
}
