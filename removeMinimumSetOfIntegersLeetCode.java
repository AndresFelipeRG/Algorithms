class Solution {
    public int minSetSize(int[] arr) {
        int bucket[] = new int[100001];
        int k = 0, total = arr.length;
        for (int num : arr) {
            bucket[num]++;
        }
        Arrays.sort(bucket);
        for (int i = bucket.length - 1; i >= 0; i--) {
              total -= bucket[i];
              k++;
              if (total <= arr.length / 2) {
                  break;
              }
        }
        return k;
    }
}
