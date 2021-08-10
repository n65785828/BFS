package top;

public class Test {
    public static void main(String[] args) {
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
