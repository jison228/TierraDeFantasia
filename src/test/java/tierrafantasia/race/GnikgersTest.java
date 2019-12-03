package tierrafantasia.race;

import org.junit.Assert;
import org.junit.Test;
import tierrafantasia.race.gnikgers.Gnikgers;
import tierrafantasia.stats.Health;

public class GnikgersTest {

	@Test
	public void ataqueBasico_Fuera_rango_expected_no_recibir_dano() {
		Race raceDummy = new RaceDummy();

		Race gnikgers = new Gnikgers();

		Double attackDistance = 3.;

		gnikgers.attack(raceDummy, attackDistance);

		attackDistance = 100.;

		gnikgers.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(100), raceDummy.health);

		Assert.assertEquals("Gnikger normal", gnikgers.toString());
	}

	@Test
	public void ataqueBasico_rango_min() {
		Race raceDummy = new RaceDummy();

		Race gnikgers = new Gnikgers();

		Double attackDistance = 0.;

		gnikgers.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(80), raceDummy.health);
	}

	@Test
	public void ataqueBasico_rango_max() {
		Race raceDummy = new RaceDummy();

		Race gnikgers = new Gnikgers();

		Double attackDistance = 2.;

		gnikgers.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(80), raceDummy.health);
	}

	@Test
	public void ataqueBasico_incrementa_dano_por_cada_ataque() {
		Race raceDummy = new RaceDummy();

		Race gnikgers = new Gnikgers();

		Double attackDistance = 2.;

		gnikgers.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(80), raceDummy.health);

		raceDummy = new RaceDummy();

		gnikgers.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(76), raceDummy.health);

		raceDummy = new RaceDummy();

		gnikgers.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(68), raceDummy.health);
	}

	@Test
	public void descansar_se_vuelve_de_piedra() {
		Race gnikgers = new Gnikgers();

		gnikgers.rest();

		Assert.assertEquals("Gnikger de piedra", gnikgers.toString());
	}

	@Test
	public void descansar_recupera_toda_la_vida() {
		Race gnikgers = new Gnikgers();

		gnikgers.receiveAttack(10.);

		Assert.assertEquals("Gnikger normal", gnikgers.toString());
		Assert.assertEquals(new Health(76), gnikgers.health);

		gnikgers.rest();

		Assert.assertEquals("Gnikger de piedra", gnikgers.toString());
		Assert.assertEquals(new Health(86), gnikgers.health);
	}

	@Test
	public void gniker_descansa_3_turnos_seguido_sigue_siendo_de_piedra() {
		Race gnikgers = new Gnikgers();

		gnikgers.rest();

		gnikgers.rest();

		gnikgers.rest();

		Assert.assertEquals("Gnikger de piedra", gnikgers.toString());
	}

	@Test
	public void gniker_recibe_ataque_siendo_de_piedra_recibe_un_tercio_de_dano() {
		Race gnikgers = new Gnikgers();

		gnikgers.rest();

		gnikgers.receiveAttack(30.);

		Assert.assertEquals("Gnikger de piedra", gnikgers.toString());

		Assert.assertEquals(new Health(76), gnikgers.health);
	}

	@Test
	public void gniker_recibe_3_ataques_siendo_de_piedra_recibe_un_tercio_de_dano_primeros_dos_luego_ataque_normal() {
		Race gnikgers = new Gnikgers();

		gnikgers.rest();

		gnikgers.receiveAttack(30.);

		Assert.assertEquals("Gnikger de piedra", gnikgers.toString());

		Assert.assertEquals(new Health(76), gnikgers.health);

		gnikgers.receiveAttack(30.);

		Assert.assertEquals("Gnikger normal", gnikgers.toString());

		Assert.assertEquals(new Health(66), gnikgers.health);

		gnikgers.receiveAttack(30.);

		Assert.assertEquals(new Health(36), gnikgers.health);
	}

	@Test
	public void ataca_2_veces_recibe_1_ataque_descansa_recibe_otro_ataque_ataca_expected_no_danar_en_modo_piedra_y_acumular_modificadores_ataca() {
		Race gnikgers = new Gnikgers();
		Race raceDummy = new RaceDummy();

		Double attackDistance = 0.;

		gnikgers.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(80), raceDummy.health);

		gnikgers.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(56), raceDummy.health);

		gnikgers.receiveAttack(30.);

		Assert.assertEquals(new Health(56), gnikgers.health);

		Assert.assertEquals("Gnikger normal", gnikgers.toString());

		gnikgers.rest();

		Assert.assertEquals("Gnikger de piedra", gnikgers.toString());
		Assert.assertEquals(new Health(86), gnikgers.health);

		gnikgers.receiveAttack(30.);

		Assert.assertEquals(new Health(76), gnikgers.health);
		Assert.assertEquals("Gnikger de piedra", gnikgers.toString());

		gnikgers.receiveAttack(30.);

		Assert.assertEquals(new Health(66), gnikgers.health);
		Assert.assertEquals("Gnikger normal", gnikgers.toString());

		gnikgers.attack(raceDummy, attackDistance);

		Assert.assertEquals(new Health(24), raceDummy.health);
	}

}