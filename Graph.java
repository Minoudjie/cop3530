import java.util.ArrayList;

public class Graph {
    private ArrayList<City> cities;
    private ArrayList<Edge> edges;
    
    public Graph() {
        cities = new ArrayList<>();
        edges = new ArrayList<>();
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
