package tierrafantasia.race.gnikgers;

import tierrafantasia.race.Race;
import tierrafantasia.race.gnikgers.state.GnikgerNormalState;
import tierrafantasia.race.gnikgers.state.GnikgerState;
import tierrafantasia.race.gnikgers.state.GnikgerStoneState;
import tierrafantasia.stats.Health;
import tierrafantasia.weapons.Katana;

public class Gnikgers extends Race {
	private static final int DAMAGE_MULTIPLIER = 4;

	private static final double HEALTH = 86;

	private Integer completedAttacks = 0;

	private GnikgerState state;

	public Gnikgers() {
		super(new Health(HEALTH), new Katana());

		state = new GnikgerNormalState(this);
	}

	@Override
	protected void doRest() {
		health.heal(HEALTH);

		state = new GnikgerStoneState(this);
	}

	@Override
	protected Double preReceivedAttack(Double damage) {
		return state.preReceivedAttack(damage);
	}

	@Override
	protected void postReceivedAttack() {
		state = state.postReceivedAttack();
	}

	@Override
	protected void postAttack(Race target) {
		completedAttacks++;
		state = state.postAttack();
	}

	@Override
	public String toString() {
		return String.format("Gnikger %s", state.toString());
	}

	public void increaseDamage() {
		weapon.increaseDamage(DAMAGE_MULTIPLIER * completedAttacks);
	}
}
