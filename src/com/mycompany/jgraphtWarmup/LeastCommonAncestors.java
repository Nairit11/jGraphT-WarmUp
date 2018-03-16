package com.mycompany.jgraphtWarmup;

/**
 *
 * @author nairit-11
 */
import org.jgrapht.Graph;
import org.jgrapht.alg.CycleDetector;
import org.jgrapht.alg.NaiveLcaFinder;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.io.*;

import java.io.File;
import java.util.Set;
public class LeastCommonAncestors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if (args.length != 3) {
            System.out.println("Parameters passed should be of form : input_file person1 person2");
            return;
        }
        
        File InputFile = new File(args[0]);
        
        String person1 = args[1];
        String person2 = args[2];

        // Importing the graph from input file
        Graph<String, DefaultEdge> InputGraph = new SimpleDirectedGraph<>(DefaultEdge.class);
        VertexProvider<String> vp = (label, attributes) -> label;
        EdgeProvider<String, DefaultEdge> ep = (from, to, label, attributes) -> new DefaultEdge();
        GraphImporter<String, DefaultEdge> importer = new DOTImporter<>(vp, ep);
        try {
            importer.importGraph(InputGraph, InputFile);
        } catch (ImportException e) {
            System.out.println("Import of Graph Failed : "+e);
        }
        
        // Checking for cycles in the graph, in case there are cycles present least common ancestor cannot be found
        CycleDetector<String, DefaultEdge> cd = new CycleDetector<>(InputGraph);
        if (cd.detectCycles()) {
            System.out.println("The Graph Contains Cycles");
            return;
        }
        
        // Getting all least commont ancestors 
        NaiveLcaFinder<String, DefaultEdge> lcaFinder = new NaiveLcaFinder<>(InputGraph);
        Set<String> lcas = lcaFinder.findLcas(person1, person2);
        
        // Printing the fetched result
        System.out.println("Least Common Ancestors of "+person1+" and "+ person2+" is/are :");
        if(!lcas.isEmpty()){
            for (String i : lcas) {
                System.out.println(i);
            }
        }
        else{
            System.out.println("None");
        }
    }
    
}
