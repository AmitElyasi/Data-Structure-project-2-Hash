/**
 * 
 * Amit Elyasi 316291434 Amitelyasi
 * Shahar Haskor 208127787 Shaharhaskor
 *
 */

import java.util.concurrent.ThreadLocalRandom;

public class ModHash {
	private long a; 
	private long b;
	private int m;
	private long p;
	
	
	public ModHash(long a, long b, int m, long p) {
		this.a = a;
		this.b = b;
		this.m = m;
		this.p = p;
	}
	
	public static ModHash GetFunc(int m, long p){
		long a = ThreadLocalRandom.current().nextLong(1,p);
		long b = ThreadLocalRandom.current().nextLong(p);
		 return new ModHash(a, b, m, p);
	}
	
	public int Hash(long key) {
		// ((a * key + b) % p) % m  
		return (int) Math.floorMod(((a * key + b) % p),this.m);
	}
}
