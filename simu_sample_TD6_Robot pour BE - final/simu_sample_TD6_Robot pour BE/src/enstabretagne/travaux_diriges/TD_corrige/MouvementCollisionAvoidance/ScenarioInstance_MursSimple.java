package enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance;

import java.util.ArrayList;
import java.util.List;

import enstabretagne.base.time.LogicalDateTime;
import enstabretagne.base.time.LogicalDuration;
import enstabretagne.simulation.components.ScenarioId;
import enstabretagne.simulation.core.IScenario;
import enstabretagne.simulation.core.IScenarioInstance;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Robot.RobotFeatures;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Robot.RobotInit;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Wall.WallFeatures;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Wall.WallInit;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.scenarios.ScenMvtCollisionAvoidance;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.scenarios.ScenMvtCollisionAvoidanceFeatures;
import javafx.geometry.Point3D;
import javafx.scene.paint.Color;

public class ScenarioInstance_MursSimple implements IScenarioInstance {

	@Override
	public IScenario getScenarioInstance(long seed) {
		ScenMvtCollisionAvoidanceFeatures mcaf = new ScenMvtCollisionAvoidanceFeatures("RbScen1");

		// Construction de l'environnement

		List<Point3D> lP;
		// Les objets qui sont des  murs extérieurs sont de type 2 
		// les autre mur type 3
		//le reste type 1 (ex: chaise)
		
		
		//Trac� du mur d'enceinte
		WallFeatures wf = new WallFeatures("RF", Color.ORANGE, 2, 0.15, 3);
		WallInit wi;
		lP = new ArrayList<>();
		lP.add(new Point3D(0, 0, 0));
		lP.add(new Point3D(0, 50, 0));
		lP.add(new Point3D(30, 50, 0));
		lP.add(new Point3D(30, 0, 0));
		lP.add(new Point3D(0, 0, 0));
		wi = new WallInit("Mur d'enceinte", new Point3D(0, 0, 0), Point3D.ZERO, lP);
		
		//Trac� du mur en zigzag
		WallFeatures wf2 = new WallFeatures("RF", Color.ORANGE, 3, 0.1, 2);
		WallInit wi2;
		lP = new ArrayList<>();
		lP.add(new Point3D(10, 11, 0));
		lP.add(new Point3D(15, 11, 0));
		lP.add(new Point3D(15, 16, 0));
		lP.add(new Point3D(20, 16, 0));
		lP.add(new Point3D(20, 21, 0));
		wi2 = new WallInit("Mur Zigzag", new Point3D(0, 0, 0), Point3D.ZERO, lP);
		
		//Trac� du mur entourant le robot ennemi
		WallInit wi3;
		lP = new ArrayList<>();
		lP.add(new Point3D(10, 45, 0));
		lP.add(new Point3D(10, 35, 0));
		lP.add(new Point3D(20, 35, 0));
		lP.add(new Point3D(20, 45, 0));
		wi3 = new WallInit("Mur carre", new Point3D(0, 0, 0), Point3D.ZERO, lP);
	
		//Ajout d'une table et deux chaises
		WallFeatures wf_obj_table = new WallFeatures("RF", Color.RED, 1, 2, 0.8);
		WallFeatures wf_obj_chaise = new WallFeatures("RF", Color.BLUE, 1, 1, 0.4);
		WallInit wi_obj1, wi_obj2, wi_obj3;
		List<Point3D> lT;
		lT = new ArrayList<>();
		lT.add(new Point3D(0, 0, 0));
		wi_obj1 = new WallInit("Table", new Point3D(15, 25, 0), Point3D.ZERO, lT);
		wi_obj2 = new WallInit("Chaise", new Point3D(9, 15, 0), Point3D.ZERO, lT);
		wi_obj3 = new WallInit("Chaise2", new Point3D(25, 12, 0), Point3D.ZERO, lT);
		
		/*//Ajout du sol (grand mur qu'on renverse)
		WallFeatures wf_sol_pair = new WallFeatures("RF", Color.GRAY.brighter(), 2, 0.01, 1);
		WallFeatures wf_sol_impair = new WallFeatures("RF", Color.BEIGE.brighter(), 2, 0.01, 1);
		for (int i=0; i<30; i++) {
			for (int j=0; j<50; j++) {
				WallInit wi_sol;
				lP = new ArrayList<>();
				lP.add(new Point3D(i, 0, j));
				lP.add(new Point3D(i+1, 0, j));
				int index = 50-i;
				wi_sol = new WallInit("carreau_"+index+'_'+j, new Point3D(0, 0, 0), new Point3D(90, 0, 0), lP);
				if (i%2==0)
					if (j%2==0)
						mcaf.getWalls().put(wi_sol, wf_sol_pair);
					else
						mcaf.getWalls().put(wi_sol, wf_sol_impair);
				else
					if (j%2==1)
						mcaf.getWalls().put(wi_sol, wf_sol_pair);
					else
						mcaf.getWalls().put(wi_sol, wf_sol_impair);
			}
		}*/
		
		
		//Ajout des �l�ments
		mcaf.getWalls().put(wi, wf);
		mcaf.getWalls().put(wi2, wf2);
		mcaf.getWalls().put(wi3, wf2);
		mcaf.getWalls().put(wi_obj1,wf_obj_table);
		mcaf.getWalls().put(wi_obj2,wf_obj_chaise);
		mcaf.getWalls().put(wi_obj3,wf_obj_chaise);


		// Cr�ation des robots
		// Cr�ation du robot gentil
		RobotFeatures rf = new RobotFeatures("RF", 5.0, 100.0, 1,2*Math.PI,15);
		RobotInit ri = new RobotInit("RI", Color.AQUA, new Point3D(1, 14, 1), new Point3D(0, 0, 0), false, new Point3D(20, 1, 0.5));

		// Cr�ation du robot m�chant
		RobotFeatures rfbad = new RobotFeatures("RF", 0, 0, 1, 2*Math.PI,15);
		RobotInit rb = new RobotInit("BadGuy", Color.MEDIUMVIOLETRED, new Point3D(15, 40, 0.5), new Point3D(0, 0, 90), true, Point3D.ZERO);
		
		//Ajout des robots � l'environnement
		mcaf.getRobots().put(ri, rf);
		mcaf.getRobots().put(rb, rfbad);

		// Initialisation du temps
		LogicalDateTime start = new LogicalDateTime("05/12/2017 06:00");
		LogicalDateTime end = start.add(LogicalDuration.ofMinutes(2));

		ScenMvtCollisionAvoidance scen = new ScenMvtCollisionAvoidance(new ScenarioId("Scen1"), mcaf, start, end);
		return scen;
	}

}