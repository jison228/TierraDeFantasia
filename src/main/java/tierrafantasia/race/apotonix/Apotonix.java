package tierrafantasia.race.apotonix;

import tierrafantasia.race.Race;
import tierrafantasia.stats.Health;
import tierrafantasia.weapons.Bow;

public class Apotonix extends Race {
	private static final double DAMAGE_REDUCER = (5.0 / 6.0);
	private static final double INITIAL_HEALTH = 81.0;
	private static final double RECOVERY_RATE = 0.25;

	private int receivedAttacks = 0;

	public Apotonix() {
		super(new Health(INITIAL_HEALTH), new Bow());
	}

	@Override
	protected void postReceivedAttack() {
		receivedAttacks++;

		weapon.increaseDamage(Math.pow(2, receivedAttacks));
	}

	@Override
	protected Double preReceivedAttack(Double damage) {
		return damage * DAMAGE_REDUCER;
	}

	@Override
	protected void doRest() {
		heal(INITIAL_HEALTH * RECOVERY_RATE);
	}
}
