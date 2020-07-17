// Java program to rotate an array by
// d elements

class RotateArray {
    /*Function to left rotate arr[] of size n by d*/
    void leftRotate(int arr[], int d, int n)
    {
        for (int i = 0; i < d; i++)
            leftRotatebyOne(arr, n);
    }

    void leftRotatebyOne(int arr[], int n)
    {
        int i, temp;
        temp = arr[0];
        for (i = 0; i < n - 1; i++)
            arr[i] = arr[i + 1];
        arr[i] = temp;
    }

    /* utility function to print an array */
    void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        RotateArray rotate = new RotateArray();
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };

        int d = 100;
        int temp = 0,i ;

        for (i = 0; i < d - 1; i++)
            arr[i] = arr[i + 1];

        arr[i] = temp;
        System.out.print( arr[i] + " Hello Swetabh");

       // rotate.printArray(arr, 7);
    }
}

// This code has been contributed by Mayank Jaiswal
