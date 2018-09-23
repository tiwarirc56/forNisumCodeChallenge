package domain;

public class Limit implements Comparable<Limit>{

	private Integer lowerLimit;
	private Integer upperLimit;
	
	public Limit() {
		// TODO Auto-generated constructor stub
	}

	public Limit(Integer lowerLimit, Integer upperLimit) {
		super();
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
	}

	public Integer getLowerLimit() {
		return lowerLimit;
	}

	public void setLowerLimit(Integer lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	public Integer getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(Integer upperLimit) {
		this.upperLimit = upperLimit;
	}

	@Override
	public int compareTo(Limit o) {
		return this.lowerLimit.compareTo(o.lowerLimit);
	}
}