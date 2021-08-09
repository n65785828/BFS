package top.algorithm.friend;


import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;

public class User {
    private String name;
    private Set<User> friendSet = new HashSet<>();

    public User(String name) {
        this.name = name;
    }

    public void beFriend(User otherUser){
        friendSet.add(otherUser);
        otherUser.friendSet.add(this);
    }

    public boolean isDirectFriend(User otherUser){
        return this==otherUser||friendSet.contains(otherUser);
    }

    public boolean isIndirectFriend(User otherUser){
        Deque<User> scanQueue = new LinkedList<>();
        Set<User> scannedSet = new HashSet<>();
        scanQueue.add(this);
        while (!scanQueue.isEmpty()){
            User user = scanQueue.removeFirst();
            if(scannedSet.add(user)){
                if(user==otherUser){
                    return true;
                }
                scanQueue.addAll(user.friendSet);
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //广度优先算法 返回包含路径信息的node
    public Node isFriend(User otherUser){
        Deque<Node> scanQueue = new LinkedList<>();
        Set<User> scannedSet = new HashSet<>();
        Node node = new Node(this,null);
        scanQueue.add(node);
        while (!scanQueue.isEmpty()){
            Node n = scanQueue.removeFirst();
            if(scannedSet.add(n.detail)){
                if(n.detail==otherUser){
                    return n;
                }
                scanQueue.addAll(n.detail.friendSet.stream().map(t->new Node(t,n)).collect(Collectors.toList()));
            }
        }
        return null;
    }

    public static class Node{
        public User detail;
        public Node parent;

        public Node(User detail, Node parent) {
            this.detail = detail;
            this.parent = parent;
        }
    }

}
