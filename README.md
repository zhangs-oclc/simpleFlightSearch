# simpleFlightSearch
I want to asses your ability to create a simple AngularJS application. It truly is the bare minimum of knowledge necessary to be successful in this position. I don't  want you to spend a lot of time on this. You should be able to do this in a few hours if the job is right for you.

Flight Search

This programming task consists of building a simple web application to search for flights. Create a new local branch to implement  a simple flight search application. It should take this input from the user:

(Flight Number ||  (Origin && Destination)) && Date

Your  application will call a service with the values of the inputs entered by the user and display the results.  These results will be returned by a service included in the repository. You will need to install stubby first. (This requires admin privileges) 

npm install -g  stubby

To start the service simply run this command in the root directory of the project

stubby -d ./stubs/flight-search.yaml

You will be able to call this end point get a response once you have started the service

http://localhost:8882/searchFlights?ori=IAH&des=ORD&d=2018-01-20

Or 

http://localhost:8882/searchFlights?f=1234&d=2018-01-20

You may use any version of AngularJS and style however you would like. You have total freedom to do what you want but make sure it can do these two things:

	• Validate that the user has provided the right criteria to make a search 
	• Neatly display the results

Create a pull request once you have it working  and so I can evaluate it. I will follow up with a quick discussion to review the code.

