package molde.exce��o;

public class DominioExce��o extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DominioExce��o(String msg) {
		super(msg);
	} // serve para permite a hera�a de Exception

}
