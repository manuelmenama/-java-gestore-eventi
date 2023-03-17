package org.lessons.java.events;

import java.time.LocalDate;

public class Evento {
    //attributi
    private String titolo;
    private LocalDate data;
    private int capienzaMassima;
    private static int postiPrenotati;

    //costruttori

    public Evento(String titolo, LocalDate data, int capienzaMassima) throws IllegalArgumentException{
        this.titolo = titolo;
        if (LocalDate.now().isAfter(data)){
            throw new IllegalArgumentException("La data deve essere successiva a " + LocalDate.now() + ".");
        }
        this.data = data;
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

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getCapienzaMassima() {
        return capienzaMassima;
    }

    public void setCapienzaMassima(int capienzaMassima) {
        this.capienzaMassima = capienzaMassima;
    }

    public static int getPostiPrenotati() {
        return postiPrenotati;
    }

    //metodi

    @Override
    public String toString() {
        return "Evento{" +
                "titolo='" + titolo + '\'' +
                ", data=" + data +
                ", capienzaMassima=" + capienzaMassima +
                '}';
    }
}
