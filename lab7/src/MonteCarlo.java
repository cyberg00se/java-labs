import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.*;

class MonteCarlo {
    private int threads;
    private int iterations;
    private double lastExecutionTime;

    public int getThreads() {
        return threads;
    }
    public void setThreads(int threads) {
        this.threads = threads;
    }
    public int getIterations() {
        return iterations;
    }
    public void setIterations(int iterations) {
        this.iterations = iterations;
    }
    public double getLastExecutionTime() {
        return lastExecutionTime;
    }

    public MonteCarlo(int threads, int iterations) {
        this.threads = threads;
        this.iterations = iterations;
        this.lastExecutionTime = 0;
    }

    public double calculatePI() throws ExecutionException, InterruptedException {
        lastExecutionTime = System.currentTimeMillis();

        int circlePoints = countPoints();
        double circlePointsPercentage = (double)circlePoints/iterations;
        double PI = circlePointsPercentage * 4;

        lastExecutionTime = System.currentTimeMillis() - lastExecutionTime;
        return PI;
    }

    private int countPoints() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(threads);
        ArrayList<Future<Integer>> localPointsArray = new ArrayList<>();

        for (int i = 0; i < threads; i++) {
            MonteCarloThread thread = new MonteCarloThread(iterations/threads);
            Future<Integer> futureLocalPoints = pool.submit(thread);
            localPointsArray.add(futureLocalPoints);
        }

        int globalPoints = 0;
        for(Future<Integer> localPoints : localPointsArray) {
            globalPoints += localPoints.get();
        }
        return globalPoints;
    }
}
