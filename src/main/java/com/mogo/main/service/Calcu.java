package com.mogo.main.service;

import com.mogo.main.model.Personal;
import org.assertj.core.internal.cglib.asm.$Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class Calcu {

    //通过id识别出调查最相似的某个人
    public Map calResult(String str) throws Exception {
        String strleng[]={"a","b","c","d","e"};//分项选值
        //data list
        List<Personal> personalList = new RandomData().getRandomData();

        //data length
        int datalength = personalList.size();
        int similar[][] = new int[datalength][datalength];

        for (int i = 0; i < datalength; i++) {
            for (int j = 0; j < datalength; j++) {
                String big = personalList.get(i).getChoice();
                String small = personalList.get(j).getChoice();
                if (big.length() < small.length()) {
                    String tmp = big;
                    big = small;
                    small = big;
                }
                int len = 0;
                if (i != j) {
                    for (int k = 0; k < small.length(); k++) {
                        if (small.substring(k, k + 1).equals(big.substring(k, k + 1))) {
                            len++;
                        }
                    }
                }
                similar[i][j] = len;
                if (i != j) {
                    //System.out.print((i + 1) + ",  " + (j + 1) + ",符合数量:" + len + "    ");
                }
            }
            //System.out.println();
        }

        int correct = -1;
        for (int i =0;i<personalList.size();i++){
            if(str.equals(personalList.get(i).getId())){
                correct = i;
            }
        }

        if(correct<0){
            //计算对方昵称
            Map<String,String> resultMap = new HashMap<>();
            resultMap.put("my","illgeal user");
            resultMap.put("score", "0");
            return resultMap;
        }

        int max = 0;
        int position = correct;
        for (int j = 0; j < datalength; j++) {
            if (similar[correct][j] > max) {
                position = j;
                max = similar[correct][j];
            }
        }
        //System.out.println((correct + 1) + "," + (position + 1) + ",最符合项目:" + similar[correct][position]);

        //计算对方昵称
        Map<String,String> resultMap = new HashMap<>();
        resultMap.put("my",personalList.get(correct).getNickName());
        resultMap.put("nickname",personalList.get(position).getNickName());
        System.out.println("similar[correct][position]):"+similar[correct][position]+",strleng.length:"+strleng.length);

        //计算匹配分数
        int score = (new BigDecimal(similar[correct][position]))
                .divide(new BigDecimal(strleng.length),2,RoundingMode.HALF_EVEN)
                .multiply(new BigDecimal(100)).intValue();
        resultMap.put("score", score+"");
        return resultMap;

    }


}
