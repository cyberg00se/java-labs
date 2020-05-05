import java.util.concurrent.Callable;

class MonteCarloThread implements Callable {
    private int threadIterations;
    private int localPoints;

    public int getLocalPoints() {
        return localPoints;
    }

    public MonteCarloThread(int threadIterations) {
        super();
        this.localPoints = 0;
        this.threadIterations = threadIterations;
    }

    @Override
    public Integer call() {
        for (int i = 0; i < threadIterations; i++){
            if(throwPoint() == true)
                localPoints++;
        }
        return localPoints;
    }

    private boolean throwPoint() {
        double x = Math.random();
        double y = Math.random();
        double radius = Math.pow(x, 2) + Math.pow(y, 2);

        if(radius <= 1)
            return true;
        else
            return false;
    }
}
