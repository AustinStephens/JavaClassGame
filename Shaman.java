
public class Shaman extends Player
{
	public Shaman()
	{
		super(12, 18, 7, "shaman.jpg", "Lava Bolt", "lb.jpg", "Frost Bite", "frostb.jpg", "Restore Spirit", "restsp.jpg", "Curse", "curse.jpg");
	}
	
	public void damageSpell(Player enemy)
	{
		getDebuffState().dmgSpell(enemy, getDamage());
	}
	
	public void dotSpell(Player enemy)
	{
		setDotState(dot);
		setDotCount(3);
		getDebuffState().dmgSpell(enemy, getDotDmg());
	}
	
	public void hosSpell()
	{
		gainHealth(getHeal());
	}
	
	public void debuffSpell()
	{
		setDebuffState(debuff);
		setDebuffCount(3);
	}
}