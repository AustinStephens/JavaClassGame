import java.lang.*;

public class Debuff implements DebuffState
{
    public Player user;
    
    public Debuff(Player p)
    {
        user = p;
    }
    
    public void change()
    {
        user.setDebuffState(user.noDebuff);
    }
    
    public void dmgSpell(Player enemy, int dmg)
    {
        enemy.loseHealth((int) Math.floor(dmg * 1.5));
    }
    
}