public class RndEng {


    protected static int rndEng(int max, int min) {

        double temp = (Math.random() * ((max - min) + 1)) + min;
        return (int) temp;
    }

}
