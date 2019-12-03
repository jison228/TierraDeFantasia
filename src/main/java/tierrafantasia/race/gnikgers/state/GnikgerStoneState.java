package tierrafantasia.race.gnikgers.state;

import tierrafantasia.race.gnikgers.Gnikgers;

public class GnikgerStoneState extends GnikgerState {

	private static final double DAMAGE_REDUCER = 1. / 3.;
	private int turnInStone = 0;

	public GnikgerStoneState(Gnikgers gnikgers) {
		super(gnikgers);
	}

	private GnikgerState state() {
		if (turnInStone == 2) {
			return new GnikgerNormalState(gnikgers);
		}

		return this;
	}

	@Override
	public Double preReceivedAttack(Double damage) {
		damage *= DAMAGE_REDUCER;

		return damage;
	}

	@Override
	public GnikgerState postAttack() {
		turnInStone++;

		return state();
	}

	@Override
	public GnikgerState postReceivedAttack() {
		return postAttack();
	}

	@Override
	public String toString() {
		return "de piedra";
	}
}
