package work.letcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhailzh
 * 
 * @Date 20161229:29:02
 * 
 * һ֪飬ҳеĸһĺΪĳһֵ顣
 */
public class Lettcode4Sum18 {

public List<List<Integer>> fourSum(int[] nums, int target) {
	List<List<Integer>>  res = new ArrayList<List<Integer>>();
	if(nums == null || nums.length < 4){
		return res;
	}
	
	//ʼ
	Arrays.sort(nums);
	
	int fir = 0; 
	int sec = 1;
	
	int thi =  nums.length-2 ;
	int thu =  nums.length -1 ;

	for (; fir < nums.length-3; fir++) {
		int temp = nums[fir]+nums[sec]+nums[thi]+nums[thu];
		if(temp == target){
			List<Integer> restemp = new ArrayList<Integer>();
			restemp.addAll(Arrays.asList(nums[fir],nums[sec],nums[thi],nums[thu]));
			res.add(restemp);
		}else if( temp < target){
			//ӵֵĿֵҪС˵ҪֵҲ˵Ҫfir  sec
//			Ϊֵ
//			1sec+1 fir 
//			2 fir+1sec+1 
//			 
//			sec1firǷ1 Ҫ
			
			while(fir+1 < nums.length -3 && nums[fir+1] == nums[fir]) fir++;
			while(sec+1 < nums.length -3 && nums[sec+1] == nums[sec]) sec++;
		}
	}
	
	
	return null;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
