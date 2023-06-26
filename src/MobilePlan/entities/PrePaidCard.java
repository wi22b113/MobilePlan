package MobilePlan.entities;

import MobilePlan.provided.Customer;

public class PrePaidCard extends MobilePhoneContract{

    private float preloadedAmount = 0;

    public PrePaidCard(Customer customer, String imei, String carrier, float preloadedAmount){
        super (customer,imei,carrier);
        setPreloadedAmount(preloadedAmount);
//        if (preloadedAmount > 0){
//            this.preloadedAmount = preloadedAmount;
//        }
    }

    public PrePaidCard(Customer customer, String imei, String carrier){
        super(customer,imei,carrier);
    }

    public void setPreloadedAmount(float preloadedAmount) {
        if (preloadedAmount > 0) {
            this.preloadedAmount = preloadedAmount;
        }
    }



    @Override
    public int unitsLeft() {
        int unitsLeft = (int) (preloadedAmount / 0.4) - getUsedUnits();
        if (unitsLeft >= 0){
            return unitsLeft;
        }else return 0;
    }

    @Override
    public float additionalFee() {
        if (unitsLeft() > 0){
            return 0;
        }else return getUsedUnits()*0.4F;
    }

    public void topUp(float additionalAmount){
        if (additionalAmount%5 == 0){
            preloadedAmount += additionalAmount;
        }
    }

}
