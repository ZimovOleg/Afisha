package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;
import ru.netology.manager.Manager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerTest {

    private Manager manager = new Manager();
    MovieItem f1 = new MovieItem(1, 1, "Бладшот", "comedy", false);
    MovieItem f2 = new MovieItem(2, 2, "Отель", "comedy", false);
    MovieItem f3 = new MovieItem(3, 3, "Вперед", "thriller", false);
    MovieItem f4 = new MovieItem(4, 4, "Джентельмены", "drama", false);
    MovieItem f5 = new MovieItem(5, 5, "Человек неведимка", "musical", false);
    MovieItem f6 = new MovieItem(6, 6, "Тролли", "musical", false);
    MovieItem f7 = new MovieItem(7, 7, "Номер один", "science-fiction", false);
    MovieItem f8 = new MovieItem(8, 8, "Золото", "biography", false);
    MovieItem f9 = new MovieItem(9, 9, "Форсаж", "thriller", false);
    MovieItem f10 = new MovieItem(10, 10, "Человек паук", "mystery", false);
    MovieItem f11 = new MovieItem(11, 11, "Мстители", "mystery", false);
    MovieItem f12 = new MovieItem(12, 12, "Человек огня", "mystery", false);

    @BeforeEach
    public void setUp() {
        manager.addMovie(f1);
        manager.addMovie(f2);
        manager.addMovie(f3);
        manager.addMovie(f4);
        manager.addMovie(f5);
        manager.addMovie(f6);
        manager.addMovie(f7);
        manager.addMovie(f8);
        manager.addMovie(f9);
}
    @Test //фильмы в ленте выдаются в обратном порядке
    public void reversMovieInNewFeed() {
        Manager manager = new Manager();
        manager.addMovie(f1);
        manager.addMovie(f2);
        manager.addMovie(f3);
        manager.addMovie(f4);
        manager.addMovie(f5);
        manager.addMovie(f6);
        manager.addMovie(f7);
        manager.addMovie(f8);
        manager.addMovie(f9);
        MovieItem[] expected = new MovieItem[]{f9, f8, f7, f6, f5, f4, f3, f2, f1};
        MovieItem[] actual = manager.showAll();
        assertArrayEquals(expected, actual);
    }

    @Test  //Добавление 1 фильма в новую ленту
    public void addingOneMovieNewFeed() {
        Manager manager = new Manager();
        manager.addMovie(f1);
        MovieItem[] expected = new MovieItem[]{f1};
        MovieItem[] actual = manager.showAll();
        assertArrayEquals(expected, actual);
    }

    @Test // Добавление 1 фильма в ленту
    public void addingMovieForFeed() {
        manager.addMovie (f10);
        MovieItem[] actual = manager.showAll();
        MovieItem[] expected = new MovieItem[]{f10, f9, f8, f7, f6, f5, f4, f3, f2, f1};
        assertArrayEquals(expected, actual);
    }

    @Test  //Добавление нескольких фильмов в новую ленту
    public void addingSeveralMovieNewFeed() {
        Manager manager = new Manager();
        manager.addMovie(f1);
        manager.addMovie(f2);
        manager.addMovie(f3);
        manager.addMovie(f4);
        MovieItem[] expected = new MovieItem[]{f4,f3,f2,f1};
        MovieItem[] actual = manager.showAll();
        assertArrayEquals(expected, actual);
    }

    @Test //10 фильмов добавляются в новую ленту выдаются в обратном порядке
    public void addingNew10MovieNewFeed() {
        Manager manager = new Manager();
        manager.addMovie(f1);
        manager.addMovie(f2);
        manager.addMovie(f3);
        manager.addMovie(f4);
        manager.addMovie(f5);
        manager.addMovie(f6);
        manager.addMovie(f7);
        manager.addMovie(f8);
        manager.addMovie(f9);
        manager.addMovie(f10);
        MovieItem[] expected = new MovieItem[]{f10, f9, f8, f7, f6, f5, f4, f3, f2, f1};
        MovieItem[] actual = manager.showAll();
        assertArrayEquals(expected, actual);
    }

    @Test //больше 10 фильмов добавляются в новую ленту и выдаются в обратном порядке
    public void addingMoreNew10MovieNewFeed() {
        Manager manager = new Manager();
        manager.addMovie(f1);
        manager.addMovie(f2);
        manager.addMovie(f3);
        manager.addMovie(f4);
        manager.addMovie(f5);
        manager.addMovie(f6);
        manager.addMovie(f7);
        manager.addMovie(f8);
        manager.addMovie(f9);
        manager.addMovie(f10);
        manager.addMovie(f11);
        MovieItem[] expected = new MovieItem[]{f11,f10, f9, f8, f7, f6, f5, f4, f3, f2};
        MovieItem[] actual = manager.showAll();
        assertArrayEquals(expected, actual);
    }


    @Test // лента выдает фильмы в обратном порядке
    public void feedReversMovie() {
        MovieItem[] actual = manager.showAll();
        MovieItem[] expected = new MovieItem[]{f9, f8, f7, f6, f5, f4, f3, f2, f1};
        assertArrayEquals(expected, actual);
    }

    @Test // лента выдает последние добавленные 10 фильмов
    public void AddingMoreThan10Movies() {
        manager.addMovie (f10);
        manager.addMovie (f11);
        manager.addMovie (f12);
        MovieItem[] actual = manager.showAll();
        MovieItem[] expected = new MovieItem[]{f12, f11, f10, f9, f8, f7, f6, f5, f4, f3};
        assertArrayEquals(expected, actual);

    }
}