package org.lessons.java.events;

import java.util.ArrayList;
import java.util.List;

public class ProgrammaEventi {
    //attributi
    private String title;
    private List<Evento> eventi;

    //costruttore

    public ProgrammaEventi(String title) {
        this.title = title;
        this.eventi = new ArrayList<>();
    }

    //getter e setter

    //metodi
    public void addEvento(Evento evento) {
        eventi.add(evento);
    }

    public String printDateEvento() {
        String message = "";
        for (Evento evento : eventi) {
            message += evento.getData() + "\n";
        }
        return message;
    }

    public int getNumeroDate() {
        int quantity = eventi.size();
        return quantity;
    }

    public void deleteAllDate() {
        for (int i = 0; i < getNumeroDate(); i++) {
            eventi.remove(i);
        }
    }

}
