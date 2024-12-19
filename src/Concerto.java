import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
    LocalTime time;
    double price;

    public Concerto(String title, int day, int month, int year, int totalSeats, int hours, int minutes, double price) {
        super(title, day, month, year, totalSeats);
        this.time = LocalTime.of(hours, minutes);
        this.price = price;
    }

    public LocalTime getTime() {
        return this.time;
    }

    public void setTime(int hours, int minutes) {
        if(hours >= 0 && hours < 12 && minutes >= 0 && minutes < 60){
        this.time = LocalTime.of(hours, minutes);
        } else { 
            System.out.println("I dati inseriti non sono corretti per cambiare l'orario");
        }
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if(price > 0){
            this.price = price;
        } else {
            System.out.println("Il prezzo inserito è inferiore a 0");
        }
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
}
