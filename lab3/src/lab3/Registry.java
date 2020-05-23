package lab3;

import java.util.ArrayList;

class Creator {
    protected static int counter = 0;

    public void CreateValidityCard(ValidityCard.Validity validity) {
        Registry.cards.add(new ValidityCard(++counter, validity));
    }

    public void CreateRidesCard(RidesCard.Rides rides) {
        Registry.cards.add(new RidesCard(++counter, rides));
    }

    public void CreateCard(int balance) {
        Registry.cards.add(new BalanceCard(++counter, balance));
    }
}

class Registry {
    public static ArrayList<BasicCard> cards;
    public static ArrayList<Integer> allowedPasses;
    public static ArrayList<Integer> stoppedPasses;
    
    public static BasicCard getCard(int id) {
        for (BasicCard card: cards) {
            if(card.getId() == id)
                return card;
        }
        return cards.get(cards.size() - 1); // last card
    }
    public static void blockCard(BasicCard card) {
        card.setBlocked(true);
    }
}
