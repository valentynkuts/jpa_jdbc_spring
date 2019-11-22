package com.example.demo.auto_JDBC;

import javax.persistence.*;

/*
Utwórz klasę Car – ma ona mieć w sobie pola: make (marka samochodu) i registration.
Niech klasa w której znajduje się main implementuje CommandLineRunner.
Następnie nadpisz (@Override) metodę run(), a w niej stwórz tabelę za pomocą JDBCTemplate
Utwórz kontroler i utwórz w nim endpointy:
GET, który zwraca samochód po id
GET, który zwraca samochód po marce
GET, który zwraca samochód po rejestracji
POST, który dodaje samochód do bazy
PUT, który aktualizuje samochód w bazie
DELETE który kasuje samochód z bazy
 */
@Entity
@Table(name = "auto")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String marka;
    private String registration;

    public Auto() {
    }

    public Auto(Long id, String marka, String registration) {
        this.id = id;
        this.marka = marka;
        this.registration = registration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }
}
