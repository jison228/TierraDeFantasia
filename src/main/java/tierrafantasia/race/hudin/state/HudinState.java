package tierrafantasia.race.hudin.state;

import tierrafantasia.stats.Health;

public abstract class HudinState {
	public abstract HudinState postReceivedAttack();

	public abstract boolean preAttack(Health health);
}
