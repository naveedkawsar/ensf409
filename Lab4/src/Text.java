
class Text implements Cloneable
{
	
	private final Double DEFAULT_SIZE = 10.0;
	
    private Colour colour;
    private Double fontSize;
    
    private String text;


	public Text(String text) {
       this.text = text;
       fontSize = DEFAULT_SIZE;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public Double getFontSize(){
		return fontSize;
	}
	
	public void setColour(String s){
		colour = new Colour(s);
	}
	
	public void setText(String newText){
		text = newText;
	}
	
	public String getText(){
		return text ;
	}
	
	@Override
	public String toString(){
		return (text);
	}
	
	public void shrink(double divisor) throws SizeFactorException {
		/* Note that class Text does not implement interface Resizable */
		if (divisor < Resizable.LIMIT) {
			throw new SizeFactorException("Exception -- " + this.toString() 
			+ " divisor argument (" + divisor 
			+ ") less than Size Factor limit, "+ Resizable.LIMIT);
		}
		this.fontSize /= divisor;
	}
	
	public void enlarge(double multiplier) throws SizeFactorException {
		/* Note that class Text does not implement interface Resizable */
		if (multiplier < Resizable.LIMIT) {
			throw new SizeFactorException("Exception -- " + this.toString() 
			+ " multiplier argument (" + multiplier
			+ ") less than Size Factor limit, " + Resizable.LIMIT);
		}
		this.fontSize *= multiplier;
	}

       
}
