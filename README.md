# Products

## How to run
on the folder, just go with <code>./mvnw spring-boot:run</code>. It will kick up the database migration and start 
the endpoints

## Endpoints

### /products
#### POST
checks the `content-type` header if it matches `application/xml` or `application/json` and parses the body accordingly,
validates the contents of the payload if they're present (throws BAD_REQUEST in case not) and saves on the database,
returning 201.
Throws generic exception in case some other error (parsing, etc)  

#### /{id}
fetches the product with the provided id or returns a 404 in case the id doesn't exist in the database
