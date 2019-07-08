package collections;
import java.util.*;

public class ShoppingListApp {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String userContinue = "y";

		Map<String, Double> items = new HashMap<>();
		items.put("banana", 0.43);
		items.put("apple", 0.99);
		items.put("strawberries", 1.25);
		items.put("cucumber", 0.50);
		items.put("zucchini", 0.85);
		items.put("jalapenio", 1.35);
		items.put("garlic", 1.60);
		items.put("onion", 1.15);
		items.put("avocado", 2.00);
		items.put("cilantro", 0.49);

		List<String> userItems = new ArrayList<>();
		List<Double> userPrices = new ArrayList<>();

		System.out.println("Welcome to Guenther's Market!\n" );

		do{
			System.out.printf("%-10s %-8s\n", "Item", "Price");
			System.out.printf("%-10s \n","---------------------------");
			System.out.printf("%-10s \n","---------------------------");

			for (Map.Entry<String, Double> me : items.entrySet()) {
				System.out.printf("%-12s %-1s %.2f \n", me.getKey()," $",me.getValue());
			}//end for

			System.out.print("What item would you like to order? ");
			String item = scnr.next();
			if(items.containsKey(item)){
				System.out.println("\nAdding " + item + "to cart at $" + items.get(item) + "\n");
				userItems.add(item);
				userPrices.add(items.get(item));
				System.out.print("Would you like to continue? (y/n) ");
				userContinue = scnr.next();
			}//end if
			else{
				System.out.println("Sorry, we don't have those. Please try again.\n");
				userContinue = "y";
			}//end else
		}//end do
		while(userContinue.equals("y") || userContinue.equals("Y"));

		System.out.println("Thanks for your order!");
		System.out.println("Here's what you got:");
		for (int i = 0; i < userItems.size(); i++) {
			System.out.printf("%-11s %-1s %.2f \n", userItems.get(i)," $",userPrices.get(i));
		}//end for
		System.out.printf("Average price per item in order was %.2f ", findAveragePrice(userPrices));
		System.out.println("\nLowest price index in the order was " + findLowestPriceIndex(userPrices) + " which was the " + userItems.get(findLowestPriceIndex(userPrices)));
		System.out.println("Highest price index in the order was " + findHighestPriceIndex(userPrices) + " which was the " + userItems.get(findHighestPriceIndex(userPrices)));
		scnr.close();

	}//end of main

	public static double findAveragePrice(List<Double> prices){
		double average = 0.0;
		double pricesSum = 0.0;
		for (int i = 0; i < prices.size(); i++) {
			pricesSum+=prices.get(i);
		}//end for
		average = pricesSum/(prices.size());
		return average;
	}//end findAveragePrice

	public static int findLowestPriceIndex(List<Double> prices){
		int index = 0;
		for (int i = 0; i < prices.size()-1; i++) {
			if(prices.get(i)<=prices.get(i+1)){
				index = i;
			}
			else{
				index = i+1;
			}
		}//end for
		return index;
	}//end findLowestPriceIndex

	public static int findHighestPriceIndex(List<Double> prices){
		int index = 0;
		for (int i = 0; i < prices.size()-1; i++) {
			if(prices.get(i)>=prices.get(i+1)){
				index = i;
			}
			else{
				index = i+1;
			}
		}//end for
		return index;
	}//end findHighestPriceIndex
}// end of shoppingList