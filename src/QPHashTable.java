/**
 * 
 * Amit Elyasi 316291434 Amitelyasi
 * Shahar Haskor 208127787 Shaharhaskor
 *
 */

public class QPHashTable extends OAHashTable {

	private ModHash hashFunc;

	public QPHashTable(int m, long p) {
		super(m);
		ModHash func= ModHash.GetFunc(m, p);
		this.hashFunc= func;
	}
	
	@Override
	public int Hash(long x, int i) {
		
		return Math.floorMod((hashFunc.Hash(x) + i*i),super.m);
	}
}

