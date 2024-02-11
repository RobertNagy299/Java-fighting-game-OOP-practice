import java.util.*;
import java.io.*;

public class Game {

    public String gameName;
    public ArrayList<Team> teams = new ArrayList<>(); //type inference

    public Game(String gameName){
        this.gameName = gameName;
    }

    //Method to delete a specific team
    public void deleteTeam(String nameOfTheTeam){
        int index = -1;
        for(Team t : teams){
            index++;
            if(t.teamName.equals(nameOfTheTeam)){
                this.teams.remove(index);
                break;
            }
        }
    }
    public void listNamesAccordingToTeam(){
        try{
            for(Team t : this.teams){

                String fileName = String.format("namelist-%s.txt",t.teamName);
                File myFile = new File(fileName);

                //true if the file did not already exist
                if(myFile.createNewFile()){

                    FileWriter myWriter = new FileWriter(fileName);
                    
                    for(GameCharacter c : t.teamMembers){
                        myWriter.write(String.format("%s\n",c.getUsername()));  
                    }

                    myWriter.close();
                }
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        
    }

    //Method to determine whether there are more swordsmen or archers
    public String determineMajorityType(){

        int numberOfSwordsmen = 0;
        int numberOfArchers = 0;
        for(Team t : this.teams){
            for(GameCharacter c : t.teamMembers){
                if(c instanceof Swordsman){
                    numberOfSwordsmen++;
                    continue;
                }
                if(c instanceof Archer){
                    numberOfArchers++;
                }
                
            }
        }
        if(numberOfArchers == numberOfSwordsmen){
            return String.format("The number of swordsmen is the same as the number of archers.");
        }
        if(numberOfArchers > numberOfSwordsmen){
            return String.format("There are more archers!");
        }
        else{
            return String.format("There are more swordsmen!");
        }
    }

    public GameCharacter bestCharacter(){

        GameCharacter best = null;
        int maximum = -1111;
        for(Team t : this.teams){
            for(GameCharacter c : t.teamMembers){

                if(c.getPlayerLevel() >= maximum){
                    maximum = c.getPlayerLevel();
                    best = c;
                }

            }
        }
        return best;
    }

    //Method that returns an array filled with the XP values of each member of the specified team
    public ArrayList<Long> experienceOfTeamMembers(String nameOfTheTeam){

        ArrayList<Long> myArr = new ArrayList<>();

        for(Team t : this.teams){
            if(t.teamName.equals(nameOfTheTeam)){

                for(GameCharacter c : t.teamMembers){
                    myArr.add(c.getExperience());
                }
            }
        }
        return myArr;//.stream().mapToLong(i -> i).toArray();
    }

    //Method to add a new character to a selected team
    public void addCharacterToSpecifiedTeam(String nameOfTheTeam, GameCharacter characterToBeAdded){
        Boolean teamExists = false;
        int index = -1;
        for(Team t : this.teams){
            index++;
            if(t.teamName.equals(nameOfTheTeam)){
                teamExists = true;
                break;
            }
        }
        if(teamExists == true){
            teams.get(index).insertMember(characterToBeAdded);
            return;
        }
        else{
            teams.add(new Team(nameOfTheTeam, characterToBeAdded));
        }
    }
    public class Team {

        public String teamName;
        public ArrayList<GameCharacter> teamMembers = new ArrayList<>();

        public Team(String teamName, GameCharacter characterToBeAdded){
            this.teamName = teamName;
            this.teamMembers.add(characterToBeAdded);
            Game.this.teams.add(this);
        }
        
        //Method to insert new team members in increasing order, based on the player IDs.
        public void insertMember(GameCharacter c){

            if(this.teamMembers.isEmpty()){
                this.teamMembers.add(c);
                return;
            }
            int index = -1;
            Boolean atEnd = true;
            for(GameCharacter player : this.teamMembers){

                index++;
                if(player.getPlayerId() >= c.getPlayerId()){
                    atEnd = false;
                    break;
                    
                }
                
            }
            if(atEnd == false){
                this.teamMembers.add(index, c);
                return;
            } else {
                this.teamMembers.add(c);
            }
            

        }
    }


}