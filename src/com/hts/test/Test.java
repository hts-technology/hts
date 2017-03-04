package com.hts.test;

import java.util.ArrayList;
import java.util.List;
import com.hts.entity.CalculationResult;
import com.hts.entity.Fraction;
public class Test {

	public static List<CalculationResult> getCalculationResultList(int count){
		List<CalculationResult> list=new ArrayList<>();
		char[] op={'+','-','*','/'};
		for(int i=0;i<count;i++){
			Fraction f=new Fraction();
			Fraction f1=new Fraction();
			int x=(int)(Math.random()*10);
			int y=1+(int)(Math.random()*10);
			int m=(int)(Math.random()*10);
			int n=1+(int)(Math.random()*10);
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
