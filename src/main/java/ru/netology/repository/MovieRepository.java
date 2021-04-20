package ru.netology.repository;

import ru.netology.domain.MovieItem;

import static org.mockito.Mockito.doReturn;

public class MovieRepository {
    private MovieItem[] items = new MovieItem[0];

    public void save(MovieItem movie) {
        int length = items.length + 1;//this throws an NPE because items is null!
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
        doReturn(items).when(this).findAll();
        items = findAll();
        int j = items.length;//this throws an NPE because items is null!
        for (int i = 0; i < j; i++) {
            if (items[i].getId() == id) {
                return items[i];
            }
        }
        return null;
    }

    public void removeById(int id) {
        doReturn(items).when(this).findAll();
        items = findAll();
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