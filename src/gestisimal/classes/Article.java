package gestisimal.classes;

import java.util.Objects;
import gestisimal.exceptions.ArticleIllegalArgumentException;

public class Article {
  private static int lastCode = 0;
  private int code;
  private String name;
  private String brand;
  private double buyingPrice;
  private double sellingPrice;
  private int units;
  private int securityStock;
  private int maxStock;
  
  Article(String name, String brand, double buyingPrice, double sellingPrice, int units, int securityStock, int maxStock) {
    this.code = Article.lastCode++;
    setName(name);
    setBrand(brand);
    setBuyingPrice(buyingPrice);
    setSellingPrice(sellingPrice);
    setUnits(units);
    setSecurityStock(securityStock);
    setMaxStock(maxStock);
  }

  Article(String name, String brand, double buyingPrice, double sellingPrice, int units){
    this(name, brand, buyingPrice, sellingPrice, units, 0, 0);
  }

  @Override
  public String toString() {
    return "Article [code=" + code + ", name=" + name + ", brand=" + brand + ", buyingPrice="
        + buyingPrice + ", sellingPrice=" + sellingPrice + ", units=" + units + ", securityStock="
        + securityStock + ", maxStock=" + maxStock + "]";
  }

  public int getCode() {
    return code;
  }
  void setCode(int code) {
    this.code = code;
  }

  String getName() {
    return name;
  }

  void setName(String name) {
    throwExceptionIfStringIsNotValid(name);
    this.name = name;
  }

  String getBrand() {
    return brand;
  }

  void setBrand(String brand) {
    throwExceptionIfStringIsNotValid(brand);
    this.brand = brand;
  }

  double getBuyingPrice() {
    return buyingPrice;
  }


  void setBuyingPrice(double buyingPrice){
    throwExceptionIfNegativePrice(buyingPrice);
    this.buyingPrice = buyingPrice;
  }

  double getSellingPrice() {
    return sellingPrice;
  }

  void setSellingPrice(double sellingPrice){
    throwExceptionIfNegativePrice(sellingPrice);
    this.sellingPrice = sellingPrice;
  }

  int getUnits() {
    return units;
  }

  void setUnits(int units) {
    throwsExceptionIfUnitsAreNegative(units);
    this.units = units;
  }
  
  void increaseUnits(int units) {
    throwsExceptionIfArticleUnitsAreNegative(units);
    this.units += units;
  }

  void decreaseUnits(int units){
    throwsExceptionIfArticleUnitsAreNegative(units);
    this.units -= units;
  }

  int getSecurityStock() {
    return securityStock;
  }

  void setSecurityStock(int securityStock) {
    this.securityStock = securityStock;
  }

  int getMaxStock() {
    return maxStock;
  }

  void setMaxStock(int maxStock) {
    this.maxStock = maxStock;
  }

  @Override
  public int hashCode() {
    return Objects.hash(brand, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Article other = (Article) obj;
    return Objects.equals(brand, other.brand) && Objects.equals(name, other.name);
  }
  
  private void throwsExceptionIfUnitsAreNegative(int units) {
    if(units < 0) {
      throw new ArticleIllegalArgumentException("Las unidades a modificar no pueden ser negativa");
    }
  }
  
  void throwExceptionIfNegativePrice(double buyingPrice) {
    if (buyingPrice < 0) {
      throw new ArticleIllegalArgumentException("El precio no puede ser negativo");
    }
  }

  private void throwExceptionIfStringIsNotValid(String name) {
    if (name == null || name == "") {
      throw new ArticleIllegalArgumentException("La cadena no puede ser null o estar vacia.");
    }
  }
  
  private void throwsExceptionIfArticleUnitsAreNegative(int units){
    if ((this.units-units) <= 0) {
      throw new ArticleIllegalArgumentException("Las unidades no pueden ser negativas.");
    }
  }
}
