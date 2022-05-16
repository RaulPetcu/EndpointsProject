package com.example.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Complaint {
    private String cmplnt_num;
    private String cmplnt_fr_dt;
    private String cmplnt_fr_tm;
    private String cmplnt_to_dt;
    private String cmplnt_to_tm;
    private String addr_pct_cd;
    private String rpt_dt;
    private String ky_cd;
    private String ofns_desc;
    private String pd_cd;
    private String pd_desc;
    private String crm_atpt_cptd_cd;
    private String law_cat_cd;
    private String boro_nm;
    private String loc_of_occur_desc;
    private String prem_typ_desc;
    private String juris_desc;
    private String jurisdiction_code;
    private String parks_nm;
    private String hadevelopt;
    private String housing_psa;
    private String x_coord_cd;
    private String y_coord_cd;
    private String susp_age_group;
    private String susp_race;
    private String susp_sex;
    private String transit_district;
    private String latitude;
    private String longitude;
    private String lat_lon;
    private String patrol_boro;
    private String station_name;
    private String vic_age_group;
    private String vic_race;
    private String vic_sex;

    public Complaint(String cmplnt_num, String cmplnt_fr_dt, String cmplnt_fr_tm, String cmplnt_to_dt, String cmplnt_to_tm, String addr_pct_cd, String rpt_dt, String ky_cd, String ofns_desc, String pd_cd, String pd_desc, String crm_atpt_cptd_cd, String law_cat_cd, String boro_nm, String loc_of_occur_desc, String prem_typ_desc, String juris_desc, String jurisdiction_code, String parks_nm, String hadevelopt, String housing_psa, String x_coord_cd, String y_coord_cd, String susp_age_group, String susp_race, String susp_sex, String transit_district, String latitude, String longitude, String lat_lon, String patrol_boro, String station_name, String vic_age_group, String vic_race, String vic_sex) {
        this.cmplnt_num = cmplnt_num;
        this.cmplnt_fr_dt = cmplnt_fr_dt;
        this.cmplnt_fr_tm = cmplnt_fr_tm;
        this.cmplnt_to_dt = cmplnt_to_dt;
        this.cmplnt_to_tm = cmplnt_to_tm;
        this.addr_pct_cd = addr_pct_cd;
        this.rpt_dt = rpt_dt;
        this.ky_cd = ky_cd;
        this.ofns_desc = ofns_desc;
        this.pd_cd = pd_cd;
        this.pd_desc = pd_desc;
        this.crm_atpt_cptd_cd = crm_atpt_cptd_cd;
        this.law_cat_cd = law_cat_cd;
        this.boro_nm = boro_nm;
        this.loc_of_occur_desc = loc_of_occur_desc;
        this.prem_typ_desc = prem_typ_desc;
        this.juris_desc = juris_desc;
        this.jurisdiction_code = jurisdiction_code;
        this.parks_nm = parks_nm;
        this.hadevelopt = hadevelopt;
        this.housing_psa = housing_psa;
        this.x_coord_cd = x_coord_cd;
        this.y_coord_cd = y_coord_cd;
        this.susp_age_group = susp_age_group;
        this.susp_race = susp_race;
        this.susp_sex = susp_sex;
        this.transit_district = transit_district;
        this.latitude = latitude;
        this.longitude = longitude;
        this.lat_lon = lat_lon;
        this.patrol_boro = patrol_boro;
        this.station_name = station_name;
        this.vic_age_group = vic_age_group;
        this.vic_race = vic_race;
        this.vic_sex = vic_sex;
    }
}
