package lab3;

abstract class BasicCard {
    private int id;
    private boolean blocked = false;

    public int getId() {
        return this.id;
    }

    public void setBlocked(boolean input) { this.blocked = input; }
    public boolean IsBlocked() { return this.blocked; }

    public BasicCard(int id){
        this.id = id;
    }

    abstract protected boolean PassCard();
}

abstract class BasicPreferentialCard extends BasicCard {
    private boolean preferential = false;

    public void setPreferential(boolean input) { this.preferential = input; }
    public boolean IsPreferential() { return this.preferential; }

    public BasicPreferentialCard(int id){
        super(id);
    }
}

