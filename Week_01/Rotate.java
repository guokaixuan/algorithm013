/**
 * 旋转数组
 */
public class Rotate {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for(int i = 0; count < nums.length; i++) {
            int currentIndex = i;
            int tempValue = nums[currentIndex];
            do{
                int nextIndex = (currentIndex + k) % nums.length;
                int nextValue = nums[nextIndex];
                nums[nextIndex] = tempValue;
                tempValue = nextValue;
                currentIndex = nextIndex;
                count++;
            }while(i != currentIndex);
        }
    }
}
