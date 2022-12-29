
package enterprise;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CarPlate Class Tests")
class CarPlateTest {

    static CarPlate carPlate = new CarPlate();
    public static final String CAR_PLATES_REGEX = "[A-Z]{3}[0-9]{3}";
    static List<String> carsPlates;
    public static final String EXISTED_CAR_PLATE = "ABC123";
    public static final String EXISTED_FIRST_SORTED_CAR_PLATE = "AAA111";
    public static final String NOT_CAR_PLATE = "000AAA";
    public static final List<String> PLATES = List.of(
            EXISTED_CAR_PLATE, EXISTED_FIRST_SORTED_CAR_PLATE,
            "BBВ555", "РUV678", "НIJ456", "ОPQ789", "ТUV000");

    @BeforeAll
    static void setUp() {

        carsPlates = carPlate.generatePlates();
    }

    private String getRandomCarNumber() {

        return carsPlates.get(new Random().nextInt(carsPlates.size()));
    }

    @Test
    @DisplayName("List size bigger than 10 millions")
    void coolNumbersSizeTest() {

        System.out.println("List size:" + carsPlates.size());
        assertTrue(carsPlates.size() >= 10_000_000,
                "Plates must be more than 10 millions");
    }

    @Test
    @DisplayName("Plates list format: ABC123")
    void coolNumbersFormatTest() {

        assertTrue(carsPlates.size() > 0,
                "List is empty!");

        for (int i = 0; i < 10; i++) {
            assertTrue(getRandomCarNumber().matches(CAR_PLATES_REGEX));
        }
    }

    @Test
    @DisplayName("Brute force search: plate exists in list")
    void bruteForceSearchFound() {

        List<String> list = new ArrayList<>(PLATES);
        assertTrue(carPlate.bruteForceSearchInList(list, EXISTED_CAR_PLATE),
                "Plate exists in list, but not found by brute force search method");
    }

    @Test
    @DisplayName("Brute force search: plate doesn't exists in list")
    void bruteForceSearchNotFound() {

        List<String> list = new ArrayList<>(PLATES);
        assertFalse(carPlate.bruteForceSearchInList(list, NOT_CAR_PLATE),
                "Plate doesn't exists in list, but brute force search method found it");
    }

    @Test
    @DisplayName("Binary search: plate exists in list")
    void binarySearchFound() {

        List<String> list = PLATES.stream()
                .sorted()
                .collect(Collectors.toList());

        assertTrue(carPlate.binarySearchInList(list, EXISTED_FIRST_SORTED_CAR_PLATE),
                "Plate exists in list, but not found by binary search method");
    }

    @Test
    @DisplayName("Binary search: plate doesn't exists in list")
    void binarySearchNotFound() {

        List<String> list = PLATES.stream()
                .sorted()
                .collect(Collectors.toList());

        assertFalse(carPlate.binarySearchInList(list, NOT_CAR_PLATE),
                "Plate doesn't exists in list, but binary search method found it");
    }

    @Test
    @DisplayName("HashSet search: plate exists in list")
    void hashSetSearchFound() {

        HashSet<String> set = new HashSet<>(PLATES);
        assertTrue(carPlate.searchInHashSet(set, EXISTED_CAR_PLATE),
                "Plate exists in list, but not found by HashSet search method");
    }

    @Test
    @DisplayName("HashSet search: plate doesn't exists in list")
    void hashSetSearchNotFound() {

        HashSet<String> set = new HashSet<>(PLATES);
        assertFalse(carPlate.searchInHashSet(set, NOT_CAR_PLATE),
                "Plate doesn't exists in list, but HashSet search method found it");
    }

    @Test
    @DisplayName("TreeSet search: plate exists in list")
    void treeSetSearchFound() {

        TreeSet<String> set = new TreeSet<>(PLATES);
        assertTrue(carPlate.searchInTreeSet(set, EXISTED_CAR_PLATE),
                "Plate exists in list, but not found by TreeSet search method");
    }

    @Test
    @DisplayName("TreeSet search: plate doesn't exists in list")
    void treeSetSearchNotFound() {

        TreeSet<String> set = new TreeSet<>(PLATES);
        assertFalse(carPlate.searchInTreeSet(set, NOT_CAR_PLATE),
                "Plate doesn't exists in list, but TreeSet search method found it");
    }
}
