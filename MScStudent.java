import java.util.ArrayList;

public class MScStudent extends Student
{

    private String researchTitle;
    private Professor supervisor;

    /**
     * MScStudent - Representation of an MSc Student.
     * @param research research title
     * @param superv Student's supervisor
     */
    public MScStudent(String fn, int rn, String em, String research, Professor superv) {
        super(fn, rn, em, null, false);
        this.researchTitle = research;
        this.supervisor = superv;
    }

    /**
     * @return Student's supervisor
     */
    public Professor getSupervisor() {
        return supervisor;
    }

    /**
     * @return the research title
     */
    public String getResearchTitle() {
        return researchTitle;
    }

    /**
     * Set/change the research title
     */
    public void setResearchTitle(String researchTitle) {
        this.researchTitle = researchTitle;
    }

    /**
     * Set/change Student's supervisor
     */
    public void setSupervisor(Professor supervisor) {
        this.supervisor = supervisor;
    }

    public String toString() {
        return "MSc Student: " + fullName + ", Registration Number: " + registrationNumber + ", Email: " + email + ", Research Title: " + researchTitle + ", Supervisor: " + supervisor;
    }
}