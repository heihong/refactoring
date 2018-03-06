package fr.soat.cleancoders.exo3;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;


public class PersonClientTest {
    private PersonClient client;

    @Before
    public void initialize_common_variables() throws Exception {
        client = new PersonClient();
    }


    @Test
    public void should_write_name_using_different_clients() throws IOException {
        Person bobSmith = new Person("Smith", "Bob", null);

        StringWriter out = new StringWriter();
        client.client1(out, bobSmith);

        Assertions.assertThat(out.toString()).isEqualTo("Bob Smith");
        Assertions.assertThat(client.client2(bobSmith)).isEqualTo("Smith, Bob");

        out = new StringWriter();
        client.client3(out, bobSmith);
        Assertions.assertThat(out.toString()).isEqualTo("Smith, Bob");

        Assertions.assertThat(client.client4(bobSmith)).isEqualTo("Smith, Bob");


    }

    @Test
    public void should_write_the_name_using_differently() throws IOException {
        StringWriter out = new StringWriter();
        Person jennyJJones = new Person("Jones", "Jenny", "J");

        client.client1(out, jennyJJones);

        Assertions.assertThat(out.toString()).isEqualTo("Jenny J Jones");
        Assertions.assertThat(client.client2(jennyJJones)).isEqualTo("Jones, Jenny J");
        out = new StringWriter();
        client.client3(out, jennyJJones);

        Assertions.assertThat(out.toString()).isEqualTo("Jones, Jenny J");

        Assertions.assertThat(client.client4(jennyJJones)).isEqualTo("Jones, Jenny J");

    }

}