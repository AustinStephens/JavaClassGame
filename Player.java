import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

abstract class Player
{
	private int health;     //base stats
	private int damage;
	private int dotDmg;
	private int heal;
	private boolean shield;
	
	//state properties
	private DotState dotState;
	private DebuffState debuffState;
	
	public String classIcon;
	//spell 1
	public String damageName;          //These are private in C++ version, however,
	public String damageIcon;			//looking now they dont really contain sensitive
										//information, nor would I ever change these
	//spell 2							//so I'm gonna make them public
	public String dotName;
	public String dotIcon;
	
	//spell 3
	public String hosName;
	public String hosIcon;
	
	//spell 4
	public String debuffName;
	public String debuffIcon;
	
	//counts for states
	private int debuffCount;
	private int dotCount;
	
	//each possible state property
	public NoDebuff noDebuff;
	public Debuff debuff;
	public Dot dot;
	public NoDot noDot;
	
	//text field and health bar
	public JLabel healthBar;
	
	//METHODS *********************************************************
	//*****************************************************************
	
	//CONSTRUCTOR
	public Player(int dmg, int h, int dd, String ci, String dn, String di, String don, String doi, String hn, String hi, String den, String dei)
	{
		setHealth(100);
		setDamage(dmg);
		setHeal(h);
		setDotDmg(dd);
		classIcon = ci;
		damageName = dn;
		damageIcon = di;
		dotName = don;
		dotIcon = doi;
		hosName = hn;
		hosIcon = hi;
		debuffName = den;
		debuffIcon = dei;
		
		//making new objects and storing them rather than making new ones each time states change
		noDot = new NoDot(this);
		dot = new Dot(this);
		noDebuff = new NoDebuff(this);
		debuff = new Debuff(this);
		
		//setting debuff and dot states to nothing
		setDebuffState(noDebuff);
		setDotState(noDot);
	}
	
	//ABSTRACT METHODS
	abstract void damageSpell(Player enemy);
	abstract void dotSpell(Player enemy);
	abstract void hosSpell();
	abstract void debuffSpell();
	
	//REGULAR METHODS
	
	//getters for states
	public DotState getDotState()
	{ return dotState; }
	
	public DebuffState getDebuffState()
	{ return debuffState; }
	
	//setters for states
	public void setDotState(DotState dotS)
	{ dotState = dotS; }
	
	public void setDebuffState(DebuffState debuffS)
	{ debuffState = debuffS; }
	
	//getters for base stats
	public int getHealth()
	{ return health; }
	
	public int getDamage()
	{ return damage; }
	
	public int getDotDmg()
	{ return dotDmg; }
	
	public int getHeal()
	{ return heal; }
	
	public int getDotCount()
	{ return dotCount; }
	
	public int getDebuffCount()
	{ return debuffCount; }
	
	//setters for base stats
	public void setHealth(int hp)
	{
		if (hp < 0)
		{
			hp = 0;
		}
		health = hp;
	}
	
	public void loseHealth(int hpLost)
	{
		setHealth(getHealth() - hpLost);
	}
	
	public void gainHealth(int hpGained)
	{
		if (shield || getHealth() + hpGained <= 100) {
			setHealth(getHealth() + hpGained);
		} else {
			setHealth(100); 
		}
	}
	
	public void setDamage(int dmg)
	{ damage = dmg; }
	
	public void setDotDmg(int dd)
	{ dotDmg = dd; }
	
	public void setHeal(int h)
	{ heal = h; }
	
	public void setDebuffCount(int count)
	{
		if(count <= 0) //equals-to is only there to change the state when its 0
		{
			count = 0;
			getDebuffState().change();
		}
		
		debuffCount = count;
	}
	
	public void setDotCount(int count)
	{
		if(count <= 0)
		{
			count = 0;
			getDotState().change();
		}
		
		dotCount = count;
	}
	
	public void updateCounts()
	{
		setDebuffCount(getDebuffCount() - 1);
		setDotCount(getDotCount() - 1);
	}
	
	public void updateBar()
	{
		healthBar.setText(getHealth() + "/100");
	}
}