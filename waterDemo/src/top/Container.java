package top;

import java.util.HashSet;
import java.util.Set;

public class Container {

    public Container(){
        this.group = new Group(this);
    }

    private Group group;

    public double getWater(){
        return group.getGroupVolume();
    }

    public void addWater(double water){
        this.group.setGroupVolume(water/this.group.members.size()+this.group.getGroupVolume());
    }

    public void connectTo(Container other){
        if(this.group==other.group){
            return;
        }
        double allWater = this.group.getGroupVolume()*this.group.getMembers().size()+other.group.getGroupVolume()*other.group.getMembers().size();
        double avgWater = allWater/(this.group.getMembers().size()+other.group.getMembers().size());
        this.group.getMembers().addAll(other.getGroup().getMembers());
        this.group.setGroupVolume(avgWater);
        other.getGroup().getMembers().forEach(t->{
            t.setGroup(this.group);
        });
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public static class Group{
        private Set<Container> members;

        private double groupVolume;

        public Group(Container c){
            members = new HashSet<>();
            members.add(c);
        }

        public Set<Container> getMembers() {
            return members;
        }

        public void setMembers(Set<Container> members) {
            this.members = members;
        }

        public double getGroupVolume() {
            return groupVolume;
        }

        public void setGroupVolume(double groupVolume) {
            this.groupVolume = groupVolume;
        }
    }
}
