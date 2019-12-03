package tierrafantasia.race.gnikgers.state;

import tierrafantasia.race.gnikgers.Gnikgers;

public class GnikgerNormalState extends GnikgerState {
	public GnikgerNormalState(Gnikgers gnikgers) {
		super(gnikgers);
	}

	@Override
	public GnikgerState postAttack() {
		gnikgers.increaseDamage();

		return this;
	}

	@Override
	public String toString() {
		return "normal";
	}
}
