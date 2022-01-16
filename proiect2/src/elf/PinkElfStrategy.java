package elf;

import child.Child;
import common.Constants;

public class PinkElfStrategy implements ElfStrategy {
    /**
     * Method executing the pink elf strategy, meaning the child will receive a 30% budget increase
     */
    public void execute(final Child child) {
        Double assignedBudget = child.getAssignedBudget();

        // increase budget with 30%
        assignedBudget = assignedBudget + assignedBudget * Constants.THIRTY / Constants.HUNDRED;
        child.setAssignedBudget(assignedBudget);
    }
}
