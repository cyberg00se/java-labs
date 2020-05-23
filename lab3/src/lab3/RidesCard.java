package lab3;

class RidesCard extends BasicPreferentialCard {
    private int rides;

    public void setRides(int input) { this.rides = input; }
    public int getRides()
    {
        return this.rides;
    }

    public enum Rides {
        FOUR(4),
        TEN(10),
        TWENTY(20);

        private int value;
        Rides(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }

    public RidesCard(int id, Rides rides) {super(id); this.rides = rides.getValue();}

    protected boolean PassCard(){
        if (this.rides > 0) {
            this.rides--;
            return true;
        }
        else
            return false;
    }
}
