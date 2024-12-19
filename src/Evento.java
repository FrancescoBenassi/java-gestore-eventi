import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

    private String title;
    private LocalDate date;
    private int totalSeats;
    private int reservedSeats;

    public Evento(String title, int day, int month, int year, int totalSeats) {
        LocalDate dateToday = LocalDate.now();
        this.date = LocalDate.of(year, month, day);
        if (dateToday.isBefore(this.date) && totalSeats > 0) {
            this.title = title;
            this.totalSeats = totalSeats;
            this.reservedSeats = 0;
        } else if (dateToday.isAfter(this.date)) {
            System.out.println("La data inserita è già passata, riprova");
        } else if (totalSeats < 1) {
            System.out.println("Il numero totale di posti è inferiore ad 1, riprova");
        } else {
            System.out.println("La data inserita è già passata e il numero totale di posti è inferiore ad 1, riprova");
        }

    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(int day, int month, int year) {
        this.date = LocalDate.of(year, month, day);
    }

    public int getTotalSeats() {
        return this.totalSeats;
    }

    public int getReservedSeats() {
        return this.reservedSeats;
    }

    public void addReservedSeat(int numberUserBookings) {
        LocalDate dateToday = LocalDate.now();
        if (this.totalSeats - this.reservedSeats > numberUserBookings && dateToday.isBefore(this.date)) {
            this.reservedSeats++;
        } else if (this.totalSeats - this.reservedSeats < numberUserBookings) {
            System.out.println(
                    "Non è stato possibile aggiungere i posti, il numero di posti prenotati è superiore al numero di posti disponibili");
        } else {
            System.out.println("Non è stato possibile aggiungere un posto, l'evento è già passato");
        }
    }

    public void removeReservedSeat(int numberCancelSeatUser) {
        LocalDate dateToday = LocalDate.now();
        if (this.reservedSeats > numberCancelSeatUser && dateToday.isBefore(this.date)) {
            this.reservedSeats--;
        } else if (this.reservedSeats < numberCancelSeatUser) {
            System.out.println(
                    "Non è stato possibile disdire i posti, i posti disdetti sono maggiori di quelli prenotati");
        } else {
            System.out.println("Non è stato possibile rimuovere un posto, l'evento è già passato");
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
