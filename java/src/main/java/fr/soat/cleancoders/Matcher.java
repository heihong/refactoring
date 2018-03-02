package fr.soat.cleancoders;

class Matcher {

    boolean match(int[] expected, int[] actual, int clipLimit, int delta) {
        //Clip "too large" values
        for (int i = 0; i < actual.length; i++)
            if (actual[i] > clipLimit)
                actual[i] = clipLimit;

            //Check for length differences
            if (actual.length != expected.length)
                return false;

            //Check that each entry within the expected +/- delta
            for (int i = 0; i < expected.length; i++)
            if (Math.abs(expected[i] - actual[i]) > delta)
                return false;

        return true;
    }
}
