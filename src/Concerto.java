import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
    private LocalTime time;
    private double price;

    public Concerto(String title, LocalDate dateEvent, int totalSeats, LocalTime timeEvent, double price)
            throws IllegalPriceException {
        super(title, dateEvent, totalSeats);
        // if (hours < 0 || hours >= 24 || minutes < 0 || minutes >= 60) {
        //     throw new IllegalValueTimeException("I dati inseriti non sono corretti per inserire l'orario");
        // }
        if (price < 0) {
            throw new IllegalPriceException("Il prezzo inserito è inferiore a 0");
        }
        this.time = timeEvent;
        this.price = price;
    }

    public LocalTime getTime() {
        return this.time;
    }

    public void setTime(int hours, int minutes) throws IllegalValueTimeException {
        if (hours < 0 || hours >= 24 || minutes < 0 || minutes >= 60) {
            throw new IllegalValueTimeException("I dati inseriti non sono corretti per cambiare l'orario");
        }
        this.time = LocalTime.of(hours, minutes);
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) throws IllegalPriceException {
        if (price < 0) {
            throw new IllegalPriceException("Il prezzo inserito è inferiore a 0");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        DateTimeFormatter hoursMinutes = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter yearMonthDay = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat twoPlaces = new DecimalFormat("0.00€");
        String dateString = super.getDate().format(yearMonthDay);
        String timeString = this.time.format(hoursMinutes);
        String priceString = twoPlaces.format(this.price);
        return dateString + " " + timeString + " - " + super.getTitle() + " - " + priceString;
    }

    public static void main(String[] args) {
        try {
            LocalDate dateEvent = LocalDate.of( 2025,  12,  28);
            LocalTime timeEvent = LocalTime.of(23, 10);
            Concerto concert = new Concerto("Noemi", dateEvent, 200, timeEvent, 50);
            System.out.println(concert.getPrice());
            System.out.println(concert.getReservedSeats());
            System.out.println(concert.getSeatingAvailable());
            System.out.println(concert.getTitle());
            System.out.println(concert.getDate());
            System.out.println(concert.getTime());
            System.out.println(concert.getClass());
            System.out.println(concert.toString());
        } catch (Exception e) {
            System.out.println("Hai sbagliato");
        }
        // Concerto concert = new Concerto("Noemi", 6, 3, 2025, 200, 12, 0, 50);
        // System.out.println(concert.getPrice());
        // System.out.println(concert.getReservedSeats());
        // System.out.println(concert.getSeatingAvailable());
        // System.out.println(concert.getTitle());
        // System.out.println(concert.getDate());
        // System.out.println(concert.getTime());
        // System.out.println(concert.getClass());
        // System.out.println(concert.toString());

    }
}
