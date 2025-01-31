package com.workintech.s19d1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="actor",schema = "fsweb")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
    fetch = FetchType.EAGER)
    @JoinTable(
            name = "actor_movie", // Hem Actor hem Movie için ortak isim
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> movieList = new ArrayList<>();


    public void addMovie(Movie movie) {
        if (movieList == null)
            movieList = new ArrayList<>();
        movieList.add(movie);
    }
}
