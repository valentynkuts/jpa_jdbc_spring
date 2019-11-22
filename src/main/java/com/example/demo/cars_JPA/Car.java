package com.example.demo.cars_JPA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
Utwórz klasę Car – ma ona mieć w sobie pola: make (marka samochodu) i registration.
Następnie utwórz interfejs CarRepository – dziedziczący po CrudRepository<Car, Long> – i przygotuj
w nim metody na wyciąganie obiektów z bazy po marce i po rejestracji.
Utwórz kontroler i utwórz w nim endpointy:
GET, który zwraca samochód po id
GET, który zwraca samochód po marce
GET, który zwraca samochód po rejestracji
POST, który dodaje samochód do bazy
PUT, który aktualizuje samochód w bazie
DELETE który kasuje samochód z bazy
 */
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String marka;
    private String registration;

    public Car() {
    }

    public Car(Long id, String marka, String registration) {
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
