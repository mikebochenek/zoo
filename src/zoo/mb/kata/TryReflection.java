package zoo.mb.kata;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TryReflection {

	public static void main(String[] args) {        
		List<String> stringList = new ArrayList<String>() {};        
		List<BigDecimal> bdList = new ArrayList<BigDecimal>() {};        
		List<Integer> intList = new ArrayList<Integer>() {};
		List<Properties> pList = new ArrayList<Properties>() {};
		
		System.out.println(getName(stringList)); //output should be String        
		System.out.println(getName(bdList));    //output should be BigDecimal        
		System.out.println(getName(intList));   //output should be Integer        
		System.out.println(getName(pList));     //output should be Properties}

	}

	public static String getName(List<?> list2) { 
		return list2.getClass().getGenericSuperclass().toString();
	}
}
