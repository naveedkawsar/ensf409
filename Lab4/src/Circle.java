

class Circle extends Shape
{
	private Double radius;
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	Circle(Double x_origin, Double y_origin, Double newradius,  String name, Colour colour){
		super(x_origin, y_origin, name, colour);
		radius = newradius;
	}
	
	public void set_radius(Double newradius){
		radius = newradius;
	}
	
	public Double get_radius() {
		return radius;
	}
	
	public Double area() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public Double perimeter() {
		return 2 * Math.PI * radius;
	}
	
	public Double  volume(){
		return 0.0;
	}
	
	
	public String toString(){
		String s = super.toString()+ "\nRadius: " + radius;
		return s;
	}
	
	public void shrink(double divisor) throws SizeFactorException {
		if (divisor < LIMIT) {
			throw new SizeFactorException("Exception -- " + this.getName() 
			+ " divisor argument (" + divisor 
			+ ") less than Size Factor limit, "+ LIMIT);
		}
		set_radius(this.radius / divisor);
	}
	
	public void enlarge(double multiplier) throws SizeFactorException {
		if (multiplier < LIMIT) {
			throw new SizeFactorException("Exception -- " + this.getName() 
			+ " multiplier argument (" + multiplier
			+ ") less than Size Factor limit, " + LIMIT);
		}
		set_radius(this.radius * multiplier);
	}
         
}