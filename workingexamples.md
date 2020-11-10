

$ curl -v -X GET -u kuser:kpass -H "Content-Type: application/json" "http://localhost:8080/movie/fetchMovieInfo?apiName=themoviedb&movieTitle=titanic"



[{"name":"Titanic","year":"1997","director":"James Cameron"},{"name":"Titanic 2","year":"2010","director":"Shane van Dyke"},{"name":"Titanic","year":"1953","director":"Jean Negulesco"},{"name":"Titanic: 100 Years On","year":"2012","director":"Tara Pirnia"},{"name":"Titanic","year":"1943","director":"Werner Klingler"},{"name":"S.O.S. Titanic","year":"1979","director":"William Hale"},{"name":"Aliens vs. Titanic","year":"2017","director":"Jeff Leroy"},{"name":"Raise the Titanic","year":"1980","director":"Jerry Jameson"},{"name":"Titanic: The Legend Goes On...","year":"2000","director":"Camillo Teti"},{"name":"Reflections on Titanic","year":"2012","director":"Ed W. Marsh"},{"name":"Nazi Titanic","year":"2012","director":"Oscar Chan"},{"name":"Titanic 2000","year":"1999","director":"John Paul Fedele"},{"name":"Inside the Titanic","year":"2012","director":"Richard Dale"},{"name":"The Legend of the Titanic","year":"1999","director":"Kim J. Ok"},{"name":"Drain the Titanic","year":"2016","director":"Jobim Sampson"},{"name":"Titanic: The Aftermath","year":"2012","director":"Marion Milne"},{"name":"Saving the Titanic","year":"2012","director":"Maurice Sweeney"},{"name":"Back To The Titanic","year":"2020","director":"Tom Stubberfield"},{"name":"Cinematic Titanic: Rattlers","year":"2012","director":"Stoney Sharp"},{"name":"Titanic Town","year":"1998","director":"Roger Michell"}]




-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


$ curl -v -X GET -u kuser:kpass -H "Content-Type: application/json" "http://localhost:8080/movie/fetchMovieInfo?apiName=omdb&movieTitle=titanic"
[{"name":"Titanic","year":"1997","director":"James Cameron"}]
