package a.b.c.ch4;

public class ElectronicAdapter implements Electronic110v {
	
		//Electronic220v를 객체로 가지고 있고 
		private Electronic220v electronic220v;
		
		//맨처음 생성자에 Electronic220v를 넣어 가지고 있는다 
		public ElectronicAdapter(Electronic220v electronic220v) {
			this.electronic220v = electronic220v;
		}
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		electronic220v.connect();
	}

}
