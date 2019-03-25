this will contain project notes and goals

currently working on:
method to count elements per genre(4) 
- contains counter for each genre
- will increment counter when a movie has been "watched"
new constraints: 
-password must be 8 characters long

to do:
setup menu for user to interact with
clean up main menu to have less than 20 lines


overview:

main.
calls startmenu


> startmenu
can acces1 ----
    user registers
	first name, last name, // username, password
	method1a: collects all variables & checks for constraints
	method2a: stores in arrays (pairs up variables, first, last, username, password)
	method3a: prints user variables for each login attempt

can access2 -----
    user logsin
	method1b: checks variables against stored collected in prev method 

	method2b: logs user in if variables are valid, if they are invalid, 		 		  redirects to login method1 again. if user has been redirected to 		  method 1 more than twice,

	method3b: creates temp login details for user
		- calls method 2a to check variables, 

can access 3-9

