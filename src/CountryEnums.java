/**
 * Created by sww_6 on 2019/5/26.
 */
public enum CountryEnums {
    ONE(1, "韩"), TWO(2, "魏"), THREE(3, "赵"), FOUR(4, "齐"), FIVE(5, "楚"), SIX(6, "燕"),;

    private Integer recode;
    private String retMessage;

    CountryEnums(Integer recode, String retMessage) {
        this.recode = recode;
        this.retMessage = retMessage;
    }

    public Integer getRecode() {
        return recode;
    }

    public void setRecode(Integer recode) {
        this.recode = recode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }

    public static CountryEnums foreachCountryEnums(Integer index) {
        for (CountryEnums element : values()) {
            if (element.getRecode() == index) {
                return element;
            }
        }
        return null;
    }
}
