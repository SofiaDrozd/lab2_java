package touristfirm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TouristFirm {
    private String name;                   // Назва фірми
    private LocalDate registrationDate;    // Дата реєстрації фірми
    private List<Tour> tours;              // Список турів

    // Конструктор з трьома параметрами: назва фірми, дата заснування та список турів
    public TouristFirm(String name, LocalDate registrationDate, List<Tour> tours) {
        this.name = name;
        this.registrationDate = registrationDate;
        this.tours = tours;
    }

    // Конструктор з двома параметрами: назва фірми та дата заснування
    public TouristFirm(String name, LocalDate registrationDate) {
        this(name, registrationDate, new ArrayList<>()); // Ініціалізація пустого списку турів
    }

    // Конструктор з одним параметром: назва фірми
    public TouristFirm(String name) {
        this(name, LocalDate.now()); // Використовуємо поточну дату за замовчуванням
    }

    // Сеттер для дати заснування фірми
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    // Додає тур до списку
    public void addTour(Tour tour) {
        tours.add(tour);
    }

    // Геттер для списку турів
    public List<Tour> getTours() {
        return tours;
    }

    // Виведення основної інформації про туристичну фірму
    @Override
    public String toString() {
        return "TouristFirm{" +
                "name='" + name + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }

    // Виведення повної інформації про фірму та тури
    public String fullInfo() {
        return "TouristFirm{" +
                "name='" + name + '\'' +
                ", registrationDate=" + registrationDate +
                ", tours=" + tours +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TouristFirm)) return false;
        TouristFirm that = (TouristFirm) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(registrationDate, that.registrationDate) &&
                Objects.equals(tours, that.tours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, registrationDate, tours);
    }
}
