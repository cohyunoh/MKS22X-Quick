public class tester{
  public static void main(String[] args) {
    int[]ary = { 2, 10, 15, 23, 0,  5};  //sorted :  {0,2,5,10,15,23}
    System.out.println(Quick.quickselect(ary , 0 ));
    System.out.println(Quick.quickselect(ary , 1 ));
    System.out.println(Quick.quickselect(ary , 2 ));
    System.out.println(Quick.quickselect(ary , 3 ));
    System.out.println(Quick.quickselect(ary , 4 ));
    System.out.println(Quick.quickselect(ary , 5 ));
  }
}
