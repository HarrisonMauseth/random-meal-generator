# Random Meal Generator Readme
Are you like me and have food in your fridge that is about to go bad, a need to practice what you have been learning for an end-of-module assessment in a software development bootcamp, and a lack of desire to make a decision on what to eat today? I might not be able to help you with the practice side of things, but I am happy to share with you my personal project.

Inspired by Jake Pauwels's "Roll for Sandwich" TikTok series and a love for TTRPGs, this Java application was started a way for me to gamify the early stages of my journey into software development. Not only do I get to practice what I am learning, I get to have fun while doing it.

While the project has taken a bit of a hiatus due to focusing on all the new material I am learning,  it encapsulates a lot of the foundational elements I learned over the first ten weeks of the full-stack bootcamp.

## What the Application Does
In its current state, the scope of the application provides the following functionality:
- Reads an inbound pipe-delimited text file where each line is a category.
- Sorts the items into their corresponding list.
- Dynamically generates a "recipe" based on the size and category of each list.
- Uses an Object-Oriented Programming package structure with multiple classes for ease of expansion
- Implements Unit Testing (via JUnit 4) to mitigate bugs that may arise during future updates.

## Short Term Roadmap
While the core functionality of the project works for what I need, there are plenty of quality-of-life updates I would like to include. The goal is to make the application more fun for me to use and to provide greater accessibility to anyone else who may come across this.

Some core features I would like to implement:

- Expand classes to allow for new meals like "Salad" and "Soup"
- Implement a method to prioritize ingredients during generation
- Create a log of past meals
- Create a user interface that:
    - updates the files from within the program
    - displays a log of previous creations
    - allows for ranking of previous creations
    - displays top-rated sandwiches
    - prompts for user input for type of meal to create
    - offers a way to "roll with advantage" to pick the better of two creations
    - implements re-rolls
    - allows the user to define if the category should be rolled twice by default

## Long Term Project Goals
Meal generation is merely a jumping off point. I'd love for this project to grow into an inventory management system for the food in my house. Broadly speaking, this means creating a relational database, a server-side API, and a GUI for remote access.

These are the steps I want to take to achieve this:
- Transition from File I/O to a DAO using Spring's JDBC and a PostgreSQL database
- Find a nutrition-based API and create a service to handle that
- Create a server-side API using Spring Boot
- Develop a front end using elements of HTML, CSS, JavaScript, and a framework like Vue.JS

## Application Overview
The application is structured into packages based on functionality. We will be looking at the `mauseth.generator`, `mauseth.generator.food`, and `mauseth.generator.util` packages in greater depth below.

***
### The `mauseth.generator` Package
This is the root package for the project. In here, you will find the `App` class as well as the `food` and `util` packages.

#### `App`
This is the runnable class where the `public static void main (String[] args)` method is located. Within this class you will find three methods:
- `initialize()`
    - takes no inbound parameters, has no return, and throws a custom `FileHandlingException`
    - Invokes the `FileHandling.readContentsOfFile` method, reading from the `sandwich.txt` file and returning a List of Strings called `sandwichItems`
    - Creates a new `sandwich` object
    - Loops through the `sandwichItems`, splitting the String, checking the category field of the array (index 0), and then storing the ingredients to their respective list in the sandwich object
    - Stores the `sandwich` object in a queue called `sandwichesToMake` (this is so we can use a "First In, First Out" approach during the generation phase)
- `makeSandwich()`
    - takes an inbound parameter of a `Sandwich` object called `sandwich`
    -

***
### The `food` Package
Located within the food package, you will find the `Meal` and `Sandwich` classes as well as the `RandomMealGeneration` interface. `Main` is the super class and implements the `RandomMealGeneration` interface. `Sandwich` is the subclass that extends `Meal`.

#### Sandwich Class
The `Sandwich` class has the following properties:

##### Formatting the Text File for the Sandwich Class
You will need to create a text file that the program can read from. In the code provided, this text file is called `sandwich.txt` and is stored in `src/main/resources/`. This file contains contains lines of pipe delimited categories. The first item in the line is the category and everything else on the line are ingredients of that category. The Sandwich class supports the following categories:
- "Bread"
- "Main"
- "Cheese"
- "Roughage"
- "Sauce"
- "Wild Magic"

Correct formatting for the sandwich class using the categories above looks like this:

```
Bread|Naan Rounds|Tortilla|Pretzel Bun|Ciabatta Bun|Honey Wheat 
Main|Pepperoni|Pastrami|Genoa|Ham|Chicken
Cheese|Gouda|Feta|Wensleydale|Dill Havarti|Pepperjack|Cream Cheese|Sharp Cheddar 
Roughage|None|Jalapenos|Banana Pepppers|Pickles|Carrot|Cucumber|Yellow Pepper|Red Onion|Spinach
Sauce|None|Honey Mustard|Mayonnaise|Ranch|Mustard|Cholula|Gochujang|BBQ Sauce  
Wild Magic|None|Peanut Butter|Jalapeno Jelly|Sriracha|Peanut Butter|Cholula|Buffalo Sauce|Cajun Seasoning|Wasabi
```

***
### The `util` Package
This is where I have stored the basic File I/O handler as well as the custom File I/O Exception. In my heart, I know that creating a class with public static methods circumvents the core concept of Object Oriented Programming. But from a functionality standpoint, it made more sense to handle the file reading and writing this way.