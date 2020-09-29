/**
 * 
 * Amit Elyasi 316291434 Amitelyasi
 * Shahar Haskor 208127787 Shaharhaskor
 *
 */

public abstract class OAHashTable implements IHashTable {

	private HashTableElement[] table;
	private int numFilledSlots;
	protected int m;
	protected final HashTableElement ERAESED = new HashTableElement(-1, -1);

	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
		for (int i = 0; i < table.length; i++) {
			table[i] = null;
		}
		this.numFilledSlots = 0;
		this.m = m;
	}

	@Override
	public HashTableElement Find(long key) {
		for (int i = 0; i < this.m; ++i) {
			// next index
			int index = Hash(key, i);

			// empty slot
			if (table[index] == null) {
				return null;
			}
			// find the key
			else if (table[index].GetKey() == key && table[index] != ERAESED) {
				return table[index];
			}
		}

		// key isn't in the table
		return null;
	}

	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException, KeyAlreadyExistsException {

		if (numFilledSlots == table.length) {
			throw new TableIsFullException(hte);
		}
		if (this.Find(hte.GetKey()) != null) {
			throw new KeyAlreadyExistsException(hte);
		}

		boolean insert = false;
		for (int i = 0; i < table.length; i++) {
			// next index
			int index = Hash(hte.GetKey(), i);

			// doesn't contain value
			if (table[index] == null || table[index] == ERAESED) {
				table[index] = hte;
				numFilledSlots++;
				insert = true;
				break;
			}
			// same key as the key we are inserting with
			else if (table[index].GetKey() == hte.GetKey() && table[index] != ERAESED) {
				throw new KeyAlreadyExistsException(hte);
			}
		}
		if (!insert) {
			throw new TableIsFullException(hte);
		}
	}

	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		boolean deleted = false;

		for (int i = 0; i < table.length; i++) {
			// Compute the next index in the probe sequence
			int index = Hash(key, i);

			// empty slot
			if (table[index] == null) {
				throw new KeyDoesntExistException(key);
			}
			// find the key
			else if (table[index].GetKey() == key && table[index] != ERAESED) {
				table[index] = ERAESED;
				numFilledSlots--;
				deleted = true;
				break;
			}
		}
		// key isn't in the table
		if (!deleted) {
			throw new KeyDoesntExistException(key);
		}
	}

	public void printTable() {
		System.out.println("TABLE PRINT START");
		for (int i = 0; i < table.length; i++) {
			if (table[i] == null) {
				System.out.println("NULL");
			} else if (table[i] == ERAESED) {
				System.out.println("ERAESED");
			} else {
				System.out.println(table[i].GetKey());
			}
		}
		System.out.println("TABLE PRINT FINISH");
	}

	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);
}
