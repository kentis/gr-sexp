#Gr-sexp -- A S-expression parser in groovy

##About

Gr-sexp is a very simple [S-expression](http://en.wikipedia.org/wiki/Sexp) parser written in [Groovy](http://groovy.codehaus.org/). Since it is written in groovy it should also work for all languages on the JVM platform including Java.

Gr-sexp was written to allow another application to parse S-expressions properly. It is extremely simplistic and does not support data types, even ones like numbers and strings other than treating them like any other Atom.

##Acknowledgments

Gr-sexp is a rewrite into Groovy of parts of a lisp parser for python posted at [Probably Programming](http://probablyprogramming.com/2009/11/23/a-simple-lisp-parser-in-python).



##Compiling

Gr-sexp is compiled using [Gradle](http://www.gradle.org/). Provided Gradle is installed on your system Gr-sexp can be compiled by running:

    gradle jar


##Using Gr-sexp

Gr-sexp has a class called `org.k1s.GrSexp.GrSexp`. This class has a method called `parse` which expects as an argument an S-expression as a `String`. The parse method returns A list of the parsed S-expression. In the parsed expression lists are represented by `java.util.List`, and everything else is represented by instances of `org.k1s.GrSexp.Atom`
