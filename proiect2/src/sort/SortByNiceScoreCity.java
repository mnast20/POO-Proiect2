package sort;

import child.Child;
import child.ChildUtil;
import enums.Cities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SortByNiceScoreCity implements Sort {
    /**
     * Method sorting cities based on their average nice scores and returning all children,
     * ordered by their city's average nice score
     */
    public ArrayList<Child> sort() {
        ArrayList<Child> sortedChildrenByNiceScoreCities = new ArrayList<>();
        Map<Cities, ArrayList<Child>> cityChildrenMap = new HashMap<>();
        Map<Cities, Double> cityAverageScoreMap = new HashMap<>();
        ArrayList<Cities> cities = new ArrayList<>();

        for (Cities city: Cities.values()) {
            // get all children in city
            ArrayList<Child> childrenInCity = new ChildUtil().findChildrenInCity(city);

            if (childrenInCity.size() > 0) {
                // put list of children and city inside map
                cities.add(city);
                cityChildrenMap.put(city, childrenInCity);

                // calculate city's average score and put it inside map
                cityAverageScoreMap.put(city,
                        new ChildUtil().calculateAverageScoreChildren(childrenInCity));
            }
        }

        // sort cities based on average score and then name
        cities.sort((city1, city2) -> {
            // compare average scores
            int result = (-1) * Double.compare(cityAverageScoreMap.get(city1),
                    cityAverageScoreMap.get(city2));

            // compare names
            if (result == 0) {
                return city1.toString().compareTo(city2.toString());
            }

            return result;
        });

        // put children from the sorted cities inside a list
        for (Cities city: cities) {
            sortedChildrenByNiceScoreCities.addAll(cityChildrenMap.get(city));
        }

        return sortedChildrenByNiceScoreCities;
    }
}
