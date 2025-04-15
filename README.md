Hello, this is my very basic Spring Boot application.

The requirement:

As an admin I want to be able to add, edit, change price, delete and see al the available products in my application, identifying them using the barcode.

As a user I want to be able to view all the products available in my application or to view the details of a product identified by its barcode.

The implementation:

* A simple REST controller in order to support the basic GET, POST, PATCH and DELETE operations.
* An underlying h2 database, in order to persist the objects.
The objects are retrieved from the DB based on their barcode number. 
* My assumption is that the barcode number is unique and well formated for every object. The uniqness is tested against the other objects from the database, but the formatting is not.
* Authorization is very basic, two roles and two hardcoded users