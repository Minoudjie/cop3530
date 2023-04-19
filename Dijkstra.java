import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Dijkstra {
    public static Map<City, Integer> shortestPaths(Graph graph, City source) {
        Map<City, Integer> distances = new HashMap<>();
        HashSet<City> visited = new HashSet<>();
        ArrayList<City> unvisited = new ArrayList<>();
        distances.put(source, 0);
        unvisited.add(source);

        while (!unvisited.isEmpty()) {
            City current = getMinimum(distances, unvisited);
            visited.add(current);
            unvisited.remove(current);
            ArrayList<City> neighbors = getNeighbors(current, graph);
            for (City neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    int tentativeDistance = distances.get(current) + getDistance(current, neighbor, graph);
                    if (tentativeDistance < getDistance(neighbor, distances)) {
                        distances.put(neighbor, tentativeDistance);
                        unvisited.add(neighbor);
                    }
                }
            }
        }

        return distances;
    }

    private static City getMinimum(Map<City, Integer> distances, ArrayList<City> cities) {
        City minimum = null;
        for (City city : cities) {
            if (minimum == null || getDistance(city, distances) < getDistance(minimum, distances)) {
                minimum = city;
            }
        }
        return minimum;
    }

    private static int getDistance(City city, Map<City, Integer> distances) {
        Integer distance = distances.get(city);
        if (distance == null) {
            return Integer.MAX_VALUE;
        } else {
            return distance;
        }
    }

    private static ArrayList<City> getNeighbors(City city, Graph graph) {
        ArrayList<City> neighbors = new ArrayList<>();
        for (Edge edge : graph.getEdges()) {
            if (edge.getCity1().equals(city) && !isVisited(edge.getCity2(), graph)) {
                neighbors.add(edge.getCity2());
            } else if (edge.getCity2().equals(city) && !isVisited(edge.getCity1(), graph)) {
                neighbors.add(edge.getCity1());
            }
        }
        return neighbors;
    }

    private static boolean isVisited(City city, Graph graph) {
        return graph.getCities().contains(city);
    }

    private static int getDistance(City city1, City city2, Graph graph) {
        for (Edge edge : graph.getEdges()) {
            if ((edge.getCity1().equals(city1) && edge.getCity2().equals(city2)) ||
                    (edge.getCity1().equals(city2) && edge.getCity2().equals(city1))) {
                return edge.getDistance();
            }
        }
        throw new RuntimeException("Should not happen");
    }
}
