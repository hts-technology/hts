package com.hts.entity;

public class TimerReturn {
		private String message;
		private String time;
		private String errorCount;
		private String correctRate;
		
		public String getErrorCount() {
			return errorCount;
		}
		public void setErrorCount(String errorCount) {
			this.errorCount = errorCount;
		}
		public String getCorrectRate() {
			return correctRate;
		}
		public void setCorrectRate(String correctRate) {
			this.correctRate = correctRate;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		
		public TimerReturn(String message, String time, String errorCount, String correctRate) {
			super();
			this.message = message;
			this.time = time;
			this.errorCount = errorCount;
			this.correctRate = correctRate;
		}
		public TimerReturn() {

		}
		@Override
		public String toString() {
			return "TimerReturn [message=" + message + ", time=" + time + "]";
		}
		
}
