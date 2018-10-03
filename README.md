# simpleFlightSearch
I want to asses your ability to create a simple AngularJS / Express application. It truly is the bare minimum of knowledge necessary to be successful in this position. I don't want you to spend a lot of time on this. You should be able to do this in a few hours if the job is right for you.

###Flight Search

This programming task consists of building a simple web application to search for flights. Create a new local branch to implement  a simple flight search application. It should take this input from the user:

(Flight Number ||  (Origin && Destination)) && Date

The application will call a service that you create in ExpressJS. Use Couchbase as the data source. You can download the docker image of Couchase and run it locally.   
                                                                                                                                                                                                        
https://docs.couchbase.com/server/5.5/analytics/quick-start.html#Using_docker
 
Create a new bucket and add the documents included in project.

[Flight Documents](./flight-docs/flight-sample.json)

The file contains an array. Make a document out of each array element. You can you use any value you want as the document key. Create a N1QL statement update the date component of the arrrival and departure properties of each document. This will allow you to specify a current date when searching. 


You must use Angular 4 or higher. Style however you would like. You have total freedom to do what you want but make sure it can do these two things:

	• Validate that the user has provided the right criteria to make a search 
	• Neatly display the results

Create a pull request once you have it working and so I can evaluate it. I will follow up with a quick discussion to review the code.

