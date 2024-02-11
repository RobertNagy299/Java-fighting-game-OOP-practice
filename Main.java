import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws AttackCanNotBePerformedException{

        try {
            
            Archer myArcher = new Archer(5,"5",56,25,50,15);
            Archer myArcher2 = new Archer(80,"80",56,25,50,15);
            Archer myArcher3 = new Archer(13,"13",56,25,50,15);
            Archer myArcher4 = new Archer(1,"1",56,25,50,15);
            Swordsman mySwordsman = Swordsman.createSwordsman("1360;Ted1;15643242;50;150;1");
            Swordsman mySwordsman2 = Swordsman.createSwordsman("137;Ted2;156;50;150;1");
            Swordsman mySwordsman3 = Swordsman.createSwordsman("138;Ted3;156;50;150;1");
            Swordsman mySwordsman4 = Swordsman.createSwordsman("139;Ted4;156;50;150;1");
            Swordsman mySwordsman5 = Swordsman.createSwordsman("140;Ted5;156;50;150;1");
            
            Game myGame = new Game("FirstGame");
            Game.Team myFirstTeam = myGame.new Team("Eagles", myArcher);
            Game.Team mySecondTeam = myGame.new Team("Boars", mySwordsman);
            myFirstTeam.insertMember(myArcher2);
            myFirstTeam.insertMember(myArcher3);
            myFirstTeam.insertMember(myArcher4);

            myGame.addCharacterToSpecifiedTeam("Boars",mySwordsman2);
            myGame.addCharacterToSpecifiedTeam("Boars",mySwordsman3);
            myGame.addCharacterToSpecifiedTeam("Boars",mySwordsman4);
            myGame.addCharacterToSpecifiedTeam("Boars",mySwordsman5);

            for(Game.Team t : myGame.teams){
                System.out.println(t.teamMembers);
            }
            System.out.println(myGame.teams.size());
            ArrayList<Long> myExps= myGame.experienceOfTeamMembers("Boars");
            System.out.println(myExps.toString());
            GameCharacter best = myGame.bestCharacter();
            System.out.println(best);
            String maj = myGame.determineMajorityType();
            System.out.println(maj);
            myGame.listNamesAccordingToTeam();
            myGame.deleteTeam("Eagles");
            System.out.println(myGame.teams.size());

            /****
             * TESTED: Team.insertMember()
             *         Team Constructor
             * 
             *         Game Constructor
             *         Game determineMajorityType()
             *         Game deleteTeam()
             *         Game addCharacterToSpecificTeam()
             *         Game experienceOfTeamMembers()
             *         Game bestCharacter()
             *         Game listNamesAccordingToTeam()
             */
        }
        catch(Exception e){
            System.out.println(e);
        }



    }
    private static void testEx() throws AttackCanNotBePerformedException{
        throw new AttackCanNotBePerformedException();
    }
}