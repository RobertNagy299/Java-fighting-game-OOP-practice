import java.util.*;

public class Archer extends GameCharacter {

    private int numberOfArrows;

    //Constructor with a custom amount of arrows
    public Archer(int id, String name, long xp, int dmg, int hp, int arrows){
        super(id,name,xp,dmg,hp);
        this.setArrows(arrows);
    }

    //Constructor with the default number of arrows
    public Archer(int id, String name, long xp, int dmg, int hp){
        this(id,name,xp,dmg,hp,5);
    }

    //Method to check if this archer has more arrows than some other archer
    public Boolean doesHaveMoreArrows(Archer otherArcher){
        return (this.numberOfArrows > otherArcher.getArrows());
    }

    @Override
    public Boolean attack(GameCharacter otherCharacter) throws AttackCanNotBePerformedException{

        if(this.numberOfArrows == 0){
            throw new AttackCanNotBePerformedException();
        }
        
        this.numberOfArrows--;
        otherCharacter.takeDamage(this.damagePoints);
        this.experience += 13*this.damagePoints;
        
        if(otherCharacter.isDead()){

            System.out.println("The archer has defeated the enemy.");
            return true;
        }
        return false;

        

    }
    public void setArrows(int n){
        if(n < 0){
            throw new IllegalArgumentException();
        }
        this.numberOfArrows = n;
    }
    public int getArrows(){
        return this.numberOfArrows;
    }
}