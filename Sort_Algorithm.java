
// Idea: select the min value and swap with the first element;
// [0, i] subarray already sorted
// [i+1, n] not yet sort array
Class SelectionSort{
  void sort(int arr[]){
    int n = arr.length;

    for(int i = 0; i < n; i++){
      int min_index = i;
      for(j = i+1; j < n; j++){
        if(arr[j] < arr[min_index]){
          min_index = j;
        }

        // swap the smallest element
        int temp = arr[min_index];
        arr[min_index] = arr[i];
        arr[i] = temp;
      }
    }
  }

}


// insert the new element arr[i] to sorted list [0, i-1]
// no need to swap just cover the next one
Class InsertionSort{
  void sort(int arr[]){
    int n = arr.length;
    for(int i = 1; i < n; i++){
      int j = i - 1;
      int key = arr[i];
      while(j >= 0 && arr[j] > key){
        arr[j+1] = arr[j];
        j -= 1;
      }
      arr[j+1] = key;
    }
  }
}

// Bubble Sort
// Repeatatiely Sorting the adjacent elements
Class BubbleSort{
  void sort(int arr[]){
    int n = arr.length;

    for(int i = 0; i < n - 1; i++){
      for(int j = 0; j < n - i - 1; j++){
        if(arr[j] > arr[j+1]){
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = arr[j];
        }
      }
    }
  }
}

//
Class
