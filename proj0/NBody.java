public class NBody {

    static double radius;
    static Planet planets[];

    public static double readRadius(String fileName) {
        In in = new In(fileName);
        int temp = in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        int len = in.readInt();
        double radius = in.readDouble();

        Planet[] planets = new Planet[len];
        int index = 0;

        while(index < len) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            Planet p = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
            planets[index++] = p;
        }

        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        radius = readRadius(filename);
        planets = readPlanets(filename);

        StdDraw.setScale(-radius, radius);


        StdDraw.enableDoubleBuffering();

        int t = 0;
        while(t < T) {
            double xForces[] = new double[planets.length], yForces[] = new double[planets.length];
            for(int i = 0; i < planets.length; i++) {
                double netXForces = 0, netYForces = 0;
                for(int j = 0; j < planets.length; j++) {
                    if(i == j) continue;
                    netXForces += planets[i].calcForceExertedByX(planets[j]);
                    netYForces += planets[i].calcForceExertedByY(planets[j]);
                }
                xForces[i] = netXForces;
                yForces[i] = netYForces;
            }

            for(int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "images/" + "starfield.jpg");

            for(Planet p : planets) {
                p.draw();
            }

            StdDraw.show();

            StdDraw.pause(5);

            t += dt;
        }



    }

}
