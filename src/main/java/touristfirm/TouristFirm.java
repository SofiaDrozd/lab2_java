package touristfirm;

import java.util.*;
import java.util.stream.Collectors;

public class TouristFirm {
    private List<Tour> tours;

    public TouristFirm(List<Tour> tours) {
        this.tours = tours;
    }

    // Сервісний метод для пошуку турів дешевше заданої ціни
    public List<Tour> findToursCheaperThan(double maxPrice) {
        return tours.stream()
                .filter(tour -> tour.getPrice() < maxPrice)
                .collect(Collectors.toList());
    }

    // Сервісний метод для сортування турів за тривалістю
    public List<Tour> sortToursByDuration() {
        return tours.stream()
                .sorted(Comparator.comparingInt(Tour::getDuration))
                .collect(Collectors.toList());
    }

    // Сервісний метод для пошуку туру за назвою
    public Optional<Tour> findTourByName(String name) {
        return tours.stream()
                .filter(tour -> tour.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    // Виведення всіх турів
    public void printAllTours() {
        tours.forEach(System.out::println);
    }
}
