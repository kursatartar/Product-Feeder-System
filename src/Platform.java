import java.util.List;

public interface Platform {
    String getName();
    String getFormat();
    void generateFile(List<Product> products);
}
