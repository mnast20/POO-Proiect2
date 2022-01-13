package child.visitor;

import child.Baby;
import child.Kid;
import child.Teen;
import common.Constants;

public class ChildVisitor implements Visitor {
    /**
     * Method visiting and calculating the Baby's average nice score
     */
    @Override
    public void visit(final Baby baby) {
        // baby's average nice score is always set as 10
        baby.setAverageScore(Constants.MAXIMUM_SCORE);
    }

    /**
     * Method visiting and calculating the Kid's average nice score
     */
    @Override
    public void visit(final Kid kid) {
        Double averageScore = 0.0;
        Double numerator = 0.0;
        int size = kid.getNiceScoreHistory().size();

        // calculate arithmetic average score of the nice score history list
        for (Double niceScore: kid.getNiceScoreHistory()) {
            numerator += niceScore;
        }

        if (size != 0) {
            averageScore = numerator / size;
        }

        // add nice score bonus
        averageScore += averageScore * kid.getNiceScoreBonus() / Constants.HUNDRED;

        // check if nice score exceeds the maximum value and reduce it to 10
        if (averageScore > Constants.MAXIMUM_SCORE) {
            averageScore = Constants.MAXIMUM_SCORE;
        }

        kid.setAverageScore(averageScore);
    }

    /**
     * Method visiting and calculating the Teen's average nice score
     */
    @Override
    public void visit(final Teen teen) {
        Double i = 1.0;
        Double averageScore = 0.0;
        double numerator = 0.0;
        double denominator = 0.0;

        // calculate weighted average score of the nice score history list
        for (Double niceScore: teen.getNiceScoreHistory()) {
            numerator += niceScore * i;
            denominator += i;
            i += 1.0;
        }

        if (denominator != 0.0) {
            averageScore = numerator / denominator;
        }

        // add nice score bonus
        averageScore += averageScore * teen.getNiceScoreBonus() / Constants.HUNDRED;

        // check if nice score exceeds the maximum value and reduce it to 10
        if (averageScore > Constants.MAXIMUM_SCORE) {
            averageScore = Constants.MAXIMUM_SCORE;
        }

        teen.setAverageScore(averageScore);

    }
}
