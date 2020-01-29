package enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Vision;

import java.util.HashMap;

import enstabretagne.base.logger.Logger;
import enstabretagne.base.time.LogicalDuration;
import enstabretagne.simulation.components.IEntity;
import enstabretagne.simulation.components.data.SimFeatures;
import enstabretagne.simulation.core.implementation.SimEvent;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Robot.Robot;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Robot.Robot.StartMouvement;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Vision.EntityVisionGood.MouvementStrategie;
import javafx.geometry.Point3D;

public class EntityVisionBad extends EntityVision {
	
	public EntityVisionBad(String name, SimFeatures features) {
		super(name, features);
	}
	
	
	@Override
	protected void AfterActivate(IEntity sender, boolean starting) {
		Post(new WaitAndShoot(), getCurrentLogicalDate().add(LogicalDuration.ofMillis(1)));
	}
	
	
	public class WaitAndShoot extends SimEvent {

		@Override
		public void Process() {
			Robot r = (Robot) getParent();
			
			
			if(!canSeeNemesisRobot()){
				Logger.Information( r,"AfterActivate", "EntityVisionBad : Can't see DetectionRobot "  );
				Post(new WaitAndShoot(), getCurrentLogicalDate().add(LogicalDuration.ofSeconds(10)));
			}else{
				Logger.Information( r,"AfterActivate", "EntityVisionBad : I shoot the DetectionRobot "  );
			}
			
		}
		
	}	
	
	

}
