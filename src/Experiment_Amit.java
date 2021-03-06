import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Experiment_Amit {
	public static void main(String args[]) throws Exception{
		int m = 10000019;
		long p = 1000000007;
			
		  // Question 4 Section (a)
		long avg=0;
		long sum=0;
		for (int k = 0; k < 5; k++) {
			LPHashTable table = new LPHashTable(m,p);
			Random rand = new Random();
			
			for (long i = 0; i < Math.floorDiv(m, 2); i++) {
				
				int b = rand.nextInt(99);
				long a = 100*i + b;
				HashTableElement hte = new HashTableElement(a,b);
				long startTime = System.currentTimeMillis();
				table.Insert(hte);
				long stopTime = System.currentTimeMillis();
				sum += stopTime - startTime;
			}
			avg+=sum;
			//System.out.println(k+": "+sum);
			sum = 0;
		}
		System.out.println("LP avg time is:"+avg/5);
		
		for (int k = 0; k < 5; k++) {
			AQPHashTable table = new AQPHashTable(m,p);
			Random rand = new Random();
			
			for (long i = 0; i < Math.floorDiv(m, 2); i++) {
				
				int b = rand.nextInt(99);
				long a = 100*i + b;
				HashTableElement hte = new HashTableElement(a,b);
				long startTime = System.currentTimeMillis();
				table.Insert(hte);
				long stopTime = System.currentTimeMillis();
				sum += stopTime - startTime;
			}
			avg+=sum;
			//System.out.println(k+": "+sum);
			sum = 0;
		}
		System.out.println("AQP avg time is:"+avg/5);
		
		for (int k = 0; k < 5; k++) {
			QPHashTable table = new QPHashTable(m,p);
			Random rand = new Random();
			
			for (long i = 0; i < Math.floorDiv(m, 2); i++) {
				
				int b = rand.nextInt(99);
				long a = 100*i + b;
				HashTableElement hte = new HashTableElement(a,b);
				long startTime = System.currentTimeMillis();
				table.Insert(hte);
				long stopTime = System.currentTimeMillis();
				sum += stopTime - startTime;
			}
			avg+=sum;
			//System.out.println(k+": "+sum);
			sum = 0;
		}
		System.out.println("QP avg time is:"+avg/5);
	 
	

 
	for (int k = 0; k < 5; k++) {
		DoubleHashTable table = new DoubleHashTable(m,p);
		Random rand = new Random();
		
		for (long i = 0; i < Math.floorDiv(m, 2); i++) {
			
			int b = rand.nextInt(99);
			long a = 100*i + b;
			HashTableElement hte = new HashTableElement(a,b);
			long startTime = System.currentTimeMillis();
			table.Insert(hte);
			long stopTime = System.currentTimeMillis();
			sum += stopTime - startTime;
		}
		avg+=sum;
		//System.out.println(k+": "+sum);
		sum = 0;
	}
	System.out.println("Double avg time is:"+avg/5);

	/** 
		int m, n;
		long p;
		Random rand = new Random();
		Instant start, finish;
		double runnigTime;
		LPHashTable tableLP;
		AQPHashTable tableAQP;
		QPHashTable tableQP;
		DoubleHashTable tableD;

		// Q 3.b
		System.out.println("====================================================");
		System.out.println("STARTING Q 3.b");
		System.out.println("====================================================");
		m = 6571;
		p = 1000000007;
		int excepQP=0, excepAQP=0;

		long[] d = new long[m];
		//System.out.println("Start inserting for QPHashTable: ");
		for (int t = 0; t < 100; t++) {

			QPHashTable table3 = new QPHashTable(m, p);

			// The random series
			for (int i = 0; i < m; i++) {
				d[i] = (100 * i) + rand.nextInt(100);
			}

			for (int i = 0; i < m; i++) {
				try {
					table3.Insert(new HashTableElement(d[i], d[i]));
				} catch (Exception e) {
					e.printStackTrace();
					excepQP++;
					
					
				}
			}
		}
		
		long[] d2 = new long[m];
		//System.out.println("Start inserting for AQPHashTable: ");
		for (int k = 0; k < 100; k++) {

			AQPHashTable table3_2 = new AQPHashTable(m, p);

			// The random series
			for (int i = 0; i < m; i++) {
				d2[i] = (100 * i) + rand.nextInt(100);
			}

			for (int i = 0; i < m; i++) {
				try {
					table3_2.Insert(new HashTableElement(d2[i], d2[i]));
				} catch (Exception e) {
					excepAQP++;
				}
			}
		}
	System.out.println("number of exceptions in QP: "+excepQP+"\nnumber of exceptions in AQP: "+excepAQP);	


		// Q 4.a
		System.out.println("====================================================");
		System.out.println("STARTING Q 4.a");
		System.out.println("====================================================");
		m = 10000019;
		p = 1000000007;
		n = (int) (m / 2);
		long[] a = new long[n];

		// The random series
		for (int i = 0; i < n; i++) {
			a[i] = (100 * i) + rand.nextInt(100);
		}

		// LP test
		start = Instant.now();
		tableLP = new LPHashTable(m, p);
		for (int i = 0; i < n; i++) {
			HashTableElement element = new HashTableElement(a[i], a[i]);
			try {
				tableLP.Insert(element);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		finish = Instant.now();
		double runningTime = Duration.between(start, finish).toMillis();
		System.out.println("The running time of LP is: " + runningTime);

		// QP test
		start = Instant.now();
		tableQP = new QPHashTable(m, p);
		for (int i = 0; i < n; i++) {
			HashTableElement element = new HashTableElement(a[i], a[i]);
			try {
				tableQP.Insert(element);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		finish = Instant.now();
		runningTime = Duration.between(start, finish).toMillis();
		System.out.println("The running time of QP is: " + runningTime);

		// AQP test
		start = Instant.now();
		tableAQP = new AQPHashTable(m, p);
		for (int i = 0; i < n; i++) {
			HashTableElement element = new HashTableElement(a[i], a[i]);
			try {
				tableAQP.Insert(element);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		finish = Instant.now();
		runningTime = Duration.between(start, finish).toMillis();
		System.out.println("The running time of AQP is: " + runningTime);

		// DoubleHashTable test
		start = Instant.now();
		tableD = new DoubleHashTable(m, p);
		for (int i = 0; i < n; i++) {
			
			HashTableElement element = new HashTableElement(a[i], a[i]);
			try {
				tableD.Insert(element);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		finish = Instant.now();
		runningTime = Duration.between(start, finish).toMillis();
		System.out.println("The running time of DoubleHashTable is: " + runningTime);

		// Q 4.b
		System.out.println("====================================================");
		System.out.println("STARTING Q 4.b");
		System.out.println("====================================================");
		m = 10000019;
		p = 1000000007;
		n = (int) ((19 * m) / 20);
		long[] b = new long[n];

		// The random series
		for (int i = 0; i < n; i++) {
			b[i] = (100 * i) + rand.nextInt(100);
		}

		// LP test
		start = Instant.now();
		tableLP = new LPHashTable(m, p);
		for (int i = 0; i < n; i++) {
			HashTableElement element = new HashTableElement(b[i], b[i]);
			try {
				tableLP.Insert(element);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		finish = Instant.now();
		runningTime = Duration.between(start, finish).toMillis();
		System.out.println("The running time of LP is: " + runningTime);

		// QP test
		start = Instant.now();
		tableQP = new QPHashTable(m, p);
		for (int i = 0; i < n; i++) {
			HashTableElement element = new HashTableElement(b[i], b[i]);
			try {
				tableQP.Insert(element);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		finish = Instant.now();
		runningTime = Duration.between(start, finish).toMillis();
		System.out.println("The running time of QP is: " + runningTime);

		// AQP test
		start = Instant.now();
		tableAQP = new AQPHashTable(m, p);
		for (int i = 0; i < n; i++) {
			HashTableElement element = new HashTableElement(b[i], b[i]);
			try {
				tableAQP.Insert(element);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		finish = Instant.now();
		runningTime = Duration.between(start, finish).toMillis();
		System.out.println("The running time of AQP is: " + runningTime);

		// DoubleHashTable test
		start = Instant.now();
		tableD = new DoubleHashTable(m, p);
		for (int i = 0; i < n; i++) {
			HashTableElement element = new HashTableElement(b[i], b[i]);
			try {
				tableD.Insert(element);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		finish = Instant.now();
		runningTime = Duration.between(start, finish).toMillis();
		System.out.println("The running time of DoubleHashTable is: " + runningTime);

		
		// Q 5
		System.out.println("====================================================");
		System.out.println("STARTING Q 5");
		System.out.println("====================================================");
		m = 10000019;
		p = 1000000007;
		n = (int) (m / 2);
		long[] c = new long[n];
		start = Instant.now();

		DoubleHashTable table5 = new DoubleHashTable(m, p);
		for (int times = 1; times <= 6; times++) {

			if (times == 1 || times == 4) {
				start = Instant.now();
			}
			// a. The random series
			for (int i = 0; i < n; i++) {
				c[i] = (100 * i) + rand.nextInt(100);
			}

			// b. inserting
			for (int i = 0; i < n; i++) {
				try {
					table5.Insert(new HashTableElement(c[i], c[i]));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// c. deleting
			for (int i = 0; i < n; i++) {
				try {
					table5.Delete(c[i]);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (times == 3 || times == 6) {
				finish = Instant.now();
				runningTime = Duration.between(start, finish).toMillis();
				System.out.println("The running time after iteration " + times + " is " + runningTime);
			}
		}**/
	}
}
