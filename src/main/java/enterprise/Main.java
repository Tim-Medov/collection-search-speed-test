
package enterprise;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        CarPlate carPlate = new CarPlate();
        List<String> plates = carPlate.generatePlates();

        String coolPlateToSearch = "VIP777";
        String foundPlate;

        System.out.println("\nFind a COOL car plate \"" + coolPlateToSearch + "\" in the collections:\n");

        // brute-force search in sorted List --------------------------------------------------------------------------

        long startBruteForceTime = System.currentTimeMillis();

        boolean bruteForceSearch =
                carPlate.bruteForceSearchInList(plates, coolPlateToSearch);

        if (bruteForceSearch) {

            foundPlate = "Plate " + coolPlateToSearch + " is found";

        } else {

            foundPlate = "The plate " + coolPlateToSearch + " is not found";

        }

        long finishBruteForceTime = System.currentTimeMillis() - startBruteForceTime;

        System.out.println("Brute force search in sorted List: " + foundPlate +
                ", the search took " + finishBruteForceTime + " milliseconds");

        // binary search in sorted List -------------------------------------------------------------------------------

        long startBinarySearchTime = System.currentTimeMillis();

        boolean binarySearch =
                carPlate.binarySearchInList(plates, coolPlateToSearch);

        if (binarySearch) {

            foundPlate = "Plate " + coolPlateToSearch + " is found";

        } else {

            foundPlate = "The plate " + coolPlateToSearch + " is not found";

        }

        long finishBinarySearchTime = System.currentTimeMillis() - startBinarySearchTime;

        System.out.println("Binary search in sorted List: " + foundPlate +
                ", the search took " + finishBinarySearchTime + " milliseconds");

        // search in HashSet ------------------------------------------------------------------------------------------

        HashSet<String> platesHashSet = new HashSet<>(plates);

        long startHashSetSearchTime = System.currentTimeMillis();

        boolean hashSetSearch =
                carPlate.searchInHashSet(platesHashSet, coolPlateToSearch);

        if (hashSetSearch) {

            foundPlate = "Plate " + coolPlateToSearch + " is found";

        } else {

            foundPlate = "The plate " + coolPlateToSearch + " is not found";

        }

        long finishHashSetSearchTime = System.currentTimeMillis() - startHashSetSearchTime;

        System.out.println("Search in HashSet: " + foundPlate +
                ", the search took " + finishHashSetSearchTime + " milliseconds");

        // search in TreeSet ------------------------------------------------------------------------------------------

        TreeSet<String> platesTreeSet = new TreeSet<>(plates);

        long startTreeSetSearchTime = System.currentTimeMillis();

        boolean treeSetSearch =
                carPlate.searchInTreeSet(platesTreeSet, coolPlateToSearch);

        if (treeSetSearch) {

            foundPlate = "Plate " + coolPlateToSearch + " is found";

        } else {

            foundPlate = "The plate " + coolPlateToSearch + " is not found";

        }

        long finishTreeSetSearchTime = System.currentTimeMillis() - startTreeSetSearchTime;

        System.out.println("Search in TreeSet: " + foundPlate +
                ", the search took " + finishTreeSetSearchTime + " milliseconds");

        // search in HashMap ------------------------------------------------------------------------------------------

        HashMap<Integer, String> platesHashMap = new HashMap<>();

        for (int i = 0; i < plates.size(); i++) {

            platesHashMap.put(i, plates.get(i));

        }

        long startHashMapSearchTime = System.currentTimeMillis();

        boolean hashMapSearch =
                carPlate.searchInHashMap(platesHashMap, coolPlateToSearch);

        if (hashMapSearch) {

            foundPlate = "Plate " + coolPlateToSearch + " is found";

        } else {

            foundPlate = "The plate " + coolPlateToSearch + " is not found";

        }

        long finishHashMapSearchTime = System.currentTimeMillis() - startHashMapSearchTime;

        System.out.println("Search in HashMap: " + foundPlate +
                ", the search took " + finishHashMapSearchTime + " milliseconds");

        // search in TreeMap ------------------------------------------------------------------------------------------

        TreeMap<Integer, String> platesTreeMap = new TreeMap<>();

        for (int i = 0; i < plates.size(); i++) {

            platesTreeMap.put(i, plates.get(i));

        }

        long startTreeMapSearchTime = System.currentTimeMillis();

        boolean treeMapSearch =
                carPlate.searchInTreeMap(platesTreeMap, coolPlateToSearch);

        if (treeMapSearch) {

            foundPlate = "Plate " + coolPlateToSearch + " is found";

        } else {

            foundPlate = "The plate " + coolPlateToSearch + " is not found";

        }

        long finishTreeMapSearchTime = System.currentTimeMillis() - startTreeMapSearchTime;

        System.out.println("Search in TreeMap: " + foundPlate +
                ", the search took " + finishTreeMapSearchTime + " milliseconds");
    }
}
