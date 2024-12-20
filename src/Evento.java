import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

    private String title;
    private LocalDate date;
    private int totalSeats;
    private int reservedSeats;

    public Evento(String title, int day, int month, int year, int totalSeats) throws IllegalArgumentException {
        LocalDate dateToday = LocalDate.now();
        if (day < 0 || day > 31 || month < 0 || month > 12 || year < 0) {
            throw new IllegalArgumentException("I valori della data inseriti non sono corretti");
        }
        this.date = LocalDate.of(year, month, day);
        if (dateToday.isAfter(this.date)) {
            throw new IllegalArgumentException("La data inserita è già passata, riprova");
        }
        if (totalSeats < 1) {
            throw new IllegalArgumentException("Il numero totale di posti è inferiore ad 1, riprova");
        }
        if (title.length() == 0) {
            throw new IllegalArgumentException("Il titolo inserito è vuoto");
        }
        this.title = title;
        this.totalSeats = totalSeats;
        this.reservedSeats = 0;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) throws IllegalArgumentException {
        if (title.length() == 0) {
            throw new IllegalArgumentException("Il titolo inserito è vuoto");
        }
        this.title = title;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(int day, int month, int year) throws IllegalArgumentException {
        if (day > 0 || day <= 31 || month > 0 || month <= 12 || year > 0) {
            throw new IllegalArgumentException("I valori della data inseriti non sono corretti");
        }
        this.date = LocalDate.of(year, month, day);
    }

    public int getTotalSeats() {
        return this.totalSeats;
    }

    public int getReservedSeats() {
        return this.reservedSeats;
    }

    public void addReservation(int numberUserBookings) throws IllegalArgumentException {
        LocalDate dateToday = LocalDate.now();
        if (this.totalSeats - this.reservedSeats < numberUserBookings || numberUserBookings < 0) {
            throw new IllegalArgumentException(
                    "Non è stato possibile aggiungere prenotazioni, il dato inserito non è valido");
        }
        if (dateToday.isAfter(this.date)) {
            throw new IllegalArgumentException("Non è stato possibile aggiungere prenotazioni, l'evento è già passato");
        }
        for (int i = 0; i < numberUserBookings; i++) {
            this.reservedSeats++;
        }
    }

    public void removeReservation(int numberCancelSeatUser) throws IllegalArgumentException {
        LocalDate dateToday = LocalDate.now();
        if (this.reservedSeats - numberCancelSeatUser < 0 || numberCancelSeatUser < 0) {
            throw new IllegalArgumentException(
                    "Non è stato possibile disdire, il dato inserito non è valido");
        }
        if (dateToday.isAfter(this.date)) {
            throw new IllegalArgumentException("Non è stato possibile disdire, l'evento è già passato");
        }
        for (int i = 0; i < numberCancelSeatUser; i++) {
            this.reservedSeats--;
        }
    }

    public int getSeatingAvailable() {
        return this.totalSeats - this.reservedSeats;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateString = this.date.format(formatter);
        return dateString + " - " + this.title;
    }

}
