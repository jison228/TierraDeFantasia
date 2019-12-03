package tierrafantasia.race.gricean.states;

import tierrafantasia.weapons.Weapon;

public class GriceanRestState implements GriceanState {
	private static final double DAMAGE_REDUCER = 1. / 4.;

	@Override
	public Double preReceivedAttack(Double damage) {
		return damage * DAMAGE_REDUCER;
	}

	@Override
	public GriceanState postReceivedAttack() {
		return new GriceanRageState();
	}

	@Override
	public GriceanState postAttack(Weapon weapon) {
		return new GriceanNormalState();
	}

	@Override
	public String toString() {
		return "Descansado";
	}
}
