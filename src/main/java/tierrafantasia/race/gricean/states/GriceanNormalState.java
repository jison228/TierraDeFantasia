package tierrafantasia.race.gricean.states;

import tierrafantasia.weapons.Weapon;

public class GriceanNormalState implements GriceanState {

	@Override
	public Double preReceivedAttack(Double damage) {
		return damage;
	}

	@Override
	public GriceanState postReceivedAttack() {
		return new GriceanRageState();
	}

	@Override
	public GriceanState postAttack(Weapon weapon) {
		return this;
	}

	@Override
	public String toString() {
		return "Normal";
	}
}
