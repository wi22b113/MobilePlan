package MobilePlan.entities;

import MobilePlan.provided.Customer;

public class MonthlyContract extends MobilePhoneContract {

    private int	includedUnits = 0;

    public MonthlyContract(Customer customer, String imei, String carrier, int includedUnits){
        super(customer,imei,carrier);
        setIncludedUnits(includedUnits);
//        if (includedUnits > 0){
//            this.includedUnits = includedUnits;
//        }
    }

    public void setIncludedUnits(int includedUnits) {
        if (includedUnits > 0) {
            this.includedUnits = includedUnits;
        }
    }
    @Override
    public int unitsLeft(){
        int unitsLeft = includedUnits - getUsedUnits();
        if (unitsLeft >= 0){
            return  unitsLeft;
        } else return 0;
    }

    @Override
    public float additionalFee() {

        if (unitsLeft() == 0){
           int aboveincluded = getUsedUnits()-includedUnits;
           return aboveincluded*0.2f;
           }
        return 0;
        }

}
