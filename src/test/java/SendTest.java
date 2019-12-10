import com.mogo.main.model.Personal;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SendTest {

    private static final Logger log = LoggerFactory.getLogger(SendTest.class);

    @Test
    public void test(){
        System.out.println("test succeed!");
        try {
            List<Personal> personalList=new ArrayList<Personal>();
            personalList.add(new Personal("1gg","abccd",""));
            personalList.add(new Personal("1213","bcacd",""));
            personalList.add(new Personal("312sfsd1","abcce",""));
            personalList.add(new Personal("1sada","edacb",""));

            int leng = personalList.size();
            int similar[][] =new int[leng][leng];

            for (int i=0;i< leng;i++) {
                for (int j = 0; j < leng; j++) {
                    String big = personalList.get(i).getChoice();
                    String small = personalList.get(j).getChoice();
                    if (big.length() < small.length()) {
                        String tmp = big;
                        big = small;
                        small = big;
                    }

                    int len = 0;
                    if(i!=j){
                        for (int k = 0; k < small.length(); k++) {
                            if (small.substring(k, k + 1).equals(big.substring(k, k + 1))) {
                                len++;
                            }
                        }
                    }

                    similar[i][j] = len;
                    if(i!=j){
                        System.out.print((i+1)+ "<->"+(j+1) + ":" + len+"    ");
                    }
                }
                System.out.println();
            }

            for (int i =0;i<leng;i++){
                int max = 0;
                int position = i;
                for (int j = 0; j < leng; j++) {
                    if (similar[i][j] > max) {
                        position = j;
                        max = similar[i][j];
                    }
                }
                System.out.println((i+1)+"<->"+(position+1)+":"+similar[i][position]);
            }

        }catch (Exception e){
            log.error("send e:"+e.getMessage());
        }
    }

}
