class Item implements Comparable<Item>{
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String input) {
        name = input;
    }
    public void setPrice(int input) {
        if(input > 0)
            price = input;
        else
            price = 0;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    public int compareTo(Item anotherItem)
    {
        return this.name.compareTo(anotherItem.name);
    }
}
