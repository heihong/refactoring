package fr.soat.cleancoders.exo2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Properties;

public class TimePropertiesTest {

    @Test
    public void should_raise_an_exception_when_the_interval_is_missing() throws Exception {
        TimeProperties timeProperties = new TimeProperties();
        Properties propsWithoutInterval = new Properties();

        Assertions.assertThatThrownBy(() -> timeProperties.getTimes(propsWithoutInterval))
                .as("Missing property")
                .isInstanceOf(MissingTimePropertiesException.class)
                .hasFieldOrPropertyWithValue("message", "monitor interval");
    }

    @Test
    public void should_raise_an_exception_when_the_interval_value_is_below_or_equal_to_0() throws Exception {
        TimeProperties timeProperties = new TimeProperties();
        Properties propsWithoutInterval = new Properties();
        propsWithoutInterval.setProperty("interval", "0");

        Assertions.assertThatThrownBy(() -> timeProperties.getTimes(propsWithoutInterval))
                .as("Missing property")
                .isInstanceOf(MissingTimePropertiesException.class)
                .hasFieldOrPropertyWithValue("message", "monitor interval > 0");

        propsWithoutInterval.setProperty("interval", "-8");

        Assertions.assertThatThrownBy(() -> timeProperties.getTimes(propsWithoutInterval))
                .as("Missing property")
                .isInstanceOf(MissingTimePropertiesException.class)
                .hasFieldOrPropertyWithValue("message", "monitor interval > 0");

    }

    @Test
    public void should_raise_an_exception_when_the_duration_is_missing() throws Exception {
        Properties propsWithoutDuration = new Properties();
        propsWithoutDuration.setProperty("interval", "5");


        TimeProperties timeProperties = new TimeProperties();
        Assertions.assertThatThrownBy(() -> timeProperties.getTimes(propsWithoutDuration))
                .as("Missing property")
                .isInstanceOf(MissingTimePropertiesException.class)
                .hasFieldOrPropertyWithValue("message", "duration");
    }

    @Test
    public void should_raise_an_exception_when_the_duration_value_is_below_or_equal_to_0() throws Exception {
        TimeProperties timeProperties = new TimeProperties();
        Properties propsWithoutInterval = new Properties();

        propsWithoutInterval.setProperty("duration", "0");
        propsWithoutInterval.setProperty("interval", "5");

        Assertions.assertThatThrownBy(() -> timeProperties.getTimes(propsWithoutInterval))
                .as("Missing property")
                .isInstanceOf(MissingTimePropertiesException.class)
                .hasFieldOrPropertyWithValue("message", "duration > 0");

        propsWithoutInterval.setProperty("duration", "-8");

        Assertions.assertThatThrownBy(() -> timeProperties.getTimes(propsWithoutInterval))
                .as("Missing property")
                .isInstanceOf(MissingTimePropertiesException.class)
                .hasFieldOrPropertyWithValue("message", "duration > 0");

    }

    @Test
    public void should_raise_an_exception_when_the_duration_by_interval_is_not_equals_0() throws Exception {
        TimeProperties timeProperties = new TimeProperties();
        Properties propsWithoutInterval = new Properties();

        propsWithoutInterval.setProperty("duration", "2");
        propsWithoutInterval.setProperty("interval", "5");

        Assertions.assertThatThrownBy(() -> timeProperties.getTimes(propsWithoutInterval))
                .as("Missing property")
                .isInstanceOf(MissingTimePropertiesException.class)
                .hasFieldOrPropertyWithValue("message", "duration % checkInterval");
    }

    @Test
    public void should_raise_an_exception_when_the_departure_offset_is_missing() throws Exception {
        TimeProperties timeProperties = new TimeProperties();
        Properties propsWithoutInterval = new Properties();

        propsWithoutInterval.setProperty("duration", "5");
        propsWithoutInterval.setProperty("interval", "5");

        Assertions.assertThatThrownBy(() -> timeProperties.getTimes(propsWithoutInterval))
                .as("Missing property")
                .isInstanceOf(MissingTimePropertiesException.class)
                .hasFieldOrPropertyWithValue("message", "departure offset");
    }

    @Test
    public void should_raise_an_exception_when_the_departure_offset_value_equals_or_is_below_0() throws Exception {
        TimeProperties timeProperties = new TimeProperties();
        Properties properties = new Properties();

        properties.setProperty("duration", "5");
        properties.setProperty("interval", "5");
        properties.setProperty("departure", "0");

        Assertions.assertThatThrownBy(() -> timeProperties.getTimes(properties))
                .as("Missing property")
                .isInstanceOf(MissingTimePropertiesException.class)
                .hasFieldOrPropertyWithValue("message", "departure > 0");
    }

    @Test
    public void should_raise_an_exception_when_the_departure_by_interval_is_not_equals_0() throws Exception {
        TimeProperties timeProperties = new TimeProperties();
        Properties properties = new Properties();

        properties.setProperty("duration", "5");
        properties.setProperty("interval", "5");
        properties.setProperty("departure", "1");

        Assertions.assertThatThrownBy(() -> timeProperties.getTimes(properties))
                .as("Missing property")
                .isInstanceOf(MissingTimePropertiesException.class)
                .hasFieldOrPropertyWithValue("message", "departure % checkInterval");
    }

    @Test
    public void should_the_departure_offset_and_the_monitor_time_when_all_the_properties_have_the_same_positive_value() throws Exception {
        TimeProperties timeProperties = new TimeProperties();
        Properties properties = initializeProperties();

        TimeProperties timeProp = timeProperties.getTimes(properties);

        Assertions.assertThat(timeProp)
                .extracting("departureOffset", "monitorTime")
                .contains(5, 5);

    }

    private Properties initializeProperties() {
        Properties properties = new Properties();

        properties.setProperty("duration", "5");
        properties.setProperty("interval", "5");
        properties.setProperty("departure", "5");
        return properties;
    }


}