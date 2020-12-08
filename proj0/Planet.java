public class Planet {
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public final double G = 6.67E-11;
    public String imgFileName;

    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx = xxPos - p.xxPos;
        double dy = yyPos - p.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet p) {
        double distance = this.calcDistance(p);
        if(distance == 0) return 0;
        return (G * this.mass * p.mass) / (distance * distance);
    }

    public double calcForceExertedByX(Planet p) {
        double dx = xxPos - p.xxPos;
        double distance = this.calcDistance(p);
        if(distance == 0) return 0;
        double force = this.calcForceExertedBy(p);
        return - force * dx / distance;
    }

    public double calcForceExertedByY(Planet p) {
        double dy = yyPos - p.yyPos;
        double distance = this.calcDistance(p);
        if(distance == 0) return 0;
        double force = this.calcForceExertedBy(p);
        return - force * dy / distance;
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double xNetForce = 0;
        for(Planet p : planets) {
            double dx = xxPos - p.xxPos;
            double distance = this.calcDistance(p);
            if(distance == 0) continue;
            double force = this.calcForceExertedBy(p);
            xNetForce -= force * dx / distance;
        }
        return xNetForce;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double yNetForce = 0;
        for(Planet p : planets) {
            double dy = yyPos - p.yyPos;
            double distance = this.calcDistance(p);
            if(distance == 0) continue;
            double force = this.calcForceExertedBy(p);
            yNetForce -= force * dy / distance;
        }
        return yNetForce;
    }

    public void update(double dt, double fx, double fy) {
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        this.xxVel += ax * dt;
        this.yyVel += ay * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }

    public void draw() {
        String newImgFileName = "images/" + imgFileName;
        StdDraw.picture(xxPos, yyPos, newImgFileName);
    }

}
