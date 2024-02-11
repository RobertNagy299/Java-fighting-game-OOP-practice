import java.util.*;

public class AttackCanNotBePerformedException extends Exception{

    public AttackCanNotBePerformedException(){
        super("Attack can not be performed!");
    }
    private AttackCanNotBePerformedException(String msg){
        super(msg);
    }
    public AttackCanNotBePerformedException(Boolean b) throws AttackCanNotBePerformedException {
        if(b == true){
            throw new AttackCanNotBePerformedException();
        }
        else{
            throw new AttackCanNotBePerformedException("Invalid attack!");
        }
    }
}