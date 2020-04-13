package webadv.s99201105.p02;

import org.junit.Assert;
import org.junit.Test;
public class AppTest {
    private String ACC = "夕与";
    private String KEY = "yuxinbi2018";
    @Test
    public void testLength() {
        Assert.assertEquals(4, App.sha256hex(ACC, KEY).length());
    }
    @Test
    public void testHex() {
        String expected = "登录成功";
        Assert.assertEquals(expected, App.sha256hex(ACC, KEY));
    }
}
