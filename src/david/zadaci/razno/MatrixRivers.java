package david.zadaci.razno;

/*
* imate zadatu matricu NxM, matrica sadrzi samo 0 i 1.
* Svaka 0 predstavlja kopno/ostrvo, svaka jedinica predstavlja reku.
* Jedinica je deo neke reke ukoliko je horizontalno ili vertikalno uz nju jos jedna jedinica.
* Potrebno je da ispisete sve duzine reka (duzina od jedne jedinice je takodje reka) koje postoje u matrici...
* */

import static david.zadaci.nedelja03.Zadatak01.showMatrix;

public class MatrixRivers {
    public static void main(String[] args) {

        int[][] inputMatrix = {{1,0,1},
                {1,1,0},
                {1,0,1},
                {0,0,1}
        };
        showMatrix(inputMatrix);

        //inputMatrix();
        numberOfRivers(inputMatrix);
    }

    private static void numberOfRivers(int[][] inputMatrix) {
        for (int i = 0; i < inputMatrix.length; i++)
            for (int j = 0; j < inputMatrix[i].length; j++) {
                int size = numberOfRiversFromPosition(inputMatrix, i, j);
                if (size != 0)
                    System.out.println(size);
            }
    }

    private static int numberOfRiversFromPosition(int[][] inputMatrix, int iStart, int jStart) {
        int numberOfRivers = 0;

        for (int i = iStart; i < inputMatrix.length; i++) {
            if (inputMatrix[i][jStart] == 0)
                break;

            for (int j = jStart; j < inputMatrix[i].length; j++) {
                if (inputMatrix[i][j] == 0)
                    break;
                numberOfRivers++;
                inputMatrix[i][j] = 0;
            }
        }
        return numberOfRivers;
    }
}
