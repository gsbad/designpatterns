package decorator.starbuzzWithSizes;

//abstract decorator
public abstract class CondimentDecorator extends Beverage {
	public Beverage beverage;

	//abstract method
	public abstract String getDescription();
	
	public Size getSize() {
		return beverage.getSize();
	}
}
