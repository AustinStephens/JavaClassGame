public class Dot implements DotState
{
    public Player user;       //not going to make a getter and setter for this, kind of useless
    
    public Dot(Player p)
    {
        user = p;
    }
    
    public void change()
    {
        user.setDotState(user.noDot);
    }
    
    public void dotSpell(Player enemy)
    {
        user.getDebuffState().dmgSpell(enemy, user.getDotDmg());
    }
}