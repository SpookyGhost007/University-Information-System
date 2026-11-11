import java.util.ArrayList;

/**
 * Student - Representation of a student.
 */

public class Student extends Info
{
	protected static int MAX_NUM_MODULES = 5; // maximum number of modules that a student can enroll

	protected int numberModules; // number of modules currently enrolled
	protected ArrayList<Module> enrolledModules;
	protected boolean isARUAA;

	/**
	 * @param mods Enrolled Modules
	 * @param isARUAA ARUAA student or not
	 */
	public Student(String fn, int rn, String em, ArrayList<Module> mods, boolean isARUAA) {
		super(fn, rn, em);
		this.numberModules = 0;
		this.enrolledModules = mods;
		this.isARUAA = isARUAA;
	}

	/**
	 * @return the Number of Modules
	 */
	public int getNumberModule() {
		return this.numberModules;
	}

	/**
	 * @return enrolled Modules
	 */
	public ArrayList<Module> getenrolledModules() {
		return this.enrolledModules;
	}

	/**
	 * @return whether a student is ARUAA or not
	 */
	public boolean getIsARUAA() {
		return this.isARUAA;
	}

	/**
	 * @param mod - Module to add to this student
	 * @return true if the module was added successfully
	 */
	public boolean addModule(Module mod) {
		if (this.numberModules < MAX_NUM_MODULES && !this.enrolledModules.contains(mod)) { //ensures that the MAX number of modules won't be exceeded and restrains from adding the same module twice
			this.numberModules = (this.numberModules + 1);
			this.getenrolledModules().add(mod);
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * @return true if the module was removed successfully
	 */
	public boolean removeModule(Module mod) {
		if (this.numberModules != 0) {  //ensures that there are modules to be removed
			this.numberModules = (this.numberModules - 1); // decrease total number of modules by 1
			this.getenrolledModules().remove(mod); // remove from the ArrayList
			return true;
		}
		else {
			return false;
		}
	}


	public String toString() {
		return "Student: " + fullName;
	}
}
