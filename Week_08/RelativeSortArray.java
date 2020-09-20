public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counter = new int[1001];
        for(int i = 0; i < arr1.length; i++) {
            counter[arr1[i]]++;
        }
        int currentIndex = 0;
        for(int j = 0; j < arr2.length; j++) {
            while(counter[arr2[j]] > 0) {
                arr1[currentIndex++] = arr2[j];
                counter[arr2[j]]--;
            }
        }
        for(int k = 0; k < counter.length; k++) {
            while (counter[k] > 0) {
                arr1[currentIndex++] = k;
                counter[k]--;
            }
        }
        return arr1;
    }
}
