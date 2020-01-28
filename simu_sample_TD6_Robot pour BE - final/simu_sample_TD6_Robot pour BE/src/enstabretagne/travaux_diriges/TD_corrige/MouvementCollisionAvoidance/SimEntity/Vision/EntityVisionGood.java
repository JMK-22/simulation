package enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Vision;

import java.util.ArrayList;
import java.util.List;

import enstabretagne.base.logger.Logger;
import enstabretagne.simulation.components.IEntity;
import enstabretagne.simulation.components.data.SimFeatures;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.Expertise.BorderAndPathGenerator;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Robot.Robot;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Wall.Wall;
import javafx.geometry.Bounds;
import javafx.geometry.Point3D;

public class EntityVisionGood extends EntityVision  {
	
	EntityVisionFeature VFeat;
	EntityVisionInit ini;

	public EntityVisionGood(String name, SimFeatures features) {
		super(name, features);
	}
	
	@Override
	protected void AfterActivate(IEntity sender, boolean starting) {
		Logger.Detail(this, "AfterActivate", "Activation EntityVision", "test");	
	}
	
	protected Point3D positionR(){
		Robot r = (Robot) getParent();
		
		return r.getPosition();
	}
	
	
	
	
	
}
