package touristfirm;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Використовуємо класи Tour і TouristFirm
        List<Tour> tourList = new ArrayList<>(Arrays.asList(
                new Tour("Europe Adventure", 10, 1500),
                new Tour("Asia Discovery", 15, 1200),
                new Tour("America Highlights", 7, 1800),
                new Tour("Africa Safari", 12, 1400)
        ));

        TouristFirm touristFirm = new TouristFirm(tourList);

        System.out.println("Тури дешевші за 1600:");
        List<Tour> cheapTours = touristFirm.findToursCheaperThan(1600);
        cheapTours.forEach(System.out::println);

        System.out.println("\nТури, відсортовані за тривалістю:");
        List<Tour> sortedToursByDuration = touristFirm.sortToursByDuration();
        sortedToursByDuration.forEach(System.out::println);

        System.out.println("\nПошук туру за назвою 'Asia Discovery':");
        touristFirm.findTourByName("Asia Discovery")
                .ifPresentOrElse(System.out::println, () -> System.out.println("Тур не знайдено"));

        System.out.println("\nВсі доступні тури:");
        touristFirm.printAllTours();
    }
}