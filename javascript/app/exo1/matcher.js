"use strict"

class Matcher {

    constructor(){

    }


    match(expected, actual, clipLimit, delta){
        for (let i = 0; i < actual.length; i++)
            if (this.isSuperior(actual[i], clipLimit))
                actual[i] = clipLimit;

        //Check for length differences
        if (!this.isEqual(actual.length, expected.length))
            return false;

        //Check that each entry within the expected +/- delta
        for (let i = 0; i < expected.length; i++) {
            let nbAbs = Math.abs(expected[i] - actual[i]);
            if (this.isSuperior(nbAbs, delta)){
                return false;
            }

        }
        return true;
    }

    isSuperior(nbAbs, delta) {
        return nbAbs > delta;
    }

    isEqual(actual, expected) {
        return actual == expected;
    }
}
module.exports = Matcher;