package touristfirm;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TourService {

    // Сервісний метод для пошуку турів дешевше заданої ціни
    public List<Tour> findToursCheaperThan(List<Tour> tours, double maxPrice) {
        return tours.stream()
                .filter(tour -> tour.getPrice() < maxPrice)
                .collect(Collectors.toList());
    }

    // Сервісний метод для сортування турів за тривалістю
    public List<Tour> sortToursByDuration(List<Tour> tours) {
        return tours.stream()
                .sorted((tour1, tour2) -> Integer.compare(tour1.getDuration(), tour2.getDuration()))
                .collect(Collectors.toList());
    }

    // Сервісний метод для пошуку туру за назвою
    public Optional<Tour> findTourByName(List<Tour> tours, String name) {
        return tours.stream()
                .filter(tour -> tour.getDestination().equalsIgnoreCase(name))
                .findFirst();
    }

    // Сервісний метод для знаходження найдорожчого туру
    public Optional<Tour> findMostExpensiveTour(List<Tour> tours) {
        return tours.stream()
                .max((tour1, tour2) -> Double.compare(tour1.getPrice(), tour2.getPrice()));
    }

    // Сервісний метод для фільтрації турів за напрямком
    public List<Tour> filterByDestination(List<Tour> tours, String destination) {
        return tours.stream()
                .filter(tour -> tour.getDestination().equalsIgnoreCase(destination))
                .collect(Collectors.toList());
    }

    // за зростанням дати їх створення (від найстаріших до найновіших).
    public List<Tour> sortToursByCreationDate(List<Tour> tours) {
        return tours.stream()
                .sorted(Tour.byCreationDate())
                .collect(Collectors.toList());
    }

}
