import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Cimri implements Platform{
    private final String name;
    private final String format;

    public Cimri(String name) {
        this.name = name;
        this.format = "json";
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public void generateFile(List<Product> products) {

        String fileName = name + ".json";

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            StringBuilder xy = new StringBuilder();
            xy.append("[\n");

            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                xy.append("    {\n");
                xy.append("        \"id\": ").append(product.getId()).append(",\n");
                xy.append("        \"name\": \"").append(product.getName()).append("\",\n");
                xy.append("        \"price\": ").append(product.getPrice()).append(",\n");
                xy.append("        \"category\": \"").append(product.getCategory()).append("\"\n");
                xy.append("    }");

                if (i != products.size() - 1) {
                    xy.append(",");
                }

                xy.append("\n");
            }

            xy.append("]\n");

            fileWriter.write(xy.toString());
            System.out.println("Generated JSON file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
