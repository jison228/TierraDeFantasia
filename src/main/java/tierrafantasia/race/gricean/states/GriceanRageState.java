package tierrafantasia.race.gricean.states;

import tierrafantasia.weapons.Weapon;

public class GriceanRageState implements GriceanState {

	public static final int DAMAGE_MULTIPLIER = 2;
	public int inRageTurns = 0;

	@Override
	public Double preReceivedAttack(Double damage) {
		return damage;
	}

	@Override
	public boolean preAttack(Weapon weapon) {
		if (inRageTurns == 0) {
			weapon.multiplyDamage(DAMAGE_MULTIPLIER);
		}

		inRageTurns++;

		return true;
	}

	@Override
	public GriceanState postReceivedAttack() {
		return this;
	}

	@Override
	public GriceanState postAttack(Weapon weapon) {
		if (inRageTurns == 2) {
			weapon.divideDamage(DAMAGE_MULTIPLIER);

			return new GriceanNormalState();
		}

		return this;
	}

	@Override
	public String toString() {
		return "Furioso";
	}
}
