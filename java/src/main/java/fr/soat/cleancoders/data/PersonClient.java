package fr.soat.cleancoders.data;

import java.io.IOException;
import java.io.Writer;

public class PersonClient {
    void client1(Writer out, Person person) throws IOException {
        out.write(person.first);
        out.write(" ");
        if (person.middle != null) {
            out.write(person.middle);
            out.write(" ");
        }
        out.write(person.last);
    }

    public String client2(Person person) {
        String result = person.last + ", " + person.first;
        if (person.middle != null)
            result += " " + person.middle;
        return result;
    }

    public void client3(Writer out, Person person) throws IOException {
        out.write(person.last);
        out.write(", ");
        out.write(person.first);
        if (person.middle != null) {
            out.write(" ");
            out.write(person.middle);
        }
    }

    public String client4(Person person) {
        return person.last + ", " +
                person.first +
                ((person.middle == null) ? "" : " " + person.middle);
    }

}
