public class Info {
    protected String fullName;
    protected int registrationNumber;
    protected String email;

    /**
     * General information
     * 	 * Constructor
     * 	 * @param fn Full Name
     * 	 * @param rn Registration Number
     * 	 * @param em Email
     */

    public Info(String fn, int rn, String em) {
        this.fullName = fn;
        this.registrationNumber = rn;
        this.email = em;
    }
    public String getFullName() {
        return fullName;
    }
    /**
     * Set/change the full name
     * @param fn The new full name
     */
    public void setFullName(String fn) {
        this.fullName = fn;
    }

    /**
     * @return the registration number
     */
    public int getRegistrationNumber(){
        return registrationNumber;
    }
    /**
     * Set/change the registration number
     * @param rn The new registration number
     */
    public void setRegistrationNumber(int rn) {
        this.registrationNumber = rn;
    }

    /**
     * @return the email
     */
    public String getEmail(){
        return email;
    }
    /**
     * Set/change the email
     * @param em The new email
     */
    public void setEmail(String em) {
        this.email = em;
    }

}
