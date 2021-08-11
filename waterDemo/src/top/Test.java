package top;

import java.util.List;

public class Test {
    public static void main(String[] args) {
//        test0();
        CircleLinkContainer a = new CircleLinkContainer();
        List<CircleLinkContainer> groupContainers = a.getGroupContainers();
        CircleLinkContainer b = new CircleLinkContainer();
        CircleLinkContainer c = new CircleLinkContainer();
        CircleLinkContainer d = new CircleLinkContainer();
        CircleLinkContainer e = new CircleLinkContainer();
        CircleLinkContainer f = new CircleLinkContainer();
        a.connectTo(b);
        groupContainers = a.getGroupContainers();
        b.connectTo(c);
        groupContainers = a.getGroupContainers();
        c.connectTo(d);
        groupContainers = a.getGroupContainers();
        d.connectTo(e);
        groupContainers = a.getGroupContainers();
        e.connectTo(f);
        groupContainers = a.getGroupContainers();
        System.out.println("fin");
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
