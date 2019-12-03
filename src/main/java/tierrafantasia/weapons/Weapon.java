package tierrafantasia.weapons;

import tierrafantasia.race.Race;
import tierrafantasia.stats.Range;

public class Weapon {
	protected Range range;
	protected Double damage;

	public Weapon(Range range, Double damage) {
		this.range = range;
		this.damage = damage;
	}

	public void hurt(Race raceDummy, Double distance) {
		range.hurtIfIsInRange(raceDummy, distance, damage);
	}
	
	public void hurt(Race raceDummy, Double distance, Double multiply) {
		this.range.hurtIfIsInRange(raceDummy, distance, this.damage * multiply);
	}

	public void increaseDamage(double increment) {
		damage += increment;
	}

	public void multiplyDamage(int damageMultiplier) {
		damage *= damageMultiplier;
	}

	public void divideDamage(int damageMultiplier) {
		damage /= damageMultiplier;
	}
}
