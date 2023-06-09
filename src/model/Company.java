package model;

import structures.Graph;

import java.util.Map;

public class Company {
    Graph<String> cities;
    Graph<String> employees;
    public Company(){
        cities = new Graph<>();
        employees = new Graph<>();
        insertValues();
    }
    public void insertValues(){
        //Cities
        cities.addEdge("Bogota", "Medellin", 400, true);
        cities.addEdge("Bogota", "Ibague", 200, true);
        cities.addEdge("Bogota", "Manizales", 170, true);
        cities.addEdge("Bogota", "Bucaramanga", 320, true);
        cities.addEdge("Bogota", "Cartagena", 660, true);

        cities.addEdge("Medellin", "Bogota", 400, true);
        cities.addEdge("Medellin", "Barranquilla", 107, true);
        cities.addEdge("Medellin", "Pereira", 180, true);
        cities.addEdge("Medellin", "SantaMarta", 115, true);
        cities.addEdge("Medellin", "Cucuta", 430, true);

        cities.addEdge("Barranquilla", "Medellin", 107, true);
        cities.addEdge("Barranquilla", "Cartagena", 130, true);
        cities.addEdge("Barranquilla", "Villavicencio", 840, true);
        cities.addEdge("Barranquilla", "Valledupar", 200, true);
        cities.addEdge("Barranquilla", "Cali", 103, true);

        cities.addEdge("Cartagena", "Barranquilla", 130, true);
        cities.addEdge("Cartagena", "Bucaramanga", 840, true);
        cities.addEdge("Cartagena", "Bogota", 660, true);
        cities.addEdge("Cartagena", "Monteria", 690, true);
        cities.addEdge("Cartagena", "Armenia", 870, true);

        cities.addEdge("Bucaramanga", "Cartagena", 840, true);
        cities.addEdge("Bucaramanga", "Bogota", 320, true);
        cities.addEdge("Bucaramanga", "Pereira", 200, true);
        cities.addEdge("Bucaramanga", "Neiva", 310, true);
        cities.addEdge("Bucaramanga", "Sincelejo", 540, true);

        cities.addEdge("Pereira", "Bucaramanga", 200, true);
        cities.addEdge("Pereira", "Medellin", 180, true);
        cities.addEdge("Pereira", "SantaMarta", 990, true);
        cities.addEdge("Pereira", "Barrancabermeja", 430, true);
        cities.addEdge("Pereira", "Riohacha", 640, true);

        cities.addEdge("SantaMarta", "Pereira", 990, true);
        cities.addEdge("SantaMarta", "Medellin", 115, true);
        cities.addEdge("SantaMarta", "Manizales", 930, true);
        cities.addEdge("SantaMarta", "Popayan", 100, true);
        cities.addEdge("SantaMarta", "Buenaventura", 480, true);

        cities.addEdge("Manizales", "SantaMarta", 930, true);
        cities.addEdge("Manizales", "Bogota", 170, true);
        cities.addEdge("Manizales", "Cucuta", 550, true);
        cities.addEdge("Manizales", "Soledad", 690, true);
        cities.addEdge("Manizales", "Florencia", 460, true);

        cities.addEdge("Cucuta", "Manizales", 550, true);
        cities.addEdge("Cucuta", "Medellin", 430, true);
        cities.addEdge("Cucuta", "Ibague", 430, true);
        cities.addEdge("Cucuta", "SantaMarta", 530, true);
        cities.addEdge("Cucuta", "Tunja", 550, true);

        //Employees
        employees.addEdge("CEO", "CFO", 20, false);
        employees.addEdge("CEO", "Marketing Director", 20, false);
        employees.addEdge("CEO", "Sales Director", 20, false);
        employees.addEdge("CEO", "Advertising Director", 20, false);
        employees.addEdge("CEO", "HR Director", 20, false);

        employees.addEdge("CFO", "Alvaro", 10, false);
        employees.addEdge("CFO", "Beatriz", 10, false);
        employees.addEdge("CFO", "David", 10, false);
        employees.addEdge("CFO", "Alejandro", 10, false);
        employees.addEdge("CFO", "Panchito", 10, false);

        employees.addEdge("Marketing Director", "Martha", 10, false);
        employees.addEdge("Marketing Director", "Daniela", 10, false);
        employees.addEdge("Marketing Director", "Camila", 10, false);
        employees.addEdge("Marketing Director", "Valentina", 10, false);
        employees.addEdge("Marketing Director", "Isabella", 10, false);

        employees.addEdge("Sales Director", "Laura", 10, false);
        employees.addEdge("Sales Director", "Sebastian", 10, false);
        employees.addEdge("Sales Director", "Danna", 10, false);
        employees.addEdge("Sales Director", "Nicol", 10, false);
        employees.addEdge("Sales Director", "Juliana", 10, false);

        employees.addEdge("Advertising Director", "Dylan", 10, false);
        employees.addEdge("Advertising Director", "Santiago", 10, false);
        employees.addEdge("Advertising Director", "Juan", 10, false);
        employees.addEdge("Advertising Director", "Camilo", 10, false);
        employees.addEdge("Advertising Director", "Alexander", 10, false);

        employees.addEdge("HR Director", "Matias", 10, false);
        employees.addEdge("HR Director", "Mateo", 10, false);
        employees.addEdge("HR Director", "Raul", 10, false);
        employees.addEdge("HR Director", "Mariana", 10, false);
        employees.addEdge("HR Director", "Lucas", 10, false);

        employees.addEdge("Alvaro", "Martha", 5, true);
        employees.addEdge("Panchito", "Alexander", 5, true);
        employees.addEdge("Alejandro", "David", 5, true);
        employees.addEdge("Mariana", "Valentina", 5, true);
        employees.addEdge("Mateo", "Matias", 5, true);
        employees.addEdge("Dylan", "Sebastian", 5, true);
        employees.addEdge("Laura", "Camila", 5, true);
        employees.addEdge("David", "Isabella", 5, true);
        employees.addEdge("Santiago", "Raul", 5, true);
        employees.addEdge("Isabella", "Raul", 5, true);
    }


    public Map<String, Object> showDistanceC(String city1, String city2) {
        Map<String, Object> result = cities.Dijkstra(city1, city2);
        return result;
    }

    public Graph<String> getCities(){
        return cities;
    }

    public Graph<String> getEmployees() {
        return employees;
    }
}

