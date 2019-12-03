package tierrafantasia.race;

import tierrafantasia.stats.Health;
import tierrafantasia.weapons.NoWeapon;

public class RaceDummyReinforced extends Race {

	public RaceDummyReinforced() {
		super(new Health(200), new NoWeapon());
	}

	public RaceDummyReinforced(Health health) {
		super(health, new NoWeapon());
	}
}
