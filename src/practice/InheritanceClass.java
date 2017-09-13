package practice;

import java.io.FileNotFoundException;
import java.io.IOException;

interface InheritanceClass {

	void add() throws IOException;

}

class TestABC implements InheritanceClass{
   protected void name() {
	
}
	@Override
	public void add() throws FileNotFoundException{
		
	}
	public void add(String s){}
	
}

class abcc extends TestABC{
	public void name(){}
	
	
}

