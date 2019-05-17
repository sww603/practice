/**
 * Created by sww_6 on 2019/5/16.
 * 1、wait()和notify()要么不出现，要么成对出现。
 * 2、wait()和notify()是属于objectMapper类的，不是属于线程的，因为宪政属于操作系统。
 * 3、https://www.jianshu.com/p/435c20a64da1
 * 3、wait()可能存在虚假中断和虚假唤醒。
 */
public class ShareDate {

  private int count = 0;

  public synchronized void add() throws InterruptedException {
    /*if (count != 0) {
      this.wait();
    }*/
    //1、判断
    while (count != 0){
      this.wait();
    }
    //2、干活
    ++count;
    System.out.println(Thread.currentThread().getName() + "\t" + count);
    //唤起
    this.notify();
  }

  public synchronized void sub() throws InterruptedException {
   /* if (count == 0) {
      this.wait();
    }*/
    while (count == 0){
      this.wait();
    }
    --count;
    System.out.println(Thread.currentThread().getName() + "\t" + count);
    this.notify();
  }
}
