package com.Dhiraj;

import java.util.Scanner;
public class Main1 {

    public static void main(String[] args) {
	// write your code here
        // output
        System.out.println("Hellow world");
        // input
        Scanner input = new Scanner(System.in);
        System.out.println(input.nextLine());


        // java code follows unicode value
        System.out.println("नमस्ते");
        System.out.println("你好");



    }
}



// getting started to DSA bootcamp:
// first the package thing consider it as a folder which is assign to specific java file as like we have first_java_prg>src>com>Dhiraj>Main1.java
// the class thing every file that ends with .java is a class and class name is that file name (if it is public class that class name must be .java file name)
// There can be only one public class in a java file because the name of java file is same as the name of public class    // imp.
// class name starts with capital letter (convention), class = name group of properties and functions(identifiers)
// public before class means it can be access form anywhere any other class can access public class variables and methods
// In class we have function/ method
// the public static void main (String[] args) thing
// public toh public, static bole toh run function without declaring objects of class Main
// the variables and functions that do not depend on the object/instances that are called static variable and functions
// void is nothing but return type, void toh kuch return na karna
// (String[] args) array samjh lo yr, arguments/ command line arguments
// to know about System.out.println("Hellow") just hold command and click on System or out or whatever
// System is a class which provides functions like print and out is the variabale name of printstream class
// ln is basically prints a line
// out means where we have to print it our = null means no file to be print in and hence it will be treated as command line

// in terminal by command in terminal: javac Main1.java  --> will create a byte code of Main1.java file which can be run on any OS
// javac -d .. Main1.java  --> will create a .byte code in previous directory
// by command in terminal: java Main1.java   will execute the code


/*


Kunal Kushwaha


Introduction to programming  :


* Types of languages : Procedural, Functional, Object oriented

Procedural lang:
- Specifies the series of well structured steps and procedures to compass it.
- Contain  a systematic order of statements, function and commands to complete a task
- Types of procedural languages are Fortran, Algol, Cobol, Basic, Pascal, Java, Python and C.

Functional lang:
- Writing a program only in pure functions i.e. never modify variables, but only create ones as an output.
- Used in situations  where we have to perform lots of different operations on the same set of data, like ML
- First class functions
- Types of functional languages are Lisp, Python, Erlang, Haskell, Clojure, etc

Object oriented:
- Revolves around objects
- Code + Data = objects
- Developed to make it easier to develop, debug, reuse, and maintain software
- Types of object oriented languages are Java, Python, C#, Ruby, C+, Python


* Static vs Dynamic language
Static	                                        Dynamic
Perform type checking at compile time	Perform type checking at runtime(compilation is done)
Errors will show at compile time	    Errors might not show till program is run
Declare datatype before you use it   	No need to declare datatypes of variables
More control 	                        Saves time in writing code but might give error at runtime
Languages like C, C++,Java etc	         Languages like Lisp, Perl, Python, Ruby, etc


* Object and reference variables
Think of dynamic lang
a =  10  where a is reference variable and 10 is object
a is store in stack memory and 10 is store in heap memory, a having address of 10 in heap
a will point towards 10. NOTE a is not 10 it’s just pointing towards 10
1. More than one reference variables can point towards same object.
2. If any one of the reference variable change the object then it will going to be change for all variables.
3. If there is an object without reference variable then, object will be destroyed by “Garbage collection”.
- non-primitives are always references in Java.



Flow of program :

* Flowcharts:
Flowcharts are basically used to visualise our particular thought process and whatever algorithms we create:
- Start / stop           ——>  ⬭
- input / output       ——>  ▱
- Processing           ——>  ▭
- condition              ——>  ♢
- Flow direction of program  ——>  →

* Pseudocode
Pseudocode is an artificial and informal language that helps programmers develop algorithms.
We generate pseudo code with flowchart symbols


Introduction to Java  - Architecture and installation

How java code executes:

| .java file.         |   —compiler——->  |  .class file   |   ——interpreter———> | Machine code
|  (Human readable)   |  (entire file)   |    (byte code) |  (line by line)      |( 0 and 1 ’s)


- This code will not directly run on a system
- We need JVM to run this
- Reason why java is platform independent
- .class file can be run on any OS unless the OS have JVM
Java works by first compiling the source code into bytecode. Then,
the bytecode can be compiled into machine code with the Java Virtual Machine (JVM).
Java’s bytecode can run on any device with the JVM which is why Java is known as
 a “write once, run anywhere” language.


More about platform independence :
- It means that byte code can run on all operating systems
- We need to convert source code to machine code so computer can understand
- Compiler helps in doing this by turning it in to executable code(.exe)
- After compiling C/C++ code we get .exe file which is platform dependent
- In Java we get byte code, JVM converts this to machine code
- Java is platform-independent but JVM is platform dependent

JDK vs JRE vs JVM vs JIT
————————————————————————————————————
|  JDK = JRE + development 					|
|  (Java Development Kit)						|
|.     —————————————————————————|—————————
|.      |.  JRE = JVM +library classes        			|
|.      |.   (Java Runtime Environment)				|
|.      |	|——————————————————————|———————
|       |	|.     Java Virtual Machine (JVM)			|
|	|	|									|
|	|	|——————————————————————|———————
|	|	|.    JIT								|
|	|	|.  (Just in time)						|
|	|	|									|
|	|	|——————————————————————|———————


JDK
- Provides environment to develop and run the Java program
- It is a package that includes:
1. Development tools- to provide an environment to develop your programme
2. JRE- to execute your program
3. A compiler - javac (which compiles .java file to byte code)
4. Archiver = jar
5. Docs generator - javadoc
6. Interpreter / loader

JRE
- It is an installation package that provides environment  to only run the program
- It consists of :
1. Deployment technologies
2. User interface toolkits
3. Integration libraires
4. Base libraries
5. JVM
- After we get the .class file, the next things happen at runtime:
1. Class loader loads all Classes needed to execute the program
2. JVM sends code to Byte code verifier to check the format of code


Compile time 			        Run time       			(How JVM works) Class loader
————————                ——————————                      Loading:
.java file					class loader	  			- reads .class file and generate binary data
        ⬇️						⬇️					- an object of this class is created in heap
        ⬇️ java					⬇️
	   ⬇️ (compilation)			⬇️					 Linking:
.class file			        Byte code verifier			- JVM verifies the .class file
        					    ⬇️					- allocates memory for class variables and
        						⬇️					   direct references
						   Interpreter
							    ⬇️					Initialisation
        	  					⬇️					- all static variables are assigned with their
						    Runtime			           values defined in the code and static block
							    ⬇️
        						⬇️				      JVM contains the stack and Heap memory
						   Hardware				allocations.

JVM execution
Interpreter:
- Line by line execution
- When one method is called many times,
       It will interpret again and again
JIT:
- Those methods that are repeated,
       JIT provides direct machine code
	so re-interpretation is not required.
- Makes execute faster
	garbage collector


Brife:
Java Source Code   → JDK   →  Bytecode  →   JVM (Hardware somewhere)   →   JRE

Tools required to start programming in java
First from oracle software download java JDK and install it in your OS
Then you need to install IDE or a tool to write your code download IntelliJ IDEA community edition


In Java, all the variables must be declared before use.
1. Local Variables
A variable defined within a block or method or constructor is called a local variable.
These variables are created when the block is entered, or the function is called and destroyed after exiting from the block or when the call returns from the function.
The scope of these variables exists only within the block in which the variable is declared. i.e., we can access these variables only within that block.
Initialization of the local variable is mandatory before using it in the defined scope.

2. Instance Variables
Instance variables are non-static variables and are declared in a class outside any method, constructor, or block.
As instance variables are declared in a class, these variables are created when an object of the class is created and destroyed when the object is destroyed.
Unlike local variables, we may use access specifiers for instance variables. If we do not specify any access specifier, then the default access specifier will be used.
Initialization of Instance Variable is not Mandatory. Its default value is 0
Instance Variable can be accessed only by creating objects.

3. Static Variables
Static variables are also known as Class variables.
These variables are declared similarly as instance variables. The difference is that static variables are declared using the static keyword within a class outside any method constructor or block.
Unlike instance variables, we can only have one copy of a static variable per class irrespective of how many objects we create.
Static variables are created at the start of program execution and destroyed automatically when execution ends.
Initialization of Static Variable is not Mandatory. Its default value is 0
If we access the static variable like the Instance variable (through an object), the compiler will show the warning message, which won’t halt the program. The compiler will replace the object name with the class name automatically.
If we access the static variable without the class name, the compiler will automatically append the class name.

 */