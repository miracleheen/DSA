class MergeSortedArray { //Есть еще одно решение, но оно не совсем чистое исходя из тз (но тесты, submit проходит)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int result = m + n - 1;

        while(p1 >=0 && p2 >=0){
            if(nums1[p1] > nums2[p2]){
                nums1[result] = nums1[p1];
                --p1;
            }else{
                nums1[result] = nums2[p2];
                --p2;
            }

            --result;
        }

        while(p2>=0){
            nums1[result] = nums2[p2];
            --p2;
            --result;
        }
    }
}
