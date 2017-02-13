

class Rectangle extends Shape
{
	protected Double width, length;
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public Rectangle(Double x_origin, Double y_origin, Double newlength, Double newwidth, String  name, Colour colour){
		super(x_origin, y_origin, name, colour);
		length= newlength;
		width =newwidth;
	}
	
	protected void  set_length(Double newlength){
		length = newlength;
	}
	
	protected Double  get_length() {
		return length;
	}
	
	protected Double  area(){
		return  width *length;
	}
	
	protected Double  perimeter(){
		return  width  * 2 + length * 2;
	}
	
	protected Double  volume(){
		return 0.0;
	}
	
	@Override
	public String toString(){
		String s = super.toString()+ "\nWidth: " + width + "\nLength: " + length;
		return s;
	}
	
	public void shrink(double divisor) throws SizeFactorException {
		if (divisor < LIMIT) {
			throw new SizeFactorException("Exception -- " + this.getName() 
			+ " divisor argument (" + divisor 
			+ ") less than Size Factor limit, "+ LIMIT);
		}
		this.width /= divisor;
		this.length /= divisor;
	}
	
	public void enlarge(double multiplier) throws SizeFactorException {
		if (multiplier < LIMIT) {
			throw new SizeFactorException("Exception -- " + this.getName() 
			+ " multiplier argument (" + multiplier
			+ ") lesss than Size Factor limit, " + LIMIT);
		}
		this.width *= multiplier;
		this.length *= multiplier;
	}
        	
}