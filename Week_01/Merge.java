/**
 * 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n -1;
        while(m > 0 && n > 0) {
            nums1[len--] = nums1[m-1] > nums2[n-1] ? nums1[--m] : nums2[--n];
        }
        System.arraycopy(nums2, 0, nums1, 0, n);
    }
}
