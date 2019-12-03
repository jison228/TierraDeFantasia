package tierrafantasia.race.cilnine;

import tierrafantasia.race.Race;
import tierrafantasia.stats.Health;
import tierrafantasia.weapons.Bow;
import tierrafantasia.weapons.Dientes;

public class Cilnine extends Race {
	private static final double INITIAL_HEALTH = 116.0;
	private static final double HEAL_PERCENTAGE = 0.2;

	private int doubleDamageAttack = 0;
	private int lastAttack = 0;

	public Cilnine() {
		super(new Health(INITIAL_HEALTH), new Dientes());
	}

	@Override
	protected void postReceivedAttack() {
		this.health.healPercentage(HEAL_PERCENTAGE);
	}

	@Override
	protected Double preReceivedAttack(Double damage) {
		int multiply = 1;
		
		if(this.doubleDamageAttack > 0) {
			this.doubleDamageAttack--;
			multiply *= 2;
		}
		if(this.lastAttack == 1) {
			this.lastAttack = 0;
			multiply *= (2/7);
		}else {
			this.lastAttack = 0;
		}
		
		
		return damage * multiply;
	}

	@Override
	protected void applyAttack(Race target, Double distance) {
		
		double multiply = 1;
		
		if(this.doubleDamageAttack > 0) {
			this.doubleDamageAttack--;
			multiply *= 2;
		}
		if(this.lastAttack == 1) {
			this.lastAttack = 0;
			multiply *= 0.28571d;
		}else {
			this.lastAttack = 1;
		}
		
		weapon.hurt(target, distance, multiply);
	}

	@Override
	protected void doRest() {
		this.doubleDamageAttack = 2;
	}
}
