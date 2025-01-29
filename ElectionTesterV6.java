package com.trishawrites;
/**
 * The purpose of this program is to continue our previous program of ArrayLists. We utilize insertion methods for
 * the candidates names and votes, calculate the total votes of all 5 candidates and then, we print/insert various results
 * for our ArrayList)
 *
 * @author Trisha Ganesh
 * @version 6/24/2021
 */

import java.util.ArrayList;

public class ElectionTesterV6 {

    public static void main(String[] args) {
        // create ArrayList
        ArrayList<Candidate> candidate = new ArrayList<Candidate>();
        //add candidate
        candidate.add(new Candidate("Tony Starks", 3691));
        candidate.add(new Candidate("Henry Pymis", 2691));
        candidate.add(new Candidate("Barry Boben", 1962));
        candidate.add(new Candidate("Sammy Robis", 1491));
        candidate.add(new Candidate("Clara Davis", 1968));

        int totalVotes = getTotalVotes(candidate);
        printResults(candidate, totalVotes);
        String nametoFind = "Barry Boben";
        String nametoReplace = "Harry Potter";
        changeName(candidate, nametoFind, nametoReplace);
        int changedVotes = 5000;
        totalVotes = getTotalVotes(candidate);
        printResults(candidate, totalVotes);

        changeVotes(candidate, nametoReplace, changedVotes);
        totalVotes = getTotalVotes(candidate);
        printResults(candidate, totalVotes);

        int changedVotes2 = 4679;
        String nameToFind2 = "Clara Davis";
        String nameToReplace2 = "Joe Hilton";
        changeNameAndVotes(candidate, nameToFind2, nameToReplace2, changedVotes2);
        totalVotes = getTotalVotes(candidate);
        printResults(candidate, totalVotes);

        String insertCandidateName = "Ronald Lang";
        int insertCandidateVotes = 517;
        int insertPosition = 2;
        insertCandidate(candidate, insertPosition, insertCandidateName, insertCandidateVotes);
        totalVotes = getTotalVotes(candidate);
        printResults(candidate, totalVotes);

        int insertSecondPosition = 0;
        String insertSecondCandidateName = "Bruce Lanton";
        int insertSecondCandidateVotes = 427;
        String existingName = "Tony Starks";
        insertCandidateBeforeCandidate(candidate, insertSecondPosition, existingName, insertSecondCandidateName, insertSecondCandidateVotes);
        totalVotes = getTotalVotes(candidate);
        printResults(candidate, totalVotes);
    }

    public static void printNamesAndVotes(ArrayList<Candidate> elections) {
        for (Candidate candidate : elections)
            //print statement using to String method of Candidate class
            System.out.println(candidate);
    }

    public static int getTotalVotes(ArrayList<Candidate> elections) {
        int totalVotes = 0;
        for (Candidate candidate : elections) {
            totalVotes += candidate.getVotes();
        }
        return totalVotes;
    }

    //method for changing a candidate's name
    public static void changeName(ArrayList<Candidate> elections, String find, String replace) {
        for (int index = 0; index < elections.size(); index++)
            if (elections.get(index).getName().equals(find)) {
                System.out.println();
                System.out.println("==================================================================");
                System.out.print("<< Changing name from " + elections.get(index).getName());
                elections.get(index).setName(replace);
                System.out.println(" to " + elections.get(index).getName() + " >>");
            }
    }

    //method for changing a candidate's votes
    public static void changeVotes(ArrayList<Candidate> elections, String find, int replace) {
        int index;
        for (index = 0; index < elections.size(); index++)
            if (elections.get(index).getName().equals(find)) {
                System.out.println();
                System.out.print(" << Changing votes for " + elections.get(index).getName());
                elections.get(index).setVotes(replace);
                System.out.println("  to " + elections.get(index).getVotes() + " >>");
            }
    }

    //method for changing a candidate's Name and Votes
    public static void changeNameAndVotes(ArrayList<Candidate> elections, String find, String replaceName, int replaceVotes) {
        for (int index = 0; index < elections.size(); index++)
            if (elections.get(index).getName().equals(find)) {
                System.out.println();
                System.out.print(" << Changing name from " + elections.get(index).getName());
                elections.get(index).setName(replaceName);
                System.out.println(" to " + elections.get(index).getName() + ", then changing votes for " +
                        elections.get(index).getName());
                elections.get(index).setVotes(replaceVotes);
                System.out.println("  to " + elections.get(index).getVotes() + " >>");
            }
    }

    // a method that will insert a new candidate into a specified position
    public static void insertCandidate(ArrayList<Candidate> elections, int position, String addName, int addVotes)
    {
        {
            // insert item into ArrayList
            elections.add(position, new Candidate(addName, addVotes));
            System.out.println();
            System.out.println("=============================================================================================");
            System.out.println("<< In " + "position " + position + "," + " add " + addName + ", " + addVotes + " votes >>");

        }
    }

    public static void insertCandidateBeforeCandidate(ArrayList<Candidate> elections, int position, String findName, String addCandidate, int addVotes) {
        // insert item into ArrayList
        elections.add(position, new Candidate(addCandidate, addVotes));
        System.out.println();
        System.out.println("=============================================================================================");
        System.out.println("<< Before " + findName + " ," + " add " + addCandidate + ", " + addVotes + " votes >>");
    }


    public static void printResults(ArrayList<Candidate> elections, int totalVotes) {
        System.out.println();
        System.out.println("Original Results: ");
        System.out.println();
        System.out.println("Candidate" + "\t\t\t\t" + "Votes Received" + "\t\t\t" + "% of Total Votes");
        System.out.println("====================================================================================");
        for (Candidate candidate : elections) {
            float percentageTotalVotes = ((float) candidate.getVotes() / (float) totalVotes) * 100;
            System.out.println();
            System.out.printf("%s %21d %25s",
                    candidate.getName(), candidate.getVotes(), percentageTotalVotes + "%");
        }
        System.out.println("\n");
        System.out.println("The total number of votes for this election is: " + totalVotes);
    }
}

