import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        City sanFrancisco = new City("San Francisco", 37, -122);
        City newYork = new City("New York", 34, -118);
        City chicago = new City("Chicago", 20, -20);
        City losAngeles = new City("Los Angeles", 14, -300);
        City miami = new City("Miami", 50, -250);
        graph.addCity(sanFrancisco);
        graph.addCity(newYork);
        graph.addCity(chicago);
        graph.addCity(losAngeles);
        graph.addCity(miami);
        graph.addEdge(new Edge(sanFrancisco, newYork, 383));
        graph.addEdge(new Edge(sanFrancisco, chicago, 2112));
        graph.addEdge(new Edge(losAngeles, chicago, 2015));
        graph.addEdge(new Edge(newYork, chicago, 790));
        graph.addEdge(new Edge(newYork, miami, 1306));
        graph.addEdge(new Edge(losAngeles, miami, 2786));

        ArrayList<City> path = PathFinder.findShortestPath(graph, sanFrancisco, miami);
        System.out.println("Shortest path from " + sanFrancisco.getName() + " to " + miami.getName() + ":");
        for (City city : path) {
            System.out.println(city.getName());
        }
    }
}
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        City sanFrancisco = new City("San Francisco", 37, -122);
        City newYork = new City("New York", 34, -118);
        City chicago = new City("Chicago", 20, -20);
        City losAngeles = new City("Los Angeles", 14, -300);
        City miami = new City("Miami", 50, -250);
        graph.addCity(sanFrancisco);
        graph.addCity(newYork);
        graph.addCity(chicago);
        graph.addCity(losAngeles);
        graph.addCity(miami);
        graph.addEdge(new Edge(sanFrancisco, newYork, 383));
        graph.addEdge(new Edge(sanFrancisco, chicago, 2112));
        graph.addEdge(new Edge(losAngeles, chicago, 2015));
        graph.addEdge(new Edge(newYork, chicago, 790));
        graph.addEdge(new Edge(newYork, miami, 1306));
        graph.addEdge(new Edge(losAngeles, miami, 2786));

        ArrayList<City> path = PathFinder.findShortestPath(graph, sanFrancisco, miami);
        System.out.println("Shortest path from " + sanFrancisco.getName() + " to " + miami.getName() + ":");
        for (City city : path) {
            System.out.println(city.getName());
        }
    }
}
class City {
    private String name;
    private int latitude;
    private int longitude;

    public City(String name, int latitude, int longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }
}

class Edge {
    private City city1;
    private City city2;
    private int distance;

    public Edge(City city1, City city2, int distance) {
        this.city1 = city1;
        this.city2 = city2;
        this.distance = distance;
    }

    public City getCity1() {
        return city1;
    }

    public City getCity2() {
        return city2;
    }

    public int getDistance() {
        return distance;
    }
}

class Graph {
    private ArrayList<City> cities;
    private ArrayList<Edge> edges;

    public Graph() {
        cities = new ArrayList<City>();
        edges = new ArrayList<Edge>();
    }

    public void addCity(City city) {
        cities.add(city);
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }
}

class PathFinder {
    public static ArrayList<City> findShortestPath(Graph graph, City start, City end) {
        ArrayList<City> path = new ArrayList<City>();
        .
        return path;
    }



