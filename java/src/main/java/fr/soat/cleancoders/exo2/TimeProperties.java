package fr.soat.cleancoders.exo2;

import java.util.Properties;

public class TimeProperties {

    private int monitorTime;
    private int departureOffset;

    public void getTimes(Properties props) throws Exception { // FIXME: 02/03/2018 Add test suite
        String valueString;
        int value;

        valueString = props.getProperty("interval");
        if (valueString == null)
            throw new MissingTimePropertiesException("monitor interval");

        value = Integer.parseInt(valueString);
        if (value <= 0)
            throw new MissingTimePropertiesException("monitor interval > 0");

        int checkInterval = value;

        valueString = props.getProperty("duration");
        if (valueString == null)
            throw new MissingTimePropertiesException("duration");

        value = Integer.parseInt(valueString);
        if (value <= 0)
            throw new MissingTimePropertiesException("duration > 0");

        if ((value % checkInterval) != 0)
            throw new MissingTimePropertiesException("duration % checkInterval");

        monitorTime = value;


        valueString = props.getProperty("departure");
        if (valueString == null)
            throw new MissingTimePropertiesException("departure offset");

        if (value <= 0)
            throw new MissingTimePropertiesException("departure > 0");


        if ((value % checkInterval) != 0)
            throw new MissingTimePropertiesException("departure % checkInterval");

        departureOffset = value;
    }
}
