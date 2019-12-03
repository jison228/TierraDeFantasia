package tierrafantasia.race.hudin.state;

import tierrafantasia.stats.Health;

public class HudinNormalState extends HudinState {
	private static final double HEAL_RATE_WHEN_RECEIVE_DAMAGE = 3.;

	@Override
	public HudinState postReceivedAttack() {
		return this;
	}

	@Override
	public boolean preAttack(Health health) {
		health.heal(HEAL_RATE_WHEN_RECEIVE_DAMAGE);

		return true;
	}

	@Override
	public String toString() {
        return "Normal";
    }
}
