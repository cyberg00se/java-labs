import java.text.DecimalFormat;
import java.util.TreeMap;

class CashRegister {
    private TreeMap<Item, Integer> items; // key - item, value - number of items
    private double totalSum;
    private String check;
    private DecimalFormat priceFormat;

    public int getItemsLength() {
        return items.size();
    }
    public double getTotalSum() {
        return totalSum;
    }

    public CashRegister() {
        items = new TreeMap<>();
        check = "";
        priceFormat = new DecimalFormat("#.00");
        totalSum = 0;
    }

    public void addItem(Item item) {
        if(!items.containsKey(item))
            items.put(item, 1);
        else
            items.put(item, items.get(item) + 1);
    }

    public void calculateTotalSum() {
        for (Item item: items.keySet()) {
            totalSum += item.getPrice() * items.get(item); // price * number of items
        }
    }

    public String createCheck() {
        //add item line
        for (Item item: items.keySet()) {
            String name = item.getName();
            String price = priceFormat.format(item.getPrice());
            String number = items.get(item).toString();

            //"name_of_item 5.55 x2"
            check += String.format("%s %s x%s", name, price, number) + System.lineSeparator();
        }

        // add total sum
        check += String.format("Total sum: %s", priceFormat.format(totalSum));

        return check;
    }
}
