package br.edu.ifsp.dsw1;

import java.util.LinkedList;
import java.util.List;

public class Product implements productSubject{

	private String name;
	private int quantity;
	private double price;
	private List<productObserver> clients;
	
	public Product(String name, int quantity, double price) {
		setName(name);
		setQuantity(quantity);
		setPrice(price);
		clients = new LinkedList<>();
	}

	//Set's
	public void setName(String name) {
		if(name != "" || name != null) {
			this.name = name;			
		} else {
			throw new RuntimeException("O nome não pode ser NULO!!!");
		}
	}
	
	public void setQuantity(int quantity) {
		if(quantity >= 0) {
			this.quantity = quantity;			
		}
	}
	
	public void setPrice(double price) {
		if(price >= 0.0) {
			this.price = price;			
		}
	}
	
	//Get's
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
	
	//Funções
	public boolean reduceStock(int quantity) {
		if(getQuantity() > 0) {
			setQuantity(getQuantity() - quantity); 
			System.out.println(quantity + " itens removidos");
			return true;
		}
		
		return false;
	}
	
	public void increaseStock(int quantity) {
		setQuantity(getQuantity() + quantity);
		System.out.println(quantity + " itens Adicionados");
	}

	@Override
	public void notifyAllObserver() {
		for(int i = 0; i < clients.size(); i++) {
			clients.get(i).update(this);
		}
		
	}

	@Override
	public void attach(productObserver observer) {
		//Add a new Observer in the List(clients)
		clients.add(observer);
		
	}

	@Override
	public void detach(productObserver observer) {
		//Remove one Observer in the List(clients)
		clients.remove(observer);
		
	}
}
