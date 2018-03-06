package fr.soat.cleancoders.examples;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

public class IntroduceParameterObjectTest {

    @Test
    public void should_return_the_sum_of_charges_over_a_period() {
        LocalDate sevenDaysAgo = LocalDate.now().minusDays(7);
        LocalDate yesterday = LocalDate.now().minusDays(1);

        IntroduceParameterObject.Entry firstEntry = new IntroduceParameterObject.Entry(5.0, sevenDaysAgo);
        IntroduceParameterObject.Entry secondEntry = new IntroduceParameterObject.Entry(8.0, sevenDaysAgo);

        IntroduceParameterObject ipo = new IntroduceParameterObject(Arrays.asList(firstEntry, secondEntry));
        IntroduceParameterObject.DateRange range = new IntroduceParameterObject.DateRange(sevenDaysAgo, yesterday);

        double result = ipo.getFlowBetween(sevenDaysAgo, yesterday, range);

        Assertions.assertThat(result).isEqualTo(13d);
    }

    @Test
    public void should_exclude_all_the_charges_out_of_request_the_period() {
        LocalDate sevenDaysAgo = LocalDate.now().minusDays(7);
        LocalDate yesterday = LocalDate.now().minusDays(1);

        IntroduceParameterObject.Entry firstEntry = new IntroduceParameterObject.Entry(5.0, sevenDaysAgo);
        IntroduceParameterObject.Entry secondEntry = new IntroduceParameterObject.Entry(8.0, yesterday);

        IntroduceParameterObject ipo = new IntroduceParameterObject(Arrays.asList(firstEntry, secondEntry));

        LocalDate inSevenDays = LocalDate.now().plusDays(7);
        IntroduceParameterObject.DateRange range = new IntroduceParameterObject.DateRange(yesterday, inSevenDays);
        double result = ipo.getFlowBetween(yesterday, inSevenDays, range);

        Assertions.assertThat(result).isEqualTo(8d);
    }

    @Test
    public void should_include_an_entry_when_its_charge_date_is_after_the_start_date() {
        LocalDate sevenDaysLater = LocalDate.now().plusDays(7);
        LocalDate yesterday = LocalDate.now().minusDays(1);

        IntroduceParameterObject.Entry firstEntry = new IntroduceParameterObject.Entry(5.0, sevenDaysLater);
        IntroduceParameterObject.Entry secondEntry = new IntroduceParameterObject.Entry(8.0, sevenDaysLater);

        IntroduceParameterObject ipo = new IntroduceParameterObject(Arrays.asList(firstEntry, secondEntry));
        IntroduceParameterObject.DateRange range = new IntroduceParameterObject.DateRange(yesterday, sevenDaysLater);
        double result = ipo.getFlowBetween(yesterday, sevenDaysLater,range);

        Assertions.assertThat(result).isEqualTo(13d);
    }
}