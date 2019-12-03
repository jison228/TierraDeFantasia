package tierrafantasia.race.gricean.states;

import tierrafantasia.weapons.Weapon;

public interface GriceanState {
	Double preReceivedAttack(Double damage);

	default boolean preAttack(Weapon arma) {
		return true;
	}

	GriceanState postReceivedAttack();

	GriceanState postAttack(Weapon weapon);
}
