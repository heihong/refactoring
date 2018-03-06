package fr.soat.cleancoders.examples;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PreserveWholeObjectTest {

    @Test
    public void should_return_true_when_the_tempareture_is_within_plan() {
        PreserveWholeObject.TempRange roomRange = new PreserveWholeObject.TempRange(-5, 5);
        PreserveWholeObject.Room room = new PreserveWholeObject.Room(roomRange);
        PreserveWholeObject.TempRange heatingRange = new PreserveWholeObject.TempRange(-5, 8);

        PreserveWholeObject.HeatingPlan plan = new PreserveWholeObject.HeatingPlan(heatingRange);

        boolean isWithinPlan = room.withinPlan(plan);

        Assertions.assertThat(isWithinPlan).isTrue();
    }

    @Test
    public void should_return_true_when_the_temperature_is_not_within_plan() {

        PreserveWholeObject.TempRange tmpRange = new PreserveWholeObject.TempRange(-5, 5);
        PreserveWholeObject.Room room = new PreserveWholeObject.Room(tmpRange);

        PreserveWholeObject.TempRange heatingRange = new PreserveWholeObject.TempRange(5, 12);

        PreserveWholeObject.HeatingPlan plan = new PreserveWholeObject.HeatingPlan(heatingRange);
        boolean isWithinPlan = room.withinPlan(plan);

        Assertions.assertThat(isWithinPlan).isFalse();


    }
}