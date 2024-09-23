package Search;

public class Search {
    public static void merging(int low, int mid, int high, String[] array){
        int length = array.length;
        String tempArray[] = new String[length];
        int l1, l2, i;
        for(l1 = low, l2 = mid + 1, i = low; l1 <= mid && l2 <= high; i++) {
            if(array[l1].compareTo(array[l2])<0)
                tempArray[i] = array[l1++];
            else
                tempArray[i] = array[l2++];
        }
        while(l1 <= mid)
            tempArray[i++] = array[l1++];
        while(l2 <= high)
            tempArray[i++] = array[l2++];
        for(i = low; i <= high; i++)
            array[i] = tempArray[i];
    }
    public static void mergeSort(String[] array, int low, int high){
        int mid;
        if(low < high) {
            mid = (low + high) / 2;
            mergeSort(array,low, mid);
            mergeSort(array,mid+1, high);
            merging(low, mid, high,array);
        }
    }
    public static boolean binarySearch(String[] Array, String item, int low, int high) {
        mergeSort(Array,low, high);
        while (low <= high) {
            int middle = (high + low) / 2;
            if (Array[middle].equals(item))
                return true;
            else if (Array[middle].compareTo(item)<0) {
                low = middle + 1;
            } else
                high = middle - 1;
        }
        return false;
    }
    public static boolean exponentialSearch(String[] array, int size, String item) {
        mergeSort(array,0, array.length-1);
        int i = 1;
        if (array[0].equals(item))
            return true;
        while (i < size && array[i].compareTo(item)<=0)
            i *= 2;
        return binarySearch(array, item, i / 2, Math.min(i, size - 1));
    }
}

