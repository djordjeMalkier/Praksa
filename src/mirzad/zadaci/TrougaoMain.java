public class TrougaoMain {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,1,1};
        int [] combs = new int[3];
        combinations(array, combs,0,array.length-1,0,3);
    }

    private static void ispitajPravougli(int a,int b, int c){

    }

    private static void ispitajJednakostranicni(int a,int b,int c){
        if(a==b && b==c){
            System.out.println("Jednakostranicni: " + a + b + c);
        }
    }

    private static void ispitajJednokraki(int a, int b, int c){
        if(a == b){
            if (a + b > c/2) System.out.println("Jeste jednokraki: " + a + b + c);
        }
        else if (b == c) {
            if (b + c > a/2) System.out.println("Jeste jednokraki: " + a + b + c);
        } else if (a == c) {
            if (a + c > b/2) System.out.println("Jeste jednokraki: " + a + b + c);
        }
    }

    private static void combinations(int [] array,int [] combs, int start, int end, int index, int n){
        if (index == n){
            ispitaj(combs[0],combs[1],combs[2]);
            return;
        }

        for(int i = start; i<=end && end-i+1 >= n-index; i++){
            combs[index] = array[i];
            combinations(array,combs,i+1,end,index+1, n);
        }

    }

    private static int max(int a, int b, int c){
        if(a > b){
            if (a > c) return a;
            else return c;
        }
        else {
            if (b > c) return b;
            return c;
        }
    }

    private static int redosledMax(int a, int b, int c){
        if(a > b){
            if (a > c) return 1;
            else return 3;
        }
        else {
            if (b > c) return 2;
            return 3;
        }
    }

    private static void ispitaj(int a, int b, int c ){
        ispitajJednakostranicni(a,b,c);
        ispitajJednokraki(a,b,c);
        ispitajPravougli(a,b,c);
    }
}