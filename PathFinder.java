import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

public class PathFinder {
    public static ArrayList<City> findShortestPath(Graph graph, City source, City destination) {
        ArrayList<City> path = new ArrayList<>();
        Map<City, Integer> distances = Dijkstra.shortestPaths(graph, source);
        
        if (!distances.containsKey(destination)) {
            // destination city not found in the graph
            return path;
        }
        
        City current = destination;
        while (!current.equals(source)) {
            path.add(current);
            current = getClosestCity(current, distances, graph);
        }
        path.add(source);
        Collections.reverse(path);
        return path;
    }

    private static City getClosestCity(City city, Map<City, Integer> distances, Graph graph) {
        City closest = null;
        int shortestDistance = Integer.MAX_VALUE;
        for (Edge edge : graph.getEdges()) {
            if (edge.getCity1().equals(city) && distances.containsKey(edge.getCity2()) && distances.get(edge.getCity2()) < shortestDistance) {
                closest = edge.getCity2();
                shortestDistance = distances.get(closest);
            } else if (edge.getCity2().equals(city) && distances.containsKey(edge.getCity1()) && distances.get(edge.getCity1()) < shortestDistance) {
                closest = edge.getCity1();
                shortestDistance = distances.get(closest);
            }
        }
        return closest;
    }
}
