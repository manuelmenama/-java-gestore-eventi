package org.lessons.java.events;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Evento evento = new Evento("De Bello Gallico", LocalDate.of(2024,1,1), 10000);

        System.out.println(evento.toString());
    }
}
