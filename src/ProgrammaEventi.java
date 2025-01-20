import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class ProgrammaEventi {
    private String title;
    private ArrayList<Evento> events;

    public ProgrammaEventi(String title) {
        this.title = title;
        this.events = new ArrayList<Evento>();
    }

    public String getTitle() {
        return this.title;
    }

    public void addEvent(Evento event) {
        this.events.add(event);
    }

    public ArrayList<Evento> getEventInDate(int day, int month, int year) {
        ArrayList<Evento> copyEvent = new ArrayList<Evento>();
        LocalDate date = LocalDate.of(year, month, day);
        for (Evento event : this.events) {
            if (event.getDate().equals(date)) {
                copyEvent.add(event);
            }
        }
        return copyEvent;
    }

    public int getMaxNumberEvent() {
        return this.events.size();
    }

    public void removeAllEvents() {
        this.events.removeAll(this.events);
    }

    public String getTitleAndDate() {
        this.events.sort(Comparator.comparing(event -> event.getDate()));
        // for (Evento event : this.events) {
        // System.out.println(event.getDate() + " - " + event.getTitle());
        // }
        return this.title + this.events;
    }

    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2028, 1, 12);
        LocalDate date2 = LocalDate.of(2050, 10, 2);
        LocalDate date3 = LocalDate.of(2027, 12, 28);
        LocalDate date4 = LocalDate.of(2027, 12, 28);
        Evento event1 = new Evento("Titolo1", date1, 200);
        Evento event2 = new Evento("Titolo2", date2, 200);
        Evento event3 = new Evento("Titolo4", date3, 200);
        Evento event4 = new Evento("Titolo5", date4, 200);
        ProgrammaEventi programmaEventi = new ProgrammaEventi("Titolo56");
        programmaEventi.addEvent(event1);
        programmaEventi.addEvent(event2);
        programmaEventi.addEvent(event3);
        programmaEventi.addEvent(event4);
        System.out.println("ciao");
        System.out.println(programmaEventi.getEventInDate(28, 12, 2027));
        System.out.println(programmaEventi.getTitleAndDate());
        System.out.println(programmaEventi.getMaxNumberEvent());
        System.out.println("Ciao");
        programmaEventi.removeAllEvents();
        System.out.println(programmaEventi.getTitleAndDate());
    }
}
