package ru.netology.repository;

import ru.netology.domain.MovieItem;

public class MovieRepository {
    private MovieItem[] items = new MovieItem[0];

    public void save(MovieItem movie) {
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        System.arraycopy(items, 0, tmp, 0, length - 1);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        items = tmp;
    }

    public MovieItem[] findAll() {
        return items;
    }

    public MovieItem findById(int id) {
        int j = items.length;
        for (int i = 0; i < j; i++) {
            if (items[i].getId() == id) {
                return items[i];
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        MovieItem[] tmp = new MovieItem[length];
        int index = 0;
        for (MovieItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public void removeAll() {
        items = new MovieItem[items.length];
    }
}