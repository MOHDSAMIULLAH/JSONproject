# jsonproject

This Java program reads a list of JSON objects from a JSON file, processes each object based on the type of question, and writes the output to another JSON file.

![image](https://github.com/MOHDSAMIULLAH/JSON-project/assets/91786605/822b26e7-b6c9-4c8e-85c5-37b51ee36352)



## Requirements

- Java Development Kit (JDK) 8 or above
- json-simple library (included in the project)

## how to setup

1. Clone the repository or download the source code.

2. Ensure you have Java installed on your machine.

3. Place your input JSON file in the project directory. The file should have the following format:

   ```json
   [
     {
       "type": "first non repeating",
       "input": "aaabcd"
     },
     {
       "type": "first repeating",
       "input": "skrrt"
     }
     
   ]

### run the project:
4. Open a terminal or command prompt and navigate to the project directory.

5. Compile the Java source code by running the following command:</br>

      <b>javac -cp lib\\* src\test\java\jsonproject\jsonproject\ReadDataFromJSON.java</b>

6. Run the program using the following command:
    
   <b> java -cp lib\\* src\test\java\jsonproject\jsonproject\ReadDataFromJSON.java jsonfiles\input.json</b></br>
   
This will process the input JSON file and generate an output JSON file named output.json in the project directory.

7. Once the program finishes execution, you can find the output JSON file (output.json) in the project directory. The file will contain a list of strings in the same order as the input JSON file, representing the processed results.

The program uses the json-simple library (https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple/1.1.1) for parsing and manipulating JSON data. You can include the library by downloading the JAR file and adding it to your project's dependencies.

##  Quick summary of my decisions on how I came up with the solution
The solution uses two different approaches to find the first non-repeating and first repeating characters in a given input string. Here's a summary of the decisions made:

First Non-Repeating Character: The program utilizes an integer array count of size 256 to store the frequency of each character in the input string. It iterates over the characters in the input string twice: first to count the frequency and then to find the first non-repeating character. The array provides constant-time access to the count of each character.

First Repeating Character: The program uses a boolean array visited of size 256 to keep track of characters that have been visited. It iterates over the characters in the input string once and checks if a character has been visited before. If a character has already been visited, it is considered the first repeating character. The boolean array allows efficient checking of visited characters.

### why I choosed this data structures
<p>These data structures are chosen for their simplicity and efficiency in solving the given problems. The integer array and boolean array provide constant-time access and require minimal memory overhead.</p>
