

class Prism extends Rectangle
{
	private Double height;
	
	public Object clone() throws CloneNotSupportedException {
		return (Prism)super.clone();
	}
	
	public Prism(Double x, Double y, Double l, Double w, Double h, String  name, Colour colour)
	{
		super(x, y, l, w, name, colour);
		height = h;
	}
	
	public void  set_height(Double h)
	{
		height = h;
	}
	
	public Double  height() 
	{
		return height;
	}
	
	public Double  area()
	{
		return  2 * (length * width) + 2 * (height * length) + 2 * (height * width); 
	}
	
	public Double  perimeter()
	{
		return  width  * 2 + length * 2;
	}
	
	public Double  volume()
	{
		return  width  * length * height;
	}
	
	
	public String toString()
	{
		String s = super.toString()+ "\nheight: " + height;
		return s;
	}
	
	public void shrink(double divisor) throws SizeFactorException {
		if (divisor < LIMIT) {
			throw new SizeFactorException("Exception -- " + this.getName() 
			+ " divisor argument (" + divisor 
			+ ") less than Size Factor limit, "+ LIMIT);
		}
		super.shrink(divisor);
		set_height(this.height / divisor);
	}
	
	public void enlarge(double multiplier) throws SizeFactorException {
		if (multiplier < LIMIT) {
			throw new SizeFactorException("Exception -- " + this.getName() 
			+ " multiplier argument (" + multiplier
			+ ") less than Size Factor limit, " + LIMIT);
		}
		super.enlarge(multiplier);
		set_height(this.height * multiplier);
	}
}