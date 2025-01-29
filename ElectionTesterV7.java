package com.trishawrites;

/**
 * The purpose of this program is to continue our previous program of Arrays. We utilize deletion methods for
 * the candidates names and votes, calculate the total votes of all 5 candidates and then, we print/insert various values
 * for our Array)
 *
 * @author Trisha Ganesh
 * @version 6/24/2021
 */

public class ElectionTesterV7 {

    public static void main(String[] args) {
        Candidate[] candidate = new Candidate[5];
        candidate[0] = new Candidate("Tony Starks", 3691);
        candidate[1] = new Candidate("Henry Pymis", 2691);
        candidate[2] = new Candidate("Barry Boben", 1962);
        candidate[3] = new Candidate("Sammy Robis", 1491);
        candidate[4] = new Candidate("Clara Davis", 1968);

        //call printNamesAndVotes method
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
        String existingName = "Henry Pymis";
        insertCandidateBeforeCandidate(candidate, insertSecondPosition, existingName, insertSecondCandidateName, insertSecondCandidateVotes);
        totalVotes = getTotalVotes(candidate);
        printResults(candidate, totalVotes);

        deletePosition(candidate, 2);
        totalVotes = getTotalVotes(candidate);
        printResults(candidate, totalVotes);

        deleteCandidateName(candidate, insertSecondCandidateName);
        totalVotes = getTotalVotes(candidate);
        printResults(candidate, totalVotes);
    }

    public static void printNamesAndVotes(Candidate[] elections) {
        for (int index = 0; index < elections.length; index++)
            if(elections[index] != null)
                //print statement using to String method of Candidate class
                System.out.println(elections[index]);
    }

    public static int getTotalVotes(Candidate[] elections) {
        int totalVotes = 0;
        for (Candidate candidate : elections) {
            if (candidate != null)
                totalVotes += candidate.getVotes();
            //if (elections[index] != null);
        }
        return totalVotes;
    }

    //method for changing a candidate's name
    public static void changeName(Candidate[] elections, String find, String replace) {
        for (int index = 0; index < elections.length; index++)
            if ((elections[index] != null) && (elections[index].getName().equals(find))) {
                System.out.println();
                System.out.println("==================================================================");
                System.out.print("<< Changing name from " + elections[index].getName());
                elections[index].setName(replace);
                System.out.println(" to " + elections[index].getName() + " >>");
            }
    }

    //method for changing a candidate's Votes
    public static void changeVotes(Candidate[] elections, String find, int replace) {
        for (int index = 0; index < elections.length; index++)
            if ((elections[index] != null) && (elections[index].getName().equals(find))) {
                System.out.println();
                System.out.print(" << Changing votes for " + elections[index].getName());
                elections[index].setVotes(replace);
                System.out.println("  to " + elections[index].getVotes() + " >>");
            }
    }

    //method for changing a candidate's Name and Votes
    public static void changeNameAndVotes(Candidate[] elections, String find, String replaceName, int replaceVotes) {
        for (int index = 0; index < elections.length; index++)
            if ((elections[index] != null) && (elections[index].getName().equals(find))) {
                System.out.println();
                System.out.print(" << Changing name from " + elections[index].getName());
                elections[index].setName(replaceName);
                System.out.println(" to " + elections[index].getName() + ", then changing votes for " +
                        elections[index].getName());
                elections[index].setVotes(replaceVotes);
                System.out.println("  to " + elections[index].getVotes() + " >>");
            }
    }

    // a method that will insert a new candidate into a specified position
    public static void insertCandidate(Candidate[] elections, int position, String addName, int addVotes) {
        for (int index = elections.length - 1; index > position; index--)
            elections[index] = elections[index - 1];
        elections[position] = new Candidate(addName, addVotes);
        System.out.println();
        System.out.println("=============================================================================================");
        System.out.println("<< In " + "position " + position + "," + " add " + addName + ", " + addVotes + " votes >>");
    }



    public static void insertCandidateBeforeCandidate(Candidate[] elections, int position, String findName, String addCandidate, int addVotes) {
        position = 0;

        for (int index = 0; index < elections.length; index++)
            if (elections[index].getName().equals(findName)) {
                System.out.println();

                elections[index] = elections[index];
                elections[position] = new Candidate(addCandidate, addVotes);
                System.out.println();
                System.out.println("=============================================================================================");
                System.out.println("<< Before " + findName + " ," + " add " + addCandidate + ", " + addVotes + " votes >>");
            }
    }

    //a method that will delete a particular candidate by position in the election array
    public static void deletePosition(Candidate[] elections, int position)
    {
        if ((position > 0) && (position < elections.length))
        {
            //moving items up in the array (shortening array)
            for(int index = position; index < elections.length - 1; index++)
                elections[index] = elections[index + 1];
            //elections[position] = new Candidate(position, addName);

            elections[elections.length-1] = null;
            System.out.println();
            System.out.println("================================================================================================");
            System.out.println("<< Delete " +  "position " + position + " >>");
        }
    }

    //a method that will find a particular candidate by name and delete that candidate
    public static void deleteCandidateName(Candidate[] elections, String find)
    {
        int position = 0;
        int index;

        //finding position of name we want to delete
        for(index = 0; index < elections.length; index++)
        {
            if((elections[index] != null) && (elections[index].getName().equals(find)))
            {
                position = index;
                break;
            }
            else if(elections[index] == null)
            {
                position = -1;
                break;
            }
        }
        if ((index != elections.length) && (position >= 0))
        {
//move items up in the array
            for(index = position; index < elections.length - 1; index++)
                elections[index] = elections[index + 1];

            elections[elections.length - 1] = null;
        }
        System.out.println();
        System.out.println("<< Delete " +  find +  " >> ");
    }

    public static void printResults(Candidate[] elections, int totalVotes){
        System.out.println();
        System.out.println("Original Results: ");
        System.out.println();
        System.out.println("Candidate" + "\t\t\t\t" + "Votes Received" + "\t\t\t" + "% of Total Votes");
        System.out.println("====================================================================================");
        for (Candidate candidate : elections) {
            if (candidate != null) {
                float percentageTotalVotes = ((float) candidate.getVotes() / (float) totalVotes) * 100;
                System.out.println();
                System.out.printf("%s %21d %25s",
                        candidate.getName(), candidate.getVotes(), percentageTotalVotes + "%");
            }
        }
        System.out.println("\n");
        System.out.println("The total number of votes for this election is: " + totalVotes);
    }
}