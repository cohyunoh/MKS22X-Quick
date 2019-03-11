public class Quick{
  /*return the value that is the kth smallest value of the array.
 */
 public static int quickselect(int []data, int k){
   int output = -1;
   int start = 0;
   int end = data.length - 1;
   boolean found = false;
   while(!found){
     output = partition(data, start, end);
     if(output != k){
       if(output < k){
         start = output;
       }else{
         end = output;
       }
     }else{
       found == true;
     }
   }
   return output;
 }
 public static int partition ( int [] data, int start, int end){
   if(end == start){
     return start;
   }
   int pivotIndex = ((int)(Math.random() * 10) % (end + 1 - start)) + start;
   int first =  data[start];
   data[start] = data[pivotIndex];
   data[pivotIndex] = first;
   pivotIndex = start;
   int tempStart = start + 1;
   int tempEnd = end;
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
     }else if(data[tempStart] <= data[pivotIndex]){
       tempStart ++;
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
