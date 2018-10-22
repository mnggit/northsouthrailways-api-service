package com.railways.demo;

import com.railways.directedgraph.Vertex;

public class TravelPath {
	
  private final Vertex cityStart;
  private final Vertex cityEnd;
  private final long distance;
  private final String bestPath;
	
	public TravelPath(Vertex startTown, Vertex endTown, long distance, String bestPath) {
	    this.cityStart = startTown;
	    this.cityEnd = endTown;
        this.distance = distance;
        this.bestPath = startTown.getName() + endTown.getName() + distance;
    }

	public Vertex getStartTown() {
		return cityStart;
	}

	public Vertex getEndTown() {
		return cityEnd;
	}

	public long getDistance() {
		return distance;
	}
	
    public String getBestPath() {
		return bestPath;
	}
}
