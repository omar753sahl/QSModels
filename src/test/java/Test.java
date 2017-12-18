import utils.MathUtils;

/**
 * Created by Omar
 * Date: 17-Dec-17.
 */

public class Test {
    @org.junit.Test
    public void testSomething() {
        try {
            System.out.println(MathUtils.eval("(5 + 10) * 5"));
        } catch (Exception e) {
            System.out.println("sorry :(");
        }
    }
}
