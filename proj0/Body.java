import java.lang.Math;
public class Body {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    public static final double gConstant = (6.67*Math.pow(10,-11));

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
        double totalForce = (gConstant*a.mass*mass)/(calcDistance(a)*calcDistance(a));
        return totalForce;
    }

    public double calcForceExertedByX(Body a){
        double forceX = calcForceExertedBy(a)*(a.xxPos - xxPos)/calcDistance(a);
        return forceX;
    }

    public double calcForceExertedByY(Body a) {
        double forceY = calcForceExertedBy(a)*(a.yyPos - yyPos)/calcDistance(a);
        return forceY;
    }

    public double calcNetForceExertedByX(Body [] a){
        double netForceX = 0;
        for (int i = 0; i<a.length; i++){
            if (this.equals(a[i])){
                continue;
            }
            else{
                netForceX = netForceX + calcForceExertedByX(a[i]);
            }
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(Body [] a){
        double netForceY = 0;
        for (int i = 0; i<a.length; i++){
            if (this.equals(a[i])){
                continue;
            }
            else{
                netForceY = netForceY + calcForceExertedByY(a[i]);
            }
        }
        return netForceY;
    }


    public void update(double dt, double fx, double fy){
        double accX = fx/mass;
        double accY = fy/mass;

        xxVel = xxVel+(dt*accX);
        yyVel = yyVel+(dt*accY);

        xxPos = xxPos+(dt*xxVel);
        yyPos = yyPos+(dt*yyVel);

    }
}
