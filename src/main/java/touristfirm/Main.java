package touristfirm;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Створення турів з різними датами
        List<Tour> tourList = new ArrayList<>(Arrays.asList(
                new Tour("Europe Adventure", 10, 1500, LocalDate.of(2022, 5, 10)),
                new Tour("Asia Discovery", 15, 1200, LocalDate.of(2023, 6, 15)),
                new Tour("America Highlights", 7, 1800, LocalDate.of(2021, 11, 20)),
                new Tour("Africa Safari", 12, 1400, LocalDate.of(2022, 8, 25))
        ));

        // Дата заснування фірми
        LocalDate foundationDate = LocalDate.of(2000, 1, 1);

        // Створюємо об'єкт туристичної фірми
        TouristFirm touristFirm = new TouristFirm("Global Tours", foundationDate, tourList);

        // Створюємо об'єкт для сервісних методів
        TourService tourService = new TourService();

        // Виведення турів, відсортованих за датою створення
        System.out.println("Тури, відсортовані за датою створення:");
        List<Tour> sortedByCreationDate = tourService.sortToursByCreationDate(tourList);
        sortedByCreationDate.forEach(System.out::println);
    }
}
