import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Predicate;

public class ExecutorServiceDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable runnable = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(30);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        };
        Callable<String> callable = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Tasks execution";
        };

        List<Callable<String>> callableList = new ArrayList<>();
        callableList.add(callable);
        callableList.add(callable);
        callableList.add(callable);

        executorService.execute(runnable);
        Future<String> stringFuture = executorService.submit(callable);
        System.out.println(stringFuture);

        String result  = executorService.invokeAny(callableList);
        System.out.println(result);

        List<Future<String>> futures = executorService.invokeAll(callableList);
        System.out.println(futures);

        Predicate<String> stringPredicate = String::isEmpty;
        System.out.println(stringPredicate.test("")+" ::"+stringPredicate.test("Hello"));

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        Future<Integer> integerFuture = executorService1.submit(()->{
            System.out.println("I am started:: "+ LocalDateTime.now());
            return 42;
        }) ;
        System.out.println(integerFuture.get()+"::"+integerFuture.isDone());

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            return 32;
        }).thenApply(x->x*1)
                .exceptionally(throwable -> {
                    throwable.printStackTrace();
                    return  -1;
                });
        System.out.println(completableFuture.get());


    }

}
