package com.tw.supermarket;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tw.supermarket.model.Category;
import com.tw.supermarket.model.Item;
import com.tw.supermarket.model.PercentageDiscount;
import com.tw.supermarket.model.Product;
import com.tw.supermarket.model.SellingUnit;
import com.tw.supermarket.model.SurplusDiscount;
import com.tw.supermarket.model.VolumeInLitres;
import com.tw.supermarket.model.WeightInKiloGram;

public class SuperMarketApplicationTest {
	
	double totalPrice = 0;
	 double totalItemPrice = 0;
	 
	@Before
	public void setUp(){
		SellingUnit inKG = new WeightInKiloGram();
		SellingUnit inLitres = new  VolumeInLitres();
		
		Category produce = new Category("Produce", new PercentageDiscount(10), null);
		Category fruits = new Category("Fruits", new PercentageDiscount(18), produce);
		Category veg = new Category("Veg", new PercentageDiscount(5), produce);
		
		Category dairy = new Category("Dairy", new PercentageDiscount(15), null);
		Category milk = new Category("Milk", new PercentageDiscount(20), dairy);
		Category cheese = new Category("Cheese", new PercentageDiscount(20), dairy);
		
		
		Product apple = new Product("Apple", 50, fruits, inKG, new SurplusDiscount(3, 1));
		Product potato = new Product("Potato", 30, veg, inKG, new SurplusDiscount(5, 2));
		Product cowMilk = new Product("Cow Milk", 50, milk, inLitres, new SurplusDiscount(3, 1));
	    
		Product orange = new Product("Orange", 80, fruits, inKG, new PercentageDiscount(20));
		Product tomato = new Product("Tomato", 70, veg, inKG, new PercentageDiscount(10));
		Product gouda = new Product("Gouda", 80, cheese, inKG, new PercentageDiscount(10));
		
		 Item appleItem = new Item(6, inKG, apple);
		 Item orangeItem = new Item(2, inKG, orange);
		 Item potatoItem = new Item(14, inKG, potato);
		 Item tomatoItem = new Item(3, inKG, tomato);
		 Item cowMilkItem = new Item(8, inLitres, cowMilk);
		 Item goudaItem = new Item(2, inKG, gouda);
		 
		 List<Item> items = new ArrayList<Item>();
		 
		 items.add(goudaItem);
		 items.add(orangeItem);
		 items.add(potatoItem);
		 items.add(appleItem);
		 items.add(tomatoItem);
		 items.add(cowMilkItem);
		 
		 for(Item item : items){
			 double price = item.getItemDiscountedPrice();
			 totalItemPrice = totalItemPrice + item.getItemPrice();
			 totalPrice=totalPrice + price;
		 }
	}

	@Test
	public void testDiscountedPriceForCustomer() {
		Assert.assertEquals(1295, totalPrice,0);
	}
}
