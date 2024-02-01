import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DoomedDiceChallengePartA {

    int numberOfDice;
    private static int numberOfFaces = 6;

    public DoomedDiceChallengePartA() {
        this.numberOfDice = 2;
    }

    public DoomedDiceChallengePartA(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public void calculateTotalNumberOfCombinations() {
        System.out.printf("Total number of combinations for %d Dice: %d\n",
                numberOfDice,
                getTotalNumberOfCombinations());
    }

    public void calculateDistributionsOfAllPossibleCombinations() {
        System.out.println("All Possible Combinations Are : ");
        List<String> combinations = new ArrayList<>();
        calculateAllPossibleCombinations(combinations, 0, "");
        for (String combination : combinations) {
            System.out.printf("[%s]\n", combination);
        }
    }

    public void calculateProbabilityOfAllSumsPossible() {
        Map<Integer, Integer> sumsMap = new TreeMap<>();
        calculateAllPossibleSums(sumsMap, 0, 0);
        int totalCombinations = getTotalNumberOfCombinations();
        System.out.println("Probability Of All Possible Sums Are : ");
        for (Map.Entry<Integer, Integer> entry : sumsMap.entrySet()) {
            System.out.printf("P(Sum = %d) = %d/%d\n", entry.getKey(), entry.getValue(), totalCombinations);
        }
    }

    private int getTotalNumberOfCombinations() {
        return (int) Math.pow(numberOfFaces, numberOfDice);
    }

    private void calculateAllPossibleCombinations(List<String> combinations, int index,
            String combination) {
        if (index == numberOfDice) {
            combinations.add(combination);
            return;
        }
        for (int i = 1; i <= numberOfFaces; i++) {
            calculateAllPossibleCombinations(combinations, index + 1,
                    combination + i + " ");
        }
    }

    private void calculateAllPossibleSums(Map<Integer, Integer> sumsMap, int index, int sum) {
        if (index == numberOfDice) {
            sumsMap.put(sum, sumsMap.getOrDefault(sum, 0) + 1);
            return;
        }
        for (int i = 1; i <= numberOfFaces; i++) {
            calculateAllPossibleSums(sumsMap, index + 1, sum + i);
        }
    }
}
