# spring-case-study

# Running the application
1. Run maven clean build (to make sure mapstruct works)
2. To browse Swagger Document for the APIs (http://localhost:8080/swagger-ui/index.html#/)
3. Add Data based on the connections below:

   - Book, with following fields
     -ID
	   -Title
	   -Author
     -Description
     -Page count
     -Publish Date
     -Available stock
  - Person, with following fields
    -ID
    -Name
    -DOB
    -Address
  - Book Track, with following fields
    -ID
    -Book ID
    -Start Date
	  -Expected Return Date
    -Actual Return Date
    -Person ID
  - Librarians, with following fields
    -ID
    -Name
    -Email ID
    -Password  
  - Author, with below fields
    -ID
    -First Name
    -Last Name
