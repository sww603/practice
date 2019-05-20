import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description TODO
 * @Param
 * @return
 * @date 2019/5/20 16:18
 * @auther sww_6
 */
class MyQueue {

  private Object obj;
  private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();

  public void writeLock(Object obj) {
    rwlock.writeLock().lock();
    try {
      this.obj = obj;
      System.out.println(Thread.currentThread().getName()+"\t"+obj);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      rwlock.writeLock().unlock();
    }
  }

  public void readLock(Object obj) {
    rwlock.readLock().lock();
    try {
      System.out.println(Thread.currentThread().getName()+"\t"+obj);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      rwlock.readLock().unlock();
    }
  }
}

public class ThreadReadWrite {

  public static void main(String[] args) {
    MyQueue myQueue = new MyQueue();

    new Thread(() -> {
            myQueue.writeLock("沈文0706");
        },"myThreadWrite").start();

    for (int i = 0; i < 100; i++) {

      new Thread(() -> {
        myQueue.readLock(String.format("沈文0706"));
          },"myThreadRead").start();
    }
  }
}
