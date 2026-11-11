
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *  University maintains an ArrayList called cohorts that stores the list of classes of the university.
 *  Your task is to correctly implement the method bodies for:
 * 
 *  protected ArrayList<Cohort> quickSort(ArrayList<Cohort> list, boolean ascending, String attr)
 *	protected boolean checkForCycles(Graph rel, Module node, Map<Module, Boolean> visited, Map<Module, Boolean> beingVisited)
 *  
 *  The above methods are called via public methods of the same name which supply 
 *  the local modules object as a parameter. You can observe calls to these public
 *  methods in the go methods of UniversityTest.java.  
 */
public class University {
	private ArrayList<Cohort> cohorts;
	private Graph graph;

	public University() {
		cohorts = new ArrayList<Cohort>();
		graph = new Graph();
	}

	public void clear() {
		for (Cohort v : cohorts) {
			v.getBtree().clear();
		}
		cohorts.clear();
		graph = new Graph();
	}

	public void addClass(Cohort v) {
		cohorts.add(v);
		if (!v.getModule().getPrerequisites().isEmpty()) {
			for (Module m : v.getModule().getPrerequisites()) {
				graph.insertEdge(v.getModule(), m);
			}
		} else {
			graph.insertNode(v.getModule());
		}
	}

	public ArrayList<Cohort> getCohort() {
		return cohorts;
	}

	public Graph getGraph() {
		return graph;
	}

	public void describeModuleList() {
		for (Cohort v : cohorts) {
			System.out.println(v.toString());
			v.describeStudentTree();
		}
	}

	/**
	 * This method calls the tree walk method for a specific cohort
	 *
	 * @param val The index of the cohort that you want to call the method for
	 * @return A String with the names of all Students in the tree
	 */
	public String walkTree(int val) {
		return cohorts.get(val).walkTree();
	}

	/**
	 * This method calls the find method for a specific cohort
	 *
	 * @param val The index of the cohort that you want to call the method for
	 * @return A reference to the Student that was found or null if no Student found
	 */
	public Student find(int val, String name) {
		return cohorts.get(val).find(name);
	}

	/**
	 * This method calls the protected checkForCycle to find for cycles in the graph.
	 * <p>
	 * You should not modify this code.
	 */
	public boolean checkForCycles() {
		Map<Module, Boolean> visited = new HashMap<Module, Boolean>();
		Map<Module, Boolean> beingVisited = new HashMap<Module, Boolean>();
		for (Module m : graph.getVertices()) {
			if (checkForCycles(this.graph, m, visited, beingVisited)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method should find cycles in directed graphs.
	 *
	 * @param graph        The graph
	 * @param node         the current node
	 * @param visited      List of visited nodes
	 * @param beingVisited List of nodes being visited
	 * @return true, if there is a cycle, false otherwise
	 */
	protected boolean checkForCycles(Graph graph, Module node, Map<Module, Boolean> visited, Map<Module, Boolean> beingVisited) {
		visited.put(node, true); //add the starting node to the visited array list

		// go through its children and check if they are already present in visited array list
		for (int i = 1; i < node.getPrerequisites().size(); i++) {
			if (visited.containsKey(node.getPrerequisites().get(i))){
				return true;
			}
			// if not, visit the next children's children
			else{
				checkForCycles(graph, node.getPrerequisites().get(i), visited, beingVisited);
			}
		}
		return false; // if same nodes haven't been found
	}

	/**
	 * This method should use quick sort approach to rearrange
	 * the references in the ArrayList 'modules' such that they are in
	 * order according to the attr (attribute) parameter.
	 * If asc is true, this should be ascending order,
	 * if asc is false, this should be descending order.
	 * <p>
	 * You should not modify this code.
	 *
	 * @param asc  True if the list should be ascending order, false for descending
	 * @param attr Attribute (name or code) that will be use during the sorting
	 * @return The ArrayList 'modules' that has been sorted using insertion sort
	 */
	public ArrayList<Cohort> quickSort(boolean asc, String attr) {
		ArrayList<Cohort> sorted = new ArrayList<Cohort>(cohorts); // copy of the list
		return quickSort(sorted, 0, cohorts.size() - 1, asc, attr);
	}

	/**
	 * Method to swap elements
	 * @param list  ArrayList to sort
	 * @param i element you want to swap
	 * @param j element you want to swap
	 */
	private static void swap(ArrayList<Cohort> list, int i, int j) {
		Cohort temp = list.get(j);
		list.set(j, list.get(i));
		list.set(i, temp);
	}

	/**
	 * Method to rearrange content of the array into elements that are < pivot and element > pivot
	 * @param list The arraylist to be sorted
	 * @param low  First index
	 * @param high Last index
	 * @param asc  True if the list should be ascending order, false for descending
	 * @param attr Attribute (name or code) that will be use during the sorting
	 * @return The ArrayList 'modules' that has been sorted using insertion sort
	 */
	private int partition(ArrayList<Cohort> list, int low, int high, boolean asc, String attr) {
		// assume pivot is at the end
		int pivotCode = list.get(high).getModule().getCode(); //get pivotCode
		String pivotName = list.get(high).getModule().getName(); // get pivotName
		int i = (low - 1);
			for (int j = low; j <= high; j++) {
				if (attr == "code") {
					// swap if current value is smaller than pivot
					if (list.get(j).getModule().getCode() < pivotCode) {
						i++;
						swap(list, i, j); // move it to the “less than” part
					}

				}
				// if we are sorting by name
				else {
					// swap if compareTo value is less than 0
					if (list.get(j).getModule().getName().compareTo(pivotName) < 0) {
						i++;
						swap(list, i, j);
					}
				}
			}
			//move the pivot between “less than” and “more than” parts
		swap(list, i + 1, high);
		return (i + 1);
	}

	/**
	 * This method should use quick sort approach to rearrange
	 * the references in the ArrayList 'modules' such that they are in
	 * order according to the attr (attribute) parameter.
	 * If asc is true, this should be ascending order,
	 * if asc is false, this should be descending order.
	 *
	 * @param list The arraylist to be sorted
	 * @param low  First index
	 * @param high Last index
	 * @param asc  True if the list should be ascending order, false for descending
	 * @param attr Attribute (name or code) that will be use during the sorting
	 * @return The ArrayList 'modules' that has been sorted using insertion sort
	 */
	protected ArrayList<Cohort> quickSort(ArrayList<Cohort> list, int low, int high, boolean asc, String attr) {
		if (low < high) {        // only bother if elements to sort
			int p = partition(list, low, high, asc, attr);
			quickSort(list, low, p - 1, asc, attr); // sorts elements < pivot
			quickSort(list, p + 1, high, asc, attr); // sorts elements > pivot
			// descending order
			if (asc == false) {
				ArrayList<Cohort> reverse = new ArrayList<Cohort>();  //initiate a new ArrayList

				// go through the ascended list and add then from last to first to the new list
				for (int i = list.size() - 1; i >= 0; i--) {
					reverse.add(list.get(i));
				}
				return reverse;
			}
		}
		return list;
	}
}
