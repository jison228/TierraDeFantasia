package tierrafantasia.race;

import org.junit.Assert;
import org.junit.Test;
import tierrafantasia.race.hudin.Hudin;
import tierrafantasia.stats.Health;

public class HudinTest {

	@Test
	public void ataqueBasico_Fuera_rango_expected_no_recibir_dano() {
		Race raceDummy = new RaceDummy();

		Race hudin = new Hudin();

		Double attackDistance = 4.;

		hudin.attack(raceDummy, attackDistance);

		attackDistance = 100.;

		hudin.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(100), raceDummy.health);
	}

	@Test
	public void ataqueBasico_rango_min() {
		Race raceDummy = new RaceDummy();

		Race hudin = new Hudin();

		Double attackDistance = 1.;

		hudin.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(17), raceDummy.health);
	}

	@Test
	public void ataqueBasico_rango_max() {
		Race raceDummy = new RaceDummy();

		Race hudin = new Hudin();

		Double attackDistance = 3.;

		hudin.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(17), raceDummy.health);
	}

	@Test
	public void given_ataque_externo_recibe_doble_dano() {
		Race hudin = new Hudin();

		hudin.receiveAttack(30.);

		Assert.assertEquals(new Health(40), hudin.health);
	}

	@Test
	public void given_ataca_se_cura_por_cada_ataque_realizado() {
		Race raceDummy = new RaceDummy();

		Race hudin = new Hudin();

		hudin.receiveAttack(10.);

		Assert.assertEquals(new Health(80), hudin.health);

		Double attackDistance = 3.;

		hudin.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(17), raceDummy.health);

		Assert.assertEquals(new Health(83), hudin.health);
	}

	@Test
	public void given_descansa_no_infiere_dano() {
		Race raceDummy = new RaceDummy();

		Race hudin = new Hudin();

		hudin.rest();

		Double attackDistance = 3.;

		hudin.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(100), raceDummy.health);
	}

	@Test
	public void given_descansa_no_infiere_dano_recibe_ataque_infiere_dano() {
		Race raceDummy = new RaceDummy();

		Race hudin = new Hudin();

		Assert.assertEquals("Hudin en estado Normal", hudin.toString());

		hudin.rest();

		Assert.assertEquals("Hudin en estado Sin violencia", hudin.toString());

		Double attackDistance = 3.;

		hudin.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(100), raceDummy.health);

		hudin.receiveAttack(10.);

		Assert.assertEquals("Hudin en estado Normal", hudin.toString());

		Assert.assertEquals(new Health(80), hudin.health);

		hudin.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(17), raceDummy.health);

		Assert.assertEquals(new Health(83), hudin.health);
	}
}