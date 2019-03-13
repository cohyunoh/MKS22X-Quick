import java.util.Random;
public class Quick{
  /*return the value that is the kth smallest value of the array.
 */
 public static int quickselect(int[] data, int k){
   //output will be our answer and will be compared to k
   int output = -1;
   //this is our initial start
   int start = 0;
   //this is our initial end
   int end = data.length - 1;
   //this will tell us if we found the kth lowest term
   boolean found = false;
   while(!found){
     //output equals a value in the right order after partition from start to end
     output = partition(data, start, end);
     //if the index of the one sorted value is not equal to k then
     //check to see if the index is greater or less than k and then
     //change start and end accordingly.
     if(output != k){
       if(output < k){
         //if the output is less than k then that means that the value is in the greater
         //section of the partitioned list
         start = output + 1;
       }else{
         //if the output is greater than k then that means that the value is in the lesser
         //section of the partitioned list
         end = output - 1;
       }
     }else{
       //if they are equal then the kth lowest value has been found
       found = true;
     }
   }
   //return this values
   return data[output];
 }

 public static int[] quicksort(int[] data){
   //perform recursive helper method with the start and end being the whole list
   return quickH(data, 0, data.length - 1);
 }

/*
 private static String toString(int[] ary){
   String ans = "";
   for(int i = 0; i < ary.length; i++){
     ans += ary[i] + " ";
   }
   return ans;
 }
 */

 private static int[] quickH(int[] data, int start, int end){
   //if the two start and end are equal then that means that the element that is in this
   //index is in the right place
   if(end == start){
     return data;
   }else{
     //System.out.println("Pass");
     //System.out.println(toString(data));
    // System.out.println(start);
     //System.out.println(end);
     //get the newpivot by retrieving the value from a partitioned list from start to end
     int newpivot = partition(data, start, end);
     //perform another partition with the less half of the values
     if(newpivot - 1 > start){
       quickH(data, start, newpivot - 1);
     }
     //perform another partition with great hald of the values
     if(newpivot + 1 < end){
       quickH(data, newpivot + 1, end);
     }
   }

   return data;
 }

 public static int partition ( int [] data, int start, int end){
   //if the two are equal then just return the start index
   if(end == start){
     return start;
   }
   //the pivotIndex is the median value from start to end
   int pivotIndex = (start + end) / 2;
   //swap the first value with the pivot value
   int temp =  data[start];
   data[start] = data[pivotIndex];
   data[pivotIndex] = temp;
   pivotIndex = start;
   //this will be the start that will change around (it is the value after the pivot)
   int tempStart = start + 1;
   //this will be the end that will change around
   int tempEnd = end;
   //this will be used in the case of duplicates
   Random randnum = new Random();
   //System.out.println(pivotIndex);
   //keep on swapping until the two ends meet each other, which means that the list is split up
   //between values greater than the pivot and less than the pivot
   while(tempStart != tempEnd){
     //System.out.println("Start: " + tempStart);
     //System.out.println("End: " + tempEnd);
     //System.out.println(toString(data));

     //if the value at the start is greater than the pivot value then swap it with the end value
     //of the list and move the tempEnd down 1
     if(data[tempStart] > data[pivotIndex]){
       temp = data[tempStart];
       data[tempStart] = data[tempEnd];
       data[tempEnd] = temp;
       tempEnd --;
     //if the value at the start is less than the pivot value then move the tempStart up 1 since
     //it is in the correct position
     }else if(data[tempStart] < data[pivotIndex]){
       tempStart ++;
     //if the tempStart value and the pivot value equal then give it a 50/50 chance that it will
     //remain where it is or swap with the end
     }else if(data[tempStart] == data[pivotIndex]){
       int place = randnum.nextInt() % 2;
       if(place == 0){
         temp = data[tempStart];
         data[tempStart] = data[tempEnd];
         data[tempEnd] = temp;
         tempEnd --;
       }else if(place == 1){
         tempStart ++;
       }
     }
     //System.out.println("Start: " + tempStart);
     //System.out.println("End: " + tempEnd);
     //System.out.println(toString(data));
   }
   //loop the through list and see where there is a value greater than the pivot
   //once found swap the pivot from the start with the value before the first greater
   //number in the list
   for(int c = start; c < end + 1; c++){
     if(data[c] > data[pivotIndex]){
       temp = data[c - 1];
       data[c - 1] = data[pivotIndex];
       data[pivotIndex] = temp;
       return c - 1;
     }
   }
   //if it is the greatest then swap it with the end
   temp = data[end];
   data[end] = data[pivotIndex];
   data[pivotIndex] = temp;
   return end;
 }
}
