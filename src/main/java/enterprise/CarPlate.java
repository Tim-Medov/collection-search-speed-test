
package enterprise;

import java.util.*;

public class CarPlate {

    public List<String> generatePlates() {

        List<String> lettersList = new ArrayList<>();
        List<String> platesList = new ArrayList<>();
        List<Character> allowedLetters = new ArrayList<>() {{
            add('A');
            add('B');
            add('C');
            add('D');
            add('E');
            add('F');
            add('G');
            add('H');
            add('I');
            add('J');
            add('K');
            add('L');
            add('M');
            add('N');
            add('O');
            add('P');
            add('Q');
            add('R');
            add('S');
            add('T');
            add('U');
            add('V');
            add('W');
            add('X');
            add('Y');
            add('Z');
        }};

        String plateLetters;
        String plateNumbers;

        char x;
        char y;
        char z;

        for (Character firstLetter : allowedLetters) {

            x = firstLetter;

            for (Character secondLetter : allowedLetters) {

                y = secondLetter;

                for (Character thirdLetter : allowedLetters) {

                    z = thirdLetter;

                    plateLetters = String.format("%c%c%c", x, y, z);

                    lettersList.add(plateLetters);
                }
            }
        }

        for (String item : lettersList) {

            for (int i = 0; i <= 999; i++) {

                if (i < 10) {

                    plateNumbers = String.format("%s00%d", item, i);

                } else if (i < 100) {

                    plateNumbers = String.format("%s0%d", item, i);

                } else {

                    plateNumbers = String.format("%s%d", item, i);

                }

                platesList.add(plateNumbers);
            }
        }

        return platesList;
    }

    public boolean bruteForceSearchInList(List<String> platesList, String coolPlate) {

        Collections.sort(platesList);

        return platesList.contains(coolPlate);
    }

    public boolean binarySearchInList(List<String> platesList, String coolPlate) {

        Collections.sort(platesList);

        int plateIndex = Collections.binarySearch(platesList, coolPlate);
        boolean result;
        result = plateIndex >= 0;

        return result;
    }

    public boolean searchInHashSet(HashSet<String> platesHashSet, String coolPlate) {
        return platesHashSet.contains(coolPlate);
    }

    public boolean searchInTreeSet(TreeSet<String> platesTreeSet, String coolPlate) {
        return platesTreeSet.contains(coolPlate);
    }

    public boolean searchInHashMap(HashMap<Integer, String> platesHashMap, String coolPlate) {
        return platesHashMap.containsValue(coolPlate);
    }

    public boolean searchInTreeMap(TreeMap<Integer, String> platesTreeMap, String coolPlate) {
        return platesTreeMap.containsValue(coolPlate);
    }
}
