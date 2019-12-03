package tierrafantasia.race;

import org.junit.Assert;
import org.junit.Test;

import tierrafantasia.race.apotonix.Apotonix;
import tierrafantasia.stats.Health;

public class ApotonixTest {

	@Test
	public void ataqueBasico_Fuera_rango_expected_no_recibir_dano() {
		Race raceDummy = new RaceDummy();

		Race apotonix = new Apotonix();

		Double attackDistance = 3.;

		apotonix.attack(raceDummy, attackDistance);

		attackDistance = 100.;

		apotonix.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(100), raceDummy.health);
	}

	@Test
	public void ataqueBasico_rango_min() {
		Race raceDummy = new RaceDummy();

		Race apotonix = new Apotonix();

		Double attackDistance = 5.;

		apotonix.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(92), raceDummy.health);
	}

	@Test
	public void ataqueBasico_rango_max() {
		Race raceDummy = new RaceDummy();

		Race apotonix = new Apotonix();

		Double attackDistance = 49.;

		apotonix.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(92), raceDummy.health);
	}

	@Test
	public void recibe_un_ataque_se_espera_incremento_2_dano() {
		Race raceDummy = new RaceDummy();

		Race apotonix = new Apotonix();

		apotonix.receiveAttack(10.);

		Double attackDistance = 49.;

		apotonix.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(90), raceDummy.health);

		apotonix.receiveAttack(10d);

		apotonix.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(76), raceDummy.health);
	}

	@Test
	public void test_recibirAtaque_con_armadura() {
		Race apotonix = new Apotonix();

		apotonix.receiveAttack(10.0);

		Assert.assertEquals(new Health(72.67), apotonix.health);

		apotonix.receiveAttack(64.34);
	}

	@Test
	public void test_recibirAtaque_mayor_que_vida_se_espera_cero() {
		Race apotonix = new Apotonix();

		apotonix.receiveAttack(1000d);

		Assert.assertEquals(new Health(0), apotonix.health);
	}

	@Test
	public void test_descansar() {
		Race apotonix = new Apotonix();

		apotonix.receiveAttack(8.33);

		apotonix.rest();

		Assert.assertEquals(new Health(81), apotonix.health);
	}

	@Test
	public void test_descansar_cero_vida() {
		Race apotonix = new Apotonix();

		apotonix.receiveAttack(1000.);

		Assert.assertEquals(new Health(0), apotonix.health);

		apotonix.rest();

		Assert.assertEquals(new Health(20.25), apotonix.health);
	}
}