<h1>Basic Java fighting game</h1>

 <!--### [YouTube Demonstration](https://youtu.be/6kDIZj0qqyE) -->



<h2>Description</h2>
The project is based on a mock-exam exercise my university professor gave us for our "Programming 1" course. The main objective is to get a basic understanding of OOP, specifically, how Java implements the concepts of Object Oriented Programming. 
<br><br>
The project includes a custom exception class, an abstract class, two classes that implement the abstract class, file creation, and ArrayLists. The abstract class defines general character fields and methods, and the 'Archer' and 'Swordsman' classes extend and override these. The 'Game' class contains an inner 'Team' class, and together they form the core of this program.
<br><br>
The original problem description can be found here in Hungarian: https://okt.inf.szte.hu/prog1/gyakorlat/gyakorlat/files/kiugrozh.pdf
<br />


<h2>Languages and Utilities Used</h2>

- <b>Java</b> 


<h2>Environments Used </h2>

- <b>Debian 12 (Linux)</b>
- <b>Visual Studio Code</b>
- <b>Oracle VM Virtualbox</b>

<h2>Program walk-through:</h2>

<p align="left">
Open the folder in Visual Studio Code (make sure that all of the files are in the same folder), open a new terminal, and enter the following command to compile the code:<pre>javac -d bin/ *.java</pre> 
This creates a separate bin folder, where the Java bytecode ".class" files will be stored.
Now run the program: <br><br><pre>java -cp bin/ Main</pre><br><br>
<h2>Note</h2>
The program was compiled and executed using the default Debian JDK and JRE. The quick install guide for the debian JRE and JDK files can be found here: https://wiki.debian.org/Java
<!--<img src="https://i.imgur.com/04KZCnd.png" height="80%" width="80%" alt="Linux command to compile fractal.c"/>
<br />
<br />
Final picture after 10 minutes of runtime with size = 4  <br/>
<img src="https://i.imgur.com/zJlwhLy.png"  alt="Final picture of the dragon fractal" height="100%" width="100%" />
<br />
<br /> -->
<!--
Valgrind error messages: <br/> <br>
<img src="https://i.imgur.com/cqioXzG.png" height="80%" width="80%" alt="Valgrind error messages on the terminal screen"/>
<br />
<br />


<!--
<h2>Conclusion and final comments</h2>

I am rather disappointed by the fact that my code is so inefficient and unsafe. However, it is worth nothing that this project was more of a proof-of-concept, a challenge by an older student. 

Possible issues / ideas for improvement: Perhaps I should change the function return types to 'void', and use a node_t** type as an argument, in order to avoid unneccessarily copying nodes in the memory. I also fail to free the allocated memory at a number of instances.
<!--
 ```diff
- text in red
+ text in green
! text in orange
# text in gray
@@ text in purple (and bold)@@
```
--!>
