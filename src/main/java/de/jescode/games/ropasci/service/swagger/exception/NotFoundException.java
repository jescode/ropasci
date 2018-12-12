package de.jescode.games.ropasci.service.swagger.exception;


public class NotFoundException extends ApiException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5373708762823292357L;
	private int code;
	
    /**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
