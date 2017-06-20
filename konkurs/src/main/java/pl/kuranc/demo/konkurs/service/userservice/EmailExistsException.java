package pl.kuranc.demo.konkurs.service.userservice;


public class EmailExistsException extends Exception{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -1169268815828144924L;


	public EmailExistsException(String message){
		super(message);
	}

}
