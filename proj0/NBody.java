public class NBody {
    public static double radiusOfUniverse;
    public static int numberOfPlanet;
    public static double xPos;
    public static double yPos;
    public static double xVel;
    public static double yVel;
    public static double mass;
    public static String planet;

    public static double readRadius (String filename) {
        In in = new In(filename);

        numberOfPlanet = in.readInt();
        radiusOfUniverse = in.readDouble();
        return radiusOfUniverse;
    }

    public static Body [] readBodies (String filename){
        In in = new In(filename);
        numberOfPlanet = in.readInt();
        radiusOfUniverse = in.readDouble();

        Body [] planetArr = new Body [numberOfPlanet];

        for (int i = 0; i < numberOfPlanet; i++) {

                xPos = in.readDouble();
                yPos = in.readDouble();
                xVel = in.readDouble();
                yVel = in.readDouble();
                mass = in.readDouble();
                planet = in.readString();



            }
        return planetArr;
    }

}
