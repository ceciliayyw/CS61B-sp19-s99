import java.lang.Math;
public class Body {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;

    public Body (double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b)
    {
        Body c = new Body(b);
    }

    public double calcDistance (Body a){
       double squareofRadius = (a.xxPos - xxPos)*(a.xxPos - xxPos) + (a.yyPos - yyPos)*(a.yyPos - yyPos);
       double radius = Math.sqrt(squareofRadius);
       return radius;
    }

    public double calcForceExertedBy (Body a){
        double gConstant = (6.67*Math.pow(10,-11));
        double totalForce = (gConstant*a.mass*mass)/(calcDistance(a)*calcDistance(a));
        return totalForce;
    }
}
