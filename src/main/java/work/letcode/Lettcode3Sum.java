package work.letcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhailzh
 * 
 * @Date 2015��12��20��������4:50:24
 * 
 */
public class Lettcode3Sum {

	// Given an array S of n integers, are there elements a, b, c in S such that
	// a + b + c = 0? Find all unique triplets in the array which gives the sum
	// of zero.
	//
	// Note:
	// Elements in a triplet (a,b,c) must be in non-descending order. (ie, a �� b
	// �� c)
	// The solution set must not contain duplicate triplets.
	// For example, given array S = {-1 0 1 2 -1 -4},
	//
	// A solution set is:
	// (-1, 0, 1)
	// (-1, -1, 2)
	//
	/***
	 * �����Լ��뵽����0��Ϊ�����������Ȼ����������ź����Ժ��ҵ������������ļ����λ�ã�Ȼ��������λ�ã���ѡ�� �ߵ�Ԫ�ء�
	 * 
	 * ���Եķ����Լ������ˣ�����������������û�����⣬�����ź��������Ǿ��ܹ���ʣ�µ�����Ԫ�������������ƵĲ�����
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		// �����ݿ�ʼ����
		Arrays.sort(nums);
		// Ȼ��������ѭ����ȷ����һ��ֵ���ڶ���ֵ�͵�����ֵ�ĺ;�����
		for (int i = 0; i < nums.length - 2; i++) {
			//����������Ƶķǳ�������˼
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int from = i + 1;
				int end = nums.length - 1;
				int sumt = 0 - nums[i];
				while (from < end) {
					// ������
					int temp = nums[from] + nums[end];
					if (sumt == temp) {
						res.add(Arrays.asList(nums[i], nums[from], nums[end]));
						while (from < end && from + 1 < nums.length && nums[from] == nums[from + 1])
							from++;
						while (from < end && end + 1 < nums.length && nums[end] == nums[end + 1])
							end--;
						from++;
						end--;
					} else if (sumt < temp) {
						end--;
					} else {
						from++;
					}
				}
			}
		}
		return res;
	}

	public List<List<Integer>> threeSum1(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		for (int i = 0; i < num.length - 2; i++) {
			if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
				int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
				while (lo < hi) {
					if (num[lo] + num[hi] == sum) {
						res.add(Arrays.asList(num[i], num[lo], num[hi]));
						while (lo < hi && num[lo] == num[lo + 1])
							lo++;
						while (lo < hi && num[hi] == num[hi - 1])
							hi--;
						lo++;
						hi--;
					} else if (num[lo] + num[hi] < sum)
						lo++;
					else
						hi--;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Lettcode3Sum sm = new Lettcode3Sum();
		int[] nums = new int[] {1,-1,-1,0 };
		List<List<Integer>> res = sm.threeSum(nums);
		System.out.println(res.toString());
	}
}
