/**
 * Lift carrying cars moves up/down between floors.
 */

public class Lift {

	// lift has three states, at both floors and moving state
	enum State {
		GROUND, MOVING, FIRST
	}

	// lift may carry a car
	private Car car;
	private State state;

	// initial state
	public Lift() {
		this.car = null;
		this.state = State.GROUND;
	}

	// conditions to return a car for return_vehicle
	public synchronized void returnCar(Car car) throws InterruptedException {
		while (this.car != null || this.state != State.FIRST)
			wait();
		this.car = car;
	}

	// conditions to produce a car for producer
	public synchronized void produce(Car car) throws InterruptedException {
		while (this.car != null || this.state != State.GROUND)
			wait();
		this.car = car;
	}

	// conditions to launch a car for launch_vehicle
	public synchronized Car launchCar() throws InterruptedException {
		while (this.car == null || this.car.newcar == false
				|| this.state != State.FIRST)
			wait();
		Car temp = this.car;
		this.car = null;
		notifyAll();
		return temp;
	}

	// conditions to consume a car for consumer
	public synchronized Car consume() throws InterruptedException {
		while (this.car == null || this.car.newcar == true
				|| this.state != State.GROUND)
			wait();
		Car temp = this.car;
		this.car = null;
		notifyAll();
		return temp;
	}

	// get the state of lift
	public State getState() {
		return state;
	}

	// get the car of lift
	public Car getCar() {
		return car;
	}

	// change the state of lift to moving
	public synchronized void move() throws InterruptedException {
		this.state = State.MOVING;
	}

	// change the floor of lift
	public synchronized void moveTo(State state) throws InterruptedException {
		this.state = state;
		notifyAll();
	}

}
