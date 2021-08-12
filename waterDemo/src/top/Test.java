package top;

import java.util.List;

public class Test {
    public static void main(String[] args) {
//        test0();
        CircleLinkContainer a = new CircleLinkContainer();
        a.addWater(7);
        CircleLinkContainer b = new CircleLinkContainer();
        b.addWater(1);
        CircleLinkContainer c = new CircleLinkContainer();
        c.addWater(1);
        CircleLinkContainer d = new CircleLinkContainer();
        d.addWater(7);
        CircleLinkContainer e = new CircleLinkContainer();
        e.addWater(1);
        CircleLinkContainer f = new CircleLinkContainer();
        a.addWater(1);
        a.connectTo(b);
        b.connectTo(c);
        c.connectTo(d);
        d.connectTo(e);
        e.connectTo(f);
        System.out.println(a.getAmount());
    }

    private static void test0() {
        Container a = new Container();
        Container b = new Container();
        Container c = new Container();
        Container d = new Container();
        a.addWater(5);
        b.addWater(3);
        a.connectTo(b);
        b.connectTo(c);
        c.connectTo(d);
        d.connectTo(a);
        System.out.println(a.getWater());
        System.out.println(b.getWater());
        System.out.println(c.getWater());
        System.out.println(d.getWater());
    }
}
