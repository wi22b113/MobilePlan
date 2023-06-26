package MobilePlan.entities;

import MobilePlan.provided.ConnectionType;
import MobilePlan.provided.DateTime;

/**
 * 
 * A connection, aka a call between two contracts. A "phone call".<br>
 * 
 */
public class Connection {

    private MobilePhoneContract callee;
    private MobilePhoneContract caller;
    private DateTime dateTime;
    private ConnectionType type;
    private int units;

    public Connection(MobilePhoneContract caller, MobilePhoneContract callee, ConnectionType type, DateTime dt, int units){
        if(caller == null || callee == null|| (type != ConnectionType.PREMIUM && type != ConnectionType.STANDARD && type != ConnectionType.TEXT) || dt == null || units < 1){
            throw new IllegalArgumentException("No Connection established");
        } else {
            this.caller = caller;
            this.callee = callee;
            this.type = type;
            this.dateTime = dt;
            this.units = units;
        }
    }

    public int getUnits() {
        return units;
    }

    public MobilePhoneContract getCaller() {
        return caller;
    }

    public MobilePhoneContract getCallee() {
        return callee;
    }

    /**
     *  Creates a string representation of this connection.<br>
     */
    @Override
    public String toString() {
        return "\nConnection [caller=" + caller.getImei() + ", callee=" + callee.getImei() + ", type=" + type
                + ", units=" + units + ", DateTime=" + dateTime + "]";
    }

}
