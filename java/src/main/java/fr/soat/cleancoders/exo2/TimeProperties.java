package fr.soat.cleancoders.exo2;

import java.util.Properties;

public class TimeProperties {

    private int monitorTime;
    private int departureOffset;

    TimeProperties() {
}

    TimeProperties(int departureOffset, int monitorTime) {
        this.departureOffset = departureOffset;
        this.monitorTime = monitorTime;
    }

    TimeProperties getTimes(Properties props) throws Exception {
        String valueString;
        int value;

        value = getProperty(props);
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

        value = Integer.parseInt(valueString);
        if (value <= 0)
            throw new MissingTimePropertiesException("departure > 0");


        if ((value % checkInterval) != 0)
            throw new MissingTimePropertiesException("departure % checkInterval");

        departureOffset = value;
        return new TimeProperties(departureOffset, monitorTime );
    }

    private int getProperty(Properties props) throws MissingTimePropertiesException {
        String valueString;
        int value;
        valueString = props.getProperty("interval");
        if (valueString == null)
            throw new MissingTimePropertiesException("monitor interval");

        value = Integer.parseInt(valueString);
        return value;
    }

    public int getMonitorTime() {
        return monitorTime;
    }

    public void setMonitorTime(int monitorTime) {
        this.monitorTime = monitorTime;
    }

    public int getDepartureOffset() {
        return departureOffset;
    }

    public void setDepartureOffset(int departureOffset) {
        this.departureOffset = departureOffset;
    }
}
