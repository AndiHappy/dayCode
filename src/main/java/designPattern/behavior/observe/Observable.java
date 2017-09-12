package designPattern.behavior.observe;

import java.util.ArrayList;
import java.util.List;

public class Observable{
	int state = 0;
	int additionalState = 0;
	List<Object> observers = new ArrayList<Object>();
	public void updateState(int increment)
	{
		state = state + increment;
		notifyObservers();
	}
	private void notifyObservers() {
		for (Object object : observers) {
			object.notify();
		}
	}
}

class ConcreteObservable extends Observable{
	public void updateState(int increment){
		super.updateState(increment); // the observers are notified
		additionalState = additionalState + increment; // the state is changed after the notifiers are updated
	}
}