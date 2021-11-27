package by.epam.jwdshape.observer;

public interface ConeObservable {

	void attach(ConeObserver observer);

	void detach();

	void notifyObservers();

}
