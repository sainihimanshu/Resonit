package in.toroshu.resonit.engine;

import in.toroshu.resonit.R;

/**
 * Created by saini on 29-08-2015.
 */
public class Rings {

    int leftRing[];
    int rightRing[];

    public Rings(int leftRing[], int rightRing[]) {
        this.leftRing = leftRing;
        this.rightRing = rightRing;
    }

    public void genRings(int janta[]) {
        rightRing = new int[]{janta[1], janta[2], janta[3], janta[0]};
        leftRing = new int[]{janta[1], janta[0], janta[4], janta[5]};
    }


    // sets the right and left rings according to the difficulty level
    public int[][] getRings(int difficultyLevel) {
        int janta[] = janta = new int[]{R.drawable.doctor};
        ;
        switch (difficultyLevel + 1) {
            case 0:
                rightRing = new int[]{
                        R.drawable.doctor, R.drawable.pirate,
                        R.drawable.student, R.drawable.blank};

                leftRing = new int[]{
                        R.drawable.doctor, R.drawable.blank,
                        R.drawable.police, R.drawable.worker,
                };
                break;
            case 1:
                janta = new int[]{R.drawable.doctor, R.drawable.pirate, R.drawable.student,
                        R.drawable.blank, R.drawable.police, R.drawable.worker};
                break;
            case 2:
                janta = new int[]{R.drawable.student, R.drawable.blank, R.drawable.doctor,
                        R.drawable.pirate, R.drawable.police, R.drawable.worker};
                break;
            case 3:
                janta = new int[]{R.drawable.doctor, R.drawable.worker, R.drawable.pirate,
                        R.drawable.student, R.drawable.blank, R.drawable.police};
                break;
            case 4:
                janta = new int[]{R.drawable.police, R.drawable.blank, R.drawable.pirate,
                        R.drawable.student, R.drawable.worker, R.drawable.doctor};
                break;
            case 5:
                janta = new int[]{R.drawable.pirate, R.drawable.student, R.drawable.blank,
                        R.drawable.doctor, R.drawable.police, R.drawable.worker};
                break;
            case 6:
                janta = new int[]{R.drawable.worker, R.drawable.police, R.drawable.pirate,
                        R.drawable.student, R.drawable.doctor, R.drawable.blank};
                break;
            case 7:
                janta = new int[]{R.drawable.pirate, R.drawable.worker, R.drawable.student,
                        R.drawable.blank, R.drawable.doctor, R.drawable.police};
                break;
            case 8:
                janta = new int[]{R.drawable.police, R.drawable.doctor, R.drawable.student,
                        R.drawable.blank, R.drawable.worker, R.drawable.pirate};
                break;
            case 9:
                janta = new int[]{R.drawable.blank, R.drawable.worker, R.drawable.doctor,
                        R.drawable.pirate, R.drawable.student, R.drawable.police};
                break;
            case 10:
                janta = new int[]{R.drawable.police, R.drawable.student, R.drawable.doctor,
                        R.drawable.pirate, R.drawable.worker, R.drawable.blank};
                break;

            case 11:
                janta = new int[]{R.drawable.worker, R.drawable.pirate, R.drawable.student,
                        R.drawable.doctor, R.drawable.blank, R.drawable.police};
                break;
            case 12:
                janta = new int[]{
                        R.drawable.student, R.drawable.doctor, R.drawable.worker,
                        R.drawable.pirate, R.drawable.blank, R.drawable.police};
                break;
            case 13:
                janta = new int[]{
                        R.drawable.blank, R.drawable.pirate, R.drawable.student,
                        R.drawable.police, R.drawable.worker, R.drawable.doctor};
                break;
            case 14:
                janta = new int[]{
                        R.drawable.student, R.drawable.police, R.drawable.blank,
                        R.drawable.pirate, R.drawable.worker, R.drawable.doctor};
                break;
            case 15:
                janta = new int[]{
                        R.drawable.worker, R.drawable.student, R.drawable.blank,
                        R.drawable.pirate, R.drawable.doctor, R.drawable.police};
                break;
            case 16:
                janta = new int[]{
                        R.drawable.blank, R.drawable.pirate, R.drawable.worker,
                        R.drawable.student, R.drawable.doctor, R.drawable.police};
                break;
            case 17:
                janta = new int[]{
                        R.drawable.doctor, R.drawable.student, R.drawable.blank,
                        R.drawable.police, R.drawable.worker, R.drawable.pirate};
                break;
            case 18:
                janta = new int[]{
                        R.drawable.blank, R.drawable.police, R.drawable.doctor,
                        R.drawable.student, R.drawable.worker, R.drawable.pirate};
                break;
            case 19:
                janta = new int[]{
                        R.drawable.worker, R.drawable.police, R.drawable.student,
                        R.drawable.blank, R.drawable.pirate, R.drawable.doctor};
                break;
            case 20:
                janta = new int[]{
                        R.drawable.worker, R.drawable.doctor, R.drawable.pirate,
                        R.drawable.blank, R.drawable.student, R.drawable.police};
                break;


            case 21:
                janta = new int[]{R.drawable.pirate, R.drawable.blank, R.drawable.worker,
                        R.drawable.doctor, R.drawable.student, R.drawable.police};
                break;
            case 22:
                janta = new int[]{
                        R.drawable.worker, R.drawable.police, R.drawable.doctor,
                        R.drawable.pirate, R.drawable.blank, R.drawable.student};
                break;
            case 23:
                janta = new int[]{
                        R.drawable.student, R.drawable.doctor, R.drawable.pirate,
                        R.drawable.police, R.drawable.worker, R.drawable.blank};
                break;
            case 24:
                janta = new int[]{
                        R.drawable.pirate, R.drawable.police, R.drawable.student,
                        R.drawable.doctor, R.drawable.worker, R.drawable.blank};
                break;
            case 25:
                janta = new int[]{
                        R.drawable.worker, R.drawable.police, R.drawable.doctor,
                        R.drawable.pirate, R.drawable.blank, R.drawable.student};
                break;
            case 26:
                janta = new int[]{
                        R.drawable.pirate, R.drawable.student, R.drawable.doctor,
                        R.drawable.worker, R.drawable.blank, R.drawable.police};
                break;
            case 27:
                janta = new int[]{
                        R.drawable.blank, R.drawable.worker, R.drawable.student,
                        R.drawable.doctor, R.drawable.police, R.drawable.pirate};
                break;
            case 28:
                janta = new int[]{
                        R.drawable.doctor, R.drawable.police, R.drawable.worker,
                        R.drawable.pirate, R.drawable.student, R.drawable.blank};
                break;
            case 29:
                janta = new int[]{
                        R.drawable.blank, R.drawable.student, R.drawable.worker,
                        R.drawable.pirate, R.drawable.police, R.drawable.doctor};
                break;
            case 30:
                janta = new int[]{
                        R.drawable.pirate, R.drawable.student, R.drawable.police,
                        R.drawable.blank, R.drawable.worker, R.drawable.doctor};
                break;

        }
        genRings(janta);
        return new int[][]{leftRing, rightRing};
    }
}
