/**
 * 
 * Amit Elyasi 316291434 Amitelyasi
 * Shahar Haskor 208127787 Shaharhaskor
 *
 */


public class DoubleHashTable extends OAHashTable {

	private ModHash hashFunc1;
	private ModHash hashFunc2;
	
	public DoubleHashTable(int m, long p) {
		super(m);
		ModHash Func1 = ModHash.GetFunc(m, p);
		this.hashFunc1 = Func1;
		ModHash Func2 = ModHash.GetFunc(m-1, p);
		this.hashFunc2 = Func2;
	}
	
	@Override
	public int Hash(long x, int i) {
		return Math.floorMod((hashFunc1.Hash(x) + i*(hashFunc2.Hash(x)+1)), super.m);
	}
	
}
