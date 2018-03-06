package fr.soat.cleancoders.examples.inlineClass;

public class Person {
    private String name;
    private TelephoneNumber telephoneNumber;

    private TelephoneNumber getTelephoneNumber(){
        return telephoneNumber;
    }


    private class TelephoneNumber {
        private int codePostal;
        private int bureau;

        int getTelephoneNumber (){
            return 0;
        }
    }
}
