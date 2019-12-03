package tierrafantasia.race.gricean;

import tierrafantasia.race.Race;
import tierrafantasia.race.gricean.attack.boost.GriceanVenom;
import tierrafantasia.race.gricean.states.GriceanNormalState;
import tierrafantasia.race.gricean.states.GriceanRestState;
import tierrafantasia.race.gricean.states.GriceanState;
import tierrafantasia.stats.Health;
import tierrafantasia.weapons.Catapult;

public class Gricean extends Race {
	private static final int MAX_HEALTH = 155;
	private GriceanState state;

	public Gricean() {
		super(new Health(MAX_HEALTH), new Catapult());

		state = new GriceanNormalState();
	}

	@Override
	protected void postAttack(Race target) {
		target.addPenalization(new GriceanVenom());

		state = state.postAttack(weapon);
	}

	@Override
	protected void doRest() {
		state = new GriceanRestState();
	}

	@Override
	protected Double preReceivedAttack(Double damage) {
		damage = state.preReceivedAttack(damage);

		state = state.postReceivedAttack();

		return damage;
	}

	@Override
	protected boolean preAttack(Race target, Double distance) {
		return state.preAttack(weapon);
	}

	@Override
	public String toString() {
		return String.format("Gricean en estado %s", state.toString());
	}
}