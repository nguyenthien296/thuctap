package com.example.demoTT.Services.Impl;

import com.example.demoTT.Models.Movie;
import com.example.demoTT.Repository.MovieRepo;
import com.example.demoTT.Repository.MovieTypeRepo;
import com.example.demoTT.Repository.RateRepo;
import com.example.demoTT.Services.MovieServices;
import com.example.demoTT.dto.MovieTicketCountDTO;
import com.example.demoTT.dto.Request.MovieRequest;
import com.example.demoTT.dto.Response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServicesImpl implements MovieServices {

    @Autowired
    private MovieRepo movieRepo;
    @Autowired
    private MovieTypeRepo movieTypeRepo;
    @Autowired
    private RateRepo rateRepo;


    @Override
    public MessageResponse createMovie(MovieRequest movieRequest) {
        Movie movie = Movie.builder()
                .movieDuration(movieRequest.getMovieDuration())
                .endTime(movieRequest.getEndTime())
                .premiereDate(movieRequest.getPremiereDate())
                .description(movieRequest.getDescription())
                .director(movieRequest.getDirector())
                .heroImage(movieRequest.getImage())
                .heroImage(movieRequest.getHeroImage())
                .language(movieRequest.getLanguage())
                .movietype(movieTypeRepo.findById(movieRequest.getMovieTypeId()).orElse(null))
                .name(movieRequest.getName())
                .rate(rateRepo.findById(movieRequest.getRateId()).orElse(null))
                .trailer(movieRequest.getTrailer())
                .isActive(false)
                .build();
        movieRepo.save(movie);
        return MessageResponse.builder().message("Them movie thanh cong").build();
    }

    @Override
    public MessageResponse updateMoive(MovieRequest movieRequest, int id) {
        Optional<Movie> movieOptional = movieRepo.findById(id);
        if (movieOptional.isEmpty()) {
            return MessageResponse.builder().message("Movie không tồn tại").build();
        }
        if(!movieTypeRepo.existsById(movieRequest.getMovieTypeId())){
            return MessageResponse.builder().message("MovieType không tồn tại").build();
        }
        if(!rateRepo.existsById(movieRequest.getRateId())){
            return MessageResponse.builder().message("Rate không tồn tại").build();
        }
        Movie movie = movieOptional.get();
        movie.setMovieDuration(movieRequest.getMovieDuration());
        movie.setEndTime(movieRequest.getEndTime());
        movie.setPremiereDate(movieRequest.getPremiereDate());
        movie.setDescription(movieRequest.getDescription());
        movie.setDirector(movieRequest.getDirector());
        movie.setImage(movieRequest.getImage());
        movie.setHeroImage(movieRequest.getHeroImage());
        movie.setLanguage(movieRequest.getLanguage());
        movie.setMovietype(movieTypeRepo.findById(movieRequest.getMovieTypeId()).orElse(null));
        movie.setName(movieRequest.getName());
        movie.setRate(rateRepo.findById(movieRequest.getRateId()).orElse(null));
        movie.setTrailer(movieRequest.getTrailer());
        movieRepo.save(movie);

        return MessageResponse.builder().message("Update thanh cong").build();
    }

    @Override
    public Movie deleteMoive(int id) {
        Optional<Movie> optionalMovie = movieRepo.findById(id);
        if (optionalMovie.isEmpty()){
            return null;
        }
        else {
            movieRepo.delete(optionalMovie.get());
        }
        return optionalMovie.get();
    }
}
