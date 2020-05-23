package lab3;

class Turnstile {
    public void Pass(BasicCard card) {
        if(card.IsBlocked() == true) {
            Stop(card);
            return;
        }

        if (card instanceof BasicPreferentialCard) {
            if (((BasicPreferentialCard)card).IsPreferential() == true)
                Warn();
        }

        if(card.PassCard())
            Allow(card);
        else
            Stop(card);
    }

    private void Warn(){}

    private void Stop(BasicCard card) {
        Registry.stoppedPasses.add(card.getId());
    }
    private void Allow(BasicCard card) {
        Registry.allowedPasses.add(card.getId());
    }
}
