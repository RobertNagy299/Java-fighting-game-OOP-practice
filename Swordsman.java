import java.util.*;

public class Swordsman extends GameCharacter{

    private int numberOfSwords; //either 0, 1 or 2

    public Swordsman(int id, String name, long xp, int dmg, int hp, int swords){
        super(id,name,xp,dmg,hp);
        this.setSwords(swords);
    }

    private static Swordsman swordmanFactory(int id, String name, long xp, int dmg, int hp, int swords){
        return new Swordsman(id,name,xp,dmg,hp,swords);
    }

    //Factory function
    public static Swordsman createSwordsman(String data){

        String delim = ";";
        StringTokenizer tokens = new StringTokenizer(data, delim);

        int id = Integer.parseInt(tokens.nextToken());
        String name = tokens.nextToken();
        long xp = Long.parseLong(tokens.nextToken());
        int dmg = Integer.parseInt(tokens.nextToken());
        int hp = Integer.parseInt(tokens.nextToken());
        int swords = Integer.parseInt(tokens.nextToken());

        return swordmanFactory(id,name,xp,dmg,hp,swords);
    }

    //Method to increase the number of swords.
    //Return true if the method successfully increments the number of swords. Otherwise, return false
    public Boolean increaseNumberOfSwords(){

            if(this.numberOfSwords < 2){
                this.numberOfSwords++;
                return true;
            }
            return false;
    }

    @Override
    public Boolean attack(GameCharacter otherCharacter) throws AttackCanNotBePerformedException{

        if(this.numberOfSwords == 0){
            throw new AttackCanNotBePerformedException();
        }
        int actualDamage = 0;

        switch(this.numberOfSwords){
            case 1 : {
                actualDamage = this.damagePoints;
            }break;
            case 2 : {
                actualDamage = (int)(Math.floor(1.5*this.damagePoints));
            }break;
        }

        otherCharacter.takeDamage(actualDamage);
        this.experience += 10*actualDamage;

        if(otherCharacter.isDead()){
            return true;
        }
        return false;

    }
    public void setSwords(int n){
        if(n < 0 || n > 2){
            System.err.println("Error: the number of swords must be 0, 1 or 2");
        }
        this.numberOfSwords = n;
    }
    public int getSwords(){
        return this.numberOfSwords;
    }
}