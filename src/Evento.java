public class Evento {

    private String titolo;
    private String date;
    private int totalSeats;
    private int reservedSeats;

    public Evento(String titolo, String date, int totalSeats){
        this.titolo = titolo;
        this.date = date;
        this.totalSeats = totalSeats;
        this.reservedSeats = 0;
    }
}
