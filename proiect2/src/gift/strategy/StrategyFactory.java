package gift.strategy;

import enums.Strategy;

public class StrategyFactory {
    public static DistributeGiftsStrategy createStrategy (Strategy strategy) {
        return switch (strategy) {
            case ID_STRATEGY -> new IdStrategy();
            case NICE_SCORE_CHILDREN_STRATEGY -> new NiceScoreStrategy();
            case NICE_SCORE_CITIES_STRATEGY -> new NiceScoreCityStrategy();
        };
    }
}
