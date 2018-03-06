package fr.soat.cleancoders.examples;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;

public class DecomposeConditionalTest {

    @Test
    public void should_calculate_rate_charges_based_on_date() {
        DecomposeConditional.YurtStay stay = new DecomposeConditional.YurtStay(5,20,15);
        LocalDate nextMonth = LocalDate.now().plusMonths(1);
        double charge = stay.calculateCharge(nextMonth, 5);

        Assertions.assertThat(charge).isEqualTo(45);
    }


    @Test
    public void should_charge_more_when_the_stay_is_during_the_summer() {
        DecomposeConditional.YurtStay stay = new DecomposeConditional.YurtStay(5,20,15);
        LocalDate inHeightMonths = LocalDate.now().plusMonths(8);

        double charge = stay.calculateCharge(inHeightMonths, 5);

        Assertions.assertThat(charge).isEqualTo(75.0);
    }
}