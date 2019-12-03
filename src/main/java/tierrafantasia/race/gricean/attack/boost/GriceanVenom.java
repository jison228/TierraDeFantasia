package tierrafantasia.race.gricean.attack.boost;

import tierrafantasia.buff.Penalization;
import tierrafantasia.stats.Health;

public class GriceanVenom extends Penalization {

	private static final int TURNS_DURATION = 2;
	private static final int DAMAGE = 10;

	public GriceanVenom() {
		super(TURNS_DURATION);
	}

	@Override
	public String toString() {
		return "Veneno Gricean";
	}

	@Override
	protected void applyBuff(Health health) {
		health.decrement(DAMAGE);
	}

}
