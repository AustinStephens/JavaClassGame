
public class Warrior extends Player
{
	public Warrior()
	{
		super(20, 12, 3, "warrior.jpg", "Stab", "s.jpg", "Bleed", "bleed.jpg", "Armor Up", "au.jpg", "Disarm", "disarm.jpg");
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