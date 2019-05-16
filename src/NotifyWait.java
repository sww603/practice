/**
 * Created by sww_6 on 2019/5/16.
 * 现在两个线程，可以操作同一个变量，实现一个线程对该变量加一，一个线程对该变量减一。
 */
public class NotifyWait {

  public static void main(String[] args) {

    ShareDate shareDate = new ShareDate();
    new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 1; i < 100; i++) {
          shareDate.add();
        }
      }
    }, "A").start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 1; i < 100; i++) {
          shareDate.sub();
        }
      }
    }, "B").start();
    new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 1; i < 10; i++) {
          shareDate.sub();
        }
      }
    }, "c").start();
    new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 1; i < 10; i++) {
          shareDate.sub();
        }
      }
    }, "D").start();
  }

}
