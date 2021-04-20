package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    private MovieManager manager = new MovieManager();
    private MovieItem first = new MovieItem("first");
    private MovieItem second = new MovieItem("second");
    private MovieItem third = new MovieItem("third");
    private MovieItem forth = new MovieItem("forth");
    private MovieItem fifth = new MovieItem("fifth");
    private MovieItem sixth = new MovieItem("sixth");
    private MovieItem seventh = new MovieItem("seventh");
    private MovieItem eights = new MovieItem("eights");
    private MovieItem ninth = new MovieItem("ninth");
    private MovieItem tenth = new MovieItem("tenth");
    private MovieItem eleventh = new MovieItem("eleventh");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldReverseBelowTen() {
        MovieItem[] actual = manager.showMaxNumberOrLess();
        MovieItem[] expected = new MovieItem[] {third, second, first};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldReverseTenAndAbove() {
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eights);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        MovieItem[] actual = manager.showMaxNumberOrLess();
        MovieItem[] expected = new MovieItem[] {tenth, ninth, eights, seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldReverseCustomNumber() {
        MovieManager manager2 = new MovieManager(7);
        manager2.add(first);
        manager2.add(second);
        manager2.add(third);
        manager2.add(forth);
        manager2.add(fifth);
        manager2.add(sixth);
        manager2.add(seventh);
        MovieItem[] actual = manager2.showMaxNumberOrLess();
        MovieItem[] expected = new MovieItem[] {seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(actual, expected);
    }
}
