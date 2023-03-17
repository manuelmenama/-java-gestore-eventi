package org.lessons.java.events;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProgrammaEventi{
    //attributi
    private String title;
    private List<Evento> eventi;

    //costruttore

    public ProgrammaEventi(String title) {
        this.title = title;
        this.eventi = new ArrayList<>();
    }

    //getter e setter


    public String getTitle() {
        return title;
    }

    public List<Evento> getEventi() {
        return eventi;
    }

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

    public void ordinaListaEventi() {
        Collections.sort(eventi, new Comparator<Evento>() {
            @Override
            public int compare(Evento o1, Evento o2) {
                return o1.getData().compareTo(o2.getData());
            }
        });
    }


}
