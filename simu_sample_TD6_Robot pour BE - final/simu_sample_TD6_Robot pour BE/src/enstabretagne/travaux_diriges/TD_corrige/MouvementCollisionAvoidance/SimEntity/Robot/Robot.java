package enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Robot;

import java.util.ArrayList;
import java.util.List;



import enstabretagne.base.logger.Logger;
import enstabretagne.base.time.LogicalDuration;
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
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.MouvementSequenceur.EntityMouvementSequenceurGood;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Robot.Representation3D.IRobot3D;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Vision.EntityVision;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Vision.EntityVisionBad;
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
	public RobotInit getrIni() {
		return rIni;
	}

	RobotFeatures rFeat;
	Point3D maPosition;
	
    double pv;
	double carburant;

	private EntityMouvementSequenceur rmv;
	private EntityVision rvd;

	private Point3D dir;// direction du mouvement
	private double orientation = 0.0;
	Point3D target;
	double speed;
	Rotate r;
	
	

	public void setTarget(Point3D target) {
		this.target = target;
		rmv.setTarget(target);
//		rIni.getMvtSeqIni().setTarget(target);
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
		orientation = rIni.getOrientation();
		pv = rIni.getPv();
		carburant = rIni.getCarburant();
		//le robot m�chant ne bouge pas
		if (rIni.isBad()){
			rmv = (EntityMouvementSequenceur) createChild(EntityMouvementSequenceur.class, "Mvt", rFeat.getEmsf());
			rvd = (EntityVision) createChild(EntityVisionBad.class,"Vid",rFeat.getEvf());
		}
		//les robots gentils peuvent se d�placer en utilisant le SequenceurExemple
		else {
			rmv = (EntityMouvementSequenceur) createChild(EntityMouvementSequenceurGood.class, "Mvt",
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

			
		}
		rvd.activate();
		rmv.activate();
	}

	Cylinder lineOfSight;

	public Cylinder getLineOfSight() {
		return lineOfSight;
	}

	//algorithme montrant un exemple pour trouver un objet pr�cis de la simulation et de v�rifier si on peut le voir
	//c'est � dire sans murs pour boucher la vue!
	
	


	
	public double getPv() {
		return pv;
	}

	public void setPv(double pv) {
		this.pv = pv;
	}
	
	public void decPv(double damage) {
		this.pv -= damage;
	}

	public double getCarburant() {
		return carburant;
	}
	
	public void  decCarburant(double loss) {
		carburant =  carburant - loss;
		Logger.Information(this, "AfterMouvement", "Carburant restant=" + carburant);
	}

	public void setCarburant(double carburant) {
		this.carburant = carburant;
	}

	


	public class StartMouvement extends SimEvent {

		@Override
		public void Process() {
			Post(((EntityMouvementSequenceurGood) rmv).new StartMvt(), getCurrentLogicalDate());	
		}
	}
	
	public class MouvementFinished extends SimEvent {

		@Override
		public void Process() {
			Post(((EntityVisionGood) rvd).new MouvementStrategie(), getCurrentLogicalDate().add(LogicalDuration.ofMillis(1)));
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

	public double getOrientation() {
		return orientation;
	}
	
	public void addOrientation(double angle) {
		setOrientation(getOrientation() + angle);
	}

	public void setOrientation(double orientation) {
		this.orientation = orientation;
	}

}