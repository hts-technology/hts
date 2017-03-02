package com.hts.test;

import java.util.ArrayList;
import java.util.List;
import com.hts.entity.CalculationResult;
import com.hts.entity.Fractional;
public class Test {

	public static List<CalculationResult> getCalculationResultList(int count){
		List<CalculationResult> list=new ArrayList<>();
		char[] op={'+','-','*','/'};
		for(int i=0;i<count;i++){
			Fractional f=new Fractional();
			Fractional f1=new Fractional();
			int x=(int)(Math.random()*100);
			int y=1+(int)(Math.random()*100);
			int m=(int)(Math.random()*100);
			int n=1+(int)(Math.random()*100);
			char randowOp=op[(int)(Math.random()*4)];
			f.setMolecular(x);
			f.setDenominator(y);
			if(randowOp=='/'&&m==0){
				m=1;
			}
			f1.setMolecular(m);
			f1.setDenominator(n);
			switch(randowOp){
			case '+':{ list.add(f.getAddResult(f1)); break;}
			case '-':{ list.add(f.getSubResult(f1)); break;}
			case '*':{ list.add(f.getMulResult(f1)); break;}
			case '/':{ list.add(f.getDivResult(f1)); break;}
			}
		}
		return list;	
	}
	public static void main(String[] args) {
		System.out.println(Test.getCalculationResultList(30));
	}
}
