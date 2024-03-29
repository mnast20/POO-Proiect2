package input;

import enums.Strategy;

import java.util.ArrayList;

public final class AnnualChange {
    private Double newSantaBudget;
    private ArrayList<GiftInput> newGifts;
    private ArrayList<ChildInput> newChildren;
    private ArrayList<ChildUpdate> childrenUpdates;
    private Strategy strategy;

    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public ArrayList<GiftInput> getNewGifts() {
        return newGifts;
    }

    public ArrayList<ChildInput> getNewChildren() {
        return newChildren;
    }

    public ArrayList<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setNewSantaBudget(final Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public void setNewGifts(final ArrayList<GiftInput> newGifts) {
        this.newGifts = newGifts;
    }

    public void setNewChildren(final ArrayList<ChildInput> newChildren) {
        this.newChildren = newChildren;
    }

    public void setChildrenUpdates(final ArrayList<ChildUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    public void setStrategy(final Strategy strategy) {
        this.strategy = strategy;
    }
}
