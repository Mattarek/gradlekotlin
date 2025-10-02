package org.wrzesien.wlasnaPraktyka.Builder;

public class Car {
	private final String brand;
	private final String model;
	private final String color;
	private final boolean sunroof;
	private final boolean gps;
	private final int doors;

	private Car(final Builder builder) {
		brand = builder.brand;
		model = builder.model;
		color = builder.color;
		doors = builder.doors;
		sunroof = builder.sunroof;
		gps = builder.gps;
	}

	public String getBrand() {
		return brand;
	}

	public boolean isGps() {
		return gps;
	}

	public boolean isSunroof() {
		return sunroof;
	}

	public int getDoors() {
		return doors;
	}

	public String getColor() {
		return color;
	}

	public String getModel() {
		return model;
	}

	@Override
	public String toString() {
		return "Car{" +
				"brand='" + brand + '\'' +
				", model='" + model + '\'' +
				", color='" + color + '\'' +
				", sunroof=" + sunroof +
				", gps=" + gps +
				", doors=" + doors +
				'}';
	}

	public static class Builder {
		private final String brand;
		private final String model;
		private boolean gps;
		private boolean sunroof;
		private int doors = 4;
		private String color = "black";

		public Builder(final String brand, final String model) {
			this.brand = brand;
			this.model = model;
		}

		public Builder color(final String color) {
			this.color = color;
			return this;
		}

		public Builder doors(final int doors) {
			this.doors = doors;
			return this;
		}

		public Builder sunroof(final boolean sunroof) {
			this.sunroof = sunroof;
			return this;
		}

		public Builder gps(final boolean gps) {
			this.gps = gps;
			return this;
		}

		public Car build() {
			return new Car(this);
		}
	}
}
