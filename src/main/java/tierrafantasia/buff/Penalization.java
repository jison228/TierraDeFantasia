package tierrafantasia.buff;

import tierrafantasia.stats.Health;

public abstract class Penalization {
	private int duration;
	private int passedTurns;

	public Penalization(int duration) {
		this.duration = duration;
	}

	public Penalization returnIfDue() {
		if (duration == passedTurns) {
			return this;
		}

		return null;
	}

	private void notifyTurn() {
		passedTurns++;
	}

	public final void apply(Health health) {
		notifyTurn();

		applyBuff(health);
	}

	protected abstract void applyBuff(Health health);
}
