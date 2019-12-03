package tierrafantasia.race;

import tierrafantasia.stats.Health;
import tierrafantasia.weapons.NoWeapon;

public class RaceDummy extends Race {

	public RaceDummy() {
		super(new Health(100), new NoWeapon());
	}

	public RaceDummy(Health health) {
		super(health, new NoWeapon());
	}
}
