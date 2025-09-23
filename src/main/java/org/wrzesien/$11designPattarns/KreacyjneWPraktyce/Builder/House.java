package org.wrzesien.$11designPattarns.KreacyjneWPraktyce.Builder;

public class House {
	private final String walls;
	private final String roof;

	private House(final HouseBuilder builder) {
		walls = builder.walls;
		roof = builder.roof;
	}

	@Override
	public String toString() {
		return "House with " + walls + " and " + roof;
	}

	public static class HouseBuilder {
		private String walls;
		private String roof;

		public HouseBuilder setWalls(final String walls) {
			this.walls = walls;
			return this;
		}

		public HouseBuilder setRoof(final String roof) {
			this.roof = roof;
			return this;
		}

		public House build() {
			return new House(this);
		}
	}
}
