/*
 * @author
 * 
 * Class that creates a part object to use the parts stored
 * in parts.txt
 */
public class Part {
	private String partNum;
	private String descirption;
	private double price;
	private String warehouseID;
	private int quantity;
	
	
	public Part(String partNum, String descirption, double price, String warehouseID, int quantity) {
		super();
		this.partNum = partNum;
		this.descirption = descirption;
		this.price = price;
		this.warehouseID = warehouseID;
		this.quantity = quantity;
	}

	

	public Part(String partNum) {
		super();
		this.partNum = partNum;
	}



	public String getPartNum() {
		return partNum;
	}


	public String getDescirption() {
		return descirption;
	}


	public double getPrice() {
		return price;
	}


	public String getWarehouseID() {
		return warehouseID;
	}


	public int getQuantity() {
		return quantity;
	}



	@Override
	public boolean equals(Object arg) {
		// TODO Auto-generated method stub
		return this.partNum.equals( ((Part)arg).partNum );
	}
	
	

	
}
