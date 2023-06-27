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
            StringBuilder sb = new StringBuilder();
            sb.append("[\n");

            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                sb.append("    {\n");
                sb.append("        \"id\": ").append(product.getId()).append(",\n");
                sb.append("        \"name\": \"").append(product.getName()).append("\",\n");
                sb.append("        \"price\": ").append(product.getPrice()).append(",\n");
                sb.append("        \"category\": \"").append(product.getCategory()).append("\"\n");
                sb.append("    }");

                if (i != products.size() - 1) {
                    sb.append(",");
                }

                sb.append("\n");
            }

            sb.append("]\n");

            fileWriter.write(sb.toString());
            System.out.println("Generated JSON file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
