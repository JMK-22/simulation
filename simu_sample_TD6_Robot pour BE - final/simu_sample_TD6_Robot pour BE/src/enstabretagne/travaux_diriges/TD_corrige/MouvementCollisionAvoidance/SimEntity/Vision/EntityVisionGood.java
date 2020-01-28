package enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Vision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import enstabretagne.base.logger.Logger;
import enstabretagne.base.time.LogicalDuration;
import enstabretagne.simulation.components.IEntity;
import enstabretagne.simulation.components.data.SimFeatures;
import enstabretagne.simulation.core.implementation.SimEvent;
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
		Post(new MouvementStrategie(), getCurrentLogicalDate().add(LogicalDuration.ofMillis(1)));
	}
	
	public class MouvementStrategie extends SimEvent {

		@Override
		public void Process() {
			Robot r = (Robot) getParent();
			
			Logger.Detail(this, "AfterActivate", "Activation EntityVision", "test");
			
			HashMap<String, Point3D> d = dic_pledge();
			
			Point3D target = pleadDecision(d);
			
			r.setTarget(target);
			
			Post(r.new StartMouvement(), getCurrentLogicalDate().add(LogicalDuration.ofMillis(1)));
		}
	}
	
	protected Point3D positionR(){
		Robot r = (Robot) getParent();
		
		return r.getPosition();
	}
	
	
	
	
	
}
