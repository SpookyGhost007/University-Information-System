public class Professor extends Info
{
	private String researchTopics;
	/**
	 * Professor - Representation of a professor.
	 * @param rt research topic
	 */
	public Professor(String fn, int rn, String em, String rt) {
		super(fn, rn, em);
		this.researchTopics = rt;
	}
	/**
	 * @return the researchTopics
	 */
	public String getResearchTopics(){
		return researchTopics;
	}
	/**
	 * Set/change the researchTopics
	 */
	public void setResearchTopics(String rt) {
		this.researchTopics = rt;
	}
	
	public String toString() {
		return "Professor: " + fullName; 
	}
}
