package com.hts.entity;

public class TimerReturn {
		private String message;
		private String time;
		
		
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
		public TimerReturn(String message, String time) {
			super();
			this.message = message;
			this.time = time;
		}
		public TimerReturn() {

		}
		@Override
		public String toString() {
			return "TimerReturn [message=" + message + ", time=" + time + "]";
		}
		
}
