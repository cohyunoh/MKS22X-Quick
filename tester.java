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
    int[] ary = {1,5,1,5,5,7,7};
    int[] aryCopy = {1,5,1,5,5,7,7};
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
      Quick.quicksort(ary);
      System.out.println(toString(ary));
    }else if(Integer.parseInt(args[0]) == 1){
      Arrays.sort(aryCopy);
      System.out.println(toString(aryCopy));
    }
  }
}
