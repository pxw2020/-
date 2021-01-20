package 其他算法;

public class QuickSort {
    //swap()方法
    private static void swap(int[] data,int i,int j) {
        int temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }
    private static void subSort(int[] data,int start,int end) {
        if(start>end)
            return;
        if(start<end) {
            int pivotal = data[start];
            int low = start;
            int high = end;

            //这里你写了while(true)循环永远出不去
            while(low<high) {
                //这里要先找右边比pivotal小的下标，不然low可能停不下来
                while (low < high && pivotal <= data[high]) high--;
                while (low < high && pivotal >= data[low]) low++;
                if (low < high) {
                    swap(data, low, high);
                }
            }
            //一次遍历之后要把基准值和中间位置交换，再继续递归
            swap(data,start,low);
            subSort(data,start,high-1);
            subSort(data,high+1,end);
        }
    }


    public static void quickSort(int[] data) {
        subSort(data,0,data.length-1);
    }

    public static void main(String[] args) {
        int[] arr=new int[] {20,54,12,145,23,56,45,78,96,444,556,0,2};
        System.out.println("排序之前：");
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        quickSort(arr);
        System.out.println("\n排序之后：");
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}