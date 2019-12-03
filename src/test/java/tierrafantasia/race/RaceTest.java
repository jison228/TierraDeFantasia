package tierrafantasia.race;

import org.junit.Assert;
import org.junit.Test;
import tierrafantasia.race.gricean.attack.boost.GriceanVenom;

public class RaceTest {

	@Test
	public void test_not_duplicated_penalizations() {
		Race race = new RaceDummy();

		race.addPenalization(new GriceanVenom());
		race.addPenalization(new GriceanVenom());

		Assert.assertEquals(1, race.penalizationMap.size());
	}

}