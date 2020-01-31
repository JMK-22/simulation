package enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Vision;

import enstabretagne.simulation.components.data.SimFeatures;

public class EntityVisionFeature extends SimFeatures {
	
	private double coneVision;
	private double distanceVision;

	public EntityVisionFeature(String id, double cone, double distance) {
		super(id);
		coneVision= cone;
		distanceVision= distance;
	}
	
	

}
