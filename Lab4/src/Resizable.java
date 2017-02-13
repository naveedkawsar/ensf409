/**
 * @author Naveed Kawsar
 *
 */
public interface Resizable {
	final static double LIMIT = 1.0;

	public void shrink(double divisor) throws SizeFactorException;
	public void enlarge(double Multiplier) throws SizeFactorException;
}
