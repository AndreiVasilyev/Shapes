package by.epam.jwdshape.observer;

public interface ConeObservable {

	public void attach(ConeObserver observer);

	public void detach();

	public void notifyObservers();

}
