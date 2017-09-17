/**
 * Producer generates new cars that want to enter, hands them to the lift.
 */

public class Producer extends Thread {

	// producer will try to put new cars to the lift
	Lift lift;

	public Producer(Lift lift) {
		this.lift = lift;
	}

	public void run() {
		try {
			while (true) {
				// produce a new car at random time and put it into the lift
				lift.produce(Car.getNewCar());
				System.out.println(lift.getCar() + "enters lift to go up");
				// move the lift
				lift.move();
				Thread.sleep(Param.OPERATE_TIME);
				lift.moveTo(Lift.State.FIRST);
				Thread.sleep(Param.TOWING_TIME);
				Thread.sleep(Param.arrivalLapse());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
