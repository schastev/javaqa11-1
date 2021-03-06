package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@NoArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieItem {
    private int id;
    private String name;
    private String cover;
    private String genre;
    private boolean premiereTomorrow;


    public MovieItem(String name) {
        this.name = name;
    }
}


