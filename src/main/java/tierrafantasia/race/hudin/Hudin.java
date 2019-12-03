package tierrafantasia.race.hudin;

import tierrafantasia.race.Race;
import tierrafantasia.race.hudin.state.HudinNormalState;
import tierrafantasia.race.hudin.state.HudinState;
import tierrafantasia.race.hudin.state.NoViolenceHudinState;
import tierrafantasia.stats.Health;
import tierrafantasia.weapons.LongSword;

public class Hudin extends Race {
	private static final int WITHOUT_ARMOR_INCREMENT_RATE = 2;
	private static final double MAX_HEALTH = 100.0;

	private HudinState state;

	public Hudin() {
		super(new Health(MAX_HEALTH), new LongSword());

		state = new HudinNormalState();
	}

	@Override
	protected Double preReceivedAttack(Double damage) {
		return damage * WITHOUT_ARMOR_INCREMENT_RATE;
	}

	@Override
	protected void postReceivedAttack() {
		state = state.postReceivedAttack();
	}

	@Override
	protected boolean preAttack(Race target, Double distance) {
		return state.preAttack(health);
	}

	@Override
	protected void doRest() {
		state = new NoViolenceHudinState();
	}

	@Override
	public String toString() {
		return String.format("Hudin en estado %s", state.toString());
    }
}
