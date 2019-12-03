package tierrafantasia.race.rocnes;

import tierrafantasia.race.Race;
import tierrafantasia.stats.Health;
import tierrafantasia.weapons.Halberd;

public class Rocnes extends Race {
	private static final int DAMAGE_INCREASE = 5;
	private static final int TOTAL_ATTACKS_BEFORE_MISS = 8;
	private static final int TOTAL_ATTACKS_MUST_MISS = 2;

	private int totalMissedAttacks;
	private int missedAttacks;
	private int totalAttacks;

	public Rocnes() {
		super(new Health(84), new Halberd());
	}


	@Override
	protected boolean preAttack(Race target, Double distance) {
		boolean mustAttack = false;

		if (totalAttacks % TOTAL_ATTACKS_BEFORE_MISS == 0 && missedAttacks >= TOTAL_ATTACKS_MUST_MISS) {
			missedAttacks = 0;
		}

		//El camino facil es errar los dos primeros ataques. Lo ideal seria
		//que el ataque sea errado de manera random entre los 8 ataques.
		if (missedAttacks < TOTAL_ATTACKS_MUST_MISS) {
			missedAttacks++;
			totalMissedAttacks++;
		} else {
			mustAttack = true;
		}

		totalAttacks++;

		return mustAttack;
	}

	@Override
	protected Double preReceivedAttack(Double damage) {
		missedAttacks = 0;

		return damage;
	}

	@Override
	protected void doRest() {
		weapon.increaseDamage(DAMAGE_INCREASE * totalMissedAttacks);
	}
}
