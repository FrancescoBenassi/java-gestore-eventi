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
        }
        input.close();

    }
}
