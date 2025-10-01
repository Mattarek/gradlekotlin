package org.wrzesien.wzorceProjektowePraktyka;

//Builder
public class Order {
	private final String id;
	private final Coffee coffee;
	private final Dessert dessert;
	private final boolean takeaway;

	private Order(final Builder builder) {
		id = OrderIdGenerator.getInstance().nextId();
		coffee = builder.coffee;
		dessert = builder.dessert;
		takeaway = builder.takeaway;
	}

	@Override
	public String toString() {
		return "Order{" +
				"id='" + id + '\'' +
				", coffee=" + coffee +
				", dessert=" + dessert +
				", takeaway=" + takeaway +
				'}';
	}

	public static class Builder {
		private Coffee coffee;
		private Dessert dessert;
		private boolean takeaway;

		public Builder coffee(final Coffee coffee) {
			this.coffee = coffee;
			return this;
		}

		public Builder dessert(final Dessert dessert) {
			this.dessert = dessert;
			return this;
		}

		public Builder takeaway(final boolean takeaway) {
			this.takeaway = takeaway;
			return this;
		}

		public Order build() {
			return new Order(this);
		}
	}
}
