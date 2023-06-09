package www.haemimont.carsapp.functions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class SingleThreadAverageSum {
    public double averageSumSingle(CarAveragePriceCalculator callable) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Double> future = executor.submit(callable);
        double averageSum;
        try {
            averageSum = future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
        return averageSum;
    }
}
