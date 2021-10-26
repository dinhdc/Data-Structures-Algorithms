package sort;

public class Sort {

    public void mergeSort(int[] nums, int start, int end){
        if(end - start < 2) return;
        int mid = (start+end)/2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid, end);
        merge(nums, start, mid, end);
    }

    public void merge(int[] nums, int start, int mid, int end) {
        if(nums[mid - 1] <= nums[mid]){
            return;
        }
        int i = start;
        int j = mid;
        int tmpIndex = 0;
        int[] temp = new int[end-start];
        while(i < mid && j < end){
            temp[tmpIndex++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        System.arraycopy(nums, i, nums,start + tmpIndex, mid - i);
        System.arraycopy(temp, 0, nums, start, tmpIndex);
    }

    public void bubbleSort(int[] nums){
        // O(n^2)
        int length = nums.length;
        for(int lastUnsortedIndex = length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--){
            for(int j = 0; j < lastUnsortedIndex ; j++){
                if(nums[j] > nums[j+1]){
                    swap(nums, j, j+1);
                }
            }
        }
        printArray(nums);
    }

    public void selectionSort(int[] nums){
        // O(n^2)
        int length = nums.length;
        for(int lastUnsortedIndex = length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--){
           int largest = 0;

           for(int i = 1; i <= lastUnsortedIndex; i++){
               if(nums[i] > nums[largest]){
                   largest = i;
               }
           }
           swap(nums, largest, lastUnsortedIndex);
        }
        printArray(nums);
    }

    public void insertionSort(int[] nums){
        // O(n^2)
        int length = nums.length;
        for(int firstUnsortedIndex = 1; firstUnsortedIndex < length; firstUnsortedIndex++){
            int newElement = nums[firstUnsortedIndex];
            int i;
            for(i = firstUnsortedIndex; i>0 && nums[i-1] > newElement;i--){
                nums[i] = nums[i-1];
            }
            nums[i] = newElement;
        }
        printArray(nums);
    }

    public void shellSort(int[] nums){
        for(int gap = nums.length/2; gap>0; gap/=2){
            for(int i=gap; i< nums.length;i++){
                int newElement = nums[i];
                int j = i;
                while(j >= gap && nums[j-gap] > newElement){
                    nums[j] = nums[j-gap];
                    j-=gap;
                }
                nums[j] = newElement;
            }
        }
    }

    public void quickSort(int[] nums, int start, int end){
        // O(nlogn)
        // unstatble
        if(end - start < 2){
            return;
        }
        int pivotIndex = partition(nums, start, end);
        quickSort(nums, start, pivotIndex);
        quickSort(nums, pivotIndex+1, end);
    }

    private int partition(int[] nums, int start, int end){

        int pivot = nums[start];
        int i = start;
        int j = end;
        while(i<j){
            // empty loop
            while(i < j && nums[--j] >= pivot);
            if(i < j){
                nums[i] = nums[j];
            }

            while(i< j && nums[++i] <= pivot);
            if(i < j){
                nums[j] = nums[i];
            }
        }
        nums[j] = pivot;
        return j;
    }

    public void countingSort(int[] nums, int min, int max){
        int[] countArray = new int[(max-min) + 1];
        for(int i=0; i<nums.length;i++){
            countArray[nums[i] - min]++;
        }
        int j = 0;
        for(int i=min; i <= max; i++){
            while(countArray[i-min]>0){
                nums[j++] = i;
                countArray[i-min]--;
            }
        }
    }

    public void radixSort(int[] nums, int radix, int width){
        for (int i=0; i<width;i++){
            radixSingleSort(nums, i, radix);
        }
    }

    private void radixSingleSort(int[] nums, int position, int radix) {
        int numItems = nums.length;
        int[] countArray = new int[radix];
        for(int value: nums){
            countArray[getDigit(position, value, radix)]++;
        }
    }

    private int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(10, position) % radix;
    }

    private void swap(int[] nums, int i, int j){
        if(i==j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void printArray(int[] nums){
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
