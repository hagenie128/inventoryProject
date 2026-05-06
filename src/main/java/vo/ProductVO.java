package vo;

import java.util.Objects;

public class ProductVO {
    private String productId;
    private String name;
    private int price;
    private int stock;
    private int minStock;
    private String category;

    public ProductVO(String productId, String name, int price, int stock, int minStock, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.minStock = minStock;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return productId + "," + name + "," + price + "," + stock + "," + minStock + "," + category;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductVO productVO = (ProductVO) o;
        return Objects.equals(productId, productVO.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productId);
    }
}
