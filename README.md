Scraper
=======

Scraper application scrapes the Sainsbury’s grocery site - Ripe Fruits page and prints out 
a JSON array of all the products on the page.

Source Tree
------------

GitHub : https://github.com/ragubalan/scraper.git

Directory Structure
-------------------

Project's structure looks like:

		src
        |-- main
        |   `-- java
        |       `-- com
        |           `-- sainsburys
        |               `-- scraper
        `-- test
            `-- java
                `-- com
                    `-- sainsburys
                        `-- scraper

As you can see, the code resides in the com.sainsburys.scraper package (both testing, and regular).

Dependencies
------------

scraper depends on just few popular libraries/frameworks:

- json-simple - for JSON data manipulation.
- jsoup - for HTML parsing and DOM manipulation as well as web connections.
- junit and jmockit - for testing.

running the application
-----------------------

Use Maven to compile and run it:

    git clone git@github.com:ragubalan/scraper.git
    mvn compile
    mvn exec:java

To generate this JAR file execute

    mvn package

After that you can run the application with simple:

    java -jar target/scraper-0.0.1-SNAPSHOT.jar

The scraper-0.0.1-SNAPSHOT.jar can then be copied anywhere and executed independently. 

Testing
-------

To execute tests run:

mvn test