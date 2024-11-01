package touristfirm;

import java.util.Objects;

public class Tour implements Comparable<Tour> {
    private String name;
    private int duration; // тривалість туру в днях
    private double price;  // ціна туру

    public Tour(String name, int duration, double price) {
        this.name = name;
        this.duration = duration;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Tour{name='%s', duration=%d, price=%.2f}", name, duration, price);
    }

    @Override
    public int compareTo(Tour other) {
        return Double.compare(this.price, other.price); // Сортування за ціною
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Tour)) return false;
        Tour other = (Tour) obj;
        return duration == other.duration &&
                Double.compare(other.price, price) == 0 &&
                Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration, price);
    }

}