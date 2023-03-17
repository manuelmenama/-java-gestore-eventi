package org.lessons.java.events;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci un nuovo evento!");
        System.out.print("Titolo: ");
        String titolo = scanner.nextLine();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("Data (dd/mm/yyyy): ");
        LocalDate data = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);

        System.out.print("Capienza massima: ");
        int capienzaMassima = Integer.parseInt(scanner.nextLine());

        Evento evento = new Evento(titolo, data, capienzaMassima);

        System.out.println(evento.toString());

        boolean stopPrenotazione = false;
        int prenotazioni = 0;

        while (!stopPrenotazione) {

            System.out.println("Sono disponibili " + evento.getPostiDisponibili() + " posti.");
            System.out.print("Posti da prenotare: ");
            prenotazioni = Integer.parseInt(scanner.nextLine());

            if (evento.verificaPrenotazione(prenotazioni)) {
                System.out.println("Posti disponibili e prenotati.");
                eseguiPrenotazioni(evento, prenotazioni);
                stopPrenotazione = true;
            } else {
                System.out.println("Stai tentando di prenotare troppi posti.");
                System.out.print("Vuoi inserire una nuova quantita (1) o uscire (2)? ");
                stopPrenotazione = scanner.nextLine().equalsIgnoreCase("2");
            }
        }




        //disdette
        boolean stopDisdetta = false;
        int disdette = 0;
        while (!stopDisdetta) {
            System.out.println("Posti prenotati complessivi: " + evento.getPostiPrenotati());
            System.out.print("Vuoi disdire alcuni posti (s/n)? ");
            String choise = scanner.nextLine();
            switch (choise) {
                case "s":
                    //caso disdette
                    System.out.print("Posti da disdire: ");
                    disdette = Integer.parseInt(scanner.nextLine());
                    if (evento.verificaDisdette(disdette)){
                        System.out.println("N. " + disdette + " posti disdetti con successo.");
                        eseguiDisdetta(evento, disdette);
                        stopDisdetta = true;
                    } else {
                        System.out.println("Stai tentando di disdire troppi posti.");
                        System.out.print("Vuoi inserire una nuova quantita (1) o uscire (2)? ");
                        stopDisdetta = scanner.nextLine().equalsIgnoreCase("2");
                    }
                    break;
                case "n":
                    //caso negativo
                    stopDisdetta = true;
                    break;
                default:
                    //caso errore
                    System.out.println("Tasto errato. Riprova.");
                    break;
            }
        }

        //posti prenotati e disponibili
        System.out.println("Posti prenotati complessivi: " + evento.getPostiPrenotati());
        System.out.println("Posti disponibili: " + evento.getPostiDisponibili());

        scanner.close();
    }

    public static void eseguiPrenotazioni(Evento evento, int prenotazioni) {
        for (int i = 0; i < prenotazioni; i++){

            try {
                evento.prenota();
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void eseguiDisdetta(Evento evento, int disdette){
        for (int i = 0; i < disdette; i++){
            try {
                evento.disdici();
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
