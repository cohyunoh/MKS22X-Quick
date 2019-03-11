import java.util.Random;
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
    if(args[0] != null){
      int len = Integer.parseInt(args[0]);
      int[] ary = new int[len];
      Random nums = new Random();
      for(int i = 0; i < len; i++){
        ary[i] = nums.nextInt() / 100000000;
      }
      System.out.println(toString(ary));
      System.out.println(test(Quick.quicksort(ary)));
      System.out.println(toString(ary));
    }

    /*
    System.out.println(Quick.quickselect(ary , 0 ));
    System.out.println(Quick.quickselect(ary , 1 ));
    System.out.println(Quick.quickselect(ary , 2 ));
    System.out.println(Quick.quickselect(ary , 3 ));
    System.out.println(Quick.quickselect(ary , 4 ));
    System.out.println(Quick.quickselect(ary , 5 ));
    */
  }
}
