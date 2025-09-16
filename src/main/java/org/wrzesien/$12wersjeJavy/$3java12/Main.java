package org.wrzesien.$12wersjeJavy.$3java12;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(final String[] args) {
		Stream.of(5, 1, 32, 12)
				.collect(Collectors.teeing(
						Collectors.counting(),
						Collectors.summingInt(element -> element),
						Pair::new // łaczy wynik z Collectora Collectors.counting() i Collectors.summingInt(element
						// -> element), możemy np. zrobić dzielenie: (c1, c2) -> c2 / c1
				));
	}

	static class Pair {
		Long count;
		Integer sum;

		public Pair(final Long count, final Integer sum) {
			this.count = count;
			this.sum = sum;
		}

		public Long getCount() {
			return count;
		}

		public Integer getSum() {
			return sum;
		}
	}
}
