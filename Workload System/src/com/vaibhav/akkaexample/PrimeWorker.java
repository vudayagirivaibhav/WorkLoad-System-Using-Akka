package com.vaibhav.akkaexample;

import java.util.ArrayList;

import akka.actor.UntypedActor;
public class PrimeWorker extends UntypedActor {

	public  void onReceive(Object message) { 
		// TODO Auto-generated method stub
		
		if( message instanceof int[]){
			int msg[] = (int[]) message;
			int start=msg[0];
			int end=msg[1];
		
		
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(int i=start; i<= end; i++)
			if(isPrime(i))
				  result.add(i);
    
		
	     getSender().tell(result,getSelf());
		
	}
		else {
			unhandled(message);
		}
	}

	private static boolean isPrime(int n){
		if(n==1)
			return false;
		else if(n ==2)
			return false;
		
		if(n%2 == 0)
			return false;
		
		for(int i=3; i*i<=n; i+=2)
			if(n%i ==0)
				return false;
	     return true;	
	}
	
}
