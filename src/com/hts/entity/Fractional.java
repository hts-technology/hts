package com.hts.entity;

import com.hts.util.Util;

public class Fractional {
		private int molecular;
		private int denominator;
			
		public Fractional(int molecular, int denominator) {
			super();
			this.molecular = molecular;
			this.denominator = denominator;
		}
		public int getMolecular() {
			return molecular;
		}
		public void setMolecular(int molecular) {
			this.molecular = molecular;
		}
		public int getDenominator() {
			return denominator;
		}
		public void setDenominator(int denominator) {
			this.denominator = denominator;
		}
		public Fractional() {
			
		}
		
		public CalculationResult getAddResult(Fractional f){
			CalculationResult cr=new CalculationResult();
			String pre=molecular+"/"+denominator;
			String suf=f.getMolecular()+"/"+f.getDenominator();
			if(Util.gcd(molecular, denominator)*(molecular/denominator)==molecular){
				 pre=molecular/denominator+"";
			}
			if(Util.gcd(f.getMolecular(), f.getDenominator())*(f.getMolecular()/f.getDenominator())==f.getMolecular()){
				suf=f.getMolecular()/f.getDenominator()+"";
			}
			cr.setFormula(pre+"+"+suf+"=");
			int firstMolecularMul=molecular*f.getDenominator();
			int secondMolecularMul=denominator*f.getMolecular();
			int denominatorMul=denominator*f.getDenominator();
			int molecularSum=firstMolecularMul+secondMolecularMul;
			int k=Util.gcd(molecularSum,denominatorMul);			
			if(k!=1){
				molecularSum=molecularSum/k;
				denominatorMul=denominatorMul/k;
			}
			if(molecularSum==denominatorMul){				
				cr.setResult("1");
				return cr;
			}
			if(denominatorMul==1){				
				cr.setResult(molecularSum+"");
				return cr;
			}
			cr.setResult(molecularSum+"/"+denominatorMul);
			return cr;
		}
		public CalculationResult getSubResult(Fractional f){
			CalculationResult cr=new CalculationResult();
			String pre=molecular+"/"+denominator;
			String suf=f.getMolecular()+"/"+f.getDenominator();
			if(Util.gcd(molecular, denominator)*(molecular/denominator)==molecular){
				 pre=molecular/denominator+"";
			}
			if(Util.gcd(f.getMolecular(), f.getDenominator())*(f.getMolecular()/f.getDenominator())==f.getMolecular()){
				suf=f.getMolecular()/f.getDenominator()+"";
			}
			cr.setFormula(pre+"-"+suf+"=");
			
			int firstMolecularMul=molecular*f.getDenominator();
			int secondMolecularMul=denominator*f.getMolecular();
			int denominatorMul=denominator*f.getDenominator();
			int molecularSub=firstMolecularMul-secondMolecularMul;
			
			if(molecularSub==0){
				cr.setResult("0");
				return cr;
			}
			if(molecularSub==denominatorMul){
				cr.setResult("1");
				return cr;
			}
			if(molecularSub<0){
				molecularSub=Math.abs(molecularSub);
				int k=Util.gcd(molecularSub,denominatorMul);			
				molecularSub=molecularSub/k;
				denominatorMul=denominatorMul/k;
				if(molecularSub==denominatorMul){
					cr.setResult("-1");
						return cr;
				}			
				cr.setResult("-"+molecularSub+"/"+denominatorMul);
				return cr;
			}
			int k=Util.gcd(molecularSub,denominatorMul);			
			if(k!=1){
				molecularSub=molecularSub/k;
				denominatorMul=denominatorMul/k;
			}
			if(denominatorMul==1){				
				cr.setResult(molecularSub+"");
				return cr;
			}
			
			cr.setResult(molecularSub+"/"+denominatorMul);
			return cr;
		}
		public CalculationResult getMulResult(Fractional f){
			CalculationResult cr=new CalculationResult();
			String pre=molecular+"/"+denominator;
			String suf=f.getMolecular()+"/"+f.getDenominator();
			if(Util.gcd(molecular, denominator)*(molecular/denominator)==molecular){
				 pre=molecular/denominator+"";
			}
			if(Util.gcd(f.getMolecular(), f.getDenominator())*(f.getMolecular()/f.getDenominator())==f.getMolecular()){
				suf=f.getMolecular()/f.getDenominator()+"";
			}
			cr.setFormula(pre+"*"+suf+"=");
			int molecularMul=molecular*f.getMolecular();
			int denominatorMul=denominator*f.getDenominator();
			int k=Util.gcd(molecularMul,denominatorMul);			
			if(k!=1){
				molecularMul=molecularMul/k;
				denominatorMul=denominatorMul/k;
			}
			if(molecularMul==0){
				cr.setResult("0");
				return cr;
			}
			if(molecularMul==denominatorMul){
				cr.setResult("1");
				return cr;
			}
			if(denominatorMul==1){				
				cr.setResult(molecularMul+"");
				return cr;
			}
			cr.setResult(molecularMul+"/"+denominatorMul);
			return cr;
		}
		public CalculationResult getDivResult(Fractional f){
			CalculationResult cr=new CalculationResult();
			String pre=molecular+"/"+denominator;
			String suf=f.getMolecular()+"/"+f.getDenominator();
			if(Util.gcd(molecular, denominator)*(molecular/denominator)==molecular){
				 pre=molecular/denominator+"";
			}
			if(Util.gcd(f.getMolecular(), f.getDenominator())*(f.getMolecular()/f.getDenominator())==f.getMolecular()){
				suf=f.getMolecular()/f.getDenominator()+"";
			}
			cr.setFormula(pre+"÷"+suf+"=");
			int temp=f.molecular;
			f.molecular=f.denominator;
			f.denominator=temp;
			int molecularMul=molecular*f.getMolecular();
			int denominatorMul=denominator*f.getDenominator();
			int k=Util.gcd(molecularMul,denominatorMul);			
			if(k!=1){
				molecularMul=molecularMul/k;
				denominatorMul=denominatorMul/k;
			}
			if(molecularMul==denominatorMul){
				cr.setResult("1");
				return cr;
			}
			if(molecularMul==0){
				cr.setResult("0");
				return cr;
			}
			if(denominatorMul==1){				
				cr.setResult(molecularMul+"");
				return cr;
			}
			cr.setResult(molecularMul+"/"+denominatorMul);
			return cr;
		}
		public static void main(String[] args) {
			Fractional f=new Fractional(0, 1);
			Fractional f1=new Fractional(5, 10);
			System.out.println(f.getDivResult(f1));
		}
}
