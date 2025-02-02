INSERT INTO movie (id, name, director_name, rating, release_date) VALUES
(1, 'Inception', 'Christopher Nolan', 8.8, '2010-07-16'),
(2, 'The Dark Knight', 'Christopher Nolan', 9.0, '2008-07-18');

INSERT INTO actor (id, first_name, last_name, gender, birth_date) VALUES
(1, 'Leonardo', 'DiCaprio', 'MALE', '1974-11-11'),
(2, 'Christian', 'Bale', 'MALE', '1974-01-30');

INSERT INTO actor_movie (actor_id, movie_id) VALUES
(1, 1),
(2, 2);
