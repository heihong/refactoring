package fr.soat.cleancoders.examples;

class ParamterizeMethod {

    static class Employee {
        private double salary;

        Employee(int salary) {
            this.salary = salary;
        }

        void tenPercentRaise(){
            salary *= 1.1;
        }

        void fivePercentRaise(){
            salary *= 1.05;
        }

        double getSalary() {
            return salary;
        }
    }


}
