package de.vogella.algorithms.dijkstra.model.jfxmodel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayDeque;

import de.vogella.algorithms.dijkstra.engine.DijkstraAlgorithm;
import de.vogella.algorithms.dijkstra.model.Edge;
import de.vogella.algorithms.dijkstra.model.Graph;
import de.vogella.algorithms.dijkstra.model.IEdge;
import de.vogella.algorithms.dijkstra.model.IVertex;
import de.vogella.algorithms.dijkstra.model.Vertex;
import de.vogella.algorithms.dijkstra.model.jfxmodel.Point3DEdge;
import de.vogella.algorithms.dijkstra.model.jfxmodel.Point3DVertex;
import javafx.geometry.Point3D;


public class DijkstraGraph {

  private List<IVertex> nodes;
  private List<IEdge> edges;
  private Graph graph;
  
  private void set_graph(){
	  graph = new Graph(nodes, edges);
  }
  
  private Graph get_graph(){
	  
	  return graph;
  }
  
  public List<IVertex> getNodes() {
	return nodes;
}

public DijkstraGraph(Point3D p) {
	  nodes = new ArrayList<IVertex>();
	  edges = new ArrayList<IEdge>();
	  nodes.add(new Point3DVertex(p));
	  
	  
		
	}
  
  private void addLane(Point3DVertex s,Point3DVertex t) {
	  	
	  	if(!nodes.contains(s)){
	  		nodes.add(s);
	  	}
	  	if(!nodes.contains(t)){
	  		nodes.add(t);
	  	}

	  	Point3DEdge e1 = new Point3DEdge(s,t); 
	  	Point3DEdge e2 = new Point3DEdge(t,s); 
	  	
	    edges.add(e1);
	    edges.add(e2);

  }
  
  public void addMultipleLane(Point3D source,List<Point3D> t){
	  
	  Point3DVertex s = new Point3DVertex(source);
	  
	  if(!nodes.contains(s)){
		    System.out.println("source not Contain :" + s.toString());
	  		nodes.add(s);
	  	}else{
	  		System.out.println("source  Contain :" + s.toString());
	  	}
	  
	 
	  for (Point3D a : t){
		  Point3DVertex a1 = new Point3DVertex(a);
		  addLane(s,a1);
	  }
	  
	  
  }
  
  
  public  ArrayDeque<Point3D> shorterPath(Point3D source, Point3D arrival) {
    	
	    Point3DVertex s = new Point3DVertex(source);
	    Point3DVertex a = new Point3DVertex(arrival);
	  
	    System.out.println(nodes.contains(s));
	    System.out.println(s.toString());
	    System.out.println(nodes.contains(a));
    // Lets check from location Loc_1 to Loc_10
	    Graph graph = new Graph(nodes, edges);
	    DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
	    dijkstra.execute(s);
	    LinkedList<IVertex> path =  dijkstra.getPath(a);
	        
	    for (IVertex vertex : path) {
	      System.out.println(vertex);
	    }
	    
	    ArrayDeque<Point3D> route = new ArrayDeque<Point3D>();
	    
	    for (int i = 1; i < path.size(); i++) {
	    	route.add(((Point3DVertex) path.get(i)).getPoint());
	    }
	    
	    return route;
    
  } 
}

