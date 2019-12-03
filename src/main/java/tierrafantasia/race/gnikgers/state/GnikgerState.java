package tierrafantasia.race.gnikgers.state;

import tierrafantasia.race.gnikgers.Gnikgers;

public abstract class GnikgerState {
	protected final Gnikgers gnikgers;

	public GnikgerState(Gnikgers gnikgers) {
		this.gnikgers = gnikgers;
	}

	public abstract GnikgerState postAttack();

	public Double preReceivedAttack(Double damage) {
		return damage;
	}

	public GnikgerState postReceivedAttack() {
		return this;
	}
}
