import java.util.*;

public abstract class GameCharacter {

    protected final int playerId;
    protected String username;
    protected long experience;
    protected int damagePoints;
    protected int healthPoints;

    public GameCharacter(int id, String name, long xp, int dmg, int hp){
        if(xp < 0L){
            throw new IllegalArgumentException();
        }
        this.playerId = id;
        this.username = name;
        this.experience = xp;
        this.damagePoints = dmg;
        this.healthPoints = hp;
    }
    public int getPlayerId(){
        return this.playerId;
    }
    public String toString(){
        return String.format("%s %d xp",this.username, this.experience);
    }

    //Method to decrease the player's HP if they suffered an attack
    public void takeDamage(int damage){
        this.healthPoints -= damage;
        if(this.healthPoints < 0){
            this.healthPoints = 0;
        }
    }

    //Method to check if the player is dead
    public Boolean isDead(){
        return (this.healthPoints == 0);
    }

    //Method to check if the current player's ID is equal to some other ID
    public Boolean checkPlayer(int otherPlayerId){
        return (this.playerId == otherPlayerId);
    }

    //Method to calculate and return the level of a player, based on their XP
    /**A player's level is calculated like this: 
     * Take the square root of the player's XP
     * divide the result by 10,
     * Add 1
     * Take the integer part of the result (Math.floor)
     */
    public int getPlayerLevel(){
        return ((int)(Math.floor((Math.sqrt(this.experience) / 10) + 1)));
    }
    public String getUsername(){
        return this.username;
    }
    public long getExperience(){
        return this.experience;
    }
   abstract Boolean attack(GameCharacter otherCharacter) throws AttackCanNotBePerformedException;

}