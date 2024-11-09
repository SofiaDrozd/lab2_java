package touristfirm;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class Tour implements Comparable<Tour> {
    private String destination;
    private int duration;
    private double price;
    private LocalDate creationDate;  // Додаємо поле для дати створення туру

    // Конструктор для створення екземпляру туру
    public Tour(String destination, int duration, double price, LocalDate creationDate) {
        this.destination = destination;
        this.duration = duration;
        this.price = price;
        this.creationDate = creationDate;  // Ініціалізуємо дату створення
    }

    // Геттер для дати створення
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getDestination() {
        return destination;
    }

    public int getDuration() {
        return duration;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "destination='" + destination + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                ", creationDate=" + creationDate +  // Додаємо виведення дати створення
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tour)) return false;
        Tour tour = (Tour) o;
        return duration == tour.duration &&
                Double.compare(tour.price, price) == 0 &&
                Objects.equals(destination, tour.destination) &&
                Objects.equals(creationDate, tour.creationDate);  // Порівнюємо за датою створення
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, duration, price, creationDate);  // Додаємо дату створення до hashCode
    }

    // Comparable для сортування за цінною
    @Override
    public int compareTo(Tour other) {
        return Double.compare(this.price, other.price);
    }

    // Comparator для сортування за тривалістю
    public static Comparator<Tour> byDuration() {
        return Comparator.comparingInt(Tour::getDuration);
    }

    // Comparator для сортування за напрямком
    public static Comparator<Tour> byDestination() {
        return Comparator.comparing(Tour::getDestination);
    }

    // Comparator для сортування за датою створення
    public static Comparator<Tour> byCreationDate() {
        return Comparator.comparing(Tour::getCreationDate);
    }

    // Builder-клас для Tour
    public static class TourBuilder {
        private String destination;
        private int duration;
        private double price;
        private LocalDate creationDate = LocalDate.now();  // За замовчуванням дата - поточна

        public TourBuilder setDestination(String destination) {
            this.destination = destination;
            return this;
        }

        public TourBuilder setDuration(int duration) {
            this.duration = duration;
            return this;
        }

        public TourBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public TourBuilder setCreationDate(LocalDate creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public Tour build() {
            return new Tour(destination, duration, price, creationDate);
        }
    }
}
