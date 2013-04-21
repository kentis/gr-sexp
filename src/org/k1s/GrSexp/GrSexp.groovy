package org.k1s.GrSexp


class GrSexp {
	def whitespace = [' ','\n','\r']
	def atom_end = ['(',')','"','\'',')',' ','\n','\r']

	def parse(sexp){
		//list of a lists so that last() still will work
		def stack = [[]]
		def i = 0
		def len = sexp.size()

		while(i < len){

		def c = sexp[i]
	        def reading = stack.last()
		
		if(reading instanceof List){
			if(c == '('){ stack.add([]) }
			else if( c == ')'){ 
				def exp = stack.pop()
				stack.last().add(exp)
			}
	                else if(c == '"') stack.add('')
                	else if(c == "'") stack.add('') //: stack.append([('quote',)])
	                else if(whitespace.contains(c)){ 
				//pass 
  			}
	                else{
				def atm = new Atom()
				atm.add(c)
				stack.add(atm)
			}

		}
		else if(reading instanceof String || reading instanceof GString){
			 if (  c == '"'){
				def exp = stack.pop()
                                stack.last().add(exp)
			}
	                else if( c == '\\'){ 
	                    i += 1
        	            stack.last().add(sexp[i])
			}
	                else{ stack.last().add(c) }
		}
		else if( reading instanceof Atom){
			if(atom_end.contains(c)){
				def atom = stack.pop()
				stack.last().add(atom)
				if(c == ')'){
					i -= 1
				}
			}
			else {
				stack.last().add(c)
			}
			
		}
		i += 1
	}
	return stack.pop()
	}
}

class Atom{

def data = []

def getAt(i){ return data[i] }
def add(o){ data.add(o)  }
def plus(o){ add(o) }

String toString(){
 def str = new StringBuffer()
 data.each{ str.append(it)}
 "<${str.toString()}>"
}

String getText(){
 def str = new StringBuffer()
 data.each{ str.append(it)}
 "${str.toString()}"
}


}
