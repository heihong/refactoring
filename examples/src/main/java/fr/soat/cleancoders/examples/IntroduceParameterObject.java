package fr.soat.cleancoders.examples;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

class IntroduceParameterObject {
    List<Entry> entries;

    IntroduceParameterObject(List<Entry> entries) {
        this.entries = entries;
    }

    double getFlowBetween(DateRange range) {
        return entries()
                .filter(range.containsChargeDate())
                .mapToDouble(Entry::getValue)
                .sum();
    }

    private Stream<Entry> entries() {
        return entries.stream();
    }

    static class Entry {
        private double value;
        private LocalDate chargeDate;

        Entry(double value, LocalDate chargeDate) {
            this.value = value;
            this.chargeDate = chargeDate;
        }

        double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        LocalDate getChargeDate() {
            return chargeDate;
        }

        public void setChargeDate(LocalDate chargeDate) {
            this.chargeDate = chargeDate;
        }
    }

    static class  DateRange{
        private LocalDate start;
        private LocalDate end;

        DateRange(LocalDate start, LocalDate end) {
            this.start = start;
            this.end = end;
        }

        LocalDate getStart() {
            return start;
        }

        LocalDate getEnd() {
            return end;
        }

        private boolean containsChargeDate(LocalDate chargedDate) {
            return chargedDate.equals(getStart())
                    || chargedDate.equals(getEnd()) ||
                    (chargedDate.isAfter(getStart()) && chargedDate.isBefore(getEnd()));
        }

        private Predicate<Entry> containsChargeDate() {
            return e -> containsChargeDate(e.getChargeDate());
        }
    }
}
