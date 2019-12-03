package tierrafantasia.race.hudin.state;

import tierrafantasia.stats.Health;

public class NoViolenceHudinState extends HudinState {

	@Override
	public HudinState postReceivedAttack() {
		return new HudinNormalState();
	}

	@Override
	public boolean preAttack(Health health) {
		//No ataca en modo sin violencia
		return false;
	}

    @Override
    public String toString() {
        return "Sin violencia";
    }
}
