import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sww_6 on 2019/5/20.
 */
public class ThreadPool {

  public static void main(String[] args) {
    ExecutorService service = Executors.newFixedThreadPool(5);

    for (int i = 0; i < 10; i++) {
      try {
        service.submit(() -> {
          System.out.println(Thread.currentThread().getName() + "\t");
          return new Random().nextInt(20);
        });
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
      }
    }
  }
}
