/*
* RevisedHistoricalEvent.java - Adds on to HistoricalEvent to a add extra data
* to correct *historical" information.
*/
package cs112.lab09.models;

public class RevisedHistoricalEvent extends HistoricalEvent {
	// Constants
	public static final String DEFAULT_REVISED_DESCRIPTION = " Revised historical event description default";
	public static final String DEFAULT_CITATION = "Academic resource/citation";

	// Instance Variable
	public String revisedDescription, citation;

	/*
	* Full constructor sets object to parameter values if valid, *Otherwise outputs error message and exits the program.
	*
	* @param description historical event description.
	* @param eventDay Date object representing day of historical event.
	* @param revisedDescription which is revised Historical description.
	* @param citation which is formal citation or link to resource.
	*
	*/
	// Full Constructor
	public RevisedHistoricalEvent(String description, Date eventDay, String revisedDescription, String citation) { 
		 super(description, eventDay);
		 this.setRevisedDescription(revisedDescription); 
		 this.setCitation(citation); 
		 }
	
	/*
	* Default constructor sets RevisedHistoricalEvent object to default values.
	*/
	// Default Constructor
	public RevisedHistoricalEvent() {
		this(HistoricalEvent.DEFAULT_DESCRIPTION,HistoricalEvent.DEFAULT_EVENT_DAY,DEFAULT_REVISED_DESCRIPTION,DEFAULT_CITATION);
	}
	
	/*
	* Copy Constructor creates a deep copy of original HistoricalEvent *object, if
	* object null outputs error message and exits program.
	*
	* @param original valid RevisedHistoricalEvent object to deep copy
	*/
	// Copy Constructor
	public RevisedHistoricalEvent(RevisedHistoricalEvent original) {
		if (original != null) {
			this.setAll(original.getDescription(), original.getEventDay(), original.revisedDescription, original.citation);
		} else {
			System.out.println("ERROR: trying to copy NULL Date object. Exiting program...");
			System.exit(0);
		}
	}
	

	/*
	 * Sets revised description instance variable (no error checking, except for
	 * null)
	 *
	 * @Param revisedDescription which is revised Historical description
	 */
	// Setter Method
	public boolean setRevisedDescription(String revisedDescription) {
		if (revisedDescription != null) {
			this.revisedDescription = revisedDescription;
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Sets citation instance variable (no error checking, except for null)
	 *
	 * @Param citation which is formal citation or link to resource.
	 */
	public boolean setCitation(String citation) {
		if (citation != null) {
			this.citation = citation;
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Sets All instance varibles if parameters are valid
	 * 
	 * @param description historical event description.
	 * @param eventDay Date object representing day of historical event.
	 * @param revisedDescription which is revised Historical description.
	 * @param citation which is formal citation or link to resource.
	 *
	 * @return if description and eventDay are valid, false otherwise
	 */
	// SetAll Method
	public boolean setAll(String description, Date eventDay, String revisedDescription, String citation) {
		if ((super.setAll(description, eventDay))) {
			this.setRevisedDescription(revisedDescription);
			this.setCitation(citation);
			return true;
		} else {
			return false;
		}
	}
	/*
	 * Access value of revisedDescription instance variable
	 *
	 * @return description of historical event
	 */
	//GETTERS
	public String getRevisedDescription() {
		return this.revisedDescription;
	}
	/*
	 * Access value of citation instance variable
	 *
	 * @return citation value (resource link, etc.)
	 */
	public String getCitation() {
		return this.citation; 
	}

	/*
	 * // Getters Method public String getRevisdedDescription() { return
	 * this.revisedDescription; } public String getCitation() { return
	 * this.citation; }
	 */
	// toString Method
	@Override
	public String toString() {
		return super.toString() + "\nRevised Historical Event: "+ this.revisedDescription + "\n\nSource: " + this.citation;
	}
	// Equals Method
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		} else if (this.getClass() != other.getClass()) {
			return false;
		} else {
			RevisedHistoricalEvent otherEvent = (RevisedHistoricalEvent) other;
			return super.equals(other) && this.revisedDescription.equals(otherEvent.revisedDescription) && this.citation.equals(otherEvent.citation);
		}
	}
}