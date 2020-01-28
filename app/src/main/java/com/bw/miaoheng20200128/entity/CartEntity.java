package com.bw.miaoheng20200128.entity;

import java.util.List;


public class CartEntity {

    /**
     * result : [{"categoryName":"美妆护肤","shoppingCartList":[{"commodityId":5,"commodityName":"双头两用修容笔","count":3,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg","price":39},{"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","count":4,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/4/1.jpg","price":39},{"commodityId":10,"commodityName":"BYPHASSE蓓昂丝温和清洁净肤保湿卸妆水","count":24,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/7/1.jpg","price":69},{"commodityId":15,"commodityName":"玻儿精灵美妆蛋一个","count":24,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/1.jpg","price":6},{"commodityId":16,"commodityName":"Lara style清洗剂","count":24,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/6/1.jpg","price":12},{"commodityId":17,"commodityName":"化妆镜","count":24,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/7/1.jpg","price":31}]},{"categoryName":"女鞋","shoppingCartList":[{"commodityId":18,"commodityName":"白色经典 秋季新款简约百搭轻便休闲女鞋板鞋小白鞋","count":24,"pic":"http://172.17.8.100/images/small/commodity/nx/bx/1/1.jpg","price":79},{"commodityId":19,"commodityName":"环球 时尚拼色街拍百搭小白鞋 韩版原宿ulzzang板鞋 女休闲鞋","count":24,"pic":"http://172.17.8.100/images/small/commodity/nx/bx/2/1.jpg","price":78},{"commodityId":20,"commodityName":"环球 冬季休闲加绒保暖棉靴 韩版百搭学生小白鞋女士高帮棉鞋","count":24,"pic":"http://172.17.8.100/images/small/commodity/nx/bx/3/1.jpg","price":78}]}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * categoryName : 美妆护肤
         * shoppingCartList : [{"commodityId":5,"commodityName":"双头两用修容笔","count":3,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg","price":39},{"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","count":4,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/4/1.jpg","price":39},{"commodityId":10,"commodityName":"BYPHASSE蓓昂丝温和清洁净肤保湿卸妆水","count":24,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/7/1.jpg","price":69},{"commodityId":15,"commodityName":"玻儿精灵美妆蛋一个","count":24,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/1.jpg","price":6},{"commodityId":16,"commodityName":"Lara style清洗剂","count":24,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/6/1.jpg","price":12},{"commodityId":17,"commodityName":"化妆镜","count":24,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/7/1.jpg","price":31}]
         */

        private String categoryName;
        private boolean CartChecked;
        private List<ShoppingCartListBean> shoppingCartList;

        public boolean getCartChecked() {
            return CartChecked;
        }

        public void setCartChecked(boolean cartChecked) {
            CartChecked = cartChecked;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public List<ShoppingCartListBean> getShoppingCartList() {
            return shoppingCartList;
        }

        public void setShoppingCartList(List<ShoppingCartListBean> shoppingCartList) {
            this.shoppingCartList = shoppingCartList;
        }

        public static class ShoppingCartListBean {
            /**
             * commodityId : 5
             * commodityName : 双头两用修容笔
             * count : 3
             * pic : http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg
             * price : 39
             */

            private int commodityId;
            private String commodityName;
            private int count;
            private String pic;
            private int price;
            private boolean ProductChecked;

            public boolean getProductChecked() {
                return ProductChecked;
            }

            public void setProductChecked(boolean productChecked) {
                ProductChecked = productChecked;
            }

            public int getCommodityId() {
                return commodityId;
            }

            public void setCommodityId(int commodityId) {
                this.commodityId = commodityId;
            }

            public String getCommodityName() {
                return commodityName;
            }

            public void setCommodityName(String commodityName) {
                this.commodityName = commodityName;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }
        }
    }
}
