package tierrafantasia.weapons;

import tierrafantasia.stats.Range;

public class NoWeapon extends Weapon {
	public NoWeapon() {
		super(new Range(0, 0), 0d);
	}
}
