package org.lessons.java.events;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Evento{
    //attributi
    private static final int CAPIENZA_MINIMA = 1;
    private String titolo;
    private LocalDate data;
    private int capienzaMassima;
    private int postiPrenotati;

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

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    //metodi
    public String getFormattaData(LocalDate data) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormattata = data.format(dateTimeFormatter);
        return dataFormattata;
    }
    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return "Evento{" +
                "titolo='" + titolo + '\'' +
                ", data=" + getFormattaData(data) +
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

    public int getPostiDisponibili() {
        return getCapienzaMassima() - getPostiPrenotati();
    }

    public boolean verificaPrenotazione(int prenotazioniDisdetteRichieste) {
        return prenotazioniDisdetteRichieste <= (getPostiDisponibili());
    }

    public boolean verificaDisdette(int disdette) {
        return getPostiPrenotati() >= disdette;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evento evento)) return false;

        if (capienzaMassima != evento.capienzaMassima) return false;
        if (postiPrenotati != evento.postiPrenotati) return false;
        if (!Objects.equals(titolo, evento.titolo)) return false;
        return Objects.equals(data, evento.data);
    }

    @Override
    public int hashCode() {
        int result = titolo != null ? titolo.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + capienzaMassima;
        result = 31 * result + postiPrenotati;
        return result;
    }
}
