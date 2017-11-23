
public class Paladin extends Player
{
	public Paladin()
	{
		super(12, 18, 7, "paladin.jpg", "Smite", "smite.jpg", "Holy Wrath", "hw.jpg", "Cleanse Soul", "cleanseSoul.jpg", "Curse Soul", "curseSoul.jpg");
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