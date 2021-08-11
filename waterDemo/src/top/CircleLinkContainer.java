package top;

import java.util.LinkedList;
import java.util.List;

public class CircleLinkContainer {
    public CircleLinkContainer(){
        this.linkedTo = this;
    }

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

}
