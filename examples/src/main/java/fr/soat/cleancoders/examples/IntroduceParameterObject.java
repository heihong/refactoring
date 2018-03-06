package fr.soat.cleancoders.examples;

import java.time.LocalDate;
import java.util.List;

class IntroduceParameterObject {
    List<Entry> entries;

    IntroduceParameterObject(List<Entry> entries) {
        this.entries = entries;
    }

    double getFlowBetween(LocalDate start, LocalDate end, DateRange range) {
        double result = 0;
        for (Entry entry : entries) {
            if (entry.getChargeDate().equals(range.getStart()) || entry.getChargeDate().equals(end) ||
                    (entry.getChargeDate().isAfter(start) && entry.getChargeDate().isBefore(end)))

                result += entry.getValue();
        }
        return result;
    }

    static class Entry {
        private double value;
        private LocalDate chargeDate;

        Entry(double value, LocalDate chargeDate) {
            this.value = value;
            this.chargeDate = chargeDate;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public LocalDate getChargeDate() {
            return chargeDate;
        }

        public void setChargeDate(LocalDate chargeDate) {
            this.chargeDate = chargeDate;
        }
    }

    static class  DateRange{
        private LocalDate start;
        private LocalDate end;

        public DateRange(LocalDate start, LocalDate end) {
            this.start = start;
            this.end = end;
        }

        public LocalDate getStart() {
            return start;
        }

        public LocalDate getEnd() {
            return end;
        }
    }
}
