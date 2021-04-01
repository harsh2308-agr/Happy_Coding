package practical7;
import java.util.*; 
import java.util.Comparator;


 class Product { 
    int product_id;
    String product_name;
    int cost;
    String category;
  
    Product(int product_id, String product_name, int cost, String category) 
    { 
       this.product_id=product_id;
        this.product_name=product_name;
        this.cost=cost;
        this.category=category;
    } 
  
    public int  getcost() 
    { 
        return this.cost; 
    } 
     @Override
     public String toString(){
        return "{" + "Name: "+ product_name+" Product_id: "+ product_id+" Cost:"+cost
                +" Category: " +category+ " }";
    }
     public static Comparator<Product> cost3 = new Comparator<Product>() {

        @Override
	public int compare(Product s1, Product s2) {

	   int cost1 = s1.getcost();
	   int cost2 = s2.getcost();

	   return cost1-cost2;

   }};
    void sort(ArrayList<Product> list) 
    { 
  
         Collections.sort(list, Product.cost3);
         for(Product str: list){
			System.out.println(str+ " ");
	   }
    } 
} 
  
 public class OnlineShopping{ 
  
static void add(ArrayList<Product> list) 
    { 
        list.add(new Product(1,"NokiaPhone",15000,"Phone")); 
        list.add(new Product(2,"Shirt",500,"Clothing")); 
        list.add(new Product(3,"Bed",3000,"Furniture")); 
        list.add(new Product(4,"Hplaptop",50000,"Laptops")); 
        list.add(new Product(5,"Book",50,"Stationary")); 
        list.add(new Product(6,"Pencil",10,"Stationary"));
        list.add(new Product(7,"Chair",300,"Furniture"));
        list.add(new Product(8,"MobileCharger",2000,"Gadgets"));
        list.add(new Product(9,"T-shirt",400,"Clothing"));
        list.add(new Product(10,"DellLaptops",60000,"Laptops"));
    } 
  
    public static void main(String[] args) 
    { 
       
  
        ArrayList<Product> list1 = new ArrayList<Product>(); 
        ArrayList<Product> cartlist = new ArrayList<Product>();
        add(list1); 
        System.out.println("We have the following things for Shopping ");
        for(Product str: list1){
			System.out.println(str+ " ");
	          }
        int choice=0;
        Scanner sc= new Scanner(System.in);
        while(choice != 5){
        System.out.println("********************************");
        System.out.println("*****MAIN MENU******");
        
        System.out.println("Press 1 To sort the given Items according to the cost ");
        System.out.println("Press 2 To add items to Your cart list ");
        System.out.println("Press 3 To View Your cart ");
        System.out.println("Press 4 to Remove the items from your cart ");
        System.out.println("Press 5 To Exit ");
        System.out.println("Enter Your choice");
        choice=sc.nextInt();
        switch(choice)
        {
            case 1: 
                    System.out.println("You selected to sort the given items ");
                    Product obj=new Product(66,"hgh",12,"jj");
                    obj.sort(list1);
                    System.out.println("------------------------------------------------");
                    break;
            case 2:
                   System.out.println("You selected to Add items to your cart list ");
                   System.out.println("Enter The product id which you want to Add to your cart list ");
                   int a;
                   a=sc.nextInt();
                   for(int i=0;i<list1.size();i++)
                   {
                       if(a == list1.get(i).product_id){
                           cartlist.add(list1.get(i));
                           
                       }
                   }
                   System.out.println("Your cart list is= ");
                   for(Product str: cartlist){
			System.out.println(str+ " ");
	          }
                   System.out.println("------------------------------------------------");
                   break;
            case 3:
                System.out.println("You Selected to view your cart ");
                for(Product str: cartlist){
			System.out.println(str+ " ");
	          }
                System.out.println("------------------------------------------------");
                break;
                
            case 4:
                System.out.println("You selected to Remove the items from the Cart list ");
                System.out.println("Enter the Product id Which you want to Remove from your cart list ");
                int b;
                b=sc.nextInt();
                for( int i=0; i<cartlist.size();i++)
                {
                    if(b==cartlist.get(i).product_id)
                        cartlist.remove(cartlist.get(i));
                }
                System.out.println("Items have been Removed Successfully ");
                System.out.println("Now Your Cart is ");
                for(Product str: cartlist)
                {
			System.out.println(str+ " ");
	         }
                System.out.println("------------------------------------------------");
                break;
            case 5:
                 System.out.println("You selected to Quit ");
                 System.out.println("------------------------------------------------");
                 break;
            default:
                System.out.println("Invalid Choice , Please Enter a valid choice ");
                System.out.println("------------------------------------------------");
                break;
           }
        }
    } 
}
