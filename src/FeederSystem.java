import java.util.List;

class FeederSystem {
    private final List<Product> products;
    private final List<Platform> platforms;

    public FeederSystem(List<Product> products, List<Platform> platforms) {
        this.products = products;
        this.platforms = platforms;
    }

    public void generateFiles() {
        for (Platform platform : platforms) {
            platform.generateFile(products);
        }
    }
}