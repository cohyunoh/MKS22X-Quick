import java.util.Random;
import java.util.Arrays;
public class tester{
  private static String toString(int[] ary){
    String ans = "";
    for(int i = 0; i < ary.length; i++){
      ans += ary[i] + " ";
    }
    return ans;
  }
  private static boolean test(int[] ary){
    for(int i = 0; i < ary.length - 1; i++){
      if(ary[i] > ary[i + 1]){
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Random rand = new Random();
    int[] ary =  new int[Math.abs(rand.nextInt()) / 100];
    System.out.println("ArrayLength: " + ary.length);
    for(int i = 0; i < ary.length; i++){
      ary[i] = rand.nextInt();
    }
    int[] aryCopy = ary;
    /*
    System.out.println(Quick.partition(ary, 0 , 6));
    System.out.println(toString(ary));
    */
    /*
    System.out.println(Quick.quickselect(ary , 0 ));
    System.out.println(Quick.quickselect(ary , 1 ));
    System.out.println(Quick.quickselect(ary , 2 ));
    System.out.println(Quick.quickselect(ary , 3 ));
    System.out.println(Quick.quickselect(ary , 4 ));
    System.out.println(Quick.quickselect(ary , 5 ));
    System.out.println(Quick.quickselect(ary , 6 ));
    */
    if(args[0] == null){
      System.out.print("Please Enter 0 or 1");
    }else if(Integer.parseInt(args[0]) == 0){
      Long start = System.currentTimeMillis();
      Quick.quicksort(ary);
      Long end = System.currentTimeMillis();
      Arrays.sort(aryCopy);
      Long end1 = System.currentTimeMillis();
      System.out.println(end - start);
      System.out.println(end1 - end);
      System.out.println(Arrays.equals(ary, aryCopy));
    }
  }
}
