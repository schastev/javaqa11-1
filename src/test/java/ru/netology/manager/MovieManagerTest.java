package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MovieItem;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@ExtendWith(MockitoExtension.class)
public class MovieManagerTest {
    @Mock
    private MovieRepository repository;
    @InjectMocks
    private MovieManager manager = new MovieManager(repository);
    private MovieManager manager2 = new MovieManager(repository);
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
        manager.save(first);
        manager.save(second);
        manager.save(third);
    }

    @Test
    public void shouldReverseBelowTen() {
        MovieItem[] actual = manager.showMaxNumberOrLess();
        MovieItem[] expected = new MovieItem[] {third, second, first};
        doReturn(actual).when(repository).findAll();
        assertArrayEquals(actual, expected);
        //verify(repository).findAll();
    }

    @Test
    public void shouldReverseTenAndAbove() {
        manager.save(forth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eights);
        manager.save(ninth);
        manager.save(tenth);
        manager.save(eleventh);
        MovieItem[] actual = manager.showMaxNumberOrLess();
        MovieItem[] expected = new MovieItem[] {tenth, ninth, eights, seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldReverseCustomNumber() {
        manager2.save(first);
        manager2.save(second);
        manager2.save(third);
        manager2.save(forth);
        manager2.save(fifth);
        manager2.save(sixth);
        manager2.save(seventh);
        MovieItem[] actual = manager2.showMaxNumberOrLess();
        MovieItem[] expected = new MovieItem[] {seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void findByIdTest() {
        MovieItem actual = manager.findById(2);
        MovieItem expected = second;
        assertEquals(actual, expected);
    }
}
