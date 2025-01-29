package com.trishawrites;
/**
 * The purpose of this program is to create an Array of 5 candidate objects. (Next, we utilize methods to print
 * the candidates names and votes, calculate the total votes of all 5 candidates, and calculate the average of the total)
 *
 * @author Trisha Ganesh
 * @version 6/23/2021
 */


public class ElectionTesterV1 {

    public static void main(String[] args) {
        Candidate[] candidate = new Candidate[5];
        candidate[0] = new Candidate("Tony Starks", 3691);
        candidate[1] = new Candidate("Henry Pymis", 2691);
        candidate[2] = new Candidate("Barry Boben", 1962);
        candidate[3] = new Candidate("Sammy Robis", 1491);
        candidate[4] = new Candidate("Clara Davis", 1968);

        System.out.println("Raw Election Data: ");
        System.out.println();
        //call printNamesAndVotes method
        printNamesAndVotes(candidate);
        int totalVotes = getTotalVotes(candidate);
        printResults(candidate, totalVotes);
    }

    public static void printNamesAndVotes(Candidate[] elections) {
        for(int index = 0; index < elections.length; index++)
            //print statement using to String method of Candidate class
            System.out.println(elections[index]);
    }

    public static int getTotalVotes(Candidate[] elections) {
        int totalVotes = 0;
        for(Candidate candidate : elections)
        {
            totalVotes += candidate.getVotes();
        }
        return totalVotes;
    }
    public static void printResults(Candidate[] elections, int totalVotes){
        System.out.println();
        System.out.println("Election Results: ");
        System.out.println();
        System.out.println("Candidate" + "\t\t\t\t" + "Votes Received" + "\t\t\t" + "% of Total Votes");
        System.out.println("====================================================================================");
        for(Candidate candidate : elections) {
            float percentageTotalVotes = ((float)candidate.getVotes() / (float)totalVotes) * 100;
            System.out.println();
            System.out.printf("%s %21d %25s",
                    candidate.getName(), candidate.getVotes(), percentageTotalVotes + "%");
        }
        System.out.println("\n");
        System.out.println("The total number of votes for this election is: " + totalVotes);
    }
}
