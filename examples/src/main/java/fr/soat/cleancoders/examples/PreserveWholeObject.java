package fr.soat.cleancoders.examples;

class PreserveWholeObject {

    static class Room{
        private TempRange daysTempRange;

        Room(TempRange daysTempRange) {
            this.daysTempRange = daysTempRange;
        }

        boolean withinPlan(HeatingPlan plan){
            int low = daysTempRange.getLow();
            int high = daysTempRange.getHigh();
            return plan.wihtinRange(low, high);
        }
    }

    static class HeatingPlan {
        private TempRange range;

        HeatingPlan(TempRange range) {
            this.range = range;
        }


        boolean wihtinRange(int low, int high) {
            return (low >= range.getLow() && high <= range.getHigh());
        }

    }
     static class TempRange {
        private int low;
        private int high;

         TempRange(int low, int high) {
             this.low = low;
             this.high = high;
         }

         int getLow() {
            return low;
        }

        public void setLow(int low) {
            this.low = low;
        }

        public int getHigh() {
            return high;
        }

        public void setHigh(int high) {
            this.high = high;
        }
    }
}
