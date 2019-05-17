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
        for (int i = 1; i < 10; i++) {
          try {
            shareDate.add();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }, "A").start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 1; i < 10; i++) {
          try {
            shareDate.sub();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }, "B").start();
    new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 1; i < 10; i++) {
          try {
            shareDate.sub();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }, "C").start();
    new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 1; i < 10; i++) {
          try {
            shareDate.add();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }, "D").start();
  }
}
