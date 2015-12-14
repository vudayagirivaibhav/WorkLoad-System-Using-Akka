package com.vaibhav.akkaexample;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class PrimeCalculator {
	
	public void calc(int start, int end){
		int range[] ={start, end};
		
	
        ActorSystem actorSystem = ActorSystem.create("primeCalculator");
        
        ActorRef primeMaster = actorSystem.actorOf(Props.create(PrimeMaster.class,10));
        
        primeMaster.tell(range,primeMaster);
        
}
	
	public static void main(String[] args){
		PrimeCalculator primeCalculator = new PrimeCalculator();
		primeCalculator.calc(2, 1000000);
	}
}
