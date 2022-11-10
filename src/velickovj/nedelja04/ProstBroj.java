package velickovj.nedelja04;



public class ProstBroj {
    public static void main(String[] args) {

        int broj=1000000000;


        for(int i=broj; i<Integer.MAX_VALUE;i++){
            if(prostJe(i)) {
                System.out.println(i);
                break;
            }
        }


    }
    public static boolean prostJe(int broj){
        for(int i=2; i<(int)Math.sqrt(broj)+1;i++){
            if(broj%i==0)
                return false;
        }
        return true;
    }

}
