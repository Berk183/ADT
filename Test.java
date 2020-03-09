public class Test {
  public static void main(String[] args){
       MyBag bag=new MyBag();
       MyBag bag2=new MyBag();
       MyBag bag3=new MyBag();
       
       bag.addItem(30);
       bag.addItem(40);
       bag.addItem(50);
       bag.addItem(60);
       bag.addItem(70);
       bag.addItem(80);
       bag.addItem(90);
       bag.addItem(100);
       bag.addItem(30);
       bag.addItem(30);
       bag.addItem(70);
       System.out.println("bag");
       System.out.println(bag.toString());
       
       System.out.println("---------------------------------------");
       
       bag2.addItem(70);
       bag2.addItem(60);
       bag2.addItem(50);
       bag2.addItem(40);
       bag2.addItem(30);
       bag2.addItem(90);
       bag2.addItem(80);
       bag2.addItem(100);
       bag2.addItem(30);
       bag2.addItem(30);
       bag2.addItem(70);
       System.out.println("bag2");
       System.out.println(bag2.toString());
       System.out.println("---------------------------------------");
       System.out.println("comparing bag and bag2 and the result is:");
       if(bag.equals(bag2))
           System.out.println("objects are same");
       
       else
           System.out.println("objects are not same");
       System.out.println("---------------------------------------");
       bag3.addItem("z");
       bag3.addItem("b");
       bag3.addItem("c");
       bag3.addItem("d");
       bag3.addItem("l");
       bag3.addItem("f");
       bag3.addItem("g");
       bag3.addItem("h");
       bag3.addItem("a");
       bag3.addItem("j");
       bag3.addItem("b");
       System.out.println("bag3");
       System.out.println(bag3.toString());
       
       System.out.println("---------------------------------------");
       System.out.println("comparing bag and bag3 and the result is:");
       if(bag.equals(bag3))
           System.out.println("objects are same");
       
       else
           System.out.println("objects are not same");
       System.out.println("---------------------------------------");
       System.out.println("clearing bag");
       bag.clear();
       System.out.println(bag.toString());
       System.out.println("---------------------------------------");
       
       if(bag.isEmpty()){
           System.out.println("bag is empty");
       }
       else
           System.out.println("bag is not empty");
       System.out.println("---------------------------------------");
       if(bag2.contains(30)){
           System.out.println("bag2 contains 30");
       }
       else
           System.out.println("bag2 does not contain 30");
       
       System.out.println("---------------------------------------");
       if(bag2.contains(0)){
           System.out.println("bag2 contains 0");
       }
       else
           System.out.println("bag2 does not contain 0");
       
       System.out.println("---------------------------------------");
       
       System.out.println(bag3.toString());
       System.out.println("bag3 size: "+bag3.size());
       System.out.println("bag3 distict size: "+bag3.distictSize());
       System.out.println("removing a on bag 3:");
       bag3.remove("a");
       System.out.println(bag3.toString());
       System.out.println("---------------------------------------");
       System.out.println("removing b on bag 3:");
       bag3.remove("b");
       System.out.println(bag3.toString());
       System.out.println("---------------------------------------");
       System.out.println("bag3 size: "+bag3.size());
       System.out.println("bag3 distict size: "+bag3.distictSize());
       
       
       
       
    }
}
