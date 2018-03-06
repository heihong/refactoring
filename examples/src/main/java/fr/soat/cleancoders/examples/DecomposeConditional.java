package fr.soat.cleancoders.examples;

import java.time.LocalDate;

public class DecomposeConditional {

    static class YurtStay {
        private static final LocalDate SUMMER_START = LocalDate.now().plusMonths(6);
        private static final LocalDate SUMMER_END = SUMMER_START.plusMonths(6);
        private int winterRate;
        private int winterServiceCharge;
        private int summerRate;

        public YurtStay(int winterRate, int winterServiceCharge, int summerRate) {
            this.winterRate = winterRate;
            this.winterServiceCharge = winterServiceCharge;
            this.summerRate = summerRate;
        }

        double calculateCharge(LocalDate date, int quantity) {
            double charge;
            if (date.isBefore(SUMMER_START) || date.isAfter(SUMMER_END))
                charge = quantity * winterRate + winterServiceCharge;
            else
                charge = quantity * summerRate;
            return charge;

        }
    }
}
