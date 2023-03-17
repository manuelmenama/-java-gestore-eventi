package org.lessons.java.events;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento{

    //attributi
    private LocalTime ora;
    private BigDecimal prezzo;

    //costruttori
    public Concerto(String titolo, LocalDate data, int capienzaMassima, LocalTime ora, BigDecimal prezzo) throws IllegalArgumentException {
        super(titolo, data, capienzaMassima);
        this.ora = ora;
        this.prezzo = prezzo;
    }
    //getter e setter

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    //metodo
    public String getPrezzoFormattato(BigDecimal prezzo) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00€");

        return decimalFormat.format(prezzo);
    }

    public String getOraFormattata(LocalTime ora) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH.mm");
        return ora.format(dateTimeFormatter);
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "titolo='" + getTitolo() + '\'' +
                ", data=" + getFormattaData(getData()) +
                ", ora=" + getOraFormattata(ora) +
                ", capienzaMassima=" + getCapienzaMassima() +
                ", postiPrenotati=" + getPostiPrenotati() +
                ", prezzo=" + getPrezzoFormattato(prezzo) +
                '}';
    }
}
