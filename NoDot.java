
public class NoDot implements DotState
{
    public Player user;   //not going to make a getter and setter for this, kind of useless
    
    public NoDot(Player p)
    {
        user = p;
    }
    
    public void change()
    {
        return;
    }
    
    public void dotSpell(Player enemy)
    {
        return;
    }
}