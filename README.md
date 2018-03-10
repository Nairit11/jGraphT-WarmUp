# jGraphT-WarmUp
This application is the solution to the Warm-Up excercise for GSOC-2018.

## Problem statement

Develop a Java application which can read a simple family tree in .dot (graphviz) format and compute the closest common ancestor of two people.  For the .dot file, use Listing 1 from [this PDF file](https://visualization.sites.clemson.edu/visualization/wp-content/uploads/2016/10/user-guide-graphviz-palmetto.pdf).  Given this file as the tree to work from, and the two inputs "Jon" and "Daenerys", the result should be "Aerys II The Mad".  Or given the two inputs "Sansa" and "Arya", the result should be "Eddard".

If there are multiple common ancestors of equal distance, output all of them.

The Java application should take three parameters on the command line:

* name of .dot file
* name of person 1

## To run the application

```shell
bash main.sh input.dot person1 person2
```

## Tools required

*Java
*Maven

This application was built in NetBeansIDE, which can also be used to build and run the application 
