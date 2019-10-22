import java.util.Arrays;

public class MakeFractal { 
private final static int NOT_FOUND=-1;
private String alphaNumeric;
private String computedFractal; // the initial string is the axion
private String initialAxion; // the initial string is the axion
private Integer index,numSymbols,n,size; 
private String[] symbols;
private String[] rules;
private Integer charsPerLine=60;

// constructor
public MakeFractal(String[] symbols,Integer numSymbols,
                   String initialAxion,String[] rules,Integer n) {
this.numSymbols=numSymbols;
this.symbols=new String[this.numSymbols];
this.rules=new String[this.numSymbols];
for(int i=0;i<this.numSymbols;i++) {
   this.symbols[i]=symbols[i];
   this.rules[i]=rules[i];
   }
this.computedFractal=initialAxion;     // the initial string is the axion
this.n=n;
}

public String buildFractal() {
System.out.println("In buildFractal\n");
// print out symbols and their production rules
System.out.println("Symbol Table");
for(int i=0;i<numSymbols;i++) {
    System.out.println("symbol(" + i + ")=" + symbols[i] + 
                       "   rule(" + i +")=" + rules[i] + "\n");
}
// s is a stack
StackADT<String> s = new LinkedStack<String>();
if(n.equals(0)) { //if n=0 computedFractal is axion so return computedFractal 
return computedFractal;}
else { 
	for(int y=1; y<n; y++) { //otherwise for 1 to n iterate through n 
	for(int i=0; i<computedFractal.length();i++) { //iterate through length of computedFractal
		String q = computedFractal.substring(i,i+1); //process each ith character 
		int x = in(q, symbols); //if q is in symbols 
		if(x==-1) 
			s.push(q); //push q onto stack if returns -1 or "NOT_FOUND"
		else
			s.push(rules[x]); //else use symbol index to get production rule of that index 
		}
computedFractal = "";
while(!s.isEmpty()) { //while the stack is empty 
computedFractal = s.pop() + computedFractal; //concatenate each popped item to the left of computedFractal 
	} 
}
return(computedFractal);
	} 
}
// Return the index of the character in symbols 
// or -1 if it is not there
public Integer in(String alphaNumeric,String[] symbols) {
for(int i=0;i<symbols.length;i++)
    {
    if(alphaNumeric.equals(symbols[i])) return(i);
    }
return(NOT_FOUND);
}

// Pretty print the computed fractal
public void prettyPrint() {
String str=computedFractal;
size=str.length();
System.out.println("\nPretty print the final fractal (60 characters per line)\n");
System.out.println("-------------------------------------------------------\n");
while(charsPerLine < size) {
    // print out substrings of str of length charsPerLine
    System.out.println(str.substring(0,charsPerLine-1));
    str=str.substring(charsPerLine,size);
    size=str.length();
} 
// print last bit of str
System.out.println(str);
}

} // MakeFractal