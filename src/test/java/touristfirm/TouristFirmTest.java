package touristfirm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TouristFirmTest {

    private TouristFirm touristFirm;
    private List<Tour> tours;

    @BeforeEach
    void setUp() {
        tours = new ArrayList<>(Arrays.asList(
                new Tour("Europe Adventure", 10, 1500),
                new Tour("Asia Discovery", 15, 1200),
                new Tour("America Highlights", 7, 1800),
                new Tour("Africa Safari", 12, 1400)
        ));
        touristFirm = new TouristFirm(tours);
    }

    @Test
    void testFindToursCheaperThan() {
        System.out.println("Running testFindToursCheaperThan");
        List<Tour> cheapTours = touristFirm.findToursCheaperThan(1600);

        System.out.println("Found cheap tours:");
        cheapTours.forEach(System.out::println);

        assertEquals(3, cheapTours.size(), "Кількість турів дешевших за 1600 має дорівнювати 3");
        assertTrue(cheapTours.contains(new Tour("Asia Discovery", 15, 1200)));
        assertTrue(cheapTours.contains(new Tour("Africa Safari", 12, 1400)));
    }

    @Test
    void testSortToursByDuration() {
        System.out.println("Running testSortToursByDuration");
        List<Tour> sortedTours = touristFirm.sortToursByDuration();

        System.out.println("Sorted tours by duration:");
        sortedTours.forEach(System.out::println);

        assertEquals(4, sortedTours.size(), "Кількість турів після сортування має залишитись такою ж");
        assertEquals("America Highlights", sortedTours.get(0).getName(), "Тур з найменшою тривалістю має бути першим");
        assertEquals("Asia Discovery", sortedTours.get(3).getName(), "Тур з найбільшою тривалістю має бути останнім");
    }

    @Test
    void testFindTourByName() {
        System.out.println("Running testFindTourByName");
        Optional<Tour> foundTour = touristFirm.findTourByName("Asia Discovery");

        if (foundTour.isPresent()) {
            System.out.println("Found tour: " + foundTour.get());
        } else {
            System.out.println("Tour not found");
        }

        assertTrue(foundTour.isPresent(), "Тур з назвою 'Asia Discovery' має бути знайдено");
        assertEquals("Asia Discovery", foundTour.get().getName(), "Назва знайденого туру має відповідати запиту");

        Optional<Tour> notFoundTour = touristFirm.findTourByName("Non-existent Tour");
        assertFalse(notFoundTour.isPresent(), "Неіснуючий тур не повинен бути знайдений");
    }

    @Test
    void testTourComparableByPrice() {
        System.out.println("Running testTourComparableByPrice");
        List<Tour> sortedTours = new ArrayList<>(tours);
        sortedTours.sort(Tour::compareTo);  // Сортування за ціною через Comparable

        System.out.println("Tours sorted by price:");
        sortedTours.forEach(System.out::println);

        assertEquals("Asia Discovery", sortedTours.get(0).getName(), "Тур з найнижчою ціною має бути першим");
        assertEquals("America Highlights", sortedTours.get(3).getName(), "Тур з найвищою ціною має бути останнім");
    }
}