using NFluent;
using Xunit;

namespace Soat.CleanCoders.Refactoring.Exo1
{
    public class MatcherTest
    {
        private const int ClipLimit = 100;
        private const int Delta     = 5;

        private readonly Matcher _sut = new Matcher();

        [Fact]
        public void Should_match_given_no_difference_and_values_below_clip_limit()
        {
            //Given
            var actual   = new[] { 10, 50, 30, 90 };
            var expected = new[] { 10, 50, 30, 90 };

            //When
            var matches = _sut.Match(expected, actual, ClipLimit, 0);

            //Then
            Check.That(matches)
                 .IsTrue();
        }

        [Fact]
        public void Should_match_given_difference_below_delta()
        {
            //Given
            var actual   = new[] { 12, 55, 25, 110 };
            var expected = new[] { 10, 50, 30, 98 };

            //When
            var matches = _sut.Match(expected, actual, ClipLimit, Delta);

            //Then
            Check.That(matches)
                 .IsTrue();
        }

        [Fact]
        public void Should_not_match_given_difference_above_delta()
        {
            //Given
            var actual   = new[] { 10, 60, 30, 98 };
            var expected = new[] { 10, 50, 30, 98 };

            //When
            var matches = _sut.Match(expected, actual, ClipLimit, Delta);

            //Then
            Check.That(matches)
                 .IsFalse();
        }

        [Fact]
        public void Should_not_match_given_different_length()
        {
            //Given
            var actual   = new[] { 10, 50, 30 };
            var expected = new[] { 10, 50, 30, 98 };

            //When
            var matches = _sut.Match(expected, actual, ClipLimit, Delta);

            //Then
            Check.That(matches)
                 .IsFalse();
        }
    }
}
