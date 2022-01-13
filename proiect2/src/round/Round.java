package round;

import child.AnnualChildren;
import child.ChildUtil;
import database.SantaDatabase;
import enums.Strategy;
import gift.strategy.DistributeGiftsStrategy;
import gift.strategy.StrategyFactory;
import input.AnnualChange;
import output.Output;
import year.Year;

import java.util.ArrayList;

public final class Round {
    /**
     * Method executing a year round
     */
    public AnnualChildren executeRound(final AnnualChange annualChange) {
        DistributeGiftsStrategy strategy;
        if (annualChange == null) {
            // distribute gifts to children based on id strategy
            strategy = StrategyFactory.createStrategy(Strategy.ID_STRATEGY);
            // strategy = StrategyFactory.createStrategy(Strategy.NICE_SCORE_CHILDREN_STRATEGY);
        } else {
            // annual changes are requested and the round isn't the same as round0
            new Year().change(annualChange);
            // distribute gifts to children based on given strategy
            strategy = StrategyFactory.createStrategy(annualChange.getStrategy());
        }

        strategy.distributeGifts();
        // apply yellow elves' strategy for children with yellow children
        new ChildUtil().applyYellowElvesChildren(SantaDatabase.getSantaDatabase().getChildren());

        // add children to the annual children's list
        AnnualChildren annualChildren = new AnnualChildren();
        annualChildren.addChildrenList(SantaDatabase.getSantaDatabase().getChildren());

        // clear children's received gifts
        SantaDatabase.getSantaDatabase().clearAllReceivedGifts();

        return annualChildren;
    }

    /**
     * Method solving year rounds and creating the output
     */
    public Output solveRounds(final ArrayList<AnnualChange> annualChanges) {
        Output output = new Output();

        // execute round0
        AnnualChildren annualChildren = executeRound(null);
        // add the children from round0 to output
        output.addAnnualChildren(annualChildren);

        // execute new year rounds
        for (int i = 0; i < SantaDatabase.getSantaDatabase().getNumberOfYears(); i++) {
            if (i == 0) {
                int ok = 1;
            }
            AnnualChange annualChange = annualChanges.get(i);
            // execute new year round
            annualChildren = executeRound(annualChange);
            // add annual children to output
            output.addAnnualChildren(annualChildren);
        }

        return output;
    }
}
