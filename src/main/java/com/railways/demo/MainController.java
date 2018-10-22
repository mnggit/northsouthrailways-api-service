package com.railways.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.railways.directedgraph.Algorithm;
import com.railways.directedgraph.Edge;
import com.railways.directedgraph.Graph;
import com.railways.directedgraph.Vertex;

import com.railways.demo.TravelPaths;

@RestController
public class MainController {

	private List<Vertex> nodes;
    private List<Edge> edges;
   
            
    @RequestMapping("/travelPaths")
    public TravelPaths travelPaths(@RequestParam(value="cityStart", defaultValue="") String cityStart, @RequestParam(value="cityEnd", defaultValue="") String cityEnd) {
       
    		nodes = new ArrayList<Vertex>();
    		edges = new ArrayList<Edge>();
        
        nodes.add(new Vertex("Node_0", "A"));
        nodes.add(new Vertex("Node_1", "B"));
        nodes.add(new Vertex("Node_2", "C"));
        nodes.add(new Vertex("Node_3", "D"));
        nodes.add(new Vertex("Node_4", "E"));
        nodes.add(new Vertex("Node_5", "F"));
        nodes.add(new Vertex("Node_6", "G"));
        nodes.add(new Vertex("Node_7", "H"));
        nodes.add(new Vertex("Node_8", "I"));
        nodes.add(new Vertex("Node_9", "J"));        

        addLane("Edge_0", 0, 1, 12);
        addLane("Edge_1", 0, 3, 19);
        addLane("Edge_2", 0, 4, 20);
        addLane("Edge_3", 0, 6, 16);
        addLane("Edge_4", 1, 3, 13);
        addLane("Edge_5", 1, 2, 5);
        addLane("Edge_6", 1, 8, 15);
        addLane("Edge_7", 2, 3, 5);
        addLane("Edge_8", 3, 4, 7);
        addLane("Edge_9", 4, 5, 5);
        addLane("Edge_10", 5, 0, 5);
        addLane("Edge_11", 6, 5, 11);
        addLane("Edge_12", 7, 0, 4);
        addLane("Edge_13", 7, 1, 19);
        addLane("Edge_14", 7, 6, 6);
        addLane("Edge_15", 8, 7, 21);
        addLane("Edge_16", 8, 9, 10);
        addLane("Edge_17", 9, 1, 7);
        addLane("Edge_18", 9, 2, 15);     
        
        if (!cityStart.equalsIgnoreCase(cityEnd)) {
	        	Graph graph = new Graph(nodes, edges);
	            Algorithm algo = new Algorithm(graph);
	            
	            int cityStartInt = Integer.parseInt(cityStart);
	            int cityEndInt = Integer.parseInt(cityEnd);
	            
	            algo.execute(nodes.get(cityStartInt));
	            
	            LinkedList<TravelPath> path = algo.getPath(nodes.get(cityEndInt));
	    	    
	    	    ArrayList<String> travelPaths = new ArrayList<String>();
	    	    for (TravelPath tp : path) {
	               //System.out.println(tp.getStartTown()+tp.getEndTown()+tp.getDistance());
	    	    		System.out.println(tp.getStartTown().getName()+tp.getEndTown().getName()+tp.getDistance());
	               //System.out.println(hashMap.get(tp.getStartTown())+hashMap.get(tp.getEndTown())+tp.getDistance());
	    	    		travelPaths.add(tp.getStartTown().getName()+tp.getEndTown().getName()+tp.getDistance());
	    	    }
	        	    
	    	    //System.out.println(travelPaths);
            return new TravelPaths(travelPaths);
        } else {
        	    ArrayList<String> travelPaths = new ArrayList<String>();
        	    return new TravelPaths(travelPaths);
        }
    }
    
    private void addLane(String laneId, int sourceLocNo, int destLocNo,
            int duration) {
        Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration );
        edges.add(lane);
    }
}
