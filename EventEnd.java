		package lab5.Events;
		
		import lab5.State.Customer;
		import lab5.State.StateStore;
		
		public class EventEnd extends Event{
			
			@Override
			public void run(StateStore state){
				
			}
			
			@Override
			public double getTime() {
				return Integer.MAX_VALUE-1;
			}
		
		}
