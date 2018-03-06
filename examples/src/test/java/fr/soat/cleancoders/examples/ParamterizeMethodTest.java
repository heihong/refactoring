package fr.soat.cleancoders.examples;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParamterizeMethodTest {

    @Test
    public void should_return_the_salary_with_ten_percent_raise() {
        ParamterizeMethod.Employee employee = new ParamterizeMethod.Employee(1000);
        employee.tenPercentRaise();

        assertThat(employee.getSalary()).isEqualTo(1100.0);
    }

    @Test
    public void should_return_the_salary_with_five_percent_raise() {

        ParamterizeMethod.Employee employee = new ParamterizeMethod.Employee(1000);
        employee.fivePercentRaise();

        assertThat(employee.getSalary()).isEqualTo(1050.0);
    }
}