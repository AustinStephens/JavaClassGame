import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Warlock extends Player
{
	public Warlock()
	{
		super(15, 15, 5, "warlock.jpg", "Fire Ball", "fb.jpg", "Burn", "b.jpg", "Death Shield", "ds.jpg", "Poison", "p.jpg");
	}
	
	public void damageSpell(Player enemy)
	{
		getDebuffState().dmgSpell(enemy, getDamage());
		//output.setText(getOutputStart() + " used " + damageName + " ");
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