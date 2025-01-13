import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Vuoi inserire un nuovo evento? Rispondi con 'true' o 'false'");
        boolean userEvent = Boolean.parseBoolean(input.nextLine());
        String eventTitle;
        int dayEvent;
        int monthEvent;
        int yearEvent;
        int totalSeats;
        Evento event;
        if (userEvent) {
            try {
                System.out.println("Inserisci il titolo dell'evento");
                eventTitle = input.nextLine();
                System.out.println("Inserisci il giorno dell'evento");
                dayEvent = Integer.parseInt(input.nextLine());
                System.out.println("Inserisci il mese dell'evento");
                monthEvent = Integer.parseInt(input.nextLine());
                System.out.println("Inserisci l'anno dell'evento");
                yearEvent = Integer.parseInt(input.nextLine());
                LocalDate dateEvent = LocalDate.of(yearEvent, monthEvent, dayEvent);
                System.out.println("Inserisci la quantità di posti a sedere");
                totalSeats = Integer.parseInt(input.nextLine());
                event = new Evento(eventTitle, dateEvent, totalSeats);
                System.out.println("Vuoi fare delle prenotazioni? Rispondi con 'true o 'false'");
                boolean userBookings = Boolean.parseBoolean(input.nextLine());
                if (userBookings) {
                    System.out.println("Quante prenotazioni vuoi fare? Puoi fare al massimo "
                            + event.getSeatingAvailable() + " prenotazioni");
                    int numberUserBookings = Integer.parseInt(input.nextLine());
                    event.addReservation(numberUserBookings);
                }
                System.out.println("I posti prenotati sono " + event.getReservedSeats());
                System.out.println("I posti disponibili sono " + event.getSeatingAvailable());
                System.out.println("Vuoi disdire dei posti? Rispondi con 'true o 'false'");
                boolean cancelSeatUser = Boolean.parseBoolean(input.nextLine());
                if (cancelSeatUser) {
                    System.out.println(
                            "Quanti posti vuoi disdire? Puoi disdire al massimo " + event.getReservedSeats()
                                    + " prenotazioni");
                    int numberCancelSeatUser = Integer.parseInt(input.nextLine());
                    event.removeReservation(numberCancelSeatUser);
                }
                System.out.println("I posti prenotati sono " + event.getReservedSeats());
                System.out.println("I posti disponibili sono " + event.getSeatingAvailable());
                System.out.println(event.toString());
            } catch (IllegalWordException wordException) {
                System.out.println("Il titolo dell'evento inserito non è corretto");
            } catch (IllegalDateException dateEventException) {
                System.out.println(
                        "I valori inseriti per la data dell'evento non sono corretti. I giorni devono rientrare tra 1 e 31 compreso, i mesi devono rientrare tra 1 e 12 compreso, e l'anno deve essere superiore/uguale a quello attuale");
            } catch (DateTimeException dateEventIsNotValid) {
                System.out.println("Il dato inserito non è corretto per quella data");
            } catch (IllegalNumberSeatsException numberSeatsException) {
                System.out.println("Il numero di posti a sedere per l'evento è inferiore a 1");
            } catch (NumberFormatException numberException) {
                System.out.println("Dove richiesto di inserire numeri devi inserire solamente numeri");
            } catch (IllegalDateIsBeforeException dateEventIsBeforeException) {
                System.out.println("La data inserita per l'evento è già passata, riprova");
            } catch (IllegalAddReservationException addReservationException) {
                System.out.println("Non è stato possibile aggiungere prenotazioni, il dato inserito non è valido");
            } catch (IllegalRemoveReservationException removeReservationException) {
                System.out.println("Non è stato possibile disdire, il dato inserito non è valido");
            } catch (IllegalArgumentException c) {
                System.out.println("Uno o più campi inseriti non sono corretti, riprova");
            }
        }
        input.close();

    }
}
