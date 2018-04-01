"use strict"

class Matcher {

    constructor(clipLimit, delta){
        this.clipLimit = clipLimit;
        this.delta = delta;
    }


    match(expected, actual){
        actual = this.setClipLimit(actual, this.clipLimit);

        //Check for length differences
        if (!this.isEqual(actual.length, expected.length))
            return false;

        //Check that each entry within the expected +/- delta
        for (let i = 0; i < expected.length; i++) {
            let nbAbs = Math.abs(expected[i] - actual[i]);
            if (this.isSuperior(nbAbs, this.delta)){
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

    setClipLimit(tab, clipLimit) {
        for (let i = 0; i < tab.length; i++){
            if (this.isSuperior(tab[i], clipLimit)){
                tab[i] = clipLimit;
            }
        }
        return tab;
    }
}
module.exports = Matcher;