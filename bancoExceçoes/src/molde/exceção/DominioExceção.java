package molde.exceção;

public class DominioExceção extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DominioExceção(String msg) {
		super(msg);
	} // serve para permite a heraça de Exception

}
