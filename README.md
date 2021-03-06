# movierepo
------------------------------------------------------------------------------------------------------------------------------------------
How to run the application:
1. Download the repository code
2. mvn clean install
3. java -jar ksubaka-1.0-RELEASE.jar
4. Notic the port in the logs
5. Try the following url from another console.

curl -v -X GET -u kuser:kpass -H "Content-Type: application/json" "http://localhost:8080/movie/fetchMovieInfo?apiName=omdb&movieTitle=titanic"

{ Starting/Entry reference classes : KsukabaStarter, MovieService }

------------------------------------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------------------------------------------------------------------------------
{Sample command}
OMDB command:


curl -v -X GET -u kuser:kpass -H "Content-Type: application/json" "http://localhost:8080/movie/fetchMovieInfo?apiName=omdb&movieTitle=titanic"


The Movie DB command:

curl -v -X GET -u kuser:kpass -H "Content-Type: application/json" "http://localhost:8080/movie/fetchMovieInfo?apiName=themoviedb&movieTitle=titanic"

<Please Note: I have noticed that there is connection timeout happening for this API themoviedb>

------------------------------------------------------------------------------------------------------------------------------------------

{Negative sample output}
http://localhost:8080/movie/fetchMovieInfo?apiName=omdb234234&movieTitle=titanic

OUTPUT :    "{"key":"api.name.invalid","message":"API Name is Invalid"}"

http://localhost:8080/movie/fetchMovieInfo?apiName=omdb&movieTitle=titanic345345345


OUTPUT :   {"key":"movie.not.found","message":"Movie titanic345345345 Not Found"}

------------------------------------------------------------------------------------------------------------------------------------------


Key Points:
1. Basic functionality: A single REST api which uses 2 different public APIs (http://www.omdbapi.com/ and https://www.themoviedb.org/documentation/api) to retrieve information  about a given movie. There should be two parameters: one to specify which API is to be used and one to specify the movie title
Expected output: A list of all matching movies, with year + director

2. Basic security: Reference code:  CustomBasicAuthenticationEntryPoint,SecurityConfig
3. Exception/errorhandling: ApiNameUnexpectedException,KsubakaControllerAdvice, MovieNotFoundException, KsubakaBaseException etc
4. Sample Integration Test case and Mockito test cases
5. Properties are configuration driven for production
6. Logback support
7. Modularity
8. Readiablity 
9. Program to interfaces
10. Failure cases handled

