package enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Robot;

import java.util.List;

import enstabretagne.simulation.components.data.SimFeatures;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.MouvementSequenceur.EntityMouvementSequenceurFeature;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Vision.EntityVisionFeature;

public class RobotFeatures extends SimFeatures{

	private double vitesseMax;
	private double accelerationMax;
	private double rotationSpeedMax;
	private double taille;
	private double coneVision;
	private double distanceVision;
		
	private EntityMouvementSequenceurFeature emsf;
	private EntityVisionFeature evf;
	
	public EntityMouvementSequenceurFeature getEmsf() {
		return emsf;
	}
	
	public EntityVisionFeature getEvf(){
		return evf;
	}
	
	public double getVitesseMax() {
		return vitesseMax;
	}
	public double getRotationSpeedMax() {
		return rotationSpeedMax;
	}
	public double getTaille() {
		return taille;
	}
	public RobotFeatures(String id,
			double vitesseMax, 
			double rotationSpeedMax, 
			double taille,
			double coneVision,
			double distanceVision)
	{
		
		super(id);
		this.vitesseMax = vitesseMax;
		this.rotationSpeedMax = rotationSpeedMax;
		this.taille = taille;
		this.coneVision= coneVision;
		this.distanceVision = distanceVision;
		
		
		
		this.emsf = new EntityMouvementSequenceurFeature(
				"Sequenceur",
				vitesseMax,
				rotationSpeedMax);
		
		this.evf = new EntityVisionFeature("Vision",coneVision,distanceVision);
				
	}
	
	
	
}
