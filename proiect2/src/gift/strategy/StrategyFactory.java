package gift.strategy;

import enums.Strategy;

public final class StrategyFactory {
    private StrategyFactory() {
    }

    /**
     * Method creating strategy based on a given type
     */
    public static DistributeGiftsStrategy createStrategy(final Strategy strategy) {
        return switch (strategy) {
            case ID_STRATEGY -> new IdStrategy();
            case NICE_SCORE_CHILDREN_STRATEGY -> new NiceScoreStrategy();
            case NICE_SCORE_CITIES_STRATEGY -> new NiceScoreCityStrategy();
        };
    }
}
