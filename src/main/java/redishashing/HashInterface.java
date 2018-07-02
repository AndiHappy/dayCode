package redishashing;

/**
 * @author zhailz
 *
 * @version 2018年7月1日 下午6:39:39
 */
public interface HashInterface {

	Integer hash(String string);

	int hash(Object key);

}
