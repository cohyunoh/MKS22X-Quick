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
   if(end == start){
     return data;
   }else{
     //System.out.println("Pass");
     //System.out.println(toString(data));
    // System.out.println(start);
     //System.out.println(end);
     int newpivot = partition(data, start, end);
     if(newpivot - 1 > start){
       quickH(data, start, newpivot - 1);
     }
     if(newpivot + 1 < end){
       quickH(data, newpivot + 1, end);
     }
   }
   return data;
 }

 public static int partition ( int [] data, int start, int end){
   if(end == start){
     return start;
   }
   int pivotIndex = (start + end) / 2;
   int first =  data[start];
   data[start] = data[pivotIndex];
   data[pivotIndex] = first;
   pivotIndex = start;
   int tempStart = start + 1;
   int tempEnd = end;
   Random randnum = new Random();
   //System.out.println(pivotIndex);
   while(tempStart != tempEnd){
     //System.out.println("Start: " + tempStart);
     //System.out.println("End: " + tempEnd);
     //System.out.println(toString(data));
     if(data[tempStart] > data[pivotIndex]){
       int temp = data[tempStart];
       data[tempStart] = data[tempEnd];
       data[tempEnd] = temp;
       tempEnd --;
     }else if(data[tempStart] < data[pivotIndex]){
       tempStart ++;
     }else if(data[tempStart] == data[pivotIndex]){
       int place = randnum.nextInt() % 2;
       if(place == 0){
         int temp = data[tempStart];
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
   for(int c = start; c < end + 1; c++){
     if(data[c] > data[pivotIndex]){
       int temp = data[c - 1];
       data[c - 1] = data[pivotIndex];
       data[pivotIndex] = temp;
       return c - 1;
     }
   }
   int temp = data[end];
   data[end] = data[pivotIndex];
   data[pivotIndex] = temp;
   return end;
 }
}
