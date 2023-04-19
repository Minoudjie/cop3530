import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GraphReader {
    public static Graph readGraph(String fileName) throws FileNotFoundException {
        Graph graph = new Graph();
        Scanner scanner = new Scanner(new File(fileName));
        
        // Read the cities
        int numCities = scanner.nextInt();
        for (int i = 0; i < numCities; i++) {
            String name = scanner.next();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph.addCity(new City(name, x, y));
        }
        
        // Read the edges
        int numEdges = scanner.nextInt();
        for (int i = 0; i < numEdges; i++) {
            String city1Name = scanner.next();
            String city2Name = scanner.next();
            int distance = scanner.nextInt();
            City city1 = getCityByName(graph.getCities(), city1Name);
            City city2 = getCityByName(graph.getCities(), city2Name);
            graph.addEdge(new Edge(city1, city2, distance));
        }
        
        scanner.close();
        return graph;
    }
    
    private static City getCityByName(ArrayList<City> cities, String name) {
        for (City city : cities) {
            if (city.getName().equals(name)) {
                return city;
            }
        }
        return null;
    }
}
