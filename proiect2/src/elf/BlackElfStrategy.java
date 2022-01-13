package elf;

import child.Child;

public class BlackElfStrategy implements ElfStrategy {
    public void execute(Child child) {
        Double assignedBudget = child.getAssignedBudget();
        assignedBudget = assignedBudget - assignedBudget * 30 / 100;
        child.setAssignedBudget(assignedBudget);
    }
}
