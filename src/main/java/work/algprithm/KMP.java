package work.algprithm;

import java.util.Arrays;

/**
 * @author zhailzh
 * 
 * @Date 2015��11��12��������9:40:56
 * 
 *       KMP ������һ���ַ������ҵ�һ�����ϵıȽ϶̵��ַ�����p��ƥ���λ��
 */
public class KMP {

    public static void main(String[] args) {
	System.out.println(getTraverseindex1("BBC ABCDAB ABCDABCDABD", "ABCDABD"));
	System.out.println(getTraverseindex2("BBC ABCDAB ABCDABCDABD", "ABCDABD"));

	System.out.println(Arrays.toString(getnext("ABCDABD".toCharArray())));
    }

    // ���Ĺ���ǰ׺��׺������
    // Ϊʲô��������ǰ׺�ͺ�׺��˵����Ϊ��ƥ���ʱ�򣬲���i���ݣ��������Ǳ���
    // ȷ��i��ʼ��λ�á�
    public static int[] getNext(char[] p) {
	int[] next = new int[p.length];
	next[0] = -1;
	for (int i = 0; i < p.length; i++) {
	    int index = 0;
	    for (int j = 0; j < i; j++) {
		if (p[i - j] == p[j]) {
		    index++;
		} else {
		    break;
		}
	    }
	    next[i] = index;
	}

	return next;
    }

    // ʹ�õݹ�ķ����ҵ�next��ֵ������next�ĳ�ʼ����next[0]Ϊ-1��
    // ֪��next[j] = k ��˵��*p0,p1,p2,..pk-1*,pk,....*pn-(k-1),...,pn-1 ,pn-0*
    // ˵������*֮���Ԫ������ȵģ�����������next[j+1]
    // *p0,p1,p2,..pk-1*,pk,pk+1,...pn-(k),*pn-(k-1),...,pn-1 ,pn-0*
    // ֻ��Ҫ�Ƚ�pk,�� pn-k����
    // �������ȣ���ݹ鵽k-1�����
    public static int[] getnext(char[] p) {
	int pLen = p.length;
	int next[] = new int[pLen];
	next[0] = -1;
	int k = -1;
	int j = 0;
	while (j < pLen - 1) {
	    // p[k]��ʾǰ׺��p[j]��ʾ��׺
	    if (k == -1 || p[j] == p[k]) {
		++k;
		++j;
		next[j] = k;
	    } else {
		k = next[k];
	    }
	}

	return next;
    }

    // ���������ķ���
    public static int getTraverseindex2(String target, String pattern) {
	if (target != null && pattern != null) {
	    char[] tar = target.toCharArray();
	    char[] pat = pattern.toCharArray();

	    int i = 0, j = 0;
	    while (i < tar.length && j < pat.length) {
		if (tar[i] == pat[j]) {
		    i++;
		    j++;
		} else {
		    /**
		     * i=i-(j-1); <br/>
		     * abcdefg<br/>
		     * abcdh<br/>
		     * �����Ǹ���j�ߵ�λ�ã�i����ߣ����ǻ��ݣ�ֱ��дi++�������һ�ֲ���ȷ��д��
		     * ��Ϊi��һֱ�ĵ�����û��һ�����ݵĹ��� ������������£�"BBC ABCDAB ABCDABCDABD",
		     * "ABCDABD" ���е�17��λ�ã��ͻ�ֱ�ӵ����ӣ������ƥ���λ��
		     */
		    i = i - (j - 1);
		    // i++;
		    j = 0;
		}
	    }
	    if (i <= tar.length && j == pat.length) {
		return i - j;
	    }

	}
	return -1;

    }

    // ���������ķ���
    public static int getTraverseindex1(String target, String pattern) {
	if (target != null && pattern != null) {
	    char[] tar = target.toCharArray();
	    char[] pat = pattern.toCharArray();

	    // �������ҵ���һ���ַ���ȵ�λ��
	    for (int i = 0; i < tar.length; i++) {
		char c = tar[i];
		// �������ַ���pattern�����ַ����
		if (c == pat[0]) {
		    int j = 1;
		    boolean index = true;
		    for (; j < pat.length; j++) {
			if (pat[j] != tar[i + j]) {
			    index = false;
			    break;
			}
		    }

		    if (index) {
			return i;
		    }

		} else {
		    continue;
		}

	    }

	}

	return -1;
    }
}
