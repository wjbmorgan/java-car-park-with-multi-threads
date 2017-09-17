/**
 * Operator inspects the lift at random intervals and, once the lift is
 * unoccupied, changes it¡¯s level.
 */

public class Operator extends Thread {

	// operator will try to move the lift
	Lift lift;

	public Operator(Lift lift) {
		this.lift = lift;
	}

	public void run() {
		try {
			while (true) {
				// inspect the lift at random time, if the lift is unoccupied,
				// change the level
				Thread.sleep(Param.operateLapse());
				if (lift.getCar() == null) {
					if (lift.getState() == Lift.State.GROUND) {
						lift.move();
						System.out.println("lift goes up");
						Thread.sleep(Param.OPERATE_TIME);
						lift.moveTo(Lift.State.FIRST);
					} else if (lift.getState() == Lift.State.FIRST) {
						lift.move();
						System.out.println("lift goes down");
						Thread.sleep(Param.OPERATE_TIME);
						lift.moveTo(Lift.State.GROUND);
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
