package com.example.smartcity.bean;

import java.util.List;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.bean
 * @ClassName: CityBean
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/4/1 15:29
 */
public class CityBean {

    /**
     * provinceCode : 110000
     * provinceName : 北京市
     * mallCityList : [{"cityCode":"110100","cityName":"北京市","mallAreaList":[{"areaCode":"110101","areaName":"东城区"},{"areaCode":"110102","areaName":"西城区"},{"areaCode":"110105","areaName":"朝阳区"},{"areaCode":"110106","areaName":"丰台区"},{"areaCode":"110107","areaName":"石景山区"},{"areaCode":"110108","areaName":"海淀区"},{"areaCode":"110109","areaName":"门头沟区"},{"areaCode":"110111","areaName":"房山区"},{"areaCode":"110112","areaName":"通州区"},{"areaCode":"110113","areaName":"顺义区"},{"areaCode":"110114","areaName":"昌平区"},{"areaCode":"110115","areaName":"大兴区"},{"areaCode":"110116","areaName":"怀柔区"},{"areaCode":"110117","areaName":"平谷区"}]},{"cityCode":"110200","cityName":"北京市辖县","mallAreaList":[{"areaCode":"110228","areaName":"密云县"},{"areaCode":"110229","areaName":"延庆县"}]}]
     */

    private String provinceCode;
    private String provinceName;
    private List<MallCityListDTO> mallCityList;

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public List<MallCityListDTO> getMallCityList() {
        return mallCityList;
    }

    public void setMallCityList(List<MallCityListDTO> mallCityList) {
        this.mallCityList = mallCityList;
    }

    public static class MallCityListDTO {
        /**
         * cityCode : 110100
         * cityName : 北京市
         * mallAreaList : [{"areaCode":"110101","areaName":"东城区"},{"areaCode":"110102","areaName":"西城区"},{"areaCode":"110105","areaName":"朝阳区"},{"areaCode":"110106","areaName":"丰台区"},{"areaCode":"110107","areaName":"石景山区"},{"areaCode":"110108","areaName":"海淀区"},{"areaCode":"110109","areaName":"门头沟区"},{"areaCode":"110111","areaName":"房山区"},{"areaCode":"110112","areaName":"通州区"},{"areaCode":"110113","areaName":"顺义区"},{"areaCode":"110114","areaName":"昌平区"},{"areaCode":"110115","areaName":"大兴区"},{"areaCode":"110116","areaName":"怀柔区"},{"areaCode":"110117","areaName":"平谷区"}]
         */

        private String cityCode;
        private String cityName;
        private List<MallAreaListDTO> mallAreaList;

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public List<MallAreaListDTO> getMallAreaList() {
            return mallAreaList;
        }

        public void setMallAreaList(List<MallAreaListDTO> mallAreaList) {
            this.mallAreaList = mallAreaList;
        }

        public static class MallAreaListDTO {
            /**
             * areaCode : 110101
             * areaName : 东城区
             */

            private String areaCode;
            private String areaName;

            public String getAreaCode() {
                return areaCode;
            }

            public void setAreaCode(String areaCode) {
                this.areaCode = areaCode;
            }

            public String getAreaName() {
                return areaName;
            }

            public void setAreaName(String areaName) {
                this.areaName = areaName;
            }
        }
    }
}
