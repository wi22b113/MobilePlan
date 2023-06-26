package MobilePlan.util;

import MobilePlan.entities.MobilePhoneContract;
import MobilePlan.provided.Matcher;

public class MobilePhoneContractHomeAddressMatcher implements Matcher<MobilePhoneContract> {

    private String pattern;

    public MobilePhoneContractHomeAddressMatcher(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean matches(MobilePhoneContract t) {
        if (t.getCustomer().getHome().getState() == pattern || t.getCustomer().getHome().getCity() == pattern){
            return true;
        }else
            return false;
    }
}
