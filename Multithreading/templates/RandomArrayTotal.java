import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class RandomArrayTotal {
	public static long subtotal(int[] numbers, int start, int chunk) {
		long total = 0;

		for (int i = start; i < start + chunk; i++) {
			total = total + numbers[i];
		}

		return total;
	}

	public static long total(int[] numbers) {
		return subtotal(numbers, 0, numbers.length);
	}

	public static long total(int[] numbers, int threads) throws InterruptedException {
		if (threads < 1 || threads > numbers.length) {
			throw new ArrayIndexOutOfBoundsException(threads);
		}

		ArrayWorker[] workers = new ArrayWorker[threads];

		int chunk = numbers.length / workers.length;
		int remainder = numbers.length % workers.length;
		int last = workers.length - 1;
		long total = 0;

		for (int i = 0; i < last; i++) {
			// TODO
		}

		workers[last] = new ArrayWorker(numbers, last * chunk, chunk + remainder);
		workers[last].start();

		for (ArrayWorker worker : workers) {
			// TODO
		}

		return total;
	}

	private static class ArrayWorker extends Thread {
		private final int[] numbers;
		private final int start;
		private final int end;
		private long subtotal;

		public ArrayWorker(int[] numbers, int start, int end) {
			this.numbers = numbers;
			this.start = start;
			this.end = end;
			this.subtotal = 0;
		}

		@Override
		public void run() {
			// TODO
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int[] numbers = new Random().ints(10, 0, 100).toArray();

		System.out.println(Arrays.toString(numbers));
		System.out.println();

		System.out.println(total(numbers));
		System.out.println(total(numbers, 5));
		System.out.println();

//		int size = 100;
//		double fastest = Double.MAX_VALUE;
//
//		fastest = Math.min(fastest, benchmark(size, 1));
//		fastest = Math.min(fastest, benchmark(size, 2));
//		fastest = Math.min(fastest, benchmark(size, 3));
//		fastest = Math.min(fastest, benchmark(size, 5));
//		fastest = Math.min(fastest, benchmark(size, 8));
//
//		System.out.println();
//
//		fastest = Math.min(fastest, benchmark(size, 8));
//		fastest = Math.min(fastest, benchmark(size, 5));
//		fastest = Math.min(fastest, benchmark(size, 3));
//		fastest = Math.min(fastest, benchmark(size, 2));
//		fastest = Math.min(fastest, benchmark(size, 1));
//
//		System.out.printf("%nFastest average: %.06f", fastest);
	}

	private static double benchmark(int size, int threads) throws InterruptedException {
		int warmup = 10;
		int runs = 30;

		int[] numbers = new Random().ints(size, 0, 100).toArray();

		long placeholder = 0;
		double average = 0;

		Instant start;
		Duration elapsed;

		for (int i = 0; i < warmup; i++) {
			placeholder = Math.max(placeholder, total(numbers, threads));
		}

		for (int i = 0; i < runs; i++) {
			start = Instant.now();
			placeholder = Math.max(placeholder, total(numbers, threads));
			elapsed = Duration.between(start, Instant.now());
			average += elapsed.toNanos();
		}

		average /= runs;
		average /= Duration.ofSeconds(1).toNanos();

		System.out.printf("%.06f seconds average for %d numbers and %d threads (placeholder %d)%n", average, size, threads, placeholder);

		return average;
	}
}
