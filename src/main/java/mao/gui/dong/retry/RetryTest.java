package mao.gui.dong.retry;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/22 下午8:05
 */
public class RetryTest {
    public static void main(String[] args) {
        RetryTest retryTest = new RetryTest();
        retryTest.testRetry();

    }

    private void testRetry() {
        a:
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(j+",");
                if(j==3){
                    continue a;
                }
            }
        }
        System.out.println("hell");
    }
}
