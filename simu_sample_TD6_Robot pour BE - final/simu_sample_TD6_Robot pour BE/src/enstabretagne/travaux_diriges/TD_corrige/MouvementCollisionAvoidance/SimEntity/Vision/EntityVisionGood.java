package enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Vision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayDeque;

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
	int compteur=10;
	boolean escape = false;
	boolean approach = false;
	boolean clockwise = false;
	boolean initFollowWall = false;
	ArrayDeque<Point3D> escapeRoute;
	
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
			
			if (!canSeeBadRobot() && !escape && !approach){
				extendGraphIfNeeded();
				
				HashMap<String, Point3D> d = dic_pledge();
				
				Point3D target = pledgeDecision(d);
				
				r.setTarget(target);
				if (compteur == 0) {
					Post(r.new StartMouvement(), getCurrentLogicalDate().add(LogicalDuration.ofMillis(1000)));
				} else {
					Post(r.new StartMouvement(), getCurrentLogicalDate().add(LogicalDuration.ofMillis(1)));
				}
				
			} else if (canSeeBadRobot() && !canSeeNemesisRobot() && !escape && !approach){
				extendGraphIfNeeded();
				approach = true;
				Point3D target = approachBadRobot();
				r.setTarget(target);
				Post(r.new StartMouvement(), getCurrentLogicalDate().add(LogicalDuration.ofMillis(1)));
			} else if (!canSeeNemesisRobot() && !initFollowWall) {
				initFollowWall = true;
				initFollowWall();
			
			} else if (!escape && !canSeeNemesisRobot()) {
				extendGraphIfNeeded();
				followWall();
			} else if (!escape) {
				extend_graph();
				escapeRoute = escapeGraph.shorterPath(positionR(),((Robot) getParent()).getrIni().getPosInit());
				approach = false;
				escape();		
			} else {
				escape();
			}
		}
			
			
	}
	
	protected void extendGraphIfNeeded() {
		if (compteur == 10){
			compteur = 0;
			extend_graph();
		}
		
		compteur+=1;
	}
	
	
	protected void initFollowWall() {
		Robot r = (Robot) getParent();
		Point3D target;
		
		HashMap<String, Point3D> d = dic_pledge();
		
		if (!d.containsKey("devant")) {
			if (!d.containsKey("droite")) {
				target = d.get("gauche");
				clockwise = false;
			} else {
				target = d.get("droite");
				clockwise = true;
			}
		} else if (!d.containsKey("droite")) {
			target = d.get("devant");
			clockwise = false;
		} else {
			target = d.get("devant");
			clockwise = true;
		}
		
		r.setTarget(target);
		Post(r.new StartMouvement(), getCurrentLogicalDate().add(LogicalDuration.ofMillis(20)));
	}
	
	protected void followWall() {
		Robot r = (Robot) getParent();
		
		HashMap<String, Point3D> d = dic_pledge();
		
		Point3D target = pledgeSuivreMur(d, clockwise);
		
		r.setTarget(target);
		Post(r.new StartMouvement(), getCurrentLogicalDate().add(LogicalDuration.ofMillis(2)));
	}
	
	protected void escape() {
		Robot r = (Robot) getParent();
		long delay = 10;
		
		if (!escape) {
			delay = 30000;
			escape = true;
		}
		
		if (escapeRoute.isEmpty()) {
			System.out.println("Mission accomplished, the world is saved !");
		} else {
			r.setTarget(escapeRoute.poll());
			Post(r.new StartMouvement(), getCurrentLogicalDate().add(LogicalDuration.ofMillis(delay)));	
		}
	}
	
	protected Point3D positionR(){
		Robot r = (Robot) getParent();
		
		return r.getPosition();
	}
	
}
