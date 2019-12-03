package tierrafantasia.stats;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Health {
	private final double maxHealth;
	private double salud;

	public Health(Double value) {
		this.salud = value;
		maxHealth = value;
	}

	public Health(Integer value) {
		this.salud = Double.valueOf(value);
		maxHealth = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Health)) return false;
		Health health1 = (Health) o;
		return salud == health1.salud;
	}

	public void decrement(double dano) {
		//TODO Refactorijillo por aqui. Es la manera rapida para lidiar con los decimales que tuve
		salud = Double.parseDouble(new BigDecimal(salud - dano).setScale(2, RoundingMode.HALF_DOWN).toString());

		if (salud < 0) {
			salud = 0d;
		}
	}

	public void heal(Double vida) {
		double saludFinal = salud + vida;

		if (saludFinal > maxHealth) {
			saludFinal = maxHealth;
		}

		salud = saludFinal;
	}

	public void healPercentage(Double vida) {
		double saludFinal = salud + salud * vida;

		if (saludFinal > maxHealth) {
			saludFinal = maxHealth;
		}

		salud = saludFinal;
	}
}
