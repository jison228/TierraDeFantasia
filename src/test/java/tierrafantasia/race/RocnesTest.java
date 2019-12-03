package tierrafantasia.race;

import org.junit.Assert;
import org.junit.Test;

import tierrafantasia.race.rocnes.Rocnes;
import tierrafantasia.stats.Health;

public class RocnesTest {

	@Test
	public void ataqueBasico_Fuera_rango_expected_no_recibir_dano() {
		Race raceDummy = new RaceDummy();

		Race rocnes = new Rocnes();

		Double attackDistance = 7.;

		//Como le erra los dos ataques primeros, realizamos uno mas
		rocnes.attack(raceDummy, attackDistance);
		rocnes.attack(raceDummy, attackDistance);
		rocnes.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(100), raceDummy.health);
	}

	@Test
	public void ataqueBasico_rango_min() {
		Race raceDummy = new RaceDummy();

		Race rocnes = new Rocnes();

		Double attackDistance = 0.;

		rocnes.attack(raceDummy, attackDistance);
		rocnes.attack(raceDummy, attackDistance);
		rocnes.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(49), raceDummy.health);
	}

	@Test
	public void ataqueBasico_rango_max() {
		Race raceDummy = new RaceDummy();

		Race rocnes = new Rocnes();

		Double attackDistance = 5.;

		rocnes.attack(raceDummy, attackDistance);
		rocnes.attack(raceDummy, attackDistance);
		rocnes.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(49), raceDummy.health);
	}

	@Test
	public void test_ataques_errados_esperados_6_de_24() {
		Race raceDummy = new RaceDummy(new Health(2000));
		Race rocnes = new Rocnes();

		for (int i = 1; i <= 24; i++) {
			rocnes.attack(raceDummy, 3.);
		}

		Assert.assertEquals(new Health(1082), raceDummy.health);
	}

	@Test
	public void test_recibe_ataques_se_desconcentra_y_sigue_errando() {
		Race raceDummy = new RaceDummy(new Health(1000));
		Race rocnes = new Rocnes();

		//Ataques errados
		rocnes.attack(raceDummy, 3.);
		rocnes.attack(raceDummy, 3.);

		//Ataque efectuado
		rocnes.attack(raceDummy, 3.);
		Assert.assertEquals(new Health(949), raceDummy.health);

		//Los proximos ataques deben ser efectivos, pero recibe un ataque que lo desconcentra
		rocnes.receiveAttack(10.);
		Assert.assertEquals(new Health(74), rocnes.health);

		rocnes.attack(raceDummy, 3.);
		rocnes.attack(raceDummy, 3.);
		Assert.assertEquals(new Health(949), raceDummy.health);

		//Este ataque es efectivo ya que se vuelve a concentrar y no erra mas ataques
		rocnes.attack(raceDummy, 3.);
		Assert.assertEquals(new Health(898), raceDummy.health);
	}

	@Test
	public void test_descansa_recibe_incremento_danoataques_errados_esperados_2_de_8() {
		Race raceDummy = new RaceDummy(new Health(2000));
		Race rocnes = new Rocnes();
		double distancia = 3.;

		for (int i = 1; i <= 6; i++) {
			rocnes.attack(raceDummy, distancia);
		}

		Assert.assertEquals(new Health(1796), raceDummy.health);

		//recibe plus de daño equivalente a 4 ataques errados
		rocnes.rest();

		rocnes.attack(raceDummy, distancia);

		Assert.assertEquals(new Health(1735), raceDummy.health);
	}
}