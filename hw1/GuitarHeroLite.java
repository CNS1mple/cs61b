/** A client that uses the synthesizer package to replicate a plucked guitar string sound */
public class GuitarHeroLite {
    private static final double CONCERT_A = 440.0;
    private static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);
    private static final double CONCERT_G = CONCERT_A * Math.pow(2, 3.0 / 12.0);
    private static final double CONCERT_F = CONCERT_A * Math.pow(2, 3.0 / 12.0);

    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
        synthesizer.GuitarString stringA = new synthesizer.GuitarString(CONCERT_A);
        synthesizer.GuitarString stringC = new synthesizer.GuitarString(CONCERT_C);
        synthesizer.GuitarString stringG = new synthesizer.GuitarString(CONCERT_G);
        synthesizer.GuitarString stringF = new synthesizer.GuitarString(CONCERT_F);



        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (key == 'a') {
                    stringA.pluck();
                } else if (key == 'c') {
                    stringC.pluck();
                } else if (key == 'g') {
                    stringG.pluck();
                } else if (key == 'f') {
                    stringF.pluck();
                }
            }

        /* compute the superposition of samples */
            double sample = stringA.sample() + stringC.sample() + stringF.sample() + stringG.sample();

        /* play the sample on standard audio */
            StdAudio.play(sample);

        /* advance the simulation of each guitar string by one step */
            stringA.tic();
            stringC.tic();
            stringG.tic();
            stringF.tic();
        }
    }
}

