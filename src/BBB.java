import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by sww_6 on 2019/5/14.
 * 1、只会调一次call，避免资源的过度调度.
 * 2、get只能放在最后,不要影响主线程执行（get只有执行完成，才会继续往下）。
 */
public class BBB {

  static class MyThrad implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
      System.out.println("**********call***************");
      Thread.sleep(4000);
      return 200;
    }
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThrad());

    new Thread(futureTask, "AA").start();

    new Thread(futureTask, "BB").start();

    System.out.println(Thread.currentThread().getName());
    Integer integer1 = futureTask.get();
    System.out.println("******main********reault:" + integer1);
    Integer integer2 = futureTask.get();
    System.out.println("******main********reault:" + integer2);
  }
}
