package top;

import java.util.LinkedList;
import java.util.List;

public class CircleLinkContainer {
    public CircleLinkContainer(){
        this.linkedTo = this;
    }

    private double water;

    private CircleLinkContainer linkedTo;

    public CircleLinkContainer getLinkedTo() {
        return linkedTo;
    }

    public void connectTo(CircleLinkContainer other){
        CircleLinkContainer u0 = this;
        CircleLinkContainer l0 = this.linkedTo;
        CircleLinkContainer u1 = other;
        CircleLinkContainer l1 = other.linkedTo;
        u0.linkedTo = l1;
        u1.linkedTo = l0;
    }

    public void addWater(double addWater){
        this.water+=addWater;
    }

    public double getAmount(){
        int count = 0;
        double sumWater = 0;
        CircleLinkContainer link = this.linkedTo;
        do {
            count++;
            sumWater += link.getWater();
            link = link.getLinkedTo();
        } while (link != this.linkedTo);
        double avgWater = sumWater / count;
        link = this.linkedTo;
        do {
            link.setWater(avgWater);
            link = link.getLinkedTo();
        } while (link != this.linkedTo);
        return avgWater;
    }

    public void setLinkedTo(CircleLinkContainer linkedTo) {
        this.linkedTo = linkedTo;
    }

    public List<CircleLinkContainer> getGroupContainers(){
        List<CircleLinkContainer> list = new LinkedList<>();
        list.add(this);
        for (CircleLinkContainer i = this.getLinkedTo(); i != this ; i = i.getLinkedTo()) {
            list.add(i);
        }
        return list;
    }

    public double getWater() {
        return water;
    }

    public void setWater(double water) {
        this.water = water;
    }
}
