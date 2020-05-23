package lab3;

class ValidityCard extends BasicPreferentialCard {
    private int validity;

    public void setValidity(int input) { this.validity = input; }
    public int getValidity()
    {
        return this.validity;
    }

    public enum Validity {
        DAY(1),
        WEEK(7),
        MONTH(30);

        private int value;
        Validity(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }

    public ValidityCard(int id, Validity validity) {super(id); this.validity = validity.getValue();}

    protected boolean PassCard(){
        if (this.validity > 0)
            return true;
        else
            return false;
    }
}
