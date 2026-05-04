/*
 * Class: CMSC204 
 * Instructor: professor Thai, Gary
 * Description: Project<6>
 * Due: 5/3/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Giran Park
*/

package proj6;
import java.util.*;


public class Graph implements GraphInterface<Town, Road>{
	private Set<Town> towns= new HashSet<>();
	private Set<Road> roads= new HashSet<>();
	private Map<Town, Town> previousTownM;
	private Map<Town, Integer> distanceM;

	/**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
	@Override
    public Road getEdge(Town point1, Town point2) {
		if (point1== null || point2== null)
			return null;
		for(Road r: roads) {
			if(r.contains(point1)&& r.contains(point2))
				return r;
		}
		return null;
	}
	

    /**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * 
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     *
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target Townertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target Townertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified Townertices is null.
     */
    public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
    	if(sourceVertex== null || destinationVertex==null) throw new NullPointerException();
    	if(!towns.contains(sourceVertex)|| !towns.contains(destinationVertex)) throw new IllegalArgumentException();
    	
    	Road road= new Road(sourceVertex, destinationVertex, weight, description);
    	roads.add(road);
    	return road;
    	
    }

    /**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */
    public boolean addVertex(Town v) {
    	if(v== null) throw new NullPointerException();
    	return towns.add(v);
    }
	

    /**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
    public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
    	
    	if(getEdge(sourceVertex, destinationVertex)!= null) {
    		return true;
    				
    	}else {
    	return false;}
    }

    /**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
    public boolean containsVertex(Town v) {
    	return towns.contains(v);
    }
    
    /**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     *
     *
     * @return a set of the edges contained in this graph.
     */
    public Set<Road> edgeSet(){
    	return roads;
    }
    

    /**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
    public Set<Road> edgesOf(Town vertex){
    	if(vertex== null) throw new NullPointerException();
    	Set<Road> result= new HashSet<>();
    	for(Road r: roads) {
    		if(r.contains(vertex)) {
    			result.add(r);}
    		
    		
    	}
    	return result;
    }

        /**
         * Removes an edge going from source vertex to target vertex, if such
         * vertices and such edge exist in this graph. 
         * 
         * If weight >- 1 it must be checked
         * If description != null, it must be checked 
         * 
         * Returns the edge if removed
         * or null otherwise.
         *
         * @param sourceVertex source vertex of the edge.
         * @param destinationVertex target vertex of the edge.
         * @param weight weight of the edge
         * @param description description of the edge
         *
         * @return The removed edge, or null if no edge removed.
         */
        public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
        	Road removeRoad= null;
        	for(Road r: roads) {
        		if(r.contains(sourceVertex)&& r.contains(destinationVertex)&& r.getName().equals(description)&&(weight<0 || r.getWeight()==weight)) {
        			removeRoad=r;
        			break;
        		}
        	}
        	if(removeRoad!= null) 
        		roads.remove(removeRoad);
        	return removeRoad;
        }
        

        /**
         * Removes the specified vertex from this graph including all its touching
         * edges if present. More formally, if the graph contains a vertex 
         * u such that u.equals(v), the call removes all edges
         * that touch u and then removes u itself. If no
         * such u is found, the call leaves the graph unchanged.
         * Returns true if the graph contained the specified vertex. (The
         * graph will not contain the specified vertex once the call returns).
         *
         * If the specified vertex is null returns false.
         *
         * @param v vertex to be removed from this graph, if present.
         *
         * @return true if the graph contained the specified vertex;
         * false otherwise.
         */
        @Override
        public boolean removeVertex(Town v) {
        	if(v== null) {
        		return false;}
        	boolean removed = towns.remove(v);
            if (removed) {
                roads.removeIf(r -> r.contains(v));
            }
            return removed;
        }

            /**
             * Returns a set of the vertices contained in this graph. The set is backed
             * by the graph, so changes to the graph are reflected in the set. If the
             * graph is modified while an iteration over the set is in progress, the
             * results of the iteration are undefined.
             *
             *
             * @return a set view of the vertices contained in this graph.
             */
            public Set<Town> vertexSet(){
            	return towns;
            }
            
            /**
             * Find the shortest path from the sourceVertex to the destinationVertex
             * call the dijkstraShortestPath with the sourceVertex
             * @param sourceVertex starting vertex
             * @param destinationVertex ending vertex
             * @return An arraylist of Strings that describe the path from sourceVertex
             * to destinationVertex
             * They will be in the format: startVertex "via" Edge "to" endVertex weight
        	 * As an example: if finding path from Vertex_1 to Vertex_10, the ArrayList<String>
        	 * would be in the following format(this is a hypothetical solution):
        	 * Vertex_1 via Edge_2 to Vertex_3 4 (first string in ArrayList)
        	 * Vertex_3 via Edge_5 to Vertex_8 2 (second string in ArrayList)
        	 * Vertex_8 via Edge_9 to Vertex_10 2 (third string in ArrayList)
             */   
            public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex){
            dijkstraShortestPath(sourceVertex);
            ArrayList<String> path= new ArrayList<>();
            Town current= destinationVertex;
            
            while(current!= null && previousTownM.get(current)!=null) {
            	Town previous= previousTownM.get(current);
            	Road r= getEdge(previous, current);
            	path.add(0, previous.getName()+ " via "+ r.getName() + " to "+ current.getName()+" "+r.getWeight()+ " mi");
            	current= previous;
            	
            }
            return path;
            }
            
            private class Node implements Comparable<Node>{
            	Town town;
            	int distance;
            	
            	Node(Town town, int distance){
            		this.town= town;
            		this.distance= distance;
            	}
            	
            	@Override
            	public int compareTo(Node other) {
            		return Integer.compare(distance, other.distance);
            	}
            }
            
            
            /**
             * Dijkstra's Shortest Path Method.  Internal structures are built which
             * hold the ability to retrieve the path, shortest distance from the
             * sourceVertex to all the other vertices in the graph, etc.
             * @param sourceVertex the vertex to find shortest path from
             * 
             */
         
            public void dijkstraShortestPath(Town sourceVertex){
                distanceM = new HashMap<>();
                previousTownM = new HashMap<>();
    
                for (Town t : towns) {
                    distanceM.put(t, Integer.MAX_VALUE);
                }
                
                PriorityQueue<Node> pq= new PriorityQueue<>();
                

                distanceM.put(sourceVertex, 0);
                pq.add(new Node(sourceVertex, 0));
                
                while (!pq.isEmpty()){
                    Node current = pq.poll();
                    Town u = current.town;
                    
                       if (current.distance > distanceM.get(u)){
                        continue;
                    }

                     for (Road road : edgesOf(u)){
                        Town v = road.getSource().equals(u) ? getDestinationWorkaround(road, u) : road.getSource();
                        
                        int weight = road.getWeight(); 
                        int newDistance = distanceM.get(u) + weight;
                        
                         if (newDistance < distanceM.get(v)){
                            distanceM.put(v, newDistance);
                            previousTownM.put(v, u); 
                            pq.add(new Node(v, newDistance));
                        }
                    }
                }
            }

               private Town getDestinationWorkaround(Road road,Town u){
                  String roadStr= road.toString();
                String[] parts= roadStr.split(";");
                String destinationName= parts[2];   
                for (Town t : towns){
                    if (t.getName().equals(destinationName)){
                        return t;
                    }
                }
                return null;
            }
            }
            
    
    
    
    

