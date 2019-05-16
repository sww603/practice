import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sww_6 on 2019/5/14.
 */
public class Ticket {
  private int number = 30;
  private Lock lock = new ReentrantLock();

  public void sale() {
    lock.lock();
    try {
      if (number > 0) {
        System.out
            .println(Thread.currentThread().getName() + "卖出第:" + (number--) + "还剩下:" + number);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }
}
