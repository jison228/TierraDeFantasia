package tierrafantasia.race;

import org.junit.Assert;
import org.junit.Test;
import tierrafantasia.buff.Penalization;
import tierrafantasia.race.gricean.Gricean;
import tierrafantasia.race.gricean.attack.boost.GriceanVenom;
import tierrafantasia.stats.Health;

public class GriceanTest {
	@Test
	public void ataqueBasico_Fuera_rango_expected_no_recibir_dano() {
		Race razaDummy = new RaceDummy();

		Race gricean = new Gricean();

		double attackDistance = 16.;

		gricean.attack(razaDummy, attackDistance);

		attackDistance = 34.;

		gricean.attack(razaDummy, attackDistance);

		Assert.assertEquals(new Health(100), razaDummy.health);
	}

	@Test
	public void ataqueBasico_rango_min() {
		Race razaDummy = new RaceDummy();

		Race gricean = new Gricean();

		Double attackDistance = 17.;

		gricean.attack(razaDummy, attackDistance);

		Assert.assertEquals(new Health(69), razaDummy.health);
	}

	@Test
	public void ataqueBasico_rango_max() {
		Race razaDummy = new RaceDummy();

		Race gricean = new Gricean();

		Double attackDistance = 33.;

		gricean.attack(razaDummy, attackDistance);

		Assert.assertEquals(new Health(69), razaDummy.health);
	}

	@Test
	public void ataqueBasico_expected_victima_envenenada() {
		Race razaDummy = new RaceDummy();

		Race gricean = new Gricean();

		Double attackDistance = 33.;

		gricean.attack(razaDummy, attackDistance);

		Assert.assertEquals(new Health(69), razaDummy.health);

		Assert.assertEquals(new GriceanVenom().toString(), razaDummy.printPenalizations());
	}

	@Test
	public void ataqueBasico_victima_envenenada_realiza_accion_pierde_dano_por_veneno() {
		Race razaDummy = new RaceDummy();

		Race gricean = new Gricean();

		Double attackDistance = 33.;

		gricean.attack(razaDummy, attackDistance);

		Assert.assertEquals(new Health(69), razaDummy.health);

		Assert.assertEquals(new GriceanVenom().toString(), razaDummy.printPenalizations());

		razaDummy.rest();

		Assert.assertEquals(new Health(59), razaDummy.health);
	}

	@Test
	public void ataqueBasico_victima_envenenada_realiza_3_acciones_pierde_dano_por_veneno_dos_veces_solamente() {
		Race razaDummy = new RaceDummy();

		Race gricean = new Gricean();

		Double attackDistance = 33.;

		gricean.attack(razaDummy, attackDistance);

		Assert.assertEquals(new Health(69), razaDummy.health);

		Assert.assertEquals(new GriceanVenom().toString(), razaDummy.printPenalizations());

		razaDummy.rest();

		Assert.assertEquals(new Health(59), razaDummy.health);

		razaDummy.rest();

		Assert.assertEquals(new Health(49), razaDummy.health);

		razaDummy.rest();

		Assert.assertEquals(new Health(49), razaDummy.health);
	}

	@Test
	public void ataqueBasico_victima_envenenada_realiza_3_acciones_pero_en_el_medio_gricean_ataca_se_espera_seguir_envenenado() {
		Race razaDummy = new RaceDummy();

		Race gricean = new Gricean();

		Penalization griceanVeneno = new GriceanVenom();

		Double attackDistance = 33.;

		gricean.attack(razaDummy, attackDistance);

		Assert.assertEquals(new Health(69), razaDummy.health);

		Assert.assertEquals(griceanVeneno.toString(), razaDummy.printPenalizations());

		razaDummy.rest();

		Assert.assertEquals(new Health(59), razaDummy.health);

		gricean.attack(razaDummy, attackDistance);

		Assert.assertEquals(new Health(28), razaDummy.health);

		razaDummy.rest();

		Assert.assertEquals(new Health(18), razaDummy.health);

		razaDummy.rest();

		Assert.assertEquals(new Health(8), razaDummy.health);

		razaDummy.rest();

		Assert.assertEquals(new Health(8), razaDummy.health);

		Assert.assertEquals("", razaDummy.printPenalizations());
	}

	@Test
	public void test_gricean_receive_damage_put_him_in_rage() {
		Race gricean = new Gricean();

		gricean.receiveAttack(30.);

		Assert.assertEquals(new Health(125.0), gricean.health);

		Assert.assertEquals("Gricean en estado Furioso", gricean.toString());
	}

	@Test
	public void test_gricean_in_rage_do_double_damage() {
		Race gricean = new Gricean();
		Race raceDummy = new RaceDummy();

		gricean.receiveAttack(30.);

		gricean.attack(raceDummy, 30.);

		Assert.assertEquals(new Health(38), raceDummy.health);
	}

	@Test
	public void test_gricean_in_rage_lost_this_status_after_two_turns() {
		Race gricean = new Gricean();
		Race raceDummy = new RaceDummy();

		gricean.receiveAttack(30.);

		gricean.attack(raceDummy, 30.);

		gricean.attack(raceDummy, 30.);

		Assert.assertEquals(new Health(0), raceDummy.health);

		Assert.assertEquals("Gricean en estado Normal", gricean.toString());
	}

	@Test
	public void test_gricean_in_rage_lost_this_status_after_two_turns_restoring_original_damage() {
		Race gricean = new Gricean();
		Race raceDummy = new RaceDummy();

		gricean.receiveAttack(30.);

		gricean.attack(raceDummy, 30.);

		gricean.attack(raceDummy, 30.);

		Assert.assertEquals(new Health(0), raceDummy.health);

		raceDummy = new RaceDummy();

		gricean.attack(raceDummy, 30.);

		Assert.assertEquals(new Health(69), raceDummy.health);

		Assert.assertEquals("Gricean en estado Normal", gricean.toString());
	}


	@Test
	public void test_gricean_in_rage_receive_two_attacks_remains_in_rage() {
		Race gricean = new Gricean();
		Race raceDummy = new RaceDummy();

		gricean.receiveAttack(30.);

		gricean.receiveAttack(30.);

		gricean.receiveAttack(30.);

		Assert.assertEquals(new Health(65), gricean.health);
	}

	@Test
	public void test_gricean_in_rage_lost_this_status_after_rest() {
		Race gricean = new Gricean();
		Race raceDummy = new RaceDummy();

		gricean.receiveAttack(30.);

		gricean.attack(raceDummy, 30.);

		gricean.rest();

		Assert.assertEquals("Gricean en estado Descansado", gricean.toString());
	}

	@Test
	public void test_gricean_state_when_rest() {
		Race gricean = new Gricean();

		gricean.rest();

		Assert.assertEquals("Gricean en estado Descansado", gricean.toString());
	}

	@Test
	public void test_gricean_damage_received_when_in_rest() {
		Race gricean = new Gricean();

		gricean.rest();

		gricean.receiveAttack(20.);

		Assert.assertEquals(new Health(150), gricean.health);
	}

	@Test
	public void test_gricean_lost_rest_status_when_attacks() {
		Race gricean = new Gricean();

		gricean.rest();

		gricean.attack(new RaceDummy(), 20.);

		Assert.assertEquals("Gricean en estado Normal", gricean.toString());
	}
}