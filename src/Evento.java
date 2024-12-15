import java.util.Date;

public class Evento {

    private String titolo;
    private Date date;
    private int totalSeats;
    private int reservedSeats;

    public Evento(String titolo, Date date, int totalSeats) {
        long today = System.currentTimeMillis();
        Date dateToday = new Date(today);
        if (dateToday.before(date) && totalSeats > 0) {
            this.titolo = titolo;
            this.totalSeats = totalSeats;
            this.reservedSeats = 0;
            this.date = date;
        } else if (totalSeats > 0) {
            System.out.println("La data inserita è già passata, riprova");
        } else if (dateToday.before(date)) {
            System.out.println("Il numero totale di posti è inferiore ad 1, riprova");
        } else {
            System.out.println("La data inserita è già passata e il numero totale di posti è inferiore ad 1, riprova");
        }

    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Date getDate() {
        return this.date;
    }

    public int getTotalSeats() {
        return this.totalSeats;
    }

    public int getReservedSeats() {
        return this.reservedSeats;
    }

    public void addReservedSeat() {
        long today = System.currentTimeMillis();
        Date dateToday = new Date(today);
        if (this.totalSeats > this.reservedSeats && dateToday.before(date)) {
            this.reservedSeats++;
        } else if (this.totalSeats > this.reservedSeats){
            System.out.println("Non è stato possibile aggiungere un posto, non ci sono più posti disponibili");
        }
        else {
            System.out.println("Non è stato possibile aggiungere un posto, l'evento è già passato");
        }
    }

    public void removeReservedSeat() {
        long today = System.currentTimeMillis();
        Date dateToday = new Date(today);
        if (this.reservedSeats > 0 && dateToday.before(date)) {
            this.reservedSeats--;
        } else if (this.reservedSeats > 0){
            System.out.println("Non è stato possibile rimuovere un posto, non ci sono più posti da rimuovere");
        } else{
            System.out.println("Non è stato possibile rimuovere un posto, l'evento è già passato");
        }
    }

}
