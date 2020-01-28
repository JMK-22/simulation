package enstabretagne.travaux_diriges.TD_corrige.MouvementCollisionAvoidance.SimEntity.Vision;
import javafx.geometry.Point3D;
import  java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class Util {
	
	public static List<Point3D> MapVisionCircle (){
		
		List<Point3D> L = new ArrayList<Point3D>();
		
		for(int i = 0 ; i < 8; i++){
			
		
		  Point3D a = new Point3D(Math.cos((Math.PI/4)*i),Math.sin((Math.PI/4)*i),0);
		  for(int j = 1 ; j < 15 ; j++){
			  L.add(a.multiply(j));
		}
		  
		}
		
		return L;		
		
	}
	
 public static List<Point3D> RelativeZone(){
	 
	 List<Point3D> z = new ArrayList<Point3D>();
 
		
	 z.add(new Point3D(-15, 0, 0)); z.add(new Point3D(-14, -5, 0)); z.add(new Point3D(-14, -4, 0)); z.add(new Point3D(-14, -3, 0));
	 z.add(new Point3D(-14, -2, 0)); z.add(new Point3D(-14, -1, 0)); z.add(new Point3D(-14, 0, 0));
	 z.add(new Point3D(-14, 1, 0)); z.add(new Point3D(-14, 2, 0)); z.add(new Point3D(-14, 3, 0));
	 z.add(new Point3D(-14, 4, 0)); z.add(new Point3D(-14, 5, 0)); z.add(new Point3D(-13, -7, 0));
	 z.add(new Point3D(-13, -6, 0)); z.add(new Point3D(-13, -5, 0)); z.add(new Point3D(-13, -4, 0));
	 z.add(new Point3D(-13, -3, 0)); z.add(new Point3D(-13, -2, 0)); z.add(new Point3D(-13, -1, 0));
	 z.add(new Point3D(-13, 0, 0)); z.add(new Point3D(-13, 1, 0)); z.add(new Point3D(-13, 2, 0));
	 z.add(new Point3D(-13, 3, 0)); z.add(new Point3D(-13, 4, 0)); z.add(new Point3D(-13, 5, 0));
	 z.add(new Point3D(-13, 6, 0)); z.add(new Point3D(-13, 7, 0)); z.add(new Point3D(-12, -9, 0));
	 z.add(new Point3D(-12, -8, 0)); z.add(new Point3D(-12, -7, 0)); z.add(new Point3D(-12, -6, 0));
	 z.add(new Point3D(-12, -5, 0)); z.add(new Point3D(-12, -4, 0)); z.add(new Point3D(-12, -3, 0));
	 z.add(new Point3D(-12, -2, 0)); z.add(new Point3D(-12, -1, 0)); z.add(new Point3D(-12, 0, 0));
	 z.add(new Point3D(-12, 1, 0)); z.add(new Point3D(-12, 2, 0)); z.add(new Point3D(-12, 3, 0));
	 z.add(new Point3D(-12, 4, 0)); z.add(new Point3D(-12, 5, 0)); z.add(new Point3D(-12, 6, 0));
	 z.add(new Point3D(-12, 7, 0)); z.add(new Point3D(-12, 8, 0)); z.add(new Point3D(-12, 9, 0));
	 z.add(new Point3D(-11, -10, 0)); z.add(new Point3D(-11, -9, 0)); z.add(new Point3D(-11, -8, 0));
	 z.add(new Point3D(-11, -7, 0)); z.add(new Point3D(-11, -6, 0)); z.add(new Point3D(-11, -5, 0));
	 z.add(new Point3D(-11, -4, 0)); z.add(new Point3D(-11, -3, 0)); z.add(new Point3D(-11, -2, 0));
	 z.add(new Point3D(-11, -1, 0)); z.add(new Point3D(-11, 0, 0)); z.add(new Point3D(-11, 1, 0));
	 z.add(new Point3D(-11, 2, 0)); z.add(new Point3D(-11, 3, 0)); z.add(new Point3D(-11, 4, 0));
	 z.add(new Point3D(-11, 5, 0)); z.add(new Point3D(-11, 6, 0)); z.add(new Point3D(-11, 7, 0));
	 z.add(new Point3D(-11, 8, 0)); z.add(new Point3D(-11, 9, 0)); z.add(new Point3D(-11, 10, 0));
	 z.add(new Point3D(-10, -11, 0)); z.add(new Point3D(-10, -10, 0)); z.add(new Point3D(-10, -9, 0));
	 z.add(new Point3D(-10, -8, 0)); z.add(new Point3D(-10, -7, 0)); z.add(new Point3D(-10, -6, 0));
	 z.add(new Point3D(-10, -5, 0)); z.add(new Point3D(-10, -4, 0)); z.add(new Point3D(-10, -3, 0));
	 z.add(new Point3D(-10, -2, 0)); z.add(new Point3D(-10, -1, 0)); z.add(new Point3D(-10, 0, 0));
	 z.add(new Point3D(-10, 1, 0)); z.add(new Point3D(-10, 2, 0)); z.add(new Point3D(-10, 3, 0));
	 z.add(new Point3D(-10, 4, 0)); z.add(new Point3D(-10, 5, 0)); z.add(new Point3D(-10, 6, 0));
	 z.add(new Point3D(-10, 7, 0)); z.add(new Point3D(-10, 8, 0)); z.add(new Point3D(-10, 9, 0));
	 z.add(new Point3D(-10, 10, 0)); z.add(new Point3D(-10, 11, 0)); z.add(new Point3D(-9, -12, 0));
	 z.add(new Point3D(-9, -11, 0)); z.add(new Point3D(-9, -10, 0)); z.add(new Point3D(-9, -9, 0));
	 z.add(new Point3D(-9, -8, 0)); z.add(new Point3D(-9, -7, 0)); z.add(new Point3D(-9, -6, 0));
	 z.add(new Point3D(-9, -5, 0)); z.add(new Point3D(-9, -4, 0)); z.add(new Point3D(-9, -3, 0));
	 z.add(new Point3D(-9, -2, 0)); z.add(new Point3D(-9, -1, 0)); z.add(new Point3D(-9, 0, 0));
	 z.add(new Point3D(-9, 1, 0)); z.add(new Point3D(-9, 2, 0)); z.add(new Point3D(-9, 3, 0));
	 z.add(new Point3D(-9, 4, 0)); z.add(new Point3D(-9, 5, 0)); z.add(new Point3D(-9, 6, 0));
	 z.add(new Point3D(-9, 7, 0)); z.add(new Point3D(-9, 8, 0)); z.add(new Point3D(-9, 9, 0));
	 z.add(new Point3D(-9, 10, 0)); z.add(new Point3D(-9, 11, 0)); z.add(new Point3D(-9, 12, 0));
	 z.add(new Point3D(-8, -12, 0)); z.add(new Point3D(-8, -11, 0)); z.add(new Point3D(-8, -10, 0));
	 z.add(new Point3D(-8, -9, 0)); z.add(new Point3D(-8, -8, 0)); z.add(new Point3D(-8, -7, 0));
	 z.add(new Point3D(-8, -6, 0)); z.add(new Point3D(-8, -5, 0)); z.add(new Point3D(-8, -4, 0));
	 z.add(new Point3D(-8, -3, 0)); z.add(new Point3D(-8, -2, 0)); z.add(new Point3D(-8, -1, 0));
	 z.add(new Point3D(-8, 0, 0)); z.add(new Point3D(-8, 1, 0)); z.add(new Point3D(-8, 2, 0));
	 z.add(new Point3D(-8, 3, 0)); z.add(new Point3D(-8, 4, 0)); z.add(new Point3D(-8, 5, 0));
	 z.add(new Point3D(-8, 6, 0)); z.add(new Point3D(-8, 7, 0)); z.add(new Point3D(-8, 8, 0));
	 z.add(new Point3D(-8, 9, 0)); z.add(new Point3D(-8, 10, 0)); z.add(new Point3D(-8, 11, 0));
	 z.add(new Point3D(-8, 12, 0)); z.add(new Point3D(-7, -13, 0)); z.add(new Point3D(-7, -12, 0));
	 z.add(new Point3D(-7, -11, 0)); z.add(new Point3D(-7, -10, 0)); z.add(new Point3D(-7, -9, 0));
	 z.add(new Point3D(-7, -8, 0)); z.add(new Point3D(-7, -7, 0)); z.add(new Point3D(-7, -6, 0));
	 z.add(new Point3D(-7, -5, 0)); z.add(new Point3D(-7, -4, 0)); z.add(new Point3D(-7, -3, 0));
	 z.add(new Point3D(-7, -2, 0)); z.add(new Point3D(-7, -1, 0)); z.add(new Point3D(-7, 0, 0));
	 z.add(new Point3D(-7, 1, 0)); z.add(new Point3D(-7, 2, 0)); z.add(new Point3D(-7, 3, 0));
	 z.add(new Point3D(-7, 4, 0)); z.add(new Point3D(-7, 5, 0)); z.add(new Point3D(-7, 6, 0));
	 z.add(new Point3D(-7, 7, 0)); z.add(new Point3D(-7, 8, 0)); z.add(new Point3D(-7, 9, 0));
	 z.add(new Point3D(-7, 10, 0)); z.add(new Point3D(-7, 11, 0)); z.add(new Point3D(-7, 12, 0));
	 z.add(new Point3D(-7, 13, 0)); z.add(new Point3D(-6, -13, 0)); z.add(new Point3D(-6, -12, 0));
	 z.add(new Point3D(-6, -11, 0)); z.add(new Point3D(-6, -10, 0)); z.add(new Point3D(-6, -9, 0));
	 z.add(new Point3D(-6, -8, 0)); z.add(new Point3D(-6, -7, 0)); z.add(new Point3D(-6, -6, 0));
	 z.add(new Point3D(-6, -5, 0)); z.add(new Point3D(-6, -4, 0)); z.add(new Point3D(-6, -3, 0));
	 z.add(new Point3D(-6, -2, 0)); z.add(new Point3D(-6, -1, 0)); z.add(new Point3D(-6, 0, 0));
	 z.add(new Point3D(-6, 1, 0)); z.add(new Point3D(-6, 2, 0)); z.add(new Point3D(-6, 3, 0));
	 z.add(new Point3D(-6, 4, 0)); z.add(new Point3D(-6, 5, 0)); z.add(new Point3D(-6, 6, 0));
	 z.add(new Point3D(-6, 7, 0)); z.add(new Point3D(-6, 8, 0)); z.add(new Point3D(-6, 9, 0));
	 z.add(new Point3D(-6, 10, 0)); z.add(new Point3D(-6, 11, 0)); z.add(new Point3D(-6, 12, 0));
	 z.add(new Point3D(-6, 13, 0)); z.add(new Point3D(-5, -14, 0)); z.add(new Point3D(-5, -13, 0));
	 z.add(new Point3D(-5, -12, 0)); z.add(new Point3D(-5, -11, 0)); z.add(new Point3D(-5, -10, 0));
	 z.add(new Point3D(-5, -9, 0)); z.add(new Point3D(-5, -8, 0)); z.add(new Point3D(-5, -7, 0));
	 z.add(new Point3D(-5, -6, 0)); z.add(new Point3D(-5, -5, 0)); z.add(new Point3D(-5, -4, 0));
	 z.add(new Point3D(-5, -3, 0)); z.add(new Point3D(-5, -2, 0)); z.add(new Point3D(-5, -1, 0));
	 z.add(new Point3D(-5, 0, 0)); z.add(new Point3D(-5, 1, 0)); z.add(new Point3D(-5, 2, 0));
	 z.add(new Point3D(-5, 3, 0)); z.add(new Point3D(-5, 4, 0)); z.add(new Point3D(-5, 5, 0));
	 z.add(new Point3D(-5, 6, 0)); z.add(new Point3D(-5, 7, 0)); z.add(new Point3D(-5, 8, 0));
	 z.add(new Point3D(-5, 9, 0)); z.add(new Point3D(-5, 10, 0)); z.add(new Point3D(-5, 11, 0));
	 z.add(new Point3D(-5, 12, 0)); z.add(new Point3D(-5, 13, 0)); z.add(new Point3D(-5, 14, 0));
	 z.add(new Point3D(-4, -14, 0)); z.add(new Point3D(-4, -13, 0)); z.add(new Point3D(-4, -12, 0));
	 z.add(new Point3D(-4, -11, 0)); z.add(new Point3D(-4, -10, 0)); z.add(new Point3D(-4, -9, 0));
	 z.add(new Point3D(-4, -8, 0)); z.add(new Point3D(-4, -7, 0)); z.add(new Point3D(-4, -6, 0));
	 z.add(new Point3D(-4, -5, 0)); z.add(new Point3D(-4, -4, 0)); z.add(new Point3D(-4, -3, 0));
	 z.add(new Point3D(-4, -2, 0)); z.add(new Point3D(-4, -1, 0)); z.add(new Point3D(-4, 0, 0));
	 z.add(new Point3D(-4, 1, 0)); z.add(new Point3D(-4, 2, 0)); z.add(new Point3D(-4, 3, 0));
	 z.add(new Point3D(-4, 4, 0)); z.add(new Point3D(-4, 5, 0)); z.add(new Point3D(-4, 6, 0));
	 z.add(new Point3D(-4, 7, 0)); z.add(new Point3D(-4, 8, 0)); z.add(new Point3D(-4, 9, 0));
	 z.add(new Point3D(-4, 10, 0)); z.add(new Point3D(-4, 11, 0)); z.add(new Point3D(-4, 12, 0));
	 z.add(new Point3D(-4, 13, 0)); z.add(new Point3D(-4, 14, 0)); z.add(new Point3D(-3, -14, 0));
	 z.add(new Point3D(-3, -13, 0)); z.add(new Point3D(-3, -12, 0)); z.add(new Point3D(-3, -11, 0));
	 z.add(new Point3D(-3, -10, 0)); z.add(new Point3D(-3, -9, 0)); z.add(new Point3D(-3, -8, 0));
	 z.add(new Point3D(-3, -7, 0)); z.add(new Point3D(-3, -6, 0)); z.add(new Point3D(-3, -5, 0));
	 z.add(new Point3D(-3, -4, 0)); z.add(new Point3D(-3, -3, 0)); z.add(new Point3D(-3, -2, 0));
	 z.add(new Point3D(-3, -1, 0)); z.add(new Point3D(-3, 0, 0)); z.add(new Point3D(-3, 1, 0));
	 z.add(new Point3D(-3, 2, 0)); z.add(new Point3D(-3, 3, 0)); z.add(new Point3D(-3, 4, 0));
	 z.add(new Point3D(-3, 5, 0)); z.add(new Point3D(-3, 6, 0)); z.add(new Point3D(-3, 7, 0));
	 z.add(new Point3D(-3, 8, 0)); z.add(new Point3D(-3, 9, 0)); z.add(new Point3D(-3, 10, 0));
	 z.add(new Point3D(-3, 11, 0)); z.add(new Point3D(-3, 12, 0)); z.add(new Point3D(-3, 13, 0));
	 z.add(new Point3D(-3, 14, 0)); z.add(new Point3D(-2, -14, 0)); z.add(new Point3D(-2, -13, 0));
	 z.add(new Point3D(-2, -12, 0)); z.add(new Point3D(-2, -11, 0)); z.add(new Point3D(-2, -10, 0));
	 z.add(new Point3D(-2, -9, 0)); z.add(new Point3D(-2, -8, 0)); z.add(new Point3D(-2, -7, 0));
	 z.add(new Point3D(-2, -6, 0)); z.add(new Point3D(-2, -5, 0)); z.add(new Point3D(-2, -4, 0));
	 z.add(new Point3D(-2, -3, 0)); z.add(new Point3D(-2, -2, 0)); z.add(new Point3D(-2, -1, 0));
	 z.add(new Point3D(-2, 0, 0)); z.add(new Point3D(-2, 1, 0)); z.add(new Point3D(-2, 2, 0));
	 z.add(new Point3D(-2, 3, 0)); z.add(new Point3D(-2, 4, 0)); z.add(new Point3D(-2, 5, 0));
	 z.add(new Point3D(-2, 6, 0)); z.add(new Point3D(-2, 7, 0)); z.add(new Point3D(-2, 8, 0));
	 z.add(new Point3D(-2, 9, 0)); z.add(new Point3D(-2, 10, 0)); z.add(new Point3D(-2, 11, 0));
	 z.add(new Point3D(-2, 12, 0)); z.add(new Point3D(-2, 13, 0)); z.add(new Point3D(-2, 14, 0));
	 z.add(new Point3D(-1, -14, 0)); z.add(new Point3D(-1, -13, 0)); z.add(new Point3D(-1, -12, 0));
	 z.add(new Point3D(-1, -11, 0)); z.add(new Point3D(-1, -10, 0)); z.add(new Point3D(-1, -9, 0));
	 z.add(new Point3D(-1, -8, 0)); z.add(new Point3D(-1, -7, 0)); z.add(new Point3D(-1, -6, 0));
	 z.add(new Point3D(-1, -5, 0)); z.add(new Point3D(-1, -4, 0)); z.add(new Point3D(-1, -3, 0));
	 z.add(new Point3D(-1, -2, 0)); z.add(new Point3D(-1, -1, 0)); z.add(new Point3D(-1, 0, 0));
	 z.add(new Point3D(-1, 1, 0)); z.add(new Point3D(-1, 2, 0)); z.add(new Point3D(-1, 3, 0));
	 z.add(new Point3D(-1, 4, 0)); z.add(new Point3D(-1, 5, 0)); z.add(new Point3D(-1, 6, 0));
	 z.add(new Point3D(-1, 7, 0)); z.add(new Point3D(-1, 8, 0)); z.add(new Point3D(-1, 9, 0));
	 z.add(new Point3D(-1, 10, 0)); z.add(new Point3D(-1, 11, 0)); z.add(new Point3D(-1, 12, 0));
	 z.add(new Point3D(-1, 13, 0)); z.add(new Point3D(-1, 14, 0)); z.add(new Point3D(0, -15, 0));
	 z.add(new Point3D(0, -14, 0)); z.add(new Point3D(0, -13, 0)); z.add(new Point3D(0, -12, 0));
	 z.add(new Point3D(0, -11, 0)); z.add(new Point3D(0, -10, 0)); z.add(new Point3D(0, -9, 0));
	 z.add(new Point3D(0, -8, 0)); z.add(new Point3D(0, -7, 0)); z.add(new Point3D(0, -6, 0));
	 z.add(new Point3D(0, -5, 0)); z.add(new Point3D(0, -4, 0)); z.add(new Point3D(0, -3, 0));
	 z.add(new Point3D(0, -2, 0)); z.add(new Point3D(0, -1, 0)); z.add(new Point3D(0, 0, 0));
	 z.add(new Point3D(0, 1, 0)); z.add(new Point3D(0, 2, 0)); z.add(new Point3D(0, 3, 0));
	 z.add(new Point3D(0, 4, 0)); z.add(new Point3D(0, 5, 0)); z.add(new Point3D(0, 6, 0));
	 z.add(new Point3D(0, 7, 0)); z.add(new Point3D(0, 8, 0)); z.add(new Point3D(0, 9, 0));
	 z.add(new Point3D(0, 10, 0)); z.add(new Point3D(0, 11, 0)); z.add(new Point3D(0, 12, 0));
	 z.add(new Point3D(0, 13, 0)); z.add(new Point3D(0, 14, 0)); z.add(new Point3D(1, -14, 0));
	 z.add(new Point3D(1, -13, 0)); z.add(new Point3D(1, -12, 0)); z.add(new Point3D(1, -11, 0));
	 z.add(new Point3D(1, -10, 0)); z.add(new Point3D(1, -9, 0)); z.add(new Point3D(1, -8, 0));
	 z.add(new Point3D(1, -7, 0)); z.add(new Point3D(1, -6, 0)); z.add(new Point3D(1, -5, 0));
	 z.add(new Point3D(1, -4, 0)); z.add(new Point3D(1, -3, 0)); z.add(new Point3D(1, -2, 0));
	 z.add(new Point3D(1, -1, 0)); z.add(new Point3D(1, 0, 0)); z.add(new Point3D(1, 1, 0));
	 z.add(new Point3D(1, 2, 0)); z.add(new Point3D(1, 3, 0)); z.add(new Point3D(1, 4, 0));
	 z.add(new Point3D(1, 5, 0)); z.add(new Point3D(1, 6, 0)); z.add(new Point3D(1, 7, 0));
	 z.add(new Point3D(1, 8, 0)); z.add(new Point3D(1, 9, 0)); z.add(new Point3D(1, 10, 0));
	 z.add(new Point3D(1, 11, 0)); z.add(new Point3D(1, 12, 0)); z.add(new Point3D(1, 13, 0));
	 z.add(new Point3D(1, 14, 0)); z.add(new Point3D(2, -14, 0)); z.add(new Point3D(2, -13, 0));
	 z.add(new Point3D(2, -12, 0)); z.add(new Point3D(2, -11, 0)); z.add(new Point3D(2, -10, 0));
	 z.add(new Point3D(2, -9, 0)); z.add(new Point3D(2, -8, 0)); z.add(new Point3D(2, -7, 0));
	 z.add(new Point3D(2, -6, 0)); z.add(new Point3D(2, -5, 0)); z.add(new Point3D(2, -4, 0));
	 z.add(new Point3D(2, -3, 0)); z.add(new Point3D(2, -2, 0)); z.add(new Point3D(2, -1, 0));
	 z.add(new Point3D(2, 0, 0)); z.add(new Point3D(2, 1, 0)); z.add(new Point3D(2, 2, 0));
	 z.add(new Point3D(2, 3, 0)); z.add(new Point3D(2, 4, 0)); z.add(new Point3D(2, 5, 0));
	 z.add(new Point3D(2, 6, 0)); z.add(new Point3D(2, 7, 0)); z.add(new Point3D(2, 8, 0));
	 z.add(new Point3D(2, 9, 0)); z.add(new Point3D(2, 10, 0)); z.add(new Point3D(2, 11, 0));
	 z.add(new Point3D(2, 12, 0)); z.add(new Point3D(2, 13, 0)); z.add(new Point3D(2, 14, 0));
	 z.add(new Point3D(3, -14, 0)); z.add(new Point3D(3, -13, 0)); z.add(new Point3D(3, -12, 0));
	 z.add(new Point3D(3, -11, 0)); z.add(new Point3D(3, -10, 0)); z.add(new Point3D(3, -9, 0));
	 z.add(new Point3D(3, -8, 0)); z.add(new Point3D(3, -7, 0)); z.add(new Point3D(3, -6, 0));
	 z.add(new Point3D(3, -5, 0)); z.add(new Point3D(3, -4, 0)); z.add(new Point3D(3, -3, 0));
	 z.add(new Point3D(3, -2, 0)); z.add(new Point3D(3, -1, 0)); z.add(new Point3D(3, 0, 0));
	 z.add(new Point3D(3, 1, 0)); z.add(new Point3D(3, 2, 0)); z.add(new Point3D(3, 3, 0));
	 z.add(new Point3D(3, 4, 0)); z.add(new Point3D(3, 5, 0)); z.add(new Point3D(3, 6, 0));
	 z.add(new Point3D(3, 7, 0)); z.add(new Point3D(3, 8, 0)); z.add(new Point3D(3, 9, 0));
	 z.add(new Point3D(3, 10, 0)); z.add(new Point3D(3, 11, 0)); z.add(new Point3D(3, 12, 0));
	 z.add(new Point3D(3, 13, 0)); z.add(new Point3D(3, 14, 0)); z.add(new Point3D(4, -14, 0));
	 z.add(new Point3D(4, -13, 0)); z.add(new Point3D(4, -12, 0)); z.add(new Point3D(4, -11, 0));
	 z.add(new Point3D(4, -10, 0)); z.add(new Point3D(4, -9, 0)); z.add(new Point3D(4, -8, 0));
	 z.add(new Point3D(4, -7, 0)); z.add(new Point3D(4, -6, 0)); z.add(new Point3D(4, -5, 0));
	 z.add(new Point3D(4, -4, 0)); z.add(new Point3D(4, -3, 0)); z.add(new Point3D(4, -2, 0));
	 z.add(new Point3D(4, -1, 0)); z.add(new Point3D(4, 0, 0)); z.add(new Point3D(4, 1, 0));
	 z.add(new Point3D(4, 2, 0)); z.add(new Point3D(4, 3, 0)); z.add(new Point3D(4, 4, 0));
	 z.add(new Point3D(4, 5, 0)); z.add(new Point3D(4, 6, 0)); z.add(new Point3D(4, 7, 0));
	 z.add(new Point3D(4, 8, 0)); z.add(new Point3D(4, 9, 0)); z.add(new Point3D(4, 10, 0));
	 z.add(new Point3D(4, 11, 0)); z.add(new Point3D(4, 12, 0)); z.add(new Point3D(4, 13, 0));
	 z.add(new Point3D(4, 14, 0)); z.add(new Point3D(5, -14, 0)); z.add(new Point3D(5, -13, 0));
	 z.add(new Point3D(5, -12, 0)); z.add(new Point3D(5, -11, 0)); z.add(new Point3D(5, -10, 0));
	 z.add(new Point3D(5, -9, 0)); z.add(new Point3D(5, -8, 0)); z.add(new Point3D(5, -7, 0));
	 z.add(new Point3D(5, -6, 0)); z.add(new Point3D(5, -5, 0)); z.add(new Point3D(5, -4, 0));
	 z.add(new Point3D(5, -3, 0)); z.add(new Point3D(5, -2, 0)); z.add(new Point3D(5, -1, 0));
	 z.add(new Point3D(5, 0, 0)); z.add(new Point3D(5, 1, 0)); z.add(new Point3D(5, 2, 0));
	 z.add(new Point3D(5, 3, 0)); z.add(new Point3D(5, 4, 0)); z.add(new Point3D(5, 5, 0));
	 z.add(new Point3D(5, 6, 0)); z.add(new Point3D(5, 7, 0)); z.add(new Point3D(5, 8, 0));
	 z.add(new Point3D(5, 9, 0)); z.add(new Point3D(5, 10, 0)); z.add(new Point3D(5, 11, 0));
	 z.add(new Point3D(5, 12, 0)); z.add(new Point3D(5, 13, 0)); z.add(new Point3D(5, 14, 0));
	 z.add(new Point3D(6, -13, 0)); z.add(new Point3D(6, -12, 0)); z.add(new Point3D(6, -11, 0));
	 z.add(new Point3D(6, -10, 0)); z.add(new Point3D(6, -9, 0)); z.add(new Point3D(6, -8, 0));
	 z.add(new Point3D(6, -7, 0)); z.add(new Point3D(6, -6, 0)); z.add(new Point3D(6, -5, 0));
	 z.add(new Point3D(6, -4, 0)); z.add(new Point3D(6, -3, 0)); z.add(new Point3D(6, -2, 0));
	 z.add(new Point3D(6, -1, 0)); z.add(new Point3D(6, 0, 0)); z.add(new Point3D(6, 1, 0));
	 z.add(new Point3D(6, 2, 0)); z.add(new Point3D(6, 3, 0)); z.add(new Point3D(6, 4, 0));
	 z.add(new Point3D(6, 5, 0)); z.add(new Point3D(6, 6, 0)); z.add(new Point3D(6, 7, 0));
	 z.add(new Point3D(6, 8, 0)); z.add(new Point3D(6, 9, 0)); z.add(new Point3D(6, 10, 0));
	 z.add(new Point3D(6, 11, 0)); z.add(new Point3D(6, 12, 0)); z.add(new Point3D(6, 13, 0));
	 z.add(new Point3D(7, -13, 0)); z.add(new Point3D(7, -12, 0)); z.add(new Point3D(7, -11, 0));
	 z.add(new Point3D(7, -10, 0)); z.add(new Point3D(7, -9, 0)); z.add(new Point3D(7, -8, 0));
	 z.add(new Point3D(7, -7, 0)); z.add(new Point3D(7, -6, 0)); z.add(new Point3D(7, -5, 0));
	 z.add(new Point3D(7, -4, 0)); z.add(new Point3D(7, -3, 0)); z.add(new Point3D(7, -2, 0));
	 z.add(new Point3D(7, -1, 0)); z.add(new Point3D(7, 0, 0)); z.add(new Point3D(7, 1, 0));
	 z.add(new Point3D(7, 2, 0)); z.add(new Point3D(7, 3, 0)); z.add(new Point3D(7, 4, 0));
	 z.add(new Point3D(7, 5, 0)); z.add(new Point3D(7, 6, 0)); z.add(new Point3D(7, 7, 0));
	 z.add(new Point3D(7, 8, 0)); z.add(new Point3D(7, 9, 0)); z.add(new Point3D(7, 10, 0));
	 z.add(new Point3D(7, 11, 0)); z.add(new Point3D(7, 12, 0)); z.add(new Point3D(7, 13, 0));
	 z.add(new Point3D(8, -12, 0)); z.add(new Point3D(8, -11, 0)); z.add(new Point3D(8, -10, 0));
	 z.add(new Point3D(8, -9, 0)); z.add(new Point3D(8, -8, 0)); z.add(new Point3D(8, -7, 0));
	 z.add(new Point3D(8, -6, 0)); z.add(new Point3D(8, -5, 0)); z.add(new Point3D(8, -4, 0));
	 z.add(new Point3D(8, -3, 0)); z.add(new Point3D(8, -2, 0)); z.add(new Point3D(8, -1, 0));
	 z.add(new Point3D(8, 0, 0)); z.add(new Point3D(8, 1, 0)); z.add(new Point3D(8, 2, 0));
	 z.add(new Point3D(8, 3, 0)); z.add(new Point3D(8, 4, 0)); z.add(new Point3D(8, 5, 0));
	 z.add(new Point3D(8, 6, 0)); z.add(new Point3D(8, 7, 0)); z.add(new Point3D(8, 8, 0));
	 z.add(new Point3D(8, 9, 0)); z.add(new Point3D(8, 10, 0)); z.add(new Point3D(8, 11, 0));
	 z.add(new Point3D(8, 12, 0)); z.add(new Point3D(9, -12, 0)); z.add(new Point3D(9, -11, 0));
	 z.add(new Point3D(9, -10, 0)); z.add(new Point3D(9, -9, 0)); z.add(new Point3D(9, -8, 0));
	 z.add(new Point3D(9, -7, 0)); z.add(new Point3D(9, -6, 0)); z.add(new Point3D(9, -5, 0));
	 z.add(new Point3D(9, -4, 0)); z.add(new Point3D(9, -3, 0)); z.add(new Point3D(9, -2, 0));
	 z.add(new Point3D(9, -1, 0)); z.add(new Point3D(9, 0, 0)); z.add(new Point3D(9, 1, 0));
	 z.add(new Point3D(9, 2, 0)); z.add(new Point3D(9, 3, 0)); z.add(new Point3D(9, 4, 0));
	 z.add(new Point3D(9, 5, 0)); z.add(new Point3D(9, 6, 0)); z.add(new Point3D(9, 7, 0));
	 z.add(new Point3D(9, 8, 0)); z.add(new Point3D(9, 9, 0)); z.add(new Point3D(9, 10, 0));
	 z.add(new Point3D(9, 11, 0)); z.add(new Point3D(9, 12, 0)); z.add(new Point3D(10, -11, 0));
	 z.add(new Point3D(10, -10, 0)); z.add(new Point3D(10, -9, 0)); z.add(new Point3D(10, -8, 0));
	 z.add(new Point3D(10, -7, 0)); z.add(new Point3D(10, -6, 0)); z.add(new Point3D(10, -5, 0));
	 z.add(new Point3D(10, -4, 0)); z.add(new Point3D(10, -3, 0)); z.add(new Point3D(10, -2, 0));
	 z.add(new Point3D(10, -1, 0)); z.add(new Point3D(10, 0, 0)); z.add(new Point3D(10, 1, 0));
	 z.add(new Point3D(10, 2, 0)); z.add(new Point3D(10, 3, 0)); z.add(new Point3D(10, 4, 0));
	 z.add(new Point3D(10, 5, 0)); z.add(new Point3D(10, 6, 0)); z.add(new Point3D(10, 7, 0));
	 z.add(new Point3D(10, 8, 0)); z.add(new Point3D(10, 9, 0)); z.add(new Point3D(10, 10, 0));
	 z.add(new Point3D(10, 11, 0)); z.add(new Point3D(11, -10, 0)); z.add(new Point3D(11, -9, 0));
	 z.add(new Point3D(11, -8, 0)); z.add(new Point3D(11, -7, 0)); z.add(new Point3D(11, -6, 0));
	 z.add(new Point3D(11, -5, 0)); z.add(new Point3D(11, -4, 0)); z.add(new Point3D(11, -3, 0));
	 z.add(new Point3D(11, -2, 0)); z.add(new Point3D(11, -1, 0)); z.add(new Point3D(11, 0, 0));
	 z.add(new Point3D(11, 1, 0)); z.add(new Point3D(11, 2, 0)); z.add(new Point3D(11, 3, 0));
	 z.add(new Point3D(11, 4, 0)); z.add(new Point3D(11, 5, 0)); z.add(new Point3D(11, 6, 0));
	 z.add(new Point3D(11, 7, 0)); z.add(new Point3D(11, 8, 0)); z.add(new Point3D(11, 9, 0));
	 z.add(new Point3D(11, 10, 0)); z.add(new Point3D(12, -9, 0)); z.add(new Point3D(12, -8, 0));
	 z.add(new Point3D(12, -7, 0)); z.add(new Point3D(12, -6, 0)); z.add(new Point3D(12, -5, 0));
	 z.add(new Point3D(12, -4, 0)); z.add(new Point3D(12, -3, 0)); z.add(new Point3D(12, -2, 0));
	 z.add(new Point3D(12, -1, 0)); z.add(new Point3D(12, 0, 0)); z.add(new Point3D(12, 1, 0));
	 z.add(new Point3D(12, 2, 0)); z.add(new Point3D(12, 3, 0)); z.add(new Point3D(12, 4, 0));
	 z.add(new Point3D(12, 5, 0)); z.add(new Point3D(12, 6, 0)); z.add(new Point3D(12, 7, 0));
	 z.add(new Point3D(12, 8, 0)); z.add(new Point3D(12, 9, 0)); z.add(new Point3D(13, -7, 0));
	 z.add(new Point3D(13, -6, 0)); z.add(new Point3D(13, -5, 0)); z.add(new Point3D(13, -4, 0));
	 z.add(new Point3D(13, -3, 0)); z.add(new Point3D(13, -2, 0)); z.add(new Point3D(13, -1, 0));
	 z.add(new Point3D(13, 0, 0)); z.add(new Point3D(13, 1, 0)); z.add(new Point3D(13, 2, 0));
	 z.add(new Point3D(13, 3, 0)); z.add(new Point3D(13, 4, 0)); z.add(new Point3D(13, 5, 0));
	 z.add(new Point3D(13, 6, 0)); z.add(new Point3D(13, 7, 0)); z.add(new Point3D(14, -5, 0));
	 z.add(new Point3D(14, -4, 0)); z.add(new Point3D(14, -3, 0)); z.add(new Point3D(14, -2, 0));
	 z.add(new Point3D(14, -1, 0)); z.add(new Point3D(14, 0, 0)); z.add(new Point3D(14, 1, 0));
	 z.add(new Point3D(14, 2, 0)); z.add(new Point3D(14, 3, 0)); z.add(new Point3D(14, 4, 0));
	 z.add(new Point3D(14, 5, 0));
	 
	 return z;
		
		
	}
 
 	public static List<Point3D> AbsoluteZone (Point3D position){
 		List<Point3D> rz= RelativeZone();
 		List<Point3D> az = new ArrayList<Point3D>();
 		for(Point3D p: rz){
 			
 			az.add(p.add(position));
 			
 		}
 		return az;
 	}
 
 public static Point3D rectifi(Point3D p ){
	 
	 return new Point3D(Math.round(p.getX()),Math.round(p.getY()),0.5);
	   
   }
 
 // ici l'angle est en radian
 public static List<Point3D> Pledge_point(double direction){
	 
	 List<Point3D> Lpledge = new ArrayList<Point3D>();
	 
	 Point3D a1 = new Point3D(Math.sin(direction),Math.cos(direction),0);
	 Point3D a2 = new Point3D(Math.sin(direction + (Math.PI /2)),Math.cos(direction + (Math.PI /2)),0);
	 Point3D a3 =  new Point3D(Math.sin(direction+ Math.PI),Math.cos(direction+ Math.PI),0);
	 
	 
	 return Lpledge;
	 
 }
 
 

}
