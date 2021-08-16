//********************************************************************************************************
// DuplicateTitles.java
//
// COMP 1231 Assignment 3: Exceptions (Question 2)
//
// A program that could be used by a library to process an input file containing the title of books and
// will identify duplicates.  Specifically, the program reads all of the titles from a text file, and
// writes all of the duplicates (if any) to an output file called "duplicateTitles.out".  The output file
// contains all titles that are duplicated in the input file.  The program will only write a duplicated 
// title once to the output file, regardless of how many duplicates there are in the input file.  If there
// are no duplicates, the output file will be empty.
//********************************************************************************************************

import java.io.*;
import java.util.*;

public class DuplicateTitles {
    public static void main(String[] args) throws IOException {
        // paths for input and output files
        String inputFile = "../bookTitles.inp";
        String outputFile = "../duplicatesTitles.out";

        // to hold the title of a book
        String title;

        // list to hold all book titles
        List<String> titles = new LinkedList<String>();

        // sets to hold all unique titles and duplicated titles
        Set<String> uniques = new HashSet<String>();
        Set<String> duplicates = new HashSet<String>();

        // to read in titles from input file
        FileReader fr = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(fr);

        // to write out duplicated titles to output file
        FileWriter fw = new FileWriter(outputFile);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter outFile = new PrintWriter(bw);

        // read in first title from file
        title = br.readLine();

        // loop through remaining titles and add to list of all titles
        while (title != null) {
            titles.add(title);
            title = br.readLine();
        }

        // iterate through list of titles, to identify duplicate titles, storing in a
        // set
        for (String t : titles) {
            if (!uniques.add(t))
                duplicates.add(t);
        }

        // create iterator from set that holds duplicated titles
        Iterator<String> it = duplicates.iterator();

        // write out duplicated titles to output file
        while (it.hasNext()) {
            outFile.println(it.next());
        }

        // close input and output files
        br.close();
        outFile.close();

        System.out.println("Output file has been created: " + outputFile);
    }
}
