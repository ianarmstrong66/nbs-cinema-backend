# QA-Cinemas-SpringBoot

## Getting Started

Clone the github repository to your drive. To make this easier, you may wish to import it using an IDE such as Intellij. This will allow you to import it as a Maven repository and the IDE will download all the dependencies for you.

## APIs

The following is an exhausive list of the paths of APIs that will be exposed when the back end is running the program:

__Film__
* /getallfilms - GET - Returns a complete list of films from the database. For details on the film objects you will receive, see the Models section.    
* /searchfilms/{search} - GET - Takes text used to search for films. Search text is not case sensitive and does not need to match entire words. The search text will be compared to the film Title, each Genre, each Director and each Actor. If even a single match is made then the film will be added to the results list. The list will be in no particular order.    
* /getfilm/{id} - GET - Takes a specific film id and returns the film with that id from the database. If no match is made then no film is returned.
* /getupcomingfilms - GET - Returns a complete list of films for which the property isReleased is false.
* /getnewfilms - GET - Returns a complete list of films for which the property isReleased is true.

__Email__
* /sendEmail - POST - Sends email to Gmail. Processes user, users email, subject and message before sending mail to the Product Owner, from the Product Owner

__Comment__
* /insertcomment/{reviewId}/{username}/{body}
* /getcomments/{reviewId}

__Initialise__
* /initialise

__Review__
* /insertreview/{filmId}/{rating}/{review}/{username}
* /getreviews/{filmId}
* /getreview/{reviewId}

__Showings__
* /addshowing/{filmId}/{screenType}/{time}/{date}
* /getshowingsbyfilm/{filmId}
* /booktickets/{showingId}
