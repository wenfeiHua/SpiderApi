package spider.api.mybatis.model;

public class BankInfo extends BaseModel{
    private Integer id;

    private String bankname;

    private String bankurl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname == null ? null : bankname.trim();
    }

    public String getBankurl() {
        return bankurl;
    }

    public void setBankurl(String bankurl) {
        this.bankurl = bankurl == null ? null : bankurl.trim();
    }
}