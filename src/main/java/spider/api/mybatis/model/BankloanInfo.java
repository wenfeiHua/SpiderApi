package spider.api.mybatis.model;

import java.util.Date;

public class BankloanInfo extends BaseModel{
    private Integer id;

    private String bankname;

    private Integer shortterm;

    private String shorttermquota;

    private Float shorttermloan;

    private Integer mediumterm;

    private String mediumtermquota;

    private Float mediumtermloan;

    private Integer longterm;

    private String longtermquota;

    private Float longtermloan;

    private Date createtime;

    private Date updatetime;

    private Boolean isdelete;

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

    public Integer getShortterm() {
        return shortterm;
    }

    public void setShortterm(Integer shortterm) {
        this.shortterm = shortterm;
    }

    public String getShorttermquota() {
        return shorttermquota;
    }

    public void setShorttermquota(String shorttermquota) {
        this.shorttermquota = shorttermquota == null ? null : shorttermquota.trim();
    }

    public Float getShorttermloan() {
        return shorttermloan;
    }

    public void setShorttermloan(Float shorttermloan) {
        this.shorttermloan = shorttermloan;
    }

    public Integer getMediumterm() {
        return mediumterm;
    }

    public void setMediumterm(Integer mediumterm) {
        this.mediumterm = mediumterm;
    }

    public String getMediumtermquota() {
        return mediumtermquota;
    }

    public void setMediumtermquota(String mediumtermquota) {
        this.mediumtermquota = mediumtermquota == null ? null : mediumtermquota.trim();
    }

    public Float getMediumtermloan() {
        return mediumtermloan;
    }

    public void setMediumtermloan(Float mediumtermloan) {
        this.mediumtermloan = mediumtermloan;
    }

    public Integer getLongterm() {
        return longterm;
    }

    public void setLongterm(Integer longterm) {
        this.longterm = longterm;
    }

    public String getLongtermquota() {
        return longtermquota;
    }

    public void setLongtermquota(String longtermquota) {
        this.longtermquota = longtermquota == null ? null : longtermquota.trim();
    }

    public Float getLongtermloan() {
        return longtermloan;
    }

    public void setLongtermloan(Float longtermloan) {
        this.longtermloan = longtermloan;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}