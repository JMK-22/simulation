package enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Robot.Representation3D;

import java.util.ArrayList;
import java.util.List;

import de.vogella.algorithms.dijkstra.model.jfxmodel.Point3DEdge;
import de.vogella.algorithms.dijkstra.model.jfxmodel.Point3DVertex;
import enstabretagne.monitor.Contrat3D;
import enstabretagne.monitor.ObjTo3DMappingSettings;
import enstabretagne.monitor.implementation.Representation3D;
import enstabretagne.monitor.implementation.XYZRotator2;
import enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.Expertise.BorderAndPathGenerator;
import javafx.geometry.Bounds;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Line;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

@Contrat3D(contrat = IRobot3D.class)
public class RobotRepresentation3D extends Representation3D{
	public RobotRepresentation3D(ObjTo3DMappingSettings settings) {
		super(settings);
	}

	IRobot3D robot3D;
	Group monRobot;
	Group myworld;
	@Override
	public void init(Group world, Object obj) {
		
		myworld = world;
		robot3D = (IRobot3D) obj;
		monRobot = new Group();
		
		
		
		PhongMaterial material;
		material = new PhongMaterial(robot3D.getColor());
		
		Box head = new Box(robot3D.getSize(), robot3D.getSize(), robot3D.getSize());
		head.setMaterial(material);
		head.setTranslateZ(robot3D.getSize()/2);
		monRobot.getChildren().add(head);
		
		Cylinder antenne1 = new Cylinder(robot3D.getSize()/7, robot3D.getSize()/3);
		antenne1.setMaterial(new PhongMaterial(Color.BLACK));
		antenne1.setRotationAxis(Rotate.X_AXIS);
		antenne1.setRotate(90);
		antenne1.setTranslateZ(robot3D.getSize()*7/6);
		antenne1.setTranslateY(robot3D.getSize()/4);
		antenne1.setTranslateX(robot3D.getSize()*2/5);
		monRobot.getChildren().add(antenne1);
		
		Cylinder antenne2 = new Cylinder(robot3D.getSize()/7, robot3D.getSize()/3);
		antenne2.setMaterial(new PhongMaterial(Color.BLACK));
		antenne2.setRotationAxis(Rotate.X_AXIS);
		antenne2.setRotate(90);
		antenne2.setTranslateZ(robot3D.getSize()*7/6);
		antenne2.setTranslateY(-robot3D.getSize()/4);
		antenne2.setTranslateX(robot3D.getSize()*2/5);
		monRobot.getChildren().add(antenne2);
		
		Cylinder bras1 = new Cylinder(robot3D.getSize()/5, robot3D.getSize()/3);
		bras1.setMaterial(new PhongMaterial(Color.BLUE));
		//bras1.setRotationAxis(Rotate.Z_AXIS);
		//bras1.setRotate(90);
		bras1.setTranslateZ(robot3D.getSize()/2);
		bras1.setTranslateY(robot3D.getSize()*2/3);
		monRobot.getChildren().add(bras1);
		
		Cylinder bras2 = new Cylinder(robot3D.getSize()/5, robot3D.getSize()/3);
		bras2.setMaterial(new PhongMaterial(Color.GREEN));
		//bras2.setRotationAxis(Rotate.Z_AXIS);
		//bras2.setRotate(90);
		bras2.setTranslateZ(robot3D.getSize()/2);
		bras2.setTranslateY(-robot3D.getSize()*2/3);
		monRobot.getChildren().add(bras2);
		
		Sphere sy1 = new Sphere(robot3D.getSize()/9);
		sy1.setTranslateX(robot3D.getSize()/2);
		sy1.setTranslateY(robot3D.getSize()/4);
		sy1.setTranslateZ(robot3D.getSize()*2/3);
		sy1.setMaterial(new PhongMaterial(Color.RED));
		monRobot.getChildren().add(sy1);
		
		Sphere sy2 = new Sphere(robot3D.getSize()/6);
		sy2.setTranslateX(robot3D.getSize()/2);
		sy2.setTranslateY(-robot3D.getSize()/4);
		sy2.setTranslateZ(robot3D.getSize()*2/3);
		sy2.setMaterial(new PhongMaterial(Color.RED));
		monRobot.getChildren().add(sy2);
		
		
		world.getChildren().add(monRobot);
	}
	
	@Override
	public void update() {
		
		Point3D p = robot3D.getPosition();

		monRobot.setTranslateX(p.getX());
		monRobot.setTranslateY(p.getY());
		monRobot.setTranslateZ(p.getZ());
		
		Point3D rot = robot3D.getRotationXYZ();
		
		Affine a = XYZRotator2.getTransformByAngle(rot);
		monRobot.getTransforms().setAll(a);
		
		Cylinder c=robot3D.getLineOfSight();
		if(c!=null)
			if(!myworld.getChildren().contains(c))
					myworld.getChildren().add(c);
		
	}
	
	
}

