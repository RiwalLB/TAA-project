# TAA-project

# base de donnée hsqldb

# API Calls:

# GET (get calls return null if no element found)
#   - /allUsers : return all users
#   - /user - param "name" : return user with "name"
#   - /allMovies : return all movies
#   - /movie - param "title" : return movie with "title"
#   - /allGenres : return all genres
#   - /genre - param "genre" : return genre with "genre" as name

# POST (post calls return added element, if element already exists return that element instead)
#   - /addUser - param "name" : add user with "name"
#   - /userAddMovie - param "name" "title" : add movie "title" to user "name"
#   - /addMovie - param "title" : add movie "title" (genres empty)
#   - /addGenre - param "genre" : add genre "genre"
