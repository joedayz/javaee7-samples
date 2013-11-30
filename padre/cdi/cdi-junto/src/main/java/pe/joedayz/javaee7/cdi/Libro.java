package pe.joedayz.javaee7.cdi;


public class Libro {

  // ======================================
  // =             Attributes             =
  // ======================================

  private String title;
  private Float price;
  private String description;
  private String number;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Libro() {
  }

  public Libro(String title, Float price, String description) {
    this.title = title;
    this.price = price;
    this.description = description;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  // ======================================
  // =         hash, equals, toString     =
  // ======================================

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Book{");
    sb.append("title='").append(title).append('\'');
    sb.append(", price=").append(price);
    sb.append(", description='").append(description).append('\'');
    sb.append(", number='").append(number).append('\'');
     sb.append('}');
    return sb.toString();
  }
}