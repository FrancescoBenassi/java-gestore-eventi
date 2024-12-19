import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Vuoi inserire un nuovo evento? Rispondi con 'true' o 'false'");
        boolean userEvent = Boolean.parseBoolean(input.nextLine());
        boolean trueEvent = true;
        Evento event;
        if (userEvent) {
            System.out.println("Inserisci il titolo dell'evento");
            String eventTitle = input.nextLine();
            System.out.println("Inserisci il giorno dell'evento");
            int dayEvent = Integer.parseInt(input.nextLine());
            System.out.println("Inserisci il mese dell'evento");
            int monthEvent = Integer.parseInt(input.nextLine());
            System.out.println("Inserisci l'anno dell'evento");
            int yearEvent = Integer.parseInt(input.nextLine());
            LocalDate dateEvent = LocalDate.of(yearEvent, monthEvent, dayEvent);
            if (dateEvent.isBefore(LocalDate.now())) {
                trueEvent = false;
                System.out.println("La data inserita è già passata");
            }
            System.out.println("Inserisci la quantità di posti a sedere");
            int totalSeats = Integer.parseInt(input.nextLine());
            event = new Evento(eventTitle, dayEvent, monthEvent, yearEvent, totalSeats);
            if (trueEvent) {
                System.out.println("Vuoi fare delle prenotazioni? Rispondi con 'true o 'false'");
                boolean userBookings = Boolean.parseBoolean(input.nextLine());
                if (userBookings) {
                    System.out.println("Quante prenotazioni vuoi fare? Puoi fare al massimo "
                            + event.getSeatingAvailable() + " prenotazioni");
                    int numberUserBookings = Integer.parseInt(input.nextLine());
                    event.addReservedSeat(numberUserBookings);
                }
                System.out.println("I posti prenotati sono " + event.getReservedSeats());
                System.out.println("I posti disponibili sono " + event.getSeatingAvailable());

                System.out.println("Vuoi disdire dei posti? Rispondi con 'true o 'false'");
                boolean cancelSeatUser = Boolean.parseBoolean(input.nextLine());
                if (cancelSeatUser) {
                    System.out.println("Quanti posti vuoi disdire? Puoi disdire al massimo " + event.getReservedSeats()
                            + " prenotazioni");
                    int numberCancelSeatUser = Integer.parseInt(input.nextLine());
                    event.removeReservedSeat(numberCancelSeatUser);
                }
                System.out.println("I posti prenotati sono " + event.getReservedSeats());
                System.out.println("I posti disponibili sono " + event.getSeatingAvailable());
            }
            System.out.println(event.toString());
        } else {
            System.out.println("Grazie e arrivederci");
        }
        input.close();
    }

}
