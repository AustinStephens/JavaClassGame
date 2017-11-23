
public class NoDebuff implements DebuffState
{
        public Player user;
        
        public NoDebuff(Player p)
        {
            user = p;
        }
        
        public void change()
        {
            return;
        }
        
        public void dmgSpell(Player enemy, int dmg)
        {
            enemy.loseHealth(dmg);
        }
    
}