package ru.netology.manager;

import ru.netology.domain.MovieItem;

public class MovieManager {
    private MovieItem[] movies = new MovieItem[0];
    int maxNumber = 10;

    public void add(MovieItem movie) {
        MovieItem temp[] = new MovieItem[movies.length + 1];
        System.arraycopy(movies, 0, temp, 0, movies.length);
        temp[temp.length - 1] = movie;
        movies = temp;
    }

    public MovieItem[] showMaxNumberOrLess() {
        int len;
        if (movies.length < maxNumber) {
            len = movies.length;
        } else {
            len = maxNumber;
        }
        MovieItem result[] = new MovieItem[len];
        int j = len - 1;
        for (int i = 0; i < len; i++) {
            result[j] = movies[i];
            j--;
        }
        return result;
    }

    public MovieManager(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public MovieManager() {
    }
}
