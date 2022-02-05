package ru.netology.manager;

import ru.netology.domain.MovieItem;

public class Manager {
    private MovieItem[] items = new MovieItem[0];
    private int numberOfMovies = 10;

    public Manager() {
    }

    public void addMovie(MovieItem item) {
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MovieItem[] showAll() {
        MovieItem[] result = new MovieItem[Math.min(items.length, numberOfMovies)];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }


}
