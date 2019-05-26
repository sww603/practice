/**
 * Created by sww_6 on 2019/5/21.
 */
public class CountDownLatch {
    public static void main(String[] args) throws InterruptedException {

        java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t国被灭");
                latch.countDown();
            }, CountryEnums.foreachCountryEnums(i).getRetMessage()).start();
        }
        latch.await();
        System.out.println(Thread.currentThread().getName() + "秦王统一全国！");
    }
}
