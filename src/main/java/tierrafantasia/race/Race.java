package tierrafantasia.race;

import tierrafantasia.buff.Penalization;
import tierrafantasia.stats.Health;
import tierrafantasia.weapons.Weapon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Race {
	protected Health health;
	protected Weapon weapon;
	protected Map<String, Penalization> penalizationMap = new HashMap<>();

	public Race(Health health, Weapon weapon) {
		this.health = health;
		this.weapon = weapon;
	}

	public final void receiveAttack(Double damage) {
		damage = preReceivedAttack(damage);

		applyDamage(damage);

		postReceivedAttack();
	}

	public final void attack(Race target, Double distance) {
		if (preAttack(target, distance)) {
			applyAttack(target, distance);

			postAttack(target);
		}

		applyPenalization();
	}

	public final void rest() {
		doRest();

		applyPenalization();
	}

	protected void applyDamage(Double damage) {
		health.decrement(damage);
	}

	protected void heal(double life) {
		health.heal(life);
	}

	private void applyPenalization() {
		penalizationMap.values().forEach(buffs -> buffs.apply(health));

		clearDuePenalizations();
	}

	private void clearDuePenalizations() {
		List<Penalization> penalizationToClean = penalizationMap.values().stream()
				.filter(penalization -> penalization.returnIfDue() != null)
				.collect(Collectors.toList());

		penalizationToClean.forEach(penalization -> penalizationMap.remove(penalization.getClass().getSimpleName()));
	}

	protected void doRest() {

	}

	protected void applyAttack(Race target, Double distance) {
		weapon.hurt(target, distance);
	}

	protected boolean preAttack(Race target, Double distance) {
		return true;
	}

	protected void postAttack(Race target) {

	}

	protected Double preReceivedAttack(Double damage) {
		return damage;
	}

	protected void postReceivedAttack() {

	}

	public void addPenalization(Penalization penalization) {
		penalizationMap.put(penalization.getClass().getSimpleName(), penalization);
	}

	public String printPenalizations() {
		return penalizationMap.values().stream()
				.map(Object::toString)
				.collect(Collectors.joining(","));
	}
}
