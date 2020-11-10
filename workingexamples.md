jpawar@XIPLR124 MINGW64 /e/otherthanproject/code/movierepo (main)

$ curl -v -X GET -u kuser:kpass -H "Content-Type: application/json" "http://localhost:8080/movie/fetchMovieInfo?apiName=themoviedb&movieTitle=titanic"
Note: Unnecessary use of -X or --request, GET is already inferred.
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0*   Trying ::1:8080...
* Connected to localhost (::1) port 8080 (#0)
* Server auth using Basic with user 'kuser'
> GET /movie/fetchMovieInfo?apiName=themoviedb&movieTitle=titanic HTTP/1.1
> Host: localhost:8080
> Authorization: Basic a3VzZXI6a3Bhc3M=
> User-Agent: curl/7.71.1
> Accept: */*
> Content-Type: application/json
>
* Mark bundle as not supporting multiuse
< HTTP/1.1 200
< X-Content-Type-Options: nosniff
< X-XSS-Protection: 1; mode=block
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-Frame-Options: DENY
< Content-Type: text/plain;charset=UTF-8
< Content-Length: 1388
< Date: Tue, 10 Nov 2020 04:12:28 GMT
<
{ [1388 bytes data]
100  1388  100  1388    0     0   1220      0  0:00:01  0:00:01 --:--:--  1221[{"name":"Titanic","year":"1997","director":"James Cameron"},{"name":"Titanic 2","year":"2010","director":"Shane van Dyke"},{"name":"Titanic","year":"1953","director":"Jean Negulesco"},{"name":"Titanic: 100 Years On","year":"2012","director":"Tara Pirnia"},{"name":"Titanic","year":"1943","director":"Werner Klingler"},{"name":"S.O.S. Titanic","year":"1979","director":"William Hale"},{"name":"Aliens vs. Titanic","year":"2017","director":"Jeff Leroy"},{"name":"Raise the Titanic","year":"1980","director":"Jerry Jameson"},{"name":"Titanic: The Legend Goes On...","year":"2000","director":"Camillo Teti"},{"name":"Reflections on Titanic","year":"2012","director":"Ed W. Marsh"},{"name":"Nazi Titanic","year":"2012","director":"Oscar Chan"},{"name":"Titanic 2000","year":"1999","director":"John Paul Fedele"},{"name":"Inside the Titanic","year":"2012","director":"Richard Dale"},{"name":"The Legend of the Titanic","year":"1999","director":"Kim J. Ok"},{"name":"Drain the Titanic","year":"2016","director":"Jobim Sampson"},{"name":"Titanic: The Aftermath","year":"2012","director":"Marion Milne"},{"name":"Saving the Titanic","year":"2012","director":"Maurice Sweeney"},{"name":"Back To The Titanic","year":"2020","director":"Tom Stubberfield"},{"name":"Cinematic Titanic: Rattlers","year":"2012","director":"Stoney Sharp"},{"name":"Titanic Town","year":"1998","director":"Roger Michell"}]
* Connection #0 to host localhost left intact

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
jpawar@XIPLR124 MINGW64 /e/otherthanproject/code/movierepo (main)
$ curl -v -X GET -u kuser:kpass -H "Content-Type: application/json" "http://localhost:8080/movie/fetchMovieInfo?apiName=omdb&movieTitle=titanic"
Note: Unnecessary use of -X or --request, GET is already inferred.
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0*   Trying ::1:8080...
* Connected to localhost (::1) port 8080 (#0)
* Server auth using Basic with user 'kuser'
> GET /movie/fetchMovieInfo?apiName=omdb&movieTitle=titanic HTTP/1.1
> Host: localhost:8080
> Authorization: Basic a3VzZXI6a3Bhc3M=
> User-Agent: curl/7.71.1
> Accept: */*
> Content-Type: application/json
>
* Mark bundle as not supporting multiuse
< HTTP/1.1 200
< X-Content-Type-Options: nosniff
< X-XSS-Protection: 1; mode=block
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-Frame-Options: DENY
< Content-Type: text/plain;charset=UTF-8
< Content-Length: 61
< Date: Tue, 10 Nov 2020 04:13:00 GMT
<
{ [61 bytes data]
100    61  100    61    0     0    378      0 --:--:-- --:--:-- --:--:--   381[{"name":"Titanic","year":"1997","director":"James Cameron"}]
* Connection #0 to host localhost left intact
