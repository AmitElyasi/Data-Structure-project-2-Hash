/**
 * 
 * Amit Elyasi 316291434 Amitelyasi
 * Shahar Haskor 208127787 Shaharhaskor
 *
 */

public class LPHashTable extends OAHashTable {
	private ModHash hashFunc;
	
	public LPHashTable(int m, long p) {
		super(m);
		ModHash mh = ModHash.GetFunc(m, p);
		this.hashFunc = mh;
	}
	
	@Override
	public int Hash(long x, int i) {
		return Math.floorMod((hashFunc.Hash(x) + i), super.m);
	}
	
}
