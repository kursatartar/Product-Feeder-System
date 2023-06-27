import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Google implements Platform{
    private final String name;
    private final String format;

    public Google(String name) {
        this.name = name;
        this.format = "xml";
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public void generateFile(List<Product> products) {
        // Generate XML file
        String fileName = name + ".xml";

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            StringBuilder xy = new StringBuilder();
            xy.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            xy.append("<products>\n");

            for (Product product : products) {
                xy.append("    <product>\n");
                xy.append("        <id>").append(product.getId()).append("</id>\n");
                xy.append("        <name>").append(product.getName()).append("</name>\n");
                xy.append("        <price>").append(product.getPrice()).append("</price>\n");
                xy.append("        <category>").append(product.getCategory()).append("</category>\n");
                xy.append("    </product>\n");
            }

            xy.append("</products>\n");

            fileWriter.write(xy.toString());
            System.out.println("Generated XML file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
