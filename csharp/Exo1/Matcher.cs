using System;

namespace Soat.CleanCoders.Refactoring.Exo1
{
    public class Matcher
    {
        public bool Match(int[] expected, int[] actual, int clipLimit, int delta)
        {
            //Clip "too large" values
            for (var i = 0; i < actual.Length; i++)
            {
                if (actual[i] > clipLimit)
                {
                    actual[i] = clipLimit;
                }
            }

            //Check for length differences
            if (actual.Length != expected.Length)
            {
                return false;
            }

            //Check that each entry within the expected +/- delta
            for (var i = 0; i < expected.Length; i++)
            {
                if (Math.Abs(expected[i] - actual[i]) > delta)
                {
                    return false;
                }
            }

            return true;
        }
    }
}
