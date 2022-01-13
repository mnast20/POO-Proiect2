package elf;

import child.Child;
import common.Constants;

public class BlackElfStrategy implements ElfStrategy {
    /**
     * Method executing the black elf strategy, meaning the child will receive a 30% budget
     * decrease
     */
    public void execute(final Child child) {
        Double assignedBudget = child.getAssignedBudget();
        assignedBudget = assignedBudget - assignedBudget * Constants.THIRTY / Constants.HUNDRED;
        child.setAssignedBudget(assignedBudget);
    }
}
