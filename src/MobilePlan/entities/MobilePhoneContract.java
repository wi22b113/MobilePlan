package MobilePlan.entities;

import java.util.LinkedList;
import java.util.List;

import MobilePlan.provided.Customer;

/**
 * A MobilePhoneContract base class.<br>
 * Concrete sub types must implement the units and fee structure.
 */
public abstract class MobilePhoneContract implements Comparable<MobilePhoneContract> {

	private String carrier;
	private List<Connection> connections = new LinkedList<Connection>();
	private Customer customer;
	private String imei;

	public MobilePhoneContract(Customer customer, String imei, String carrier) {
		if (customer == null || imei == null || carrier == null){
			throw new IllegalArgumentException("Failed to create Mobile Phone Contract");
		} else {
			this.carrier = carrier;
			this.customer = customer;
			this.imei = imei;
		}
	}

	public List<Connection> outgoingConnections(){
		List<Connection> out = new LinkedList<>();
		for (Connection c : connections){
			if (c.getCaller() == this){
				out.add(c);
			}
		}
		return out;
	}

	public abstract int unitsLeft();

	public abstract float additionalFee();

	public MobilePhoneContract setImei(String imei) {
		if (imei != null || !imei.isEmpty()) {
			this.imei = imei;
		}
		return this;
	}

	public int getUsedUnits(){
		List<Connection> outgoing = outgoingConnections();
		int usedUnits = 0;
		for (Connection c : outgoing){
			usedUnits += c.getUnits();
		}
		return usedUnits;
	}

	public int compareTo(MobilePhoneContract a){
		return Integer.compare(getUsedUnits(), a.getUsedUnits());
	}

	public Customer getCustomer() {
		return customer;
	}

	public String getImei() {
		return imei;
	}

	public boolean addConnection(Connection connection){
		if(connection!=null){
			connections.add(connection);
			return true;
		}
//		if (!connections.contains(connection)){
//			connections.add(connection);
//			return true;
//		}
		return false;
	}


	/**
	 * Creates a string representation of this MobilePhoneContract.<br>
	 * 
	 * The returned string contains the values
	 * <ul>
	 * <li>customer string</li>
	 * <li>imei number</li>
	 * <li>carrier name</li>
	 * <li>used units</li>
	 * <li>units left</li>
	 * <li>additional fees to pay</li> 
	 * <li>a summary of all outgoing calls</li>
	 * </ul>
	 * 
	 * @ProgrammingProblem.Hint provided
	 * 
	 */

	@Override
	public String toString() {
		return "MobilePhoneContract [\ncarrier=" + carrier  + ", customer=" + customer
				+ ", imei=" + imei + ", usedUnits="+ getUsedUnits() + ", unitsLeft="+ unitsLeft() + ", additionalFee="+ additionalFee() +",\nconnections=" + outgoingConnections() + "\n]";
	}



}
