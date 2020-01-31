package enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Vision;

import enstabretagne.simulation.components.data.SimInitParameters;
import javafx.geometry.Point3D;

public class EntityVisionInit extends SimInitParameters {
	
	Point3D posInit; 

	
	public EntityVisionInit(Point3D p){
		
		this.posInit =p;
		
	}
	
	public Point3D getPosInit(){
		return posInit;
	}
	
	
}
