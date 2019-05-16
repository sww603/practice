/**
 * Created by sww_6 on 2019/5/16.
 */
public class ShareDate {

  private int count = 1;

  public synchronized void add() {
    if (count != 0) {
      --count;
    }
    System.out.println(Thread.currentThread().getName() + "\t" + count);
    this.notify();
  }

  public synchronized void sub() {
    if (count == 0) {
      ++count;
    }
    System.out.println(Thread.currentThread().getName() + "\t" + count);
    this.notify();
  }
}
