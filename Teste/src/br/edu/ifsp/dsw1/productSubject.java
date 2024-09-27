package br.edu.ifsp.dsw1;

public interface productSubject {
	
	public void notifyAllObserver();
	public void attach(productObserver observer);
	public void detach(productObserver observer);
	
}
