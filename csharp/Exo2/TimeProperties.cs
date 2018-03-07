namespace Soat.CleanCoders.Refactoring.Exo2
{
    public class TimeProperties
    {
        public int DepartureOffset { get; private set; }
        public int MonitorTime { get; private set; }

        public TimeProperties() { }

        private TimeProperties(int departureOffset, int monitorTime)
        {
            DepartureOffset = departureOffset;
            MonitorTime = monitorTime;
        }

        public TimeProperties GetTimes(Properties props)
        {
            var valueString = props.getProperty("interval");
            if (string.IsNullOrEmpty(valueString))
            {
                throw new MissingTimePropertiesException("monitor interval");
            }

            var value = int.Parse(valueString);
            if (value <= 0)
            {
                throw new MissingTimePropertiesException("monitor interval > 0");
            }

            var checkInterval = value;

            valueString = props.getProperty("duration");
            if (string.IsNullOrEmpty(valueString))
            {
                throw new MissingTimePropertiesException("duration");
            }

            value = int.Parse(valueString);
            if (value <= 0)
            {
                throw new MissingTimePropertiesException("duration > 0");
            }

            if (value % checkInterval != 0)
            {
                throw new MissingTimePropertiesException("duration % checkInterval");
            }

            MonitorTime = value;

            valueString = props.getProperty("departure");
            if (string.IsNullOrEmpty(valueString))
            {
                throw new MissingTimePropertiesException("departure offset");
            }

            value = int.Parse(valueString);
            if (value <= 0)
            {
                throw new MissingTimePropertiesException("departure > 0");
            }

            if (value % checkInterval != 0)
            {
                throw new MissingTimePropertiesException("departure % checkInterval");
            }

            DepartureOffset = value;
            return new TimeProperties(DepartureOffset, MonitorTime);
        }
    }
}
