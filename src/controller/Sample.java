package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.Limit;

public class Sample {
	
	private static Integer ONE = 1;
	
	private static int ZIP_CODE_LIMIT = 100000;

	public List<Limit> rangeList(List<Limit> inputRange) {

		Collections.sort(inputRange);
		
		//consider the boundries can overlap with other boundries
		for (int i=0; i<inputRange.size(); ) {
			Limit current = inputRange.get(i);
				if(++i<inputRange.size()) {
					Limit next = inputRange.get(i);
					if((current.getUpperLimit() >= next.getLowerLimit()) && (current.getUpperLimit() >= next.getUpperLimit())) {
						inputRange.remove(next);
					}else if(current.getUpperLimit() >= next.getLowerLimit()){
						current.setUpperLimit(next.getUpperLimit());
						inputRange.remove(next);
					}else if((current.getUpperLimit() + ONE) == next.getLowerLimit()){
						current.setUpperLimit(next.getUpperLimit());
						inputRange.remove(next);
					}
				}
		}
		return inputRange;
	}
	
	//method to accept the dynamic input in standalone app
	public List<Limit> addElements() throws NumberFormatException, IOException {
		List<Limit> listOfRange = new ArrayList<>();
		int choice = 0;
		while (choice != 2) {
			System.out.println("1. Add new entry");
			System.out.println("2. Exit");
			System.out.println("Enter your choice : ");
			BufferedReader br = new BufferedReader (new InputStreamReader((System.in)));
			choice = Integer.parseInt(br.readLine());
			switch (choice) {
				case 1:
					System.out.println("Enter lower limit");
					int lowerLimit = Integer.parseInt(br.readLine());
					System.out.println("Enter upper limit");
					int upperLimit = Integer.parseInt(br.readLine());
					
					if(lowerLimit <= upperLimit && lowerLimit < ZIP_CODE_LIMIT) {
						listOfRange.add(new Limit(lowerLimit, upperLimit));
					}else {
						System.out.println("Invalid range entered ");
					}
					break;
					
				case 2:
					break;
					
				default :
					break;
			}
		}
		return listOfRange;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		Sample s = new Sample();
		List<Limit> listOfRange = s.addElements();
		listOfRange = s.rangeList(listOfRange);
		
		//code is written just to print for output
		for(Limit l : listOfRange) {
			System.out.println("["+l.getLowerLimit()+","+l.getUpperLimit()+"]");
		}
	}

}
