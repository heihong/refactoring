package fr.soat.cleancoders.examples;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ReplaceParameterWithMethodTest {

    @Test
    public void should_return_the_price_when_the_quantity_is_above_100() {
        ReplaceParameterWithMethod example = new ReplaceParameterWithMethod(200, 10);
        double finalPrice = example.getPrice();

        Assertions.assertThat(finalPrice).isEqualTo(200d);
    }

    @Test
    public void should_return_the_price_when_the_quantity_is_below_100() {
        ReplaceParameterWithMethod example = new ReplaceParameterWithMethod(50, 10);
        double finalPrice = example.getPrice();

        Assertions.assertThat(finalPrice).isEqualTo(25d);
    }
}