package top.algorithm.friend;

public class Starter {
    public static void main(String[] args) {
        User a = new User("a");
        User b = new User("b");
        User c = new User("c");
        User d = new User("d");
        User e = new User("e");
        User f = new User("f");
        User g = new User("g");
        User h = new User("h");
        a.beFriend(b);
        a.beFriend(e);
        a.beFriend(c);
        b.beFriend(c);
        e.beFriend(d);
        e.beFriend(f);
        c.beFriend(g);
        d.beFriend(e);
        d.beFriend(g);
        g.beFriend(f);
        User.Node friend = f.isFriend(c);
        printWay(friend);
    }

    public static void printWay(User.Node node){
        if(node.parent!=null){
            printWay(node.parent);
        }
        System.out.print(node.detail.getName()+"  ");
    }
}
