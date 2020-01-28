package enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Robot;

import java.util.ArrayList;
import java.util.List;



import enstabretagne.base.logger.Logger;
//import enstabretagne.base.time.LogicalDuration;
import enstabretagne.monitor.interfaces.IMovable;
import enstabretagne.simulation.components.IEntity;
import enstabretagne.simulation.components.data.SimFeatures;
import enstabretagne.simulation.components.data.SimInitParameters;
import enstabretagne.simulation.components.implementation.SimEntity;
import enstabretagne.simulation.core.ISimObject;
import enstabretagne.simulation.core.implementation.SimEvent;
//import enstabretagne.simulation.core.implementation.SimEvent;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.Expertise.BorderAndPathGenerator;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.MouvementSequenceur.EntityMouvementSequenceur;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.MouvementSequenceur.EntityMouvementSequenceurExemple;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Robot.Representation3D.IRobot3D;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Vision.EntityVision;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Vision.EntityVisionGood;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Vision.Util;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Wall.Wall;
import javafx.geometry.Bounds;
import javafx.geometry.Point3D;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import  java.lang.Math;
import de.vogella.algorithms.dijkstra.model.jfxmodel.DijkstraGraph;

public class Robot extends SimEntity implements IMovable, IRobot3D {
	RobotInit rIni;
	RobotFeatures rFeat;
	Point3D maPosition;
	DijkstraGraph map;

	private EntityMouvementSequenceur rmv;
	private EntityVision rvd;

	private Point3D dir;// direction du mouvement
	Point3D target;
	double speed;
	Rotate r;

	public void setTarget(Point3D target) {
		this.target = target;
	}
	
	@Override
	public Point3D getPosition() {
		return rmv.getPosition(getCurrentLogicalDate());
	}

	public Point3D getDirection() {
		return dir;
	}

	public void setDir(Point3D dir) {
		this.dir = dir;
	}

	@Override
	public Point3D getVitesse() {
		return rmv.getVitesse(getCurrentLogicalDate());
	}

	@Override
	public Point3D getAcceleration() {
		return rmv.getAcceleration(getCurrentLogicalDate());
	}

	@Override
	public Point3D getRotationXYZ() {
		return rmv.getRotationXYZ(getCurrentLogicalDate());
	}

	@Override
	public Point3D getVitesseRotationXYZ() {
		return rmv.getVitesseRotationXYZ(getCurrentLogicalDate());
	}

	@Override
	public Point3D getAccelerationRotationXYZ() {
		return rmv.getAccelerationRotationXYZ(getCurrentLogicalDate());
	}

	@Override
	public Color getColor() {
		return rIni.getCouleur();
	}

	@Override
	public double getSize() {
		return rFeat.getTaille();
	}

	@Override
	public int getType() {
		return 0;
	}

	@Override
	public boolean isBad() {
		return rIni.isBad();
	}

	public Robot(String name, SimFeatures features) {
		super(name, features);
		rFeat = (RobotFeatures) features;

		speed = rFeat.getVitesseMax();
	}

	@Override
	protected void initializeSimEntity(SimInitParameters init) {
		rIni = (RobotInit) getInitParameters();
		maPosition = rIni.getPosInit();
		map = new DijkstraGraph(maPosition);

		//le robot m�chant ne bouge pas
		if (rIni.isBad()){
			rmv = (EntityMouvementSequenceur) createChild(EntityMouvementSequenceur.class, "Mvt", rFeat.getEmsf());
			rvd = (EntityVision) createChild(EntityVision.class,"Vid",rFeat.getEvf());
		}
		//les robots gentils peuvent se d�placer en utilisant le SequenceurExemple
		else {
			rmv = (EntityMouvementSequenceur) createChild(EntityMouvementSequenceurExemple.class, "Mvt",
					rFeat.getEmsf());
			rvd = (EntityVision) createChild(EntityVisionGood.class,"Vid",rFeat.getEvf());
								
		}
		
		rvd.initialize(rIni.getVisionIni());
		rmv.initialize(rIni.getMvtSeqIni());
	}

	@Override
	protected void AfterActivate(IEntity sender, boolean starting) {
		Logger.Detail(this, "AfterActivate", "Activation du robot", "test");

		//seul le robot gentil cherche un autre robot et v�rifie s'il peut voir la table
		if (!isBad()) {
			List<ISimObject> l = getEngine().requestSimObject(simo -> (simo instanceof Robot) && (simo != this));
			for (ISimObject o : l)
				Logger.Information(this, "AfterActivate", "Robot trouv�=" + o.getName());

			Logger.Information(this, "AfterActivate", "Can see bad Robot ? " + canSeeBadRobot());

			rvd.activate();
		}
		rmv.activate();
	}

	Cylinder lineOfSight;

	public Cylinder getLineOfSight() {
		return lineOfSight;
	}

	//algorithme montrant un exemple pour trouver un objet pr�cis de la simulation et de v�rifier si on peut le voir
	//c'est � dire sans murs pour boucher la vue!
	
	

	@SuppressWarnings("unchecked")
	public boolean canSeeBadRobot() {
		
		//syntaxe complexe ci dessous: (List<Wall>) (List<?>) est une astuce pour caster les membres d'une liste
		//simo -> (xxxxx) est une lambda expression. C'est une mani�re tr�s compacte d'exprimer une functionnalinterface
		//au final on cherche uniquement des vrais murs (pas les objets de type table par exemple
		boolean isVisible= false;
		List<Wall> walls = (List<Wall>) (List<?>) getEngine()
				.requestSimObject(simo -> (simo instanceof Wall) && ((Wall) simo).getType() == 2);
		List<Bounds> bounds = new ArrayList<Bounds>();
		for (Wall w : walls) {
			bounds.addAll(w.getBounds());
		}

		//puis on cherche la table par son nom... c'est moche mais c'est pour l'exemple!
		Robot table = null;
		List<Robot> objets = (List<Robot>) (List<?>) getEngine().requestSimObject(simo -> (simo instanceof Robot) && (simo != this));
		if (objets.size() == 1) {
			table = objets.get(0);
			
			//on cr�e donc un cylindre entre les deux positions
			//on pourra afficher le cylindre dans la vue 3D
			lineOfSight = BorderAndPathGenerator.generateCylinderBetween(table.getPosition(), getPosition());
			lineOfSight.setMaterial(new PhongMaterial(Color.AQUA));

			//le robot gentil ne peut pas voire le mauvais robot à plus de 15m 
			if(lineOfSight.getHeight()<15){
				
				isVisible = BorderAndPathGenerator.intervisibilityBetween(table.getPosition(), getPosition(),bounds);
				
			}
			
			return isVisible;
		} else
			return false;

	}

//@SuppressWarnings("unchecked")
//	public boolean Vision() {
//		
//		//syntaxe complexe ci dessous: (List<Wall>) (List<?>) est une astuce pour caster les membres d'une liste
//		//simo -> (xxxxx) est une lambda expression. C'est une mani�re tr�s compacte d'exprimer une functionnalinterface
//		//au final on cherche uniquement des vrais murs (pas les objets de type table par exemple
//		List<Wall> walls = (List<Wall>) (List<?>) getEngine()
//				.requestSimObject(simo -> (simo instanceof Wall) && ((Wall) simo).getType() == 2);
//		List<Bounds> bounds = new ArrayList<Bounds>();
//		for (Wall w : walls) {
//			bounds.addAll(w.getBounds());
//		}
//
//	    return false;
//
//	}


	
//	@SuppressWarnings("unchecked")
//	public List<Point3D> AcessibleZone(){
//		
//		List<Point3D> zone =Zone();
//		List<Point3D> AcessibleZone =new ArrayList<Point3D>();
//		
//		
//		List<Wall> walls = (List<Wall>) (List<?>) getEngine()
//				.requestSimObject(simo -> (simo instanceof Wall) && ((Wall) simo).getType() == 2);
//		List<Bounds> bounds = new ArrayList<Bounds>();
//		
//		for (Wall w : walls) {
//			bounds.addAll(w.getBounds());
//		}
//		
//		for (Point3D p : zone) {
//			boolean isAcessible = BorderAndPathGenerator.intervisibilityBetween(p, Util.rectifi(getPosition()),
//					bounds);
//			if (isAcessible){
//				AcessibleZone.add(p);	
//			}	
//		}
//		return AcessibleZone;
//	}
	
	public class StartMouvement extends SimEvent {

		@Override
		public void Process() {
			// TODO Auto-generated method stub
			rIni.getMvtSeqIni().setTarget(target);
			Post(((EntityMouvementSequenceurExemple) rmv).new StartMvt(), getCurrentLogicalDate());	
		}
	}
	
	public class MouvementFinished extends SimEvent {

		@Override
		public void Process() {
			// TODO Auto-generated method stub
			
		}
	}
	

	@Override
	protected void BeforeDeactivating(IEntity sender, boolean starting) {
		rmv.deactivate();
		rvd.deactivate();
	}

	@Override
	protected void BeforeActivating(IEntity sender, boolean starting) {

	}

	@Override
	protected void AfterDeactivated(IEntity sender, boolean starting) {

	}

	@Override
	protected void AfterTerminated(IEntity sender, boolean restart) {
	}

	@Override
	public void onParentSet() {

	}

}