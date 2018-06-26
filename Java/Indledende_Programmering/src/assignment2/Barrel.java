package assignment2;

// s144063 Magnus Soeborg-Madsen 
// s144107 Roar Nind Steffensen

public class Barrel {

	// Fields, allowing access to values from all methods within in the class.
	private double capacity, content = 0;

	// ####################################################
	// # CONSTRUCTORS
	// ####################################################
	//
	// Default constructor, giving the default capacity.
	public Barrel() {
		capacity = 100;
	}

	// Specified constructor setting requested capacity 
		//if within allowed range [20,150]
	public Barrel(double capacity) {
		if (capacity >= 20 && capacity <= 150)
			this.capacity = capacity;
		else
			this.capacity = 150;
	}

	// ####################################################
	// # METHODS
	// ####################################################
	//
	//Adding requested amount of units to content, if possible.
		//The returned boolean states if the filling succeeded.
	public boolean fillIn(double quantity) {
		if (this.content + quantity <= this.capacity) {
			content += quantity;
			return true;
		} else {
			return false;
		}
	}

	//Removing requested amount of units from content, if possible.
		//The returned boolean states if the removal succeeded.
	public boolean remove(double quantity) {
		if (this.content - quantity >= 0) {
			content -= quantity;
			return true;
		} else {
			return false;
		}

	}
	
	//Sets content to zero. This is always possible.
		//Boolean return is therefore redundant.
	public void drain() {
		this.content = 0;
	}

	//Checks if exchange between this barrel and the target barrel is possible.
		//The returned boolean states if the exchange succeeded.
	public boolean exchange(Barrel barrel) {

		if (barrel.getContent() <= this.capacity && this.content <= barrel.getCapacity()) {

			//When exchanging two values, a temporary storage unit is needed
			double temp = this.content;
			content = barrel.getContent();
			barrel.drain();
			barrel.fillIn(temp);

			return true;

		} else {

			return false;

		}
	}

	//GETTERS AND SETTERS
	public double getCapacity() {
		return this.capacity;
	}

	public double getContent() {
		return this.content;
	}

}
