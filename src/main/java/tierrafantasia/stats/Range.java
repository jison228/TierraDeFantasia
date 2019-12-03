package tierrafantasia.stats;

import tierrafantasia.race.Race;

public class Range {
	private final int maxRange;
	private final int minRange;

	public Range(int minRange, int maxRange) {
		this.minRange = minRange;
		this.maxRange = maxRange;
	}

	public void hurtIfIsInRange(Race raceDummy, Double distance, Double damage) {
		if (distance <= maxRange && distance >= minRange) {
			raceDummy.receiveAttack(damage);
		}
	}
}
