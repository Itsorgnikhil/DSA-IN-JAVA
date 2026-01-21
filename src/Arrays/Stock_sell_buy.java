package Arrays;



public class Stock_sell_buy {
public static int  stocksellbuy(int prices[]) {
	int buyprices = Integer.MAX_VALUE; 
	int maxProfit=0;
	
	for(int i=0;i<prices.length;i++) {
		
		if(buyprices<prices[i]) {
			int profit = prices[i]- buyprices;
			maxProfit =Math.max(maxProfit,profit);
			
		}else {
			buyprices = prices[i];
		}
		
	}
	return maxProfit;
	
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int prices[] = {7,1,5,3,6,4};
System.out.println(stocksellbuy(prices));
}

}
