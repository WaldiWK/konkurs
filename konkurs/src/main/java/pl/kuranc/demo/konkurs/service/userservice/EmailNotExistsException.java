package pl.kuranc.demo.konkurs.service.userservice;


public class EmailNotExistsException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6665994345847311597L;

	public EmailNotExistsException(String message) {
		super(message);
	}
}
