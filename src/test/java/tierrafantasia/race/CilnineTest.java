package tierrafantasia.race;

import org.junit.Assert;
import org.junit.Test;

import tierrafantasia.race.apotonix.Apotonix;
import tierrafantasia.race.cilnine.Cilnine;
import tierrafantasia.stats.Health;

public class CilnineTest {

	@Test
	public void ataqueBasico_Fuera_rango_expected_no_recibir_dano() {
		Race raceDummy = new RaceDummy();

		Race ciline = new Cilnine();

		Double attackDistance = 3d;

		ciline.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(100), raceDummy.health);
	}

	@Test
	public void ataqueBasico_rango_min() {
		Race raceDummy = new RaceDummy();

		Race cilnine = new Cilnine();

		Double attackDistance = 0d;

		cilnine.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(46), raceDummy.health);
	}

	@Test
	public void ataqueBasico_rango_max() {
		Race raceDummy = new RaceDummy();

		Race cilnine = new Cilnine();

		Double attackDistance = 1d;

		cilnine.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(46), raceDummy.health);
	}

	@Test
	public void recibe_un_ataque_se_espera_curar() {
		Race raceDummy = new RaceDummy();

		Race cilnine = new Cilnine();

		cilnine.receiveAttack(40d);

		Assert.assertEquals(new Health(91.2d), cilnine.health);
	}

	@Test
	public void ataqueBasico_rested_doubleDamage() {
		Race raceDummy = new RaceDummyReinforced();

		Race cilnine = new Cilnine();

		Double attackDistance = 1d;
		
		cilnine.doRest();

		cilnine.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(92), raceDummy.health);
	}	


	@Test
	public void ataqueBasico_rested_damageReduction() {
		Race raceDummy = new RaceDummyReinforced();

		Race cilnine = new Cilnine();

		Double attackDistance = 1d;

		cilnine.attack(raceDummy, attackDistance);

		cilnine.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(130.57), raceDummy.health);
	}
}