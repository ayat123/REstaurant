package com.example.reeva.restaurant.model;

/**
 * Created by Reeva on 10/10/2015.
 */
public class CustCuisineListPojo {
    private String cusineid,cusinename,cusineimage;

    public String getCusineid() {
        return cusineid;
    }

    public void setCusineid(String cusineid) {
        this.cusineid = cusineid;
    }

    public String getCusinename() {
        return cusinename;
    }

    public void setCusinename(String cusinename) {
        this.cusinename = cusinename;
    }

    public String getCusineimage() {
        return cusineimage;
    }

    public void setCusineimage(String cusineimage) {
        this.cusineimage = cusineimage;
    }

    public CustCuisineListPojo(String cusineid, String cusinename, String cusineimage) {
        this.cusineid = cusineid;
        this.cusinename = cusinename;

        this.cusineimage = cusineimage;
    }
}
