import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sww_6 on 2019/5/20.
 * 备注：多线程之前按顺序调用，实现A->b->C
 * 三个线程启动，要求如下：
 * aa打印5次，bb打印10次，cc打印15次。
 * 共计20轮。
 *
 * 相当于 A=1 ,b = 2 ,C = 3.
 * 厨房的菜刀，一提两面，现在是一个lock三面，也好比打篮球的时候，三个人投一个蓝，谁抢到谁先投。
 * 江湖人称两面三刀，一刀（lock）,三面（condition1，condition2，condition3），谁先获得资源谁使用。
 * lock可以实现可用资源的有序排序。
 * https://www.cnblogs.com/baizhanshi/p/6419268.html
 */
class Print {

  public int count = 1;
  private Lock lock = new ReentrantLock();
  private Condition condition1 = lock.newCondition();
  private Condition condition2 = lock.newCondition();
  private Condition condition3 = lock.newCondition();

  public void implement1(int totalLoop) {
    lock.lock();
    try {
      //1、判断
      while (count != 1) {
        condition1.await();
      }
      //2、干活
      for (int i = 1; i <= 5; i++) {
        System.out
            .println(Thread.currentThread().getName() + "\t" + i + "\t" + "totallooop" + totalLoop);
      }
      count = 2;
      //3、唤醒
      condition2.signal();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void implement2(int totalLoop) {
    lock.lock();
    try {
      //1、判断
      while (count != 2) {
        condition2.await();
      }
      //2、干活
      for (int i = 1; i <= 10; i++) {
        System.out
            .println(Thread.currentThread().getName() + "\t" + i + "\t" + "totallooop" + totalLoop);
      }
      //3、唤醒
      count = 3;
      condition3.signal();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void implement3(int totalLoop) {
    lock.lock();
    try {
      //1、判断
      while (count != 3) {
        condition3.await();
      }
      //2、干活
      for (int i = 1; i <= 15; i++) {
        System.out
            .println(Thread.currentThread().getName() + "\t" + i + "\t" + "totallooop" + totalLoop);
      }
      //3、唤醒
      count = 1;
      condition1.signal();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }
}

public class ThreadPrint {

  public static void main(String[] args) {

    Print print = new Print();

    new Thread(() -> {
      for (int i = 1; i < 10; i++) {
        print.implement1(i);
      }
    }, "A").start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 1; i < 10; i++) {
          print.implement2(i);
        }
      }
    }, "B").start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 1; i < 10; i++) {
          print.implement3(i);
        }
      }
    }, "C").start();
  }
}
