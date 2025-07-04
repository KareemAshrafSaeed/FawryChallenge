package model;

import java.time.LocalDate;

public interface Expirable {
    public LocalDate getExpirationDate();
    default boolean isExpired(LocalDate date) {
        return date.isAfter(getExpirationDate());
    }

}
