/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @Author Kevin Gowsell
 */
public class Quidditch_Simulation {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        String playerA = "";
        String playerB = "";
        int teamNumber = 0;
        
        ArrayList<String>harryP = new ArrayList<>();
        harryP.add("Hogwarts"); //at index 0
        harryP.add("Beauxbatons");
        harryP.add("Castelobruxo");
        harryP.add("Durmstrang");
        harryP.add("Ilvermorny");
        harryP.add("Mahoutokoro");
        harryP.add("Uagadou");
        harryP.add("Koldovstoretz"); // at index 7
        
        
        //Title 
        System.out.println("Welcome to the World Wizarding Quidditch Tournament!");
        System.out.println("This Years Competators Are: ");
        System.out.println("");
        
        for (String name : harryP) //print out the list of contestants
        {
            System.out.println(name);
        }
        System.out.println("");
        System.out.println("MATCH #1");
        playGame(harryP.get(0), harryP.get(1), harryP); //round 1 match 1
        System.out.println("");

        playGame(harryP.get(1), harryP.get(2), harryP); //round 1 match 2
        System.out.println("");
        
        playGame(harryP.get(2), harryP.get(3), harryP); //round 1 match 3
        System.out.println("");
        
        playGame(harryP.get(3), harryP.get(4), harryP); //round 1 match 4
        System.out.println("");
        System.out.println("MATCH #2");
        playGame(harryP.get(0), harryP.get(1), harryP); //round 2 match 1
        System.out.println("");
        
        playGame(harryP.get(1), harryP.get(2), harryP); //round 2 match 2
        System.out.println("");
        System.out.println("FINAL MATCH");
        playGame(harryP.get(0), harryP.get(1), harryP); //round 1 match 1
        System.out.println("");
        
        System.out.println(harryP.get(0) + " is the World Wizarding Qudditch Champion!");
           
    }
    
    public static void playGame(String teamA, String teamB, ArrayList<String>harryP)
    {
        Random rnd = new Random();
        //team A and team B will be the index with which I will pull the array name 
        //each team scores 0-4 goals randomly, each worth 10 points a peice per round 
        int goalsA = 0;
        int goalsB = 0;
        int teamATotal = 0;
        int teamBTotal = 0;
        final int POINTS_PER_GOAL = 10;
        int round = 0;
        int infiniteRounds = 4;
        boolean victory = false;
        int snitch = 0;
        int winningTeam = 0;
        int snitchValue = 150;
        boolean gameEnd = false;
        
        do
        {
            System.out.println(teamA + " vs "+ teamB );
            System.out.println("-----------------------------------------");
            do
            {
                round++; //increase the round
                
                
                
                goalsA = (int)(Math.random()*((4-0)+1))+0;
                goalsA = goalsA*10;
                teamATotal += goalsA; //random number of goals worth ten each per round
                //System.out.println("Qtr " +round + ": " +teamA + " Goals: " + goalsA);
                
                goalsB = (int)(Math.random()*((4-0)+1))+0;
                goalsB = goalsB*10;
                teamBTotal += goalsB;//random number of goals worth ten each per round
                //System.out.println("Qtr " +round + ": " +teamB + " Goals: " + goalsB);
                System.out.println("Qtr " + round + ": " +goalsA+ "    " + goalsB);
                snitch = (int)(Math.random()*((100-1)+1))+1;
                if(snitch<16) //15% chance the snitch will be caught. 
                {
                    winningTeam = (int)(Math.random()*((100-1)+1))+1;
                    if(winningTeam<=50)
                    {
                        teamATotal = teamATotal + snitchValue;
                        System.out.println(teamA + " caught the snitch! + 150 points!");
                    }
                    else
                    {
                        teamBTotal = teamBTotal + snitchValue;
                        System.out.println(teamB + " caught the snitch! + 150 points!");
                    }
                    
                     gameEnd = true; //game ends if the snitch is caught 
                }
                
                if(round >= infiniteRounds && teamATotal!=teamBTotal)
                {
                    gameEnd = true; //game ends after four quarters 
                }
                if(round ==4 && teamATotal==teamBTotal)
                {
                    round--; // the game continues for one round should there be a tie. 
                }
            }while (!gameEnd);
            System.out.println(teamA + ": " + teamATotal);
            System.out.println(teamB + ": " + teamBTotal);
            if(teamATotal>teamBTotal)
            {
                System.out.println( teamA + " wins" );
                harryP.remove(teamB);
                System.out.println(teamB + " elminated ");
            }
            else
            {
                System.out.println( teamB + " wins");
                harryP.remove(teamA);
                System.out.println(teamA+ " elminated ");
            }
            victory = true;
        }while(!victory);
        System.out.println("-----------------------------------------");
        
        
    }
    
}
