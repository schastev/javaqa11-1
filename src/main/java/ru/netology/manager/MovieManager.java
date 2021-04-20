package ru.netology.manager;

import ru.netology.domain.MovieItem;
import ru.netology.repository.MovieRepository;

public class MovieManager {
    int maxNumber = 10;

    private MovieRepository repository;

    public MovieManager(MovieRepository repository) {
        this.repository = repository;
    }

    public void save(MovieItem movie) {
        repository.save(movie);
    }

    public MovieItem[] showMaxNumberOrLess() {
        MovieItem[] startingArray = repository.findAll();
        int len;
        if (startingArray.length < maxNumber) {
            len = startingArray.length;
        } else {
            len = maxNumber;
        }
        MovieItem result[] = new MovieItem[len];
        int j = len - 1;
        for (int i = 0; i < len; i++) {
            result[j] = startingArray[i];
            j--;
        }
        return result;
    }

    public MovieItem findById(int id) {
        return repository.findById(id);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void removeAll() {
        repository.removeAll();
    }

    public MovieManager(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public MovieManager() {
    }
}
