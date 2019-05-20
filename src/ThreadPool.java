import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by sww_6 on 2019/5/20.
 */
public class ThreadPool {

  public static void main(String[] args) {

    /*//第一种，固定的线程数
    ExecutorService service = Executors.newFixedThreadPool(5);
    Future<Integer> result = null;
    try {
      for (int i = 0; i < 10; i++) {
        result = service.submit(() -> {
          System.out.println(Thread.currentThread().getName());
          return new Random().nextInt(20);
        });
        System.out.println("result" + result.get());
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
    }*/

   /* //第二种 只有一个线程
    ExecutorService service = Executors.newSingleThreadExecutor();
    Future<Integer> result = null;
    try {
      for (int i = 0; i < 10; i++) {
        result = service.submit(() -> {
          System.out.println(Thread.currentThread().getName());
          return new Random().nextInt(20);
        });
        System.out.println(result.get());
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
    }*/

    //第三种 可改变线程
    ExecutorService service = Executors.newCachedThreadPool();
    Future<Integer> result = null;
    try {
      for (int i = 0; i < 1000; i++) {
        result = service.submit(() -> {
          System.out.println(Thread.currentThread().getName());
          return new Random().nextInt(20);
        });
        System.out.println(result.get());
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
    }
  }
}
