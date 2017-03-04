package com.hts.entity;

public class CalculationResult {
		private String formula;
		private String result;
		private String flag;
		private String correct;
		
		public String getCorrect() {
			return correct;
		}
		public void setCorrect(String correct) {
			this.correct = correct;
		}
		public String getFlag() {
			return flag;
		}
		public void setFlag(String flag) {
			this.flag = flag;
		}
		public CalculationResult(String formula, String result) {
			super();
			this.formula = formula;
			this.result = result;
		}
		public String getFormula() {
			return formula;
		}
		public void setFormula(String formula) {
			this.formula = formula;
		}
		public String getResult() {
			return result;
		}
		public void setResult(String result) {
			this.result = result;
		}
		public CalculationResult() {
			
		}
		
//		public String toString() {
//			return formula +  flag ;
//		}
		@Override
		public String toString() {
			return formula +  result ;
		}
}
