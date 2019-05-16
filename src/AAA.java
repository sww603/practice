import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/**
 * Created by sww_6 on 2018/6/29.
 */
public class AAA {

  public static void main(String args[]) {
    /**
     * 高内聚，低耦合。
     */
    /**
     * runable和callable没一毛钱关系。
     */
   /* new Thread(() -> {for (int i = 1; i < 40; i++) ticket.sale();},"A").start();
    new Thread(() -> {for (int i = 1; i < 40; i++) ticket.sale();},"B").start();
    new Thread(() -> {for (int i = 1; i < 40; i++) ticket.sale();},"C").start();
    new Thread(new Runnable() {
      public void run() {
        for (int i = 1; i < 40; i++){
          ticket.sale();
        }
      }
    },"A").start();*/

      new Thread(new FutureTask<Integer>(new Callable() {
        public Integer call() throws Exception {
          System.out.println("子线程在进行计算");
          Thread.sleep(1000);
          int sum = 0;
          for (int i = 0; i < 10000; i++)
            sum += i;
          return sum;
        }
      }),"A").start();
    new Thread(new FutureTask<Integer>(new Callable() {
      public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(1000);
        int sum = 0;
        for (int i = 0; i < 10000; i++)
          sum += i;
        return sum;
      }
    }),"B").start();
    new Thread(new FutureTask<Integer>(new Callable() {
      public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(1000);
        int sum = 0;
        for (int i = 0; i < 10000; i++)
          sum += i;
        return sum;
      }
    }),"C").start();
}
}
