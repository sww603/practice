import java.util.concurrent.TimeUnit;

/**
 * Created by sww_6 on 2019/5/18.
 * 多线程的锁（8锁）。
 * 8问？
 * 1、标准访问，请问先打印android，还是ios?
 * 2、暂停4秒，请问先打印android，还是ios？
 * 3、新增普通hellow方法，请问先打印ios,还是hellow?
 * 4、两部手机，请问先打印ios,还是android?
 * 5、两个静态同步方法，同一部手机，请问先打印ios，还是android？
 * 6、两个静态同步方法，两部手机，请问先打印ios，还是android？
 * 7、一个普通同步方法，一个静态同步方法,同一部手机，请问先打印ios，还是android？
 * 8、一个普通同步方法，一个静态同步方法,两部手机，请问先打印ios，还是android？
 * <p>
 * 8答：
 * 1、2、加锁加锁，锁的是Phone这个对象，在同一时间段，有且只有一个线程访问phone对象的这个资源。
 * 例子:一部手机有好多功能，可以打电话、发短信、听歌。同一时间，郭俊成要用这部手机打电话，而沈文文要用这部手机发短信，
 * 但是不能同时进行，只能郭俊成打完电话，沈文文才能发短信，在郭俊成打电话期间，手机（对象）被锁定，其他线程只能等待。
 * 假设一个资源类有一堆同步方法，同一个时间段，只有有一个线程进来访问一个普通的同步方法，其他线程只能等待。锁的是整个对象。
 * 结论：一个对象里面如果有多个synchronized的方法，某一时刻内，只要有一个线程去调用其中的一个synchronized的方法了，其他的
 * 线程只能等待，换句话说，某一时刻内，只能有唯一一个线程去访问synchronized方法。
 * 锁的是当前对象this,被锁定后，其他的线程都不能进入到当前对象的其他的synchronized的方法。
 * 3、结论：加个普通方法，发现和同步方法无关。
 * 例子：郭俊成说我要用一部手机打电话，沈文文说我要去超市买瓶水。冲突吗？不冲突，他打他的电话，我买我的水。
 * 4、两部手机就是两个资源，郭俊成用一个打电话，沈文文用一个发短信？争吗？不争。
 * 5、6、运行的效果一样，static是类对象，是全局的。
 * 例子：郭俊成以前上厕所，把宿舍门给关上了，现在上厕所，却把大学校门给关上了。在反射上，所得是phone这个模板，就是不管ios,
 * 或者是谁先进来，都把模板给锁了。把大的class给锁了。
 * 7、一个所得是当前对象this,一个锁的是当前的Class.Class相当于工人下班，把小米共产拉闸限电，关门。
 * 8、加锁锁的是两回事，工人拉闸限电，不影响海尔空调的使用。
 */


class Phone {

    public synchronized void getIos() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("*******************ios");
    }

    public synchronized void getAndroid() {
        System.out.println("******************android");
    }

    public void getHellow() {
        System.out.println("******************hellow");
    }
}

public class ThreadPhone {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    phone.getIos();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //phone2.getAndroid();
                phone.getAndroid();
            }
        }, "BB").start();
    }
}
