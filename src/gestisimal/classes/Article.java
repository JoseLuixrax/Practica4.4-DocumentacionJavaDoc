package gestisimal.classes;

import java.util.Objects;
import gestisimal.exceptions.ArticleIllegalArgumentException;
/**
 * Representa un articulo que tiene los atributos nombre, marca, precio de compra, precio de venta, unidades, Stock de seguridad, Stock maximo
 * 
 * @author Jose Luis Perez Lara
 *
 */
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
  /**
   * Crea un articulo con los parametros especificados
   * @param name            Nombre del Articulo a añadir.
   * @param brand           Marca del Articulo a añadir.
   * @param buyingPrice     Precio de compra del Articulo a añadir.
   * @param sellingPrice    Precio de venta del Articulo a añadir.
   * @param units           Unidades del Articulo a añadir.
   * @param securityStock   Stock de seguridad del Articulo a añadir.
   * @param maxStock        Stock Maximo del Articulo a añadir.
   */
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
  /**
   * Crea un articulo con los parametros especificados
   * @param name            Nombre del Articulo a añadir.
   * @param brand           Marca del Articulo a añadir.
   * @param buyingPrice     Precio de compra del Articulo a añadir.
   * @param sellingPrice    Precio de venta del Articulo a añadir.
   * @param units           Unidades del Articulo a añadir.
   */
  Article(String name, String brand, double buyingPrice, double sellingPrice, int units){
    this(name, brand, buyingPrice, sellingPrice, units, 0, 0);
  }
  
  @Override
  public String toString() {
    return "Article [code=" + code + ", name=" + name + ", brand=" + brand + ", buyingPrice="
        + buyingPrice + ", sellingPrice=" + sellingPrice + ", units=" + units + ", securityStock="
        + securityStock + ", maxStock=" + maxStock + "]";
  }
  /**
   * Devuelte el codigo del articulo
   * @return    this.code del articulo.
   */
  public int getCode() {
    return code;
  }
  /**
   * Cambia el codigo del articulo.
   * @param code
   */
  void setCode(int code) {
    this.code = code;
  }
  /**
   * Devuelve el nombre del articulo 
   * @return    this.name del articulo
   */
  String getName() {
    return name;
  }
  /**
   * Cambia el nombre del articulo
   * @param name
   */
  void setName(String name) {
    throwExceptionIfStringIsNotValid(name);
    this.name = name;
  }
  /**
   * Devuelve la marca del articulo
   * @return    this.brand del articulo
   */
  String getBrand() {
    return brand;
  }
  /**
   * Cambia la marca del articulo
   * @param brand   
   */
  void setBrand(String brand) {
    throwExceptionIfStringIsNotValid(brand);
    this.brand = brand;
  }
  /**
   * Devuelve el precio de compra del articulo
   * @return    this.buyingPrice del articulo
   */
  double getBuyingPrice() {
    return buyingPrice;
  }

  /**
   * Cambia el precio de compra del articulo
   * @param buyingPrice
   */
  void setBuyingPrice(double buyingPrice){
    throwExceptionIfNegativePrice(buyingPrice);
    this.buyingPrice = buyingPrice;
  }
  /**
   * Devuelve el precio de venta del articulo
   * @return    this.sellingPrice del articulo.
   */
  double getSellingPrice() {
    return sellingPrice;
  }
  /**
   * Cambia el precio de venta del articulo.
   * @param sellingPrice   
   */
  void setSellingPrice(double sellingPrice){
    throwExceptionIfNegativePrice(sellingPrice);
    this.sellingPrice = sellingPrice;
  }
  /**
   * Devuelve las unidades del articulo.
   * @return    this.units del articulo
   */
  int getUnits() {
    return units;
  }
  /**
   * Cambia las unidades del articulo.
   * @param units
   */
  void setUnits(int units) {
    throwsExceptionIfUnitsAreNegative(units);
    this.units = units;
  }
  /**
   * Incremeta las unidades del articulo.
   * @param units
   */
  void increaseUnits(int units) {
    throwsExceptionIfArticleUnitsAreNegative(units);
    this.units += units;
  }
  /**
   * Decrementa las unidades del articulo.
   * @param units
   */
  void decreaseUnits(int units){
    throwsExceptionIfArticleUnitsAreNegative(units);
    this.units -= units;
  }
  
  /**
   * Devuelve el stock de seguridad del articulo
   * @return    this.securityStock del articulo
   */
  int getSecurityStock() {
    return securityStock;
  }
  /**
   * Cambia el stock de seguridad del articulo
   * @param securityStock
   */
  void setSecurityStock(int securityStock) {
    this.securityStock = securityStock;
  }

  /**
   * Devuelve el stock maximo del articulo
   * @return    this.maxStock del articulo.
   */
  int getMaxStock() {
    return maxStock;
  }
  /**
   * Cambia el stock maximo del articulo.
   * @param maxStock
   */
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
  /**
   * Comprueba si las unidades son negativas
   * @param units
   */
  private void throwsExceptionIfUnitsAreNegative(int units) {
    if(units < 0) {
      throw new ArticleIllegalArgumentException("Las unidades a modificar no pueden ser negativa");
    }
  }
  /**
   * Comprueba si el precio es negativo.
   * @param buyingPrice
   */
  void throwExceptionIfNegativePrice(double buyingPrice) {
    if (buyingPrice < 0) {
      throw new ArticleIllegalArgumentException("El precio no puede ser negativo");
    }
  }
  /**
   * Comprueba si la cadena no es valida.
   * @param name
   */
  private void throwExceptionIfStringIsNotValid(String name) {
    if (name == null || name == "") {
      throw new ArticleIllegalArgumentException("La cadena no puede ser null o estar vacia.");
    }
  }
  /**
   * Comprueba si las unidades del articulo son negativas.
   * @param units
   */
  private void throwsExceptionIfArticleUnitsAreNegative(int units){
    if ((this.units-units) <= 0) {
      throw new ArticleIllegalArgumentException("Las unidades no pueden ser negativas.");
    }
  }
}
