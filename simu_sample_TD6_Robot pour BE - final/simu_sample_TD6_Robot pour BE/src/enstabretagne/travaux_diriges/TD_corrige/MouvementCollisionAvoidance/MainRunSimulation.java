package enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance;


import enstabretagne.monitor.implementation.UniversalMonitor;

public class MainRunSimulation {

	public static void main(String[] args) {
		UniversalMonitor um = new UniversalMonitor();
		um.loadExperiencePlanFromSettings();
		um.runPlan();
		um.exit();
	}
}
