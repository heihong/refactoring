using NFluent;
using Xunit;

namespace Soat.CleanCoders.Refactoring.Exo2
{
    public class TimePropertiesTest
    {
        private readonly TimeProperties _sut = new TimeProperties();

        [Fact]
        public void Should_throw_when_the_interval_is_missing()
        {
            var props = CreateProperties();

            Check.ThatCode(() => _sut.GetTimes(props))
                 .Throws<MissingTimePropertiesException>()
                 .WithMessage("monitor interval");
        }

        [Theory]
        [InlineData("0")]
        [InlineData("-8")]
        public void Should_throw_when_the_interval_value_is_below_or_equal_to_zero(string interval)
        {
            var props = CreateProperties(interval);

            Check.ThatCode(() => _sut.GetTimes(props))
                 .Throws<MissingTimePropertiesException>()
                 .WithMessage("monitor interval > 0");
        }

        [Fact]
        public void Should_throw_when_the_duration_is_missing()
        {
            var props = CreateProperties(interval: "5");

            Check.ThatCode(() => _sut.GetTimes(props))
                 .Throws<MissingTimePropertiesException>()
                 .WithMessage("duration");
        }

        [Theory]
        [InlineData("0")]
        [InlineData("-8")]
        public void Should_throw_when_the_duration_value_is_below_or_equal_to_zero(string duration)
        {
            var props = CreateProperties(interval: "5", duration: duration, departure: "5");

            Check.ThatCode(() => _sut.GetTimes(props))
                 .Throws<MissingTimePropertiesException>()
                 .WithMessage("duration > 0");
        }

        [Fact]
        public void Should_throw_when_the_duration_by_interval_is_not_equals_0()
        {
            var props = CreateProperties(interval: "5", duration: "2");

            Check.ThatCode(() => _sut.GetTimes(props))
                 .Throws<MissingTimePropertiesException>()
                 .WithMessage("duration % checkInterval");
        }

        [Fact]
        public void Should_throw_when_the_departure_offset_is_missing()
        {
            var props = CreateProperties(interval: "5", duration: "5");

            Check.ThatCode(() => _sut.GetTimes(props))
                 .Throws<MissingTimePropertiesException>()
                 .WithMessage("departure offset");
        }

        [Fact]
        public void Should_throw_when_the_departure_offset_value_equals_or_is_below_0()
        {
            var props = CreateProperties(interval: "5", duration: "5", departure: "0");

            Check.ThatCode(() => _sut.GetTimes(props))
                 .Throws<MissingTimePropertiesException>()
                 .WithMessage("departure > 0");
        }

        [Fact]
        public void Should_throw_when_the_departure_by_interval_is_not_equals_0()
        {
            var props = CreateProperties(interval: "5", duration: "5", departure: "1");

            Check.ThatCode(() => _sut.GetTimes(props))
                 .Throws<MissingTimePropertiesException>()
                 .WithMessage("departure % checkInterval");
        }

        [Fact]
        public void Should_set_the_departure_offset_and_the_monitor_time_when_all_the_properties_have_the_same_positive_value()
        {
            var props = CreateProperties(interval: "5", duration: "5", departure: "5");

            var result = _sut.GetTimes(props);

            Check.That(result)
                 .HasFieldsWithSameValues(new { DepartureOffset = 5, MonitorTime = 5 });
        }

        private static Properties CreateProperties(string interval = null, string duration = null, string departure = null)
        {
            var properties = new Properties();
            AddPropertyIfNotNullOrEmpty(properties, "duration",  duration);
            AddPropertyIfNotNullOrEmpty(properties, "interval",  interval);
            AddPropertyIfNotNullOrEmpty(properties, "departure", departure);
            return properties;
        }

        private static void AddPropertyIfNotNullOrEmpty(Properties properties, string key, string value)
        {
            if (!string.IsNullOrEmpty(value))
            {
                properties.setProperty(key, value);
            }
        }
    }
}
