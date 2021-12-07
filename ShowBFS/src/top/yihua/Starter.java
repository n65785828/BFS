package top.yihua;

import top.yihua.bean.User;

import java.util.List;

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
        a.befriend(b);
        a.befriend(e);
        a.befriend(c);
        b.befriend(c);
        e.befriend(d);
        e.befriend(f);
        c.befriend(g);
        d.befriend(e);
        d.befriend(g);
        g.befriend(f);
        e.befriend(b);
//        User.Node friend = f.isFriend(a);
//        printWay(friend);
        List<User.Node> nodes = f.searchRoad(a);
        nodes.forEach(Starter::printWay);
    }


    public static void printWay(User.Node node){
        if(node.getParent()!=null){
            printWay(node.getParent());
        }
        System.out.print(node.getUser().getName()+"  ");
    }
}
