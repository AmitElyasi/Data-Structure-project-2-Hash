/**
 * 
 * Amit Elyasi 316291434 Amitelyasi
 * Shahar Haskor 208127787 Shaharhaskor
 *
 */

public class AQPHashTable extends OAHashTable {

	private ModHash hashFunc;
	
	public AQPHashTable(int m, long p) {
		super(m);
		ModHash mh = ModHash.GetFunc(m, p);
		this.hashFunc = mh;
	}
	
	@Override
	public int Hash(long x, int i) {
		if(i%2==0) {
			return Math.floorMod((hashFunc.Hash(x) + i*i),super.m);
		}
		else {
			return Math.floorMod((hashFunc.Hash(x) - i*i),super.m);
		}
		
	}
}
