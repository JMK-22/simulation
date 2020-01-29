package enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Vision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import de.vogella.algorithms.dijkstra.model.jfxmodel.DijkstraGraph;
import enstabretagne.base.logger.Logger;
import enstabretagne.simulation.components.IEntity;
import enstabretagne.simulation.components.data.SimFeatures;
import enstabretagne.simulation.components.data.SimInitParameters;
import enstabretagne.simulation.components.implementation.SimEntity;
import enstabretagne.simulation.core.implementation.SimEvent;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.Expertise.BorderAndPathGenerator;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Robot.Robot;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Robot.RobotFeatures;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Wall.Wall;
import javafx.geometry.Bounds;
import javafx.geometry.Point3D;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;

public class EntityVision extends SimEntity{

	EntityVisionFeature VFeat;
	EntityVisionInit ini;
	public DijkstraGraph  escapeGraph;
	 
	private int pleadCounter = 0;
	
	public EntityVision(String name, SimFeatures features) {
		super(name, features);
		
	}

	@Override
	public void onParentSet() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initializeSimEntity(SimInitParameters init) {
		ini = (EntityVisionInit) init ;
		escapeGraph = new DijkstraGraph(ini.getPosInit());
		
	}

	@Override
	protected void BeforeActivating(IEntity sender, boolean starting) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void AfterActivate(IEntity sender, boolean starting) {
		
	}

	@Override
	protected void BeforeDeactivating(IEntity sender, boolean starting) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void AfterDeactivated(IEntity sender, boolean starting) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void AfterTerminated(IEntity sender, boolean restart) {
		// TODO Auto-generated method stub
		
	}
	
	protected Point3D positionR(){
		Robot r = (Robot) getParent();
		
		return r.getPosition();
	}
	
	
	public List<Point3D> VisibleZone(){
		
		List<Point3D> zone =Util.AbsoluteZone( Util.rectifi(positionR()));
		List<Point3D> VisibleZone =new ArrayList<Point3D>();
		
		
		@SuppressWarnings("unchecked")
		List<Wall> walls = (List<Wall>) (List<?>) getEngine()
				.requestSimObject(simo -> (simo instanceof Wall) && ((Wall) simo).getType() == 2);
		List<Bounds> bounds = new ArrayList<Bounds>();
		
		for (Wall w : walls) {
			bounds.addAll(w.getBounds());
		}
		for (Point3D p:zone){
			
			boolean isAcessible = BorderAndPathGenerator.intervisibilityBetween(p, Util.rectifi(positionR()),
					bounds);
			if (isAcessible){
				VisibleZone.add(p);
				
			}
			
		}
		
		
		return VisibleZone;
		
	}

	public List<Point3D> AcessibleZone(){
	
		List<Point3D> zone =Util.AbsoluteZone( Util.rectifi(positionR()));
		List<Point3D> AcessibleZone =new ArrayList<Point3D>();
		
		
		@SuppressWarnings("unchecked")
		List<Wall> walls = (List<Wall>) (List<?>) getEngine()
				.requestSimObject(simo -> ((simo instanceof Wall) && (((Wall) simo).getType() == 2|| ((Wall) simo).getType() == 3)));
		List<Bounds> bounds = new ArrayList<Bounds>();
		
		for (Wall w : walls) {
			bounds.addAll(w.getBounds());
		}
		for (Point3D p:zone){
			
			boolean isAcessible = BorderAndPathGenerator.intervisibilityBetween(p, Util.rectifi(positionR()),
					bounds);
			if (isAcessible){
				AcessibleZone.add(p);
				
			}
			
		}
		
		
		return AcessibleZone;
	
	}
	
	@SuppressWarnings("unchecked")
	public boolean canSeeBadRobot() {
		
		// Robot can see the bad guy throught wall of type 3
		boolean isVisible= false;
		List<Wall> walls = (List<Wall>) (List<?>) getEngine()
				.requestSimObject(simo -> (simo instanceof Wall) && ((Wall) simo).getType() == 2);
		List<Bounds> bounds = new ArrayList<Bounds>();
		for (Wall w : walls) {
			bounds.addAll(w.getBounds());
		}

		
		Robot bad = null;
		List<Robot> objets = (List<Robot>) (List<?>) getEngine().requestSimObject(simo -> (simo instanceof Robot) && (simo != getParent()));

		if (objets.size() == 1) {
			bad = objets.get(0);
			
			//on cr�e donc un cylindre entre les deux positions
			//on pourra afficher le cylindre dans la vue 3D
			Cylinder lineOfSight = BorderAndPathGenerator.generateCylinderBetween(bad.getPosition(), Util.rectifi(positionR()));
			lineOfSight.setMaterial(new PhongMaterial(Color.AQUA));

			//le robot gentil ne peut pas voire le mauvais robot à plus de 15m 
			if(lineOfSight.getHeight() < 12){
				
				isVisible = BorderAndPathGenerator.intervisibilityBetween(bad.getPosition(), Util.rectifi(positionR()),bounds);
				
			}
			
			return isVisible;
		} else
			return false;

	}
	
	@SuppressWarnings("unchecked")
	public boolean canSeeNemesisRobot() {
		
		// Robot can see the bad guy throught wall of type 3
		boolean isVisible= false;
		List<Wall> walls = (List<Wall>) (List<?>) getEngine()
				.requestSimObject(simo -> (simo instanceof Wall) && (((Wall) simo).getType() == 2||((Wall) simo).getType() == 3));
		List<Bounds> bounds = new ArrayList<Bounds>();
		for (Wall w : walls) {
			bounds.addAll(w.getBounds());
		}

		
		Robot bad = null;
		List<Robot> objets = (List<Robot>) (List<?>) getEngine().requestSimObject(simo -> (simo instanceof Robot) && (simo != getParent()));

		if (objets.size() == 1) {
			bad = objets.get(0);
			
			//on cr�e donc un cylindre entre les deux positions
			//on pourra afficher le cylindre dans la vue 3D
			Cylinder lineOfSight = BorderAndPathGenerator.generateCylinderBetween(bad.getPosition(), Util.rectifi(positionR()));
			lineOfSight.setMaterial(new PhongMaterial(Color.AQUA));

			//le robot gentil ne peut pas voire le mauvais robot à plus de 15m 
			if(lineOfSight.getHeight() < 10){
				
				isVisible = BorderAndPathGenerator.intervisibilityBetween(bad.getPosition(), Util.rectifi(positionR()),bounds);
				
			}
			
			return isVisible;
		} else
			return false;

	}

	
	
	// Debut Fonctions grille
	Point3D pleadDecision(HashMap<String, Point3D> surrondings) {
		Robot r = (Robot) getParent();
		
		if (pleadCounter == 0) {
			if (surrondings.containsKey("devant")) {
				Logger.Information(r, "DECISION_MOUVEMENT", "PleadCount: " + pleadCounter + ", heading " + "devant");
				return surrondings.get("devant");
				
			} else if (surrondings.containsKey("droite")) {
				pleadCounter -= 1;
				Logger.Information(r, "DECISION_MOUVEMENT", "PleadCount: " + pleadCounter + ", heading " + "droite");
				r.addOrientation(-Math.PI / 2);
				return surrondings.get("droite");
				
			} else if (surrondings.containsKey("gauche")) {
				pleadCounter += 1;
				Logger.Information(r, "DECISION_MOUVEMENT", "PleadCount: " + pleadCounter + ", heading " + "gauche");
				r.addOrientation(Math.PI / 2);
				return surrondings.get("gauche");
				
			} else {
				Logger.Information(r, "DECISION_MOUVEMENT", "surrondings contains no point, no mvt possible");
			}
		} else if (pleadCounter > 0) {
			if (surrondings.containsKey("droite")) {
				pleadCounter -= 1;
				r.addOrientation(-Math.PI / 2);
				Logger.Information(r, "DECISION_MOUVEMENT", "PleadCount: " + pleadCounter + ", heading " + "droite");
				return surrondings.get("droite");
				
			} else if (surrondings.containsKey("devant")) {
				Logger.Information(r, "DECISION_MOUVEMENT", "PleadCount: " + pleadCounter + ", heading " + "devant");
				return surrondings.get("devant");
				
			} else if (surrondings.containsKey("gauche")) {
				Logger.Information(r, "DECISION_MOUVEMENT", "PleadCount: " + pleadCounter + ", heading " + "gauche");
				pleadCounter += 1;
				r.addOrientation(Math.PI / 2);
				return surrondings.get("gauche");
			} else {
				Logger.Information(r, "pledge", "surrondings contains no point, no mvt possible");
			}
		} else {
			if (surrondings.containsKey("gauche")) {
				pleadCounter += 1;
				r.addOrientation(Math.PI / 2);
				Logger.Information(r, "DECISION_MOUVEMENT", "PleadCount: " + pleadCounter + ", heading " + "gauche");
				return surrondings.get("gauche");

			} else if (surrondings.containsKey("devant")) {
				Logger.Information(r, "DECISION_MOUVEMENT", "PleadCount: " + pleadCounter + ", heading " + "devant");
				return surrondings.get("devant");
				
			} else if (surrondings.containsKey("droite")) {
				Logger.Information(r, "DECISION_MOUVEMENT", "PleadCount: " + pleadCounter + ", heading " + "droite");
				pleadCounter -= 1;
				r.addOrientation(-Math.PI / 2);
				return surrondings.get("droite");
				
			} else {
				Logger.Information(r, "pledge", "surrondings contains no point, no mvt possible");
			}
		}
		
		return null;
	}
	// Fin Fonctions grille
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Point3D> dic_pledge() {
		
		HashMap<String, Point3D> dicPledge = new HashMap<String, Point3D>();
		
		List<String> list = Arrays.asList("gauche", "devant", "droite"); 
		
//		Point3D dir = ((Robot) getParent()).getDirection();
		
//		double rad = Math.toRadians(dir.getZ());
		
		double rad = ((Robot) getParent()).getOrientation();
		
		List<Point3D> pledge_points = Util.Pledge_point(rad);
		
		List<Wall> walls = (List<Wall>) (List<?>) getEngine()
				.requestSimObject(simo -> (simo instanceof Wall) && (((Wall) simo).getType() == 2 || ((Wall) simo).getType()==3));
		
		List<Bounds> bounds = new ArrayList<Bounds>();
		
		
		for (Wall w : walls) {
			bounds.addAll(w.getBounds());
		}
		
		
		
		for (int i=0; i<3;i++){
			
			Point3D p = pledge_points.get(i).add(Util.rectifi(positionR()));
			
			
			
			if (BorderAndPathGenerator.intervisibilityBetween(p, Util.rectifi(positionR()),bounds)){
				
				//System.out.println(list.get(i));
				//System.out.println(p.toString());
				
				dicPledge.put(list.get(i),p);
				
			}
			
		}
		
		
		return dicPledge;
	}
	
	public void extend_graph(){
		Robot r = (Robot) getParent();
		List<Point3D> accessibleZone = AcessibleZone();
		System.out.println( "Acessible zone size !!! "+Integer.toString(accessibleZone.size()));
		escapeGraph.addMultipleLane(positionR(), accessibleZone);
	}
	
	
}
