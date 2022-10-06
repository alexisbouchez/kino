package com.kino.backend.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie) {
        Optional<Movie> movieByTitle = movieRepository.findMovieByTitle(movie.getTitle());
        if (movieByTitle.isPresent()) {
            throw new IllegalStateException("movie already exists");
        }
        movieRepository.save(movie);
    }

    public void deleteMovie(Long movieId) {
        boolean exists = movieRepository.existsById(movieId);
        if (!exists) {
            throw new IllegalStateException("student with id " + movieId + " not found");
        }
        movieRepository.deleteById(movieId);
    }
}
