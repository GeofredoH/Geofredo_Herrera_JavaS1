import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class App {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Television> televisionList;

            televisionList = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>() {
            });

            int screenSize = 60;
                    televisionList
                    .stream()
                    .filter(t -> t.getScreenSize() > screenSize)
                            .forEach(t -> {
                                System.out.println("\nMake: " + t.getBrand());
                                System.out.println("Model: " + t.getModel());
                                System.out.println("ScreenSize: " + t.getScreenSize());
                                System.out.println("Price: " + t.getPrice());
                            });

            System.out.println("====================");

            Map<String, List<Television>> groupedByBrand = televisionList .stream() .collect(Collectors.groupingBy(t -> t.getBrand()));
            Set<String> keys = groupedByBrand.keySet();
            for (String key: keys) {
                System.out.println(key);
            }

            System.out.println("==================");
            double avgScreenSize = televisionList .stream() .mapToInt(t -> t.getScreenSize()) .average() .getAsDouble();
            System.out.println("Average of Screen Size is: " + avgScreenSize);

            System.out.println("===============");
            int maxScreen = televisionList .stream() .mapToInt(t -> t.getScreenSize()) .max() .getAsInt();
            System.out.println("Max Screen Size: " + maxScreen);

            System.out.println("\n\n==============Challenge==============");

            televisionList.sort((Television s1, Television s2)->s1.getScreenSize()-s2.getScreenSize());
            for(Television tele: televisionList){
                System.out.println("\nBrand: " + tele.getBrand());
                System.out.println("Model: " + tele.getModel());
                System.out.println("ScreenSize: " + tele.getScreenSize());
                System.out.println("Price: " + tele.getPrice());
            }

        } catch (IOException e)  {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
