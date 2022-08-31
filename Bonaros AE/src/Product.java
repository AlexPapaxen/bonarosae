import java.util.ArrayList;

public class Product {
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDaystoexpire() {
		return daystoexpire;
	}

	public void setDaystoexpire(String daystoexpire) {
		this.daystoexpire = daystoexpire;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public String getSerialnumber() {
		return serialnumber;
	}

	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}

	public String getTarePercentage() {
		return tarePercentage;
	}

	public void setTarePercentage(String tarePercentage) {
		this.tarePercentage = tarePercentage;
	}

	public String getSmallItemWeight() {
		return smallItemWeight;
	}

	public void setSmallItemWeight(String smallItemWeight) {
		this.smallItemWeight = smallItemWeight;
	}

	public int getPiecesperbox() {
		return piecesperbox;
	}

	public void setPiecesperbox(int piecesperbox) {
		this.piecesperbox = piecesperbox;
	}

	public int getBoxesperpallete() {
		return boxesperpallete;
	}

	public void setBoxesperpallete(int boxesperpallete) {
		this.boxesperpallete = boxesperpallete;
	}

	public String getLabelpiece() {
		return labelpiece;
	}

	public void setLabelpiece(String labelpiece) {
		this.labelpiece = labelpiece;
	}

	public String getLabelbox() {
		return labelbox;
	}

	public void setLabelbox(String labelbox) {
		this.labelbox = labelbox;
	}

	public String getLabelpallete() {
		return labelpallete;
	}

	public void setLabelpallete(String labelpallete) {
		this.labelpallete = labelpallete;
	}

	public String getUnderWeight() {
		return underWeight;
	}

	public void setUnderWeight(String underWeight) {
		this.underWeight = underWeight;
	}

	public String getOverWeight() {
		return overWeight;
	}

	public void setOverWeight(String overWeight) {
		this.overWeight = overWeight;
	}

	public ArrayList<String> getTextsArray() {
		return textsArray;
	}

	public void setTextsArray(ArrayList<String> textsArray) {
		this.textsArray = textsArray;
	}

	private String code;
	private String barcode;
	private String description;
	private String price;
	private String daystoexpire;
	private String lot;
	private String serialnumber;
	private String tarePercentage;
	private String smallItemWeight;
	private int piecesperbox;
	private int boxesperpallete;
	private String labelpiece;
	private String labelbox;
	private String labelpallete;
	private String underWeight;
	private String overWeight;
	private ArrayList<String> textsArray = new ArrayList<>();
	
	public Product(String code,String barcode,String description,String price
	,String daystoexpire,String lot,String serialnumber,String tarePercentage,String smallItemWeight,
	int piecesperbox,int boxesperpallete,String labelpiece,String labelBox, String labelpallete,
	String underWeight,String overWeight,ArrayList<String> textsArray) {
		
		this.code = code;
		this.barcode = barcode;
		this.description = description;
		this.price = price;
		this.daystoexpire = daystoexpire;
		this.lot = lot;
		this.serialnumber = serialnumber;
		this.tarePercentage = tarePercentage;
		this.smallItemWeight = smallItemWeight;
		this.piecesperbox = piecesperbox;
		this.labelpiece = labelpiece;
		this.labelpallete = labelpallete;
		this.underWeight = underWeight;
		this.overWeight = overWeight;
		this.textsArray = textsArray;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
