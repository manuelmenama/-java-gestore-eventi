package org.lessons.java.events;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
    //attributi
    private static final int CAPIENZA_MINIMA = 1;
    private String titolo;
    private LocalDate data;
    private int capienzaMassima;
    private static int postiPrenotati;

    //costruttori

    public Evento(String titolo, LocalDate data, int capienzaMassima) throws IllegalArgumentException{
        this.titolo = titolo;
        verificaDataErrata(data);
        this.data = data;
        verificaCapienza(capienzaMassima);
        this.capienzaMassima = capienzaMassima;
        postiPrenotati = 0;
    }

    //getter e setter

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) throws IllegalArgumentException{
        verificaDataErrata(data);
        this.data = data;
    }

    public int getCapienzaMassima() {
        return capienzaMassima;
    }

    public static int getPostiPrenotati() {
        return postiPrenotati;
    }

    //metodi

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return "Evento{" +
                "titolo='" + titolo + '\'' +
                ", data=" + data.format(dateTimeFormatter) +
                ", capienzaMassima=" + capienzaMassima +
                ", postiPrenotati=" + postiPrenotati +
                '}';
    }

    private void verificaDataErrata(LocalDate data) throws IllegalArgumentException{
        if (LocalDate.now().isAfter(data)){
            throw new IllegalArgumentException("La data deve essere successiva a " + LocalDate.now() + ".");
        }
    }

    private void verificaCapienza(int capienza) throws IllegalArgumentException {
        if (capienza <= CAPIENZA_MINIMA) {
            throw new IllegalArgumentException("La capienza deve essere almeno di " + CAPIENZA_MINIMA + " posti.");
        }
    }

    public void prenota() throws RuntimeException, IllegalArgumentException{
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("L'evento si è tenuto il " + data + ". Non è possibile prenotare.");
        }
        if (postiPrenotati < capienzaMassima) {
            postiPrenotati++;
        } else {
            throw new RuntimeException("L'evento " + titolo + " è pieno.");
        }
    }

    public void disdici() throws RuntimeException, IllegalArgumentException {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("L'evento si è tenuto il " + data + ". Non è possibile prenotare.");
        }
        if (postiPrenotati <= 0) {
            throw new RuntimeException("Non c'è nessuna prenotazione per l'evento " + titolo + ".");
        } else {
            postiPrenotati--;
        }
    }
}
