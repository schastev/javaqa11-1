package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.*;

public class MovieRepositoryTest {
    MovieRepository repo = new MovieRepository();
    private MovieItem first = new MovieItem(1);
    private MovieItem second = new MovieItem(2);
    private MovieItem third = new MovieItem(3);
    private MovieItem forth = new MovieItem(4);
    private MovieItem fifth = new MovieItem(5);
    private MovieItem sixth = new MovieItem(6);
    private MovieItem seventh = new MovieItem(7);
    private MovieItem eights = new MovieItem(8);
    private MovieItem ninth = new MovieItem(9);
    private MovieItem tenth = new MovieItem(10);
    private MovieItem eleventh = new MovieItem(11);

    @BeforeEach
    public void setUp() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(forth);
    }

    @Test
    public void findAllTest() {
        MovieItem[] expected = new MovieItem[]{first, second, third, forth};
        MovieItem[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void saveTest() {
        MovieItem[] expected = new MovieItem[]{first, second, third, forth, fifth};
        repo.save(fifth);
        MovieItem[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findById() {
        MovieItem expected = third;
        MovieItem actual = repo.findById(3);
        assertEquals(expected, actual);
    }

    @Test
    public void findByIdNotFound() {
        MovieItem actual = repo.findById(7);
        assertNull(actual);
    }

    @Test
    public void removeById() {
        MovieItem[] expected = new MovieItem[]{first, second, forth};
        repo.removeById(3);
        MovieItem[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeAll() {
        MovieItem[] expected = new MovieItem[repo.findAll().length];
        repo.removeAll();
        MovieItem[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }
}
