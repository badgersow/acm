package usaco.y2020.gold;

import org.junit.jupiter.api.Test;
import util.AcmTest;

public class SpringboardsTest extends AcmTest {

    @Override
    public void processInput() throws Exception {
        new Springboards().solve();
    }

    @Test
    public void sample1() {
        compare("3 2 0 1 0 2 1 2 2 3", "3");
    }

    @Test
    public void sample2() {
        compare("3 2 0 1 1 1 1 2 2 3", "3");
    }

    @Test
    public void sample3() {
        compare("3 2 0 0 2 0 1 1 3 3", "2");
    }

    @Test
    public void sample4() {
        compare("3 2 0 0 0 0 1 1 1 1", "6");
    }

    @Test
    public void officialTest1() {
        compare(readFile("/usaco/2020/gold/springboards/1.in"),
                readFile("/usaco/2020/gold/springboards/1.out"));
    }

    @Test
    public void officialTest2() {
        compare(readFile("/usaco/2020/gold/springboards/2.in"),
                readFile("/usaco/2020/gold/springboards/2.out"));
    }

    @Test
    public void officialTest3() {
        compare(readFile("/usaco/2020/gold/springboards/3.in"),
                readFile("/usaco/2020/gold/springboards/3.out"));
    }

    @Test
    public void officialTest4() {
        compare(readFile("/usaco/2020/gold/springboards/4.in"),
                readFile("/usaco/2020/gold/springboards/4.out"));
    }

    @Test
    public void officialTest5() {
        compare(readFile("/usaco/2020/gold/springboards/5.in"),
                readFile("/usaco/2020/gold/springboards/5.out"));
    }

    @Test
    public void officialTest6() {
        compare(readFile("/usaco/2020/gold/springboards/6.in"),
                readFile("/usaco/2020/gold/springboards/6.out"));
    }

    @Test
    public void officialTest7() {
        compare(readFile("/usaco/2020/gold/springboards/7.in"),
                readFile("/usaco/2020/gold/springboards/7.out"));
    }

    @Test
    public void officialTest8() {
        compare(readFile("/usaco/2020/gold/springboards/8.in"),
                readFile("/usaco/2020/gold/springboards/8.out"));
    }

    @Test
    public void officialTest9() {
        compare(readFile("/usaco/2020/gold/springboards/9.in"),
                readFile("/usaco/2020/gold/springboards/9.out"));
    }

    @Test
    public void officialTest10() {
        compare(readFile("/usaco/2020/gold/springboards/10.in"),
                readFile("/usaco/2020/gold/springboards/10.out"));
    }

    @Test
    public void officialTest11() {
        compare(readFile("/usaco/2020/gold/springboards/11.in"),
                readFile("/usaco/2020/gold/springboards/11.out"));
    }

    @Test
    public void officialTest12() {
        compare(readFile("/usaco/2020/gold/springboards/12.in"),
                readFile("/usaco/2020/gold/springboards/12.out"));
    }

    @Test
    public void officialTest13() {
        compare(readFile("/usaco/2020/gold/springboards/13.in"),
                readFile("/usaco/2020/gold/springboards/13.out"));
    }

    @Test
    public void officialTest14() {
        compare(readFile("/usaco/2020/gold/springboards/14.in"),
                readFile("/usaco/2020/gold/springboards/14.out"));
    }

    @Test
    public void officialTest15() {
        compare(readFile("/usaco/2020/gold/springboards/15.in"),
                readFile("/usaco/2020/gold/springboards/15.out"));
    }

}