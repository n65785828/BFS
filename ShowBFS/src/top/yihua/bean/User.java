package top.yihua.bean;

import java.util.*;
import java.util.stream.Collectors;

public class User {
    private String name;
    private Set<User> friends ;

    public User(String name){
        this.friends =  new HashSet<>();
        friends.add(this);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void befriend(User other){
        friends.add(other);
        other.friends.add(this);
    }

    public boolean isDirectFriend(User other){
        return friends.contains(other);
    }

    public boolean isLinkedFriend(User other){
        Set<User> scanned = new HashSet<>();
        Deque<User> waitScanQueue = new LinkedList<>();
        waitScanQueue.add(this);
        while (!waitScanQueue.isEmpty()){
            User scanUser = waitScanQueue.removeFirst();
            if(scanned.add(scanUser)){
                if(scanUser==other){
                    return true;
                }
                waitScanQueue.addAll(scanUser.friends);
            }
        }
        return false;
    }

    public Node isFriend(User other){
        Set<Node> scanned = new HashSet<>();
        Deque<Node> waitScanQueue = new LinkedList<>();
        waitScanQueue.add(new Node(this,null));
        while (!waitScanQueue.isEmpty()){
            Node scanUser = waitScanQueue.removeFirst();
            if(scanned.add(scanUser)){
                if(scanUser.getUser()==other){
                    return scanUser;
                }
                waitScanQueue.addAll(scanUser.getUser().friends.stream().map(t->new Node(t,scanUser)).collect(Collectors.toList()));
            }
        }
        return null;
    }


    public List<Node> searchRoad(User other){
        List<Node> result = new ArrayList<>();
        searchRoad(other,result,null,null);
        return result;
    }

    private void searchRoad(User other,List<Node> roads,Node node,Set<User> scanned){
        if(scanned==null){
            scanned = new HashSet<>();
        }
        if(node==null){
            scanned.add(this);
            node = new Node(this,null);
        }
        if(node.getUser()==other){
            roads.add(node);
            return;
        }
        while(!node.getUser().friends.isEmpty()){
            Node finalNode = node;
            Set<User> finalScanned = scanned;
            node.getUser().friends.forEach(t->{
                if(finalScanned.add(t)){
                    searchRoad(other,roads,new Node(t, finalNode), finalScanned);
                }
            });
        }
    }




    public static class Node{
        private User user;
        private Node parent;

        public Node(User user ,Node parent) {
            this.user = user;
            this.parent = parent;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }
}
