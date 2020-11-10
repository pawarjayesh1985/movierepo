# movierepo
This repo fetches the information from 2 separate apis  based on the api name and movie title
------------------------------------------------------------------------------------------------------------------------------------------

OMDB command:
curl -v -X GET -u kuser:kpass -H "Content-Type: application/json" "http://localhost:8080/movie/fetchMovieInfo?apiName=omdb&movieTitle=titanic"


The Movie DB command:
curl -v -X GET -u kuser:kpass -H "Content-Type: application/json" "http://localhost:8080/movie/fetchMovieInfo?apiName=themoviedb&movieTitle=titanic"

------------------------------------------------------------------------------------------------------------------------------------------

Key Points:
1. Basic functionality: 
Write a single REST api which uses 2 different public APIs (http://www.omdbapi.com/ and https://www.themoviedb.org/documentation/api) to retrieve information about a given movie.
There should be two parameters: one to specify which API is to be used and one to specify the movie title
Expected output: A list of all matching movies, with year + director

2. Basic security:
3. Exception/errorhandling
4. Sample Integration Test case and Mockito test cases
5. Properties are configuration driven for production
6. Logback support
7. Modularity
8. Readiablity 
9. Program to interfaces
