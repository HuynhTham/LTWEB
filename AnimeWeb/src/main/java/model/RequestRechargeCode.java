package model;

class RequestRechargeCode {
	private int id;
	private int idUser;
	private double price;
	private int status;
	public RequestRechargeCode(int id, int idUser, double price, int status) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.price = price;
		this.status = status;
	}
	public RequestRechargeCode() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "RequestRechargeCode [id=" + id + ", idUser=" + idUser + ", price=" + price + ", status=" + status + "]";
	}
	
}
