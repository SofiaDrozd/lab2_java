package touristfirm;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class TourServiceTest {

    private final Tour tour1 = new Tour.TourBuilder().setDestination("Italy").setDuration(7).setPrice(1200.50).build();
    private final Tour tour2 = new Tour.TourBuilder().setDestination("France").setDuration(5).setPrice(900.00).build();
    private final Tour tour3 = new Tour.TourBuilder().setDestination("Italy").setDuration(10).setPrice(1500.00).build();

    private final TourService tourService = new TourService();

    @Test
    public void testFindMostExpensiveTour() {
        List<Tour> tours = Arrays.asList(tour1, tour2, tour3);
        Optional<Tour> result = tourService.findMostExpensiveTour(tours); // Повертається Optional<Tour>
        assertTrue(result.isPresent()); // Перевірка, чи є елемент в Optional
        assertEquals(tour3, result.get()); // Отримуємо об'єкт, якщо він присутній
    }

    @Test
    public void testSortByDuration() {
        List<Tour> tours = Arrays.asList(tour1, tour2, tour3);
        List<Tour> sortedTours = tourService.sortToursByDuration(tours);
        assertEquals(Arrays.asList(tour2, tour1, tour3), sortedTours);
    }

    @Test
    public void testFilterByDestination() {
        List<Tour> tours = Arrays.asList(tour1, tour2, tour3);
        List<Tour> filteredTours = tourService.filterByDestination(tours, "Italy");
        assertEquals(Arrays.asList(tour1, tour3), filteredTours);
    }
}
