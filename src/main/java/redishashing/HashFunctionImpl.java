package redishashing;

/**
 * @author zhailz
 *
 * @version 2018年7月1日 下午6:59:46
 */
public class HashFunctionImpl implements HashInterface {

	/* (non-Javadoc)
	 * @see redishashing.HashInterface#hash(java.lang.String)
	 */
	@Override
	public Integer hash(String string) {
		return string.hashCode();
	}

	/* (non-Javadoc)
	 * @see redishashing.HashInterface#hash(java.lang.Object)
	 */
	@Override
	public int hash(Object key) {
		return key.hashCode();
	}

}
