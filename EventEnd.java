		package lab5.Events;
		
		import lab5.State.Customer;
		import lab5.State.StateStore;
		/**
		 * EventEnd is the last event which will be runned this will be the benchmark for the summary which will be printed out at the end
		 * @author samuelgraden
		 *
		 */
		public class EventEnd extends Event{
			
			@Override
			public void run(StateStore state,EventQueue EventQueue){
				super.run(state, EventQueue);
			}
			/**
			 * the time is max so it allways will be the last.
			 */
			@Override
			public double getTime() {
				return Integer.MAX_VALUE;
			}
		
		}
